package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Automovil;
import Model.Vehiculo;
import Service.Inventario;

class InventarioTest {

	private Inventario i;
	
	
	@BeforeEach
    void setUp() {
        i = new Inventario();
    }
	
	@Test
	void testAgregarVehiculos() {
		Vehiculo v= new Vehiculo (null, null, null, null, 0, null);
		boolean resultado= i.añadir(v);
		assertTrue(resultado);
		assertEquals(1, i.getVehiculos().size());
	}
	
	

	@Test
	void testBuscarVehiculos() {
		String marca= "1";
		String vin= "1";
		Vehiculo v= new Vehiculo (marca, null, vin, null, 0, null);
		i.añadir(v);
		Vehiculo a= i.buscarPuntual(marca, vin);
		assertEquals(v, a);
	}

	@Test
	void testImprimirVehiculos() {
		String marca= "1";
		String modelo= "1";
		String vin= "1";
		Automovil v= new Automovil(marca, modelo, vin, null, 0, null, 0, null, null, null);
		i.añadir(v);
		i.imprimirVehiculos();
		
	}

	@Test
	void testEliminarVehiculos() {
		String marca= "1";
		String vin= "1";
		Vehiculo v= new Vehiculo (marca, null, vin, null, 0, null);
		i.añadir(v);
		boolean resultado=i.eliminar(marca, vin);
		assertTrue(resultado);
		assertEquals(0, i.getVehiculos().size());
	}

	@Test
	void testActualizarVehiculo() {
		Automovil v= new Automovil(null, null, null, null, 0, null, 0, null, null, null);
		i.añadir(v);
		String marca= "1";
		String modelo= "1";
		String vin= "1";
		i.ActualizarVehiculo(marca, modelo, vin, 0, vin, 0, vin, vin, vin, marca, 0, modelo, vin, 0, vin, 0, 0, v);
	}

}
