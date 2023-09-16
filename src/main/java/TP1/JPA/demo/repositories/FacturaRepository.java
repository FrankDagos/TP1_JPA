package TP1.JPA.demo.repositories;

import TP1.JPA.demo.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
