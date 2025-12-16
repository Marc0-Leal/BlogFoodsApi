package API_BlogFoods.BlogFoodsAPI.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favorites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa una receta favorita")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del favorito", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;
    
    @Column(name = "title", length = 250, nullable = false)
    @Schema(description = "Título de la receta favorita", example = "Pizza Margarita", nullable =  true)
    private String title;

    @Column(name = "description", nullable = false)
    @Schema(description = "Descripción detallada de la receta", example = "Deliciosa pizza italiana con tomate fresco y mozzarella", nullable = true)
    private String descripcion;
    
}