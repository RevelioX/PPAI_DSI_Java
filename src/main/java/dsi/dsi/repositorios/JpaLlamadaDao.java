package dsi.dsi.repositorios;

import com.example.tercerentrega_ppai.infrastructure.entity.LlamadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLlamadaDao extends JpaRepository<LlamadaEntity, Integer> {
}
