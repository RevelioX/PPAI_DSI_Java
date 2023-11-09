package dsi.dsi.repositorios;

import dsi.dsi.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPreguntaDao extends JpaRepository<Pregunta, Integer> {
}
