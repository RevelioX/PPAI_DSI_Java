package dsi.dsi.repositorios;

import dsi.dsi.entidades.RespuestaPosible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRespuestaPosibleDao extends JpaRepository<RespuestaPosible, Integer> {
}
