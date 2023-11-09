package dsi.dsi.repositorios;

import dsi.dsi.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClienteDao extends JpaRepository<Cliente, Integer>{
}
