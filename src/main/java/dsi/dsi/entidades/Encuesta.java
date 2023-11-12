package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Pregunta> preguntas;

    public List<String> coincidePregunta(List<String> descripcionesRespuestas) {
        System.out.println("PREGUNTAS:" + preguntas);
        boolean coincide = true;
        IteradorPregunta iterador = new IteradorPregunta(preguntas);
        iterador.primero();
        List<String> preguntas = new ArrayList<>();
        while(iterador.hasNext()){
            Pregunta pregunta = iterador.getActual();
            preguntas.add(pregunta.getPregunta());
            if(!pregunta.verificarRespuestas(descripcionesRespuestas)){
                coincide = false;
            }
            iterador.next();
        }
        if(coincide){
            return preguntas;
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                // Evitar llamar a toString de la lista de preguntas
                ", preguntas=" + (preguntas == null ? "null" : "[List size=" + preguntas.size() + "]") +
                '}';
    }
}
