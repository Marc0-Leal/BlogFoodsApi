package API_BlogFoods.BlogFoodsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import API_BlogFoods.BlogFoodsAPI.Model.Favorite;
import API_BlogFoods.BlogFoodsAPI.Repository.FavoriteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> findAll(){
        return favoriteRepository.findAll();
    }

    // ✅ CORREGIDO: Usa el parámetro 'id' correctamente
    public Favorite findById(Integer id) {
        return favoriteRepository.findById(id).orElse(null);
    }

    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public Favorite partialUpdate(Favorite favorite) {
        if (favorite.getId() == null) {
            return null;
        }
        
        Favorite existingFavorite = favoriteRepository.findById(favorite.getId()).orElse(null);

        if (existingFavorite != null) {
            if (favorite.getTitle() != null) {
                existingFavorite.setTitle(favorite.getTitle());
            }
            if (favorite.getDescripcion() != null) {
                existingFavorite.setDescripcion(favorite.getDescripcion());
            }
            return favoriteRepository.save(existingFavorite);
        }

        return null;
    }
    
    public void deleteById(Integer id) {
        favoriteRepository.deleteById(id);
    }
}