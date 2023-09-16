package TP1.JPA.demo.repositories;

import TP1.JPA.demo.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long>{
}
