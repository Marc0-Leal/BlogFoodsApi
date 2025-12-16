package API_BlogFoods.BlogFoodsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import API_BlogFoods.BlogFoodsAPI.Model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

}
