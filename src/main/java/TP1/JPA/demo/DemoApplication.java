package TP1.JPA.demo;


import TP1.JPA.demo.entidades.*;
import TP1.JPA.demo.repositories.ClienteRepository;
import TP1.JPA.demo.repositories.RubroRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("I'm working");
	}
	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("WORKING SUCCESFULLY");
			//Crear un rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Pizzas")
					.build();
			//Crear dos productos pertenecientes al rubro anteriormente creado
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Pizza con anchoas")
					.precioVenta(2500)
					.precioCompra(1500)
					.stockActual(60)
					.stockMinimo(2)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipo("Insumo")
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Pizza Primavera")
					.precioVenta(3000)
					.precioCompra(2000)
					.stockActual(50)
					.stockMinimo(3)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipo("Insumo")
					.build();
			//Agregar los productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			//Guardo rubro
			rubroRepository.save(rubro1);
			//Crear un cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Franco")
					.apellido("D'Agostino")
					.email("frandagos12345@gmail.com")
					.telefono("2616268532")
					.build();
			//Crear el domocilio del Cliente
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Vicente Lopez")
					.numero(431)
					.localidad("Ciudad")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Juan de Dios Videla")
					.numero(428)
					.localidad("Ciudad")
					.build();
			//Vincular los domicilio al cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			//Crear Detalles Pedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(4000)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(2200)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(6000)
					.build();
			//Configurar fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = ("2023-09-15");
			Date fecha = formatoFecha.parse(fechaString);
			//Crear Pedidos
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(6200)
					.estado("Entregado")
					.tipoEnvio("Delivery")
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(6000)
					.estado("Entregado")
					.tipoEnvio("Delivery")
					.build();
			//Crear facturas
			Factura factura1 = Factura.builder()
					.fecha(fecha)
					.total(5000)
					.numero(1)
					.descuento(400)
					.formaPago("Efectivo")
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(5400)
					.numero(2)
					.descuento(600)
					.formaPago("Efectivo")
					.build();
			//Agregar Detalles al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);
			//Agregar pedido al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			//Agregar Detakke Pedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			//Vincular factura con Cliente
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			//Guardar Cliente
			clienteRepository.save(cliente1);

			//Recuperar obketo rubro desde la base de datos
			Rubro rubroRecover = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecover != null){
				System.out.println("Denominacion: " + rubroRecover.getDenominacion());
				rubroRecover.mostrarProductos();
			}
			//Recuperar Cliente de la base de datos
			Cliente clienteRecover = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecover != null){
				System.out.println("Nombre: " + clienteRecover.getNombre());
				System.out.println("Apellido: " + clienteRecover.getApellido());
				System.out.println("Mail: " + clienteRecover.getEmail());
				System.out.println("Telefono: " + clienteRecover.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecover.mostrarDomicilios();
				clienteRecover.mostrarPedidos();

			}
					};
	}

}
