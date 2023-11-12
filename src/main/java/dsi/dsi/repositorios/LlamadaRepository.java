package dsi.dsi.repositorios;

import dsi.dsi.entidades.Llamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LlamadaRepository extends JpaRepository<Llamada, Integer> {

    List<Llamada> findByFechaLlamadaBetween(Date fechaInicio, Date fechaFin);

    List<Llamada> findAll();
}
