package dsi.dsi.repositorios;

import dsi.dsi.entidades.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {

    List<Encuesta> findAll();
}
