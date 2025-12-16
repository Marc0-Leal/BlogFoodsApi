package API_BlogFoods.BlogFoodsAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Receta")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreReceta", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "imagenReceta", nullable = true, length = 500)
    private String imagenUrl;

    @Column(name = "descripcionReceta", nullable = false, length = 1000)
    private String descripcion;


    public Receta() {
    }

    public Receta(Integer id, String nombre, String imagenUrl, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}