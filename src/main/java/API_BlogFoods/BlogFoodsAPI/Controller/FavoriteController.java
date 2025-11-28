package API_BlogFoods.BlogFoodsAPI.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_BlogFoods.BlogFoodsAPI.Model.Favorite;
import API_BlogFoods.BlogFoodsAPI.Services.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin("*")
public class FavoriteController {

    private final FavoriteService service;

    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Favorite> getFavorites() {
        return service.getAll();
    }

    @PostMapping
    public Favorite addFavorite(@RequestBody Favorite favorite) {
        return service.addFavorite(favorite);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteFavorite(@PathVariable int recipeId) {
        service.deleteByRecipeId(recipeId);
    }
}
