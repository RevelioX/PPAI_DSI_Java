package dsi.dsi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "estado")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @Column(name = "id_estado")
    int id;

    @Column(name = "nombre")
    String nombre;

    public String getNombre() {
        return nombre;
    }
}
