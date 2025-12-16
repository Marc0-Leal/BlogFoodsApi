package API_BlogFoods.BlogFoodsAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_BlogFoods.BlogFoodsAPI.Model.Favorite;
import API_BlogFoods.BlogFoodsAPI.Services.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/Favorito")
@Tag(name ="Favorite Management System")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    @Operation(summary = " View a list of available Favorites")
    public ResponseEntity<List<Favorite>> getAllFavorites(){
        List<Favorite> favorites =  favoriteService.findAll();
        if (favorites.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a favorite by Id")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Integer id) {
        Favorite favorite = favoriteService.findById(id);
        if (favorite == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(favorite);
    }

    @PostMapping
    @Operation(summary = "Add a new favorite")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) {
        Favorite createdFavorite = favoriteService.save(favorite);
        return ResponseEntity.status(201).body(createdFavorite);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update an existing favorite")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable Integer id, @RequestBody Favorite favorite) {
        favorite.setId(id);
        Favorite updatedFavorite = favoriteService.save(favorite);
        if (updatedFavorite == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFavorite);
    }
}
