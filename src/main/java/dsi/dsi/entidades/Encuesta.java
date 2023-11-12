package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToMany
    @JoinColumn(name ="id_encuesta")
    @Fetch(FetchMode.JOIN)
    List<Pregunta> preguntas;

    public List<String> coincidePregunta(List<String> descripcionesRespuestas) {
        System.out.println("PREGUNTAS:" + preguntas);
        boolean coincide = true;
        IteradorPregunta iterador = new IteradorPregunta(preguntas);
        iterador.primero();
        List<String> preguntas = new ArrayList<>();
        while(iterador.hasNext()){
            Pregunta pregunta = iterador.getActual();
            System.out.println(pregunta);
            preguntas.add(pregunta.getPregunta());
            System.out.println(preguntas);
            if(!pregunta.verificarRespuestas(descripcionesRespuestas)){
                coincide = false;
            }
            iterador.next();
        }
        if(coincide){
            return preguntas;
        }else{
            return null;
        }
    }
}
