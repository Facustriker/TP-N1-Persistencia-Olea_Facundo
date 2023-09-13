package com.utn.TP1_Persistencia;

import com.utn.TP1_Persistencia.entidades.*;
import com.utn.TP1_Persistencia.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Tp1PersistenciaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;


	public static void main(String[] args) {
		SpringApplication.run(Tp1PersistenciaApplication.class, args);
		System.out.println("Estoy andando bien");
	}


	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo, DomicilioRepository domicilioRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

/*El método builder() se genera automáticamente por Lombok
y te permite crear una instancia de Persona.Builder.
Luego, puedes encadenar llamadas a los métodos
setters generados automáticamente para establecer los
valores de los atributos de la clase.
Finalmente, build() crea la instancia
 de la clase Persona con los valores proporcionados.

 */
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero("1827")
					.localidad("Bermejo")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero("456")
					.localidad("San Martin")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Calle 3")
					.numero("987")
					.localidad("Quilmes")
					.build();

			Domicilio domicilio4 = Domicilio.builder()
					.calle("Calle 4")
					.numero("194")
					.localidad("Rosario")
					.build();

			Domicilio domicilio5 = Domicilio.builder()
					.calle("Calle 5")
					.numero("832")
					.localidad("Quilmes")
					.build();

			Domicilio domicilio6 = Domicilio.builder()
					.calle("Calle 6")
					.numero("2948")
					.localidad("San Martin")
					.build();
			// Crear instancia de Persona y agregar domicilios
			Cliente cliente = Cliente.builder()
					.nombre("Lionel")
					.apellido("Messi")
					.telefono("2616114458")
					.email("anto123@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Cristiano")
					.apellido("Ronaldo")
					.telefono("2618449923")
					.email("camelloArabigo@gmail.com")
					.build();

			Cliente cliente3 = Cliente.builder()
					.nombre("Esteban")
					.apellido("Quito")
					.telefono("2613229943")
					.email("maderita@gmail.com")
					.build();


			LocalDate fecha = LocalDate.of(2023, 9, 13);
			LocalDate fecha2 = LocalDate.of(2023, 5, 19);
			LocalDate fecha3 = LocalDate.of(2023, 3, 21);
			LocalDate fecha4 = LocalDate.of(2023, 7, 11);

			DetallePedido detalle = DetallePedido.builder()
					.cantidad(2)
					.subtotal(8000)
					.build();

			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(13000)
					.build();

			DetallePedido detalle3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(11000)
					.build();

			DetallePedido detalle4 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(6500)
					.build();

			DetallePedido detalle5 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(12000)
					.build();

			DetallePedido detalle6 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(16000)
					.build();

			DetallePedido detalle7 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(35000)
					.build();

			DetallePedido detalle8 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(60000)
					.build();

			DetallePedido detalle9 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(97000)
					.build();

			Producto producto = Producto.builder()
					.tipo("Chatarra")
					.tiempoEstimadoCocina(15)
					.denominacion("Pizza")
					.precioVenta(12500)
					.precioCompra(18000)
					.stockActual(40)
					.stockMinimo(10)
					.unidadMedida("minutos")
					.receta("Receta1")
					.build();

			Producto producto2 = Producto.builder()
					.tipo("Chatarra")
					.tiempoEstimadoCocina(12)
					.denominacion("Hamburguesa")
					.precioVenta(3500)
					.precioCompra(5000)
					.stockActual(120)
					.stockMinimo(15)
					.unidadMedida("minutos")
					.receta("Receta2")
					.build();

			Producto producto3 = Producto.builder()
					.tipo("Chatarra")
					.tiempoEstimadoCocina(10)
					.denominacion("Pancho")
					.precioVenta(1000)
					.precioCompra(2500)
					.stockActual(60)
					.stockMinimo(12)
					.unidadMedida("minutos")
					.receta("Receta3")
					.build();

			Producto producto4 = Producto.builder()
					.tipo("Saludable")
					.tiempoEstimadoCocina(30)
					.denominacion("Ensalada lentejas")
					.precioVenta(1200)
					.precioCompra(3100)
					.stockActual(77)
					.stockMinimo(23)
					.unidadMedida("minutos")
					.receta("Receta4")
					.build();

			Producto producto5 = Producto.builder()
					.tipo("Saludable")
					.tiempoEstimadoCocina(25)
					.denominacion("Tarta acelga")
					.precioVenta(3000)
					.precioCompra(7500)
					.stockActual(160)
					.stockMinimo(40)
					.unidadMedida("minutos")
					.receta("Receta5")
					.build();

			Producto producto6 = Producto.builder()
					.tipo("Saludable")
					.tiempoEstimadoCocina(45)
					.denominacion("Sopa de pollo")
					.precioVenta(4000)
					.precioCompra(9000)
					.stockActual(90)
					.stockMinimo(33)
					.unidadMedida("minutos")
					.receta("Receta6")
					.build();

			Producto producto7 = Producto.builder()
					.tipo("Gourmet")
					.tiempoEstimadoCocina(120)
					.denominacion("Langostinos rellenos")
					.precioVenta(12000)
					.precioCompra(18000)
					.stockActual(65)
					.stockMinimo(45)
					.unidadMedida("minutos")
					.receta("Receta7")
					.build();

			Producto producto8 = Producto.builder()
					.tipo("Gourmet")
					.tiempoEstimadoCocina(120)
					.denominacion("Pulpo caramelizado")
					.precioVenta(18000)
					.precioCompra(26000)
					.stockActual(89)
					.stockMinimo(56)
					.unidadMedida("minutos")
					.receta("Receta8")
					.build();

			Producto producto9 = Producto.builder()
					.tipo("Gourmet")
					.tiempoEstimadoCocina(130)
					.denominacion("Aletas de tiburon")
					.precioVenta(25000)
					.precioCompra(40000)
					.stockActual(30)
					.stockMinimo(10)
					.unidadMedida("minutos")
					.receta("Receta9")
					.build();

			producto.agregarDetallesPedidos(detalle);
			producto2.agregarDetallesPedidos(detalle2);
			producto3.agregarDetallesPedidos(detalle3);
			producto4.agregarDetallesPedidos(detalle4);
			producto5.agregarDetallesPedidos(detalle5);
			producto6.agregarDetallesPedidos(detalle6);
			producto7.agregarDetallesPedidos(detalle7);
			producto8.agregarDetallesPedidos(detalle8);
			producto9.agregarDetallesPedidos(detalle9);

			Factura factura = Factura.builder()
					.numero(1823)
					.fecha(fecha)
					.descuento(3)
					.formaPago("Efectivo")
					.total(6500)
					.build();

			Factura factura2 = Factura.builder()
					.numero(1234)
					.fecha(fecha)
					.descuento(8)
					.formaPago("Efectivo")
					.total(15000)
					.build();

			Factura factura3 = Factura.builder()
					.numero(1176)
					.fecha(fecha)
					.descuento(7)
					.formaPago("Tarjeta Debito")
					.total(11000)
					.build();

			Factura factura4 = Factura.builder()
					.numero(1188)
					.fecha(fecha2)
					.descuento(2)
					.formaPago("Tarjeta Credito")
					.total(9000)
					.build();

			Factura factura5 = Factura.builder()
					.numero(2231)
					.fecha(fecha2)
					.descuento(8)
					.formaPago("Efectivo")
					.total(11400)
					.build();

			Factura factura6 = Factura.builder()
					.numero(9821)
					.fecha(fecha2)
					.descuento(2)
					.formaPago("Tarjeta Debito")
					.total(17020)
					.build();

			Factura factura7 = Factura.builder()
					.numero(7621)
					.fecha(fecha3)
					.descuento(11)
					.formaPago("Tarjeta Credito")
					.total(9600)
					.build();

			Factura factura8 = Factura.builder()
					.numero(8821)
					.fecha(fecha4)
					.descuento(3)
					.formaPago("Efectivo")
					.total(12700)
					.build();

			Factura factura9 = Factura.builder()
					.numero(3399)
					.fecha(fecha4)
					.descuento(1)
					.formaPago("Tarjeta Debito")
					.total(18450)
					.build();

			Pedido pedido = Pedido.builder()
					.estado("Entregado")
					.fecha(fecha)
					.tipoEnvio("Domicilio")
					.total(9800.00)
					.factura(factura)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado("En camino")
					.fecha(fecha)
					.tipoEnvio("Domicilio")
					.total(1200.00)
					.factura(factura2)
					.build();

			Pedido pedido3 = Pedido.builder()
					.estado("Entregado")
					.fecha(fecha2)
					.tipoEnvio("Domicilio")
					.total(3500.00)
					.factura(factura3)
					.build();

			Pedido pedido4 = Pedido.builder()
					.estado("En camino")
					.fecha(fecha2)
					.tipoEnvio("Domicilio")
					.total(6300.00)
					.factura(factura4)
					.build();

			Pedido pedido5 = Pedido.builder()
					.estado("En camino")
					.fecha(fecha2)
					.tipoEnvio("Domicilio")
					.total(4300.00)
					.factura(factura5)
					.build();

			Pedido pedido6 = Pedido.builder()
					.estado("Entregado")
					.fecha(fecha3)
					.tipoEnvio("Domicilio")
					.total(13000.00)
					.factura(factura6)
					.build();

			Pedido pedido7 = Pedido.builder()
					.estado("Entregado")
					.fecha(fecha3)
					.tipoEnvio("Domicilio")
					.total(13400.00)
					.factura(factura7)
					.build();

			Pedido pedido8 = Pedido.builder()
					.estado("En camino")
					.fecha(fecha4)
					.tipoEnvio("Domicilio")
					.total(900.00)
					.factura(factura8)
					.build();

			Pedido pedido9 = Pedido.builder()
					.estado("Entregado")
					.fecha(fecha4)
					.tipoEnvio("Domicilio")
					.total(3320.00)
					.factura(factura9)
					.build();

			pedido.agregarDetallesPedidos(detalle);
			pedido2.agregarDetallesPedidos(detalle2);
			pedido3.agregarDetallesPedidos(detalle3);
			pedido4.agregarDetallesPedidos(detalle4);
			pedido5.agregarDetallesPedidos(detalle5);
			pedido6.agregarDetallesPedidos(detalle6);
			pedido7.agregarDetallesPedidos(detalle7);
			pedido8.agregarDetallesPedidos(detalle8);
			pedido9.agregarDetallesPedidos(detalle9);

			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);
			cliente.agregarPedido(pedido);
			cliente.agregarPedido(pedido2);
			cliente.agregarPedido(pedido3);
			cliente2.agregarDomicilio(domicilio3);
			cliente2.agregarDomicilio(domicilio4);
			cliente2.agregarPedido(pedido4);
			cliente2.agregarPedido(pedido5);
			cliente2.agregarPedido(pedido6);
			cliente3.agregarDomicilio(domicilio5);
			cliente3.agregarDomicilio(domicilio6);
			cliente3.agregarPedido(pedido7);
			cliente3.agregarPedido(pedido8);
			cliente3.agregarPedido(pedido9);



			Rubro rubro = Rubro.builder()
					.denominacion("Comida chatarra")
					.build();

			Rubro rubro2 = Rubro.builder()
					.denominacion("Comida saludable")
					.build();

			Rubro rubro3 = Rubro.builder()
					.denominacion("Comida gourmet")
					.build();

			rubro.agregarProductos(producto);
			rubro.agregarProductos(producto2);
			rubro.agregarProductos(producto3);
			rubro2.agregarProductos(producto4);
			rubro2.agregarProductos(producto5);
			rubro2.agregarProductos(producto6);
			rubro3.agregarProductos(producto7);
			rubro3.agregarProductos(producto8);
			rubro3.agregarProductos(producto9);




			// Guardar el objeto Cliente en la base de datos

			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
			clienteRepository.save(cliente3);

			// Guardar el objeto Domicilio en la base de datos

			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);
			domicilioRepository.save(domicilio4);
			domicilioRepository.save(domicilio5);
			domicilioRepository.save(domicilio6);

			// Guardar el objeto Pedido en la base de datos

			pedidoRepository.save(pedido);
			pedidoRepository.save(pedido2);
			pedidoRepository.save(pedido3);
			pedidoRepository.save(pedido4);
			pedidoRepository.save(pedido5);
			pedidoRepository.save(pedido6);
			pedidoRepository.save(pedido7);
			pedidoRepository.save(pedido8);
			pedidoRepository.save(pedido9);

			// Guardar el objeto Factura en la base de datos

			facturaRepository.save(factura);
			facturaRepository.save(factura2);
			facturaRepository.save(factura3);
			facturaRepository.save(factura4);
			facturaRepository.save(factura5);
			facturaRepository.save(factura6);
			facturaRepository.save(factura7);
			facturaRepository.save(factura8);
			facturaRepository.save(factura9);

			// Guardar el objeto Detalle Pedido en la base de datos

			detallePedidoRepository.save(detalle);
			detallePedidoRepository.save(detalle2);
			detallePedidoRepository.save(detalle3);
			detallePedidoRepository.save(detalle4);
			detallePedidoRepository.save(detalle5);
			detallePedidoRepository.save(detalle6);
			detallePedidoRepository.save(detalle7);
			detallePedidoRepository.save(detalle8);
			detallePedidoRepository.save(detalle9);


			// Guardar el objeto Producto en la base de datos

			productoRepository.save(producto);
			productoRepository.save(producto2);
			productoRepository.save(producto3);
			productoRepository.save(producto4);
			productoRepository.save(producto5);
			productoRepository.save(producto6);
			productoRepository.save(producto7);
			productoRepository.save(producto8);
			productoRepository.save(producto9);

			// Guardar el objeto Rubro en la base de datos


			rubroRepository.save(rubro);
			rubroRepository.save(rubro2);
			rubroRepository.save(rubro3);


			// Recuperar el objeto Persona desde la base de datos

			Cliente clienteRecuperado = clienteRepository.findById(String.valueOf(cliente.getId())).orElse(null);
			Cliente clienteRecuperado2 = clienteRepository.findById(String.valueOf(cliente2.getId())).orElse(null);
			Cliente clienteRecuperado3 = clienteRepository.findById(String.valueOf(cliente3.getId())).orElse(null);

			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
			if (clienteRecuperado2 != null) {
				System.out.println("Nombre: " + clienteRecuperado2.getNombre());
				System.out.println("Apellido: " + clienteRecuperado2.getApellido());
				System.out.println("Telefono: " + clienteRecuperado2.getTelefono());
				System.out.println("Email: " + clienteRecuperado2.getEmail());
				clienteRecuperado2.mostrarDomicilios();
				clienteRecuperado2.mostrarPedidos();
			}
			if (clienteRecuperado3 != null) {
				System.out.println("Nombre: " + clienteRecuperado3.getNombre());
				System.out.println("Apellido: " + clienteRecuperado3.getApellido());
				System.out.println("Telefono: " + clienteRecuperado3.getTelefono());
				System.out.println("Email: " + clienteRecuperado3.getEmail());
				clienteRecuperado3.mostrarDomicilios();
				clienteRecuperado3.mostrarPedidos();
			}
		};
	}
}



