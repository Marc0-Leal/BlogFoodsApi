package API_BlogFoods.BlogFoodsAPI.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import API_BlogFoods.BlogFoodsAPI.Model.Favorite;
import API_BlogFoods.BlogFoodsAPI.Repository.FavoriteRepository;

@Service
public class FavoriteService {

    private final FavoriteRepository repository;

    public FavoriteService(FavoriteRepository repository) {
        this.repository = repository;
    }

    public List<Favorite> getAll() {
        return repository.findAll();
    }

    public Favorite addFavorite(Favorite favorite) {
        if (!repository.existsByRecipeId(favorite.getRecipeId())) {
            return repository.save(favorite);
        }
        return null;
    }

    public void deleteByRecipeId(int recipeId) {
        repository.deleteByRecipeId(recipeId);
    }
}