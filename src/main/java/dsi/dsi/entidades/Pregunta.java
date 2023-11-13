package dsi.dsi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pregunta")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @Column(name = "id_pregunta")
    int id;

    @Column(name = "pregunta")
    String pregunta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_encuesta")
    private Encuesta encuesta;

    @OneToMany
    @JoinColumn(name = "id_pregunta")
    private List<RespuestaPosible> respuestaPosibles;

    public boolean verificarRespuestas(List<String> respuestas){
        boolean valor = false;
        for(int i = 0; i < respuestas.size(); i++){
            System.out.println("INFO :" + pregunta + respuestas.get(i) + respuestaPosibles.toString());
            List<String> res = respuestaPosibles.stream().map( r -> r.getDescripcion()).toList();
            if(res.contains(respuestas.get(i))){
                valor = true;
            }
        }
        return valor;
    }

    public String getPregunta(){
        return pregunta;
    }


}
