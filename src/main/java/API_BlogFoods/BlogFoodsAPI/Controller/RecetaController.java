package API_BlogFoods.BlogFoodsAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_BlogFoods.BlogFoodsAPI.Model.Receta;
import API_BlogFoods.BlogFoodsAPI.Services.RecetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/Receta")
@Tag(name = "Receta Management System")
public class RecetaController {
    
    @Autowired
    private RecetaService recetaService;

    @GetMapping
    @Operation(summary = "View a list of available recetas")
    public ResponseEntity<List<Receta>> getAllRecetas(){
        try {
            List<Receta> recetas = recetaService.findAll();
            if (recetas.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(recetas);
        } catch (Exception e) {
            System.err.println(" Error en getAllRecetas: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a receta by Id")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Integer id) {
        try {
            Receta receta = recetaService.findById(id);
            if (receta == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(receta);
        } catch (Exception e) {
            System.err.println(" Error en getRecetaById: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Operation(summary = "Create a new receta")
    public ResponseEntity<Receta> createReceta(@RequestBody Receta receta) {
        try {
            // Validaciones
            if (receta.getNombre() == null || receta.getNombre().trim().isEmpty()) {
                System.err.println(" Error: nombre es nulo o vacío");
                return ResponseEntity.badRequest().build();
            }
            
            if (receta.getDescripcion() == null || receta.getDescripcion().trim().isEmpty()) {
                System.err.println(" Error: descripcion es nulo o vacío");
                return ResponseEntity.badRequest().build();
            }

            // Validar longitudes
            if (receta.getNombre().length() > 100) {
                System.err.println(" Error: nombre excede 100 caracteres");
                return ResponseEntity.badRequest().build();
            }

            // Log para debug
            System.out.println(" Creando receta: " + receta.getNombre());
            
            // Asegurarse de que el ID sea null para crear nuevo registro
            receta.setId(null);
            
            Receta createdReceta = recetaService.save(receta);
            System.out.println(" Receta creada con ID: " + createdReceta.getId());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReceta);
        } catch (Exception e) {
            System.err.println(" Error en createReceta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing receta")
    public ResponseEntity<Receta> updateReceta(@PathVariable Integer id, @RequestBody Receta receta) {
        try {
            // Verificar que existe
            Receta existingReceta = recetaService.findById(id);
            if (existingReceta == null) {
                return ResponseEntity.notFound().build();
            }
            
            receta.setId(id);
            Receta updatedReceta = recetaService.save(receta);
            return ResponseEntity.ok(updatedReceta);
        } catch (Exception e) {
            System.err.println(" Error en updateReceta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a receta")
    public ResponseEntity<Void> deleteReceta(@PathVariable Integer id) {
        try {
            Receta receta = recetaService.findById(id);
            if (receta == null) {
                return ResponseEntity.notFound().build();
            }
            recetaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println(" Error en deleteReceta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}