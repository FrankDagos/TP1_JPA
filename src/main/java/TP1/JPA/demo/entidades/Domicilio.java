package TP1.JPA.demo.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Domicilio implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String calle;

    private int numero;

    private String localidad;
}
