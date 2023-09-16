package TP1.JPA.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class DetallePedido implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;

    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "producto_id") // Nombre de la columna que será la clave foránea
    private Producto producto;

}
