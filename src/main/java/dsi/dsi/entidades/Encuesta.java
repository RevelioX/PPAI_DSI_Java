package dsi.dsi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "encuesta")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta {

    @Id
    @Column(name = "id_encuesta")
    int id;

    @Column(name = "descripcion")
    String descripcion;
}
