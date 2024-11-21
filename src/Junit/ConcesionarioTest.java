package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Cliente;
import Model.Mantenimiento;
import Model.Vehiculo;
import Model.Ventas;
import Service.Concesionario;

class ConcesionarioTest {
	
	private Concesionario c;
	
	
	@BeforeEach
    void setUp() {
        c = new Concesionario("Prueba");
    }

	@Test
	void testAgregarCliente() {
		Cliente cliente= new Cliente(null, null, null, null);
		boolean resultado= c.añadir(cliente);
		assertTrue(resultado);
		assertEquals(1, c.getClientes().size());
	}

	@Test
	void testBuscarClientes() {
		String nombre= "1";
		String telefono= "1";
		Cliente cliente= new Cliente(nombre, null, telefono, null);
		c.añadir(cliente);
		Cliente clie= c.buscarPuntual(nombre, telefono);
		assertEquals(cliente, clie);
	}

	@Test
	void testImprimirClientes() {
		String nombre= "1";
		String direccion= "1";
		String telefono= "1";
		Cliente cliente= new Cliente(nombre, direccion, telefono, null);
		c.añadir(cliente);
		c.imprimirClientes();
	}

	@Test
	void testEliminarCliente() {
		String nombre= "1";
		String telefono= "1";
		Cliente cliente= new Cliente(nombre, null, telefono, null);
		c.añadir(cliente);
		boolean resultado = c.eliminar(nombre, telefono);
		assertTrue(resultado);
		assertEquals(0, c.getClientes().size());
	}

	@Test
	void testActualizarCliente() {
		Cliente cliente= new Cliente(null, null, null, null);
		c.añadir(cliente);
		String nombre= "1";
		String direccion= "1";
		String telefono= "1";
		c.ActualizarCliente(nombre, direccion, telefono, null, cliente);
	}

	@Test
	void testRegistroVentas() {
		Ventas v= new Ventas(0, null, null, null, 0, 0);
		c.registroVentas(v);
		assertEquals(1, c.getVentas().size());
		assertEquals(0, c.getInventario().getVehiculos().size());
	}

	@Test
	void testImprimirVentas() {
		String nombre= "juan";
		Cliente clie=new Cliente(nombre, null, null, null);
		String marca="1";
		Vehiculo vehi= new Vehiculo(marca, null, null, null, 0, null);
		double costo=100;
		Ventas v= new Ventas(0, vehi, clie, null, costo, 0);
		c.registroVentas(v);
		boolean resultado=c.imprimirVentas(clie, vehi, null);
		assertTrue(resultado);
		
	}

	@Test
	void testCrearMant() {
		Mantenimiento m= new Mantenimiento(null, null, null, 0, 0);
		c.crearMant(m);
		assertEquals(1, c.getMantenimientos().size());
	}

	@Test
	void testImprimirMantenimiento() {
		String marca="1";
		String modelo="1";
		String vin="1";
		Vehiculo vehi= new Vehiculo(marca, modelo, vin, null, 0, null);
		String tipo="1";
		int costo=100;
		Mantenimiento m= new Mantenimiento(vehi, tipo, null, costo, 0);
		c.crearMant(m);
		boolean resultado=c.imprimirMantenimiento(vehi);
		assertTrue(resultado);
	}

}
