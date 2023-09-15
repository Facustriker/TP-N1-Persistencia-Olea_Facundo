package com.utn.TP1_Persistencia;

import com.utn.TP1_Persistencia.entidades.*;
import com.utn.TP1_Persistencia.enumeraciones.Estado;
import com.utn.TP1_Persistencia.enumeraciones.FormaDePago;
import com.utn.TP1_Persistencia.enumeraciones.TipoDeEnvio;
import com.utn.TP1_Persistencia.enumeraciones.TipoProducto;
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
			Rubro rubro = Rubro.builder()
					.denominacion("Comida chatarra")
					.build();

			Rubro rubro2 = Rubro.builder()
					.denominacion("Comida saludable")
					.build();

			Rubro rubro3 = Rubro.builder()
					.denominacion("Comida gourmet")
					.build();

			Producto producto = Producto.builder()
					.tipo(TipoProducto.Insumo)
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
					.tipo(TipoProducto.Insumo)
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
					.tipo(TipoProducto.Insumo)
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
					.tipo(TipoProducto.Manufacturado)
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
					.tipo(TipoProducto.Manufacturado)
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
					.tipo(TipoProducto.Manufacturado)
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
					.tipo(TipoProducto.Manufacturado)
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
					.tipo(TipoProducto.Manufacturado)
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
					.tipo(TipoProducto.Insumo)
					.tiempoEstimadoCocina(130)
					.denominacion("Aletas de tiburon")
					.precioVenta(25000)
					.precioCompra(40000)
					.stockActual(30)
					.stockMinimo(10)
					.unidadMedida("minutos")
					.receta("Receta9")
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

			DetallePedido detalle = DetallePedido.builder()
					.cantidad(2)
					.subtotal(8000)
					.producto(producto)
					.build();

			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(13000)
					.producto(producto2)
					.build();

			DetallePedido detalle3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(11000)
					.producto(producto3)
					.build();

			DetallePedido detalle4 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(6500)
					.producto(producto4)
					.build();

			DetallePedido detalle5 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(12000)
					.producto(producto5)
					.build();

			DetallePedido detalle6 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(16000)
					.producto(producto6)
					.build();

			DetallePedido detalle7 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(35000)
					.producto(producto7)
					.build();

			DetallePedido detalle8 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(60000)
					.producto(producto8)
					.build();

			DetallePedido detalle9 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(97000)
					.producto(producto9)
					.build();


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


			SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = "2023-09-13";
			String fechaString2 = "2023-05-19";
			String fechaString3 = "2023-03-21";
			String fechaString4 = "2023-07-11";

			Date fecha = formatoFecha.parse(fechaString);
			Date fecha2 = formatoFecha.parse(fechaString2);
			Date fecha3 = formatoFecha.parse(fechaString3);
			Date fecha4 = formatoFecha.parse(fechaString4);

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







			Factura factura = Factura.builder()
					.numero(1823)
					.fecha(fecha)
					.descuento(3)
					.formaPago(FormaDePago.Efectivo)
					.total(6500)
					.build();

			Factura factura2 = Factura.builder()
					.numero(1234)
					.fecha(fecha)
					.descuento(8)
					.formaPago(FormaDePago.Efectivo)
					.total(15000)
					.build();

			Factura factura3 = Factura.builder()
					.numero(1176)
					.fecha(fecha)
					.descuento(7)
					.formaPago(FormaDePago.ConTarjeta)
					.total(11000)
					.build();

			Factura factura4 = Factura.builder()
					.numero(1188)
					.fecha(fecha2)
					.descuento(2)
					.formaPago(FormaDePago.ConTarjeta)
					.total(9000)
					.build();

			Factura factura5 = Factura.builder()
					.numero(2231)
					.fecha(fecha2)
					.descuento(8)
					.formaPago(FormaDePago.Efectivo)
					.total(11400)
					.build();

			Factura factura6 = Factura.builder()
					.numero(9821)
					.fecha(fecha2)
					.descuento(2)
					.formaPago(FormaDePago.ConTarjeta)
					.total(17020)
					.build();

			Factura factura7 = Factura.builder()
					.numero(7621)
					.fecha(fecha3)
					.descuento(11)
					.formaPago(FormaDePago.ConTarjeta)
					.total(9600)
					.build();

			Factura factura8 = Factura.builder()
					.numero(8821)
					.fecha(fecha4)
					.descuento(3)
					.formaPago(FormaDePago.Efectivo)
					.total(12700)
					.build();

			Factura factura9 = Factura.builder()
					.numero(3399)
					.fecha(fecha4)
					.descuento(1)
					.formaPago(FormaDePago.ConTarjeta)
					.total(18450)
					.build();

			Pedido pedido = Pedido.builder()
					.estado(Estado.Entregado)
					.fecha(fecha)
					.tipoEnvio(TipoDeEnvio.Retira)
					.total(9800.00)
					.factura(factura)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(Estado.Listo)
					.fecha(fecha)
					.tipoEnvio(TipoDeEnvio.Delivery)
					.total(1200.00)
					.factura(factura2)
					.build();

			Pedido pedido3 = Pedido.builder()
					.estado(Estado.Entregado)
					.fecha(fecha2)
					.tipoEnvio(TipoDeEnvio.Retira)
					.total(3500.00)
					.factura(factura3)
					.build();

			Pedido pedido4 = Pedido.builder()
					.estado(Estado.Preparacion)
					.fecha(fecha2)
					.tipoEnvio(TipoDeEnvio.Retira)
					.total(6300.00)
					.factura(factura4)
					.build();

			Pedido pedido5 = Pedido.builder()
					.estado(Estado.Preparacion)
					.fecha(fecha2)
					.tipoEnvio(TipoDeEnvio.Retira)
					.total(4300.00)
					.factura(factura5)
					.build();

			Pedido pedido6 = Pedido.builder()
					.estado(Estado.Listo)
					.fecha(fecha3)
					.tipoEnvio(TipoDeEnvio.Retira)
					.total(13000.00)
					.factura(factura6)
					.build();

			Pedido pedido7 = Pedido.builder()
					.estado(Estado.Entregado)
					.fecha(fecha3)
					.tipoEnvio(TipoDeEnvio.Delivery)
					.total(13400.00)
					.factura(factura7)
					.build();

			Pedido pedido8 = Pedido.builder()
					.estado(Estado.Preparacion)
					.fecha(fecha4)
					.tipoEnvio(TipoDeEnvio.Delivery)
					.total(900.00)
					.factura(factura8)
					.build();

			Pedido pedido9 = Pedido.builder()
					.estado(Estado.Iniciado)
					.fecha(fecha4)
					.tipoEnvio(TipoDeEnvio.Delivery)
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
			cliente.agregarPedido(pedido4);
			cliente.agregarPedido(pedido5);
			cliente2.agregarDomicilio(domicilio3);
			cliente2.agregarDomicilio(domicilio4);
			cliente2.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);
			cliente2.agregarPedido(pedido6);
			cliente3.agregarDomicilio(domicilio5);
			cliente3.agregarDomicilio(domicilio6);
			cliente3.agregarPedido(pedido7);
			cliente3.agregarPedido(pedido8);
			cliente3.agregarPedido(pedido9);



			// Guardar el objeto Rubro en la base de datos

			rubroRepository.save(rubro);
			rubroRepository.save(rubro2);
			rubroRepository.save(rubro3);

			// Guardar el objeto Cliente en la base de datos

			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
			clienteRepository.save(cliente3);

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



