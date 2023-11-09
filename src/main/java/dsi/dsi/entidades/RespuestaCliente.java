package dsi.dsi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "respuestacliente")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaCliente {

    @Id
    @Column(name = "id_respuestacliente")
    int id;

    @Column(name = "fechaencuesta")
    Date fechaEncuesta;
}
