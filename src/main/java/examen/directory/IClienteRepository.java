package examen.directory;

import examen.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IClienteRepository  extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNombreIs(String nombre);
}
