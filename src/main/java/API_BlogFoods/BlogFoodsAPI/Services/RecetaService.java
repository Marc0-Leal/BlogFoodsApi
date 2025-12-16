package API_BlogFoods.BlogFoodsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import API_BlogFoods.BlogFoodsAPI.Model.Receta;
import API_BlogFoods.BlogFoodsAPI.Repository.RecetaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class RecetaService {
    
    @Autowired
    private RecetaRepository recetaRepository;

    public List<Receta> findAll(){
        List<Receta> Receta = recetaRepository.findAll();
        return Receta;
    }

    @SuppressWarnings("null")
    public Receta findById(Integer id){
        return recetaRepository.findById(id).orElse(null);
    }

    public Receta save(Receta receta){
        return recetaRepository.save(receta);
    }

    public Receta partialUpdate(Receta receta) {
        Receta existingReceta = recetaRepository.findById(receta.getId()).orElse(null);

        if (existingReceta != null) {

            if (receta.getNombre() != null) {
                existingReceta.setNombre(receta.getNombre());
            }
            if (receta.getImagenUrl() != null) {
                existingReceta.setImagenUrl(receta.getImagenUrl());
            }
            if (receta.getDescripcion() != null) {
                existingReceta.setDescripcion(receta.getDescripcion());
            }
            return recetaRepository.save(existingReceta);
        }

        return null;
    }

    public void deleteById(Integer id){
        recetaRepository.deleteById(id);
    }
}
