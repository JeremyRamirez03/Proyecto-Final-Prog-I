package Service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.Crud;
import Model.Automovil;
import Model.Camion;
import Model.Cliente;
import Model.Mantenimiento;
import Model.Motocicleta;
import Model.Vehiculo;
import Model.Ventas;

public class Concesionario implements Crud {
	private String nombre;
	private ArrayList<Cliente> clientes;
	private ArrayList<Ventas> ventas;
	private Inventario inventario;
	private ArrayList<Mantenimiento> mantenimientos;

	public Concesionario(String nombre) {
		this.nombre = nombre;
		this.clientes = new ArrayList<>();
		this.ventas = new ArrayList<>();
		this.inventario = new Inventario();
		this.mantenimientos = new ArrayList<>();
	}

	/*************************************************
	 * METODOS DE CLIENTES
	 * 
	 *************************************************/

	private boolean isClienteExistente(Cliente cliente) {
		for (Cliente c : this.clientes) {
			String telefono = cliente.getTelefono();
			if (c.getTelefono().equals(telefono)) {
				return true;
			}
		}

		return false;
	}

	// Añadir cliente
	@Override
	public boolean añadir(Object o) {
		boolean esta = false;
		if (o instanceof Object) {
			Cliente cliente = (Cliente) o;
			boolean estado = isClienteExistente(cliente);
			if (estado == false) {
				this.clientes.add(cliente);
			}
			esta = !estado;
		}
		return esta;
	}

	// Buscar Clientes
	@Override
	public boolean buscar(String nombre, String direccion, String telefono) {
		boolean estado = false;
		if (nombre != null) {
			for (Cliente c : getClientes()) {
				if (c.getNombre().equalsIgnoreCase(nombre)) {
					JOptionPane.showMessageDialog(null, c.toString());
					estado = true;
				}
			}
		} else if (direccion != null) {
			for (Cliente c : getClientes()) {
				if (c.getDireccion().equalsIgnoreCase(direccion)) {
					JOptionPane.showMessageDialog(null, c.toString());
					estado = true;
				}
			}
		} else if (telefono != null) {
			for (Cliente c : getClientes()) {
				if (c.getTelefono().equals(telefono)) {
					JOptionPane.showMessageDialog(null, c.toString());
					estado = true;
				}
			}
		}
		return estado;
	}

	// Buscar Cliente
	@Override
	public Cliente buscarPuntual(String nombre, String telefono) {
		for (Cliente c : this.clientes) {
			if (c.getNombre().equalsIgnoreCase(nombre) && c.getTelefono().equals(telefono)) {
				return c;
			}
		}
		return null;
	}

	// Imprimir clientes
	public void imprimirClientes() {
		for (Cliente c : this.clientes) {
			JOptionPane.showMessageDialog(null, c.toString());
		}
	}

	// Eliminar cliente
	@Override
	public boolean eliminar(String nombre, String telefono) {
		Cliente c = buscarPuntual(nombre, telefono);
		if (c == null) {
			return false;
		}
		clientes.remove(c);
		return true;
	}

	// Actualizar Cliente
	public void ActualizarCliente(String nombre, String direccion, String telefono, String email, Cliente c) {
		c.setNombre(nombre);
		c.setDireccion(direccion);
		c.setTelefono(telefono);
		c.setEmail(email);
	}

	/*************************************************
	 * METODOS DE VENTAS
	 * 
	 *************************************************/
	// registrar venta
	public void registroVentas(Ventas ventas) {
		this.ventas.add(ventas);
	}

	public double costoVent(Vehiculo c, double valorIngesado, Ventas v) {
		double valor = 0;
		if (c instanceof Automovil) {
			valor += v.costoVentaAuto(valorIngesado);
		} else if (c instanceof Motocicleta) {
			valor += v.costoVentaMoto(valorIngesado);
		} else if (c instanceof Camion) {
			valor += v.costoVentaCamion(valorIngesado);
		}
		return valor;
	}

	// imprimir venta
	public boolean imprimirVentas(Cliente c, Vehiculo v, LocalDate f) {
		boolean estado = false;
		if (c != null) {
			String nombre = c.getNombre();
			for (Ventas venta : getVentas()) {
				if (venta.getCliente().getNombre().equalsIgnoreCase(nombre)) {
					JOptionPane.showMessageDialog(null, venta.toString());
					estado = true;
				}
			}
		} else if (v != null) {
			String marca = v.getMarca();
			for (Ventas venta : getVentas()) {
				if (venta.getVehiculo().getMarca().equalsIgnoreCase(marca)) {
					JOptionPane.showMessageDialog(null, venta.toString());
					estado = true;
				}
			}
		} else if (f != null) {
			for (Ventas venta : getVentas()) {
				if (venta.getFechaVenta().equals(f)) {
					JOptionPane.showMessageDialog(null, venta.toString());
					estado = true;
				}
			}
		}
		return estado;
	}

	/*************************************************
	 * METODOS DE MANTENIMIENTO
	 * 
	 *************************************************/

	// Crear mantenimiento
	public void crearMant(Mantenimiento mantenimiento) {
		this.mantenimientos.add(mantenimiento);
	}

	public double costoMant(Vehiculo c, double valorIngesado, Mantenimiento m) {
		double valor = 0;
		if (c instanceof Automovil) {
			valor += m.costoMantenimientoAuto(valorIngesado);
		} else if (c instanceof Motocicleta) {
			valor += m.costoMantenimientoMoto(valorIngesado);
		} else if (c instanceof Camion) {
			valor += m.costoMantenimientoCamion(valorIngesado);
		}
		return valor;
	}

	// Imprimir historial Mantenimiento
	public boolean imprimirMantenimiento(Vehiculo c) {
		boolean valor = false;
		String marca = c.getMarca();
		String modelo = c.getModelo();
		String vin = c.getVin();
		for (Mantenimiento m : getMantenimientos()) {
			if (m.getVehiculo().getMarca().equalsIgnoreCase(marca)
					&& m.getVehiculo().getModelo().equalsIgnoreCase(modelo)
					&& m.getVehiculo().getVin().equalsIgnoreCase(vin)) {
				JOptionPane.showMessageDialog(null,
						"El Historial de mantenimiento de: " + marca + " es:\n" + m.toString());
				valor = true;
			}
		}
		return valor;

	}

	// --------------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Ventas> ventas) {
		this.ventas = ventas;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public ArrayList<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

}
