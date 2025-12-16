package API_BlogFoods.BlogFoodsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import API_BlogFoods.BlogFoodsAPI.Model.Receta;

public interface RecetaRepository extends JpaRepository<Receta,Integer> {
    
}
