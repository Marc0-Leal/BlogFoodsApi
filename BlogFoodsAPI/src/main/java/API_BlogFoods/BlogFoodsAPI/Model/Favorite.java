package API_BlogFoods.BlogFoodsAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name = "RecipeId", length = 30, nullable = false)
    private Integer RecipeId;

    @Column(name = "Title", length = 250, nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;


        public Favorite() {}

    public Favorite(int recipeId, String title, String description) {
        this.RecipeId = recipeId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public int getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId(int recipeId) {
        this.RecipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

