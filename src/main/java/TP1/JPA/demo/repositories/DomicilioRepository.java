package TP1.JPA.demo.repositories;

import TP1.JPA.demo.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long>{
}
