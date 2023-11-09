package dsi.dsi.repositorios;

import dsi.dsi.entidades.CambioEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCambioEstadoDao extends JpaRepository<CambioEstado, Integer> {
}
