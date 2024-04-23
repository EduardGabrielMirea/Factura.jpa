package examen.directory;

import examen.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFacturaRepository extends JpaRepository<Factura, Long> {

    List<Factura> findByCantidadGreaterThan(Integer v);
}
