package dsi.dsi.repositorios;

import dsi.dsi.entidades.RespuestaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRespuestaClienteDao extends JpaRepository<RespuestaCliente, Integer> {
}
