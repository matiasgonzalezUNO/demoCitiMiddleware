package ar.com.itrsa.demoCitiMiddleware.repository;

import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    List<UsuarioModel> findByPrioridad(Integer prioridad);
}
