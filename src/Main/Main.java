package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import Model.Automovil;
import Model.Camion;
import Model.Cliente;
import Model.Mantenimiento;
import Model.Motocicleta;
import Model.Vehiculo;
import Model.Ventas;
import Service.Concesionario;

public class Main {

	public static Concesionario l = new Concesionario("CarHouse");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String menuPrincipal = "Menu principal \n" + "Ingrese la opcion correspondiente: \n" + "1. Añadir Cliente. \n"
				+ "2. Buscar Cliente. \n" + "3. Eliminar Cliente. \n" + "4. Actualizar Cliente. \n" + "5. Lista De Clientes. \n"
				+ "6. Añadir Vehiculo. \n" + "7. Buscar Vehiculos. \n" + "8. Eliminar Vehiculo. \n"
				+ "9. Actualizar Vehiculo. \n" + "10. Lista De Vehiculos. \n" + "11. Registrar Mantenimiento. \n"
				 + "12. Historial Mantenimientos. \n" +  "13. Registrar Venta. \n" +  "14. Historial Ventas. \n" 
				  +"15. Salir";

		int opcionSeleccionada = 0;

		do {
			opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null, menuPrincipal));
			opcionMenu(opcionSeleccionada);
		} while (opcionSeleccionada != 15);

	}

	private static void opcionMenu(int opcionSeleccionada) {
		switch (opcionSeleccionada) {
		case 1:
			añadirCliente();
			break;
		case 2:
			buscarCliente();
			break;
		case 3:
			eliminarCliente();
			break;
		case 4:
			actualizarCliente();
			break;
		case 5:
			getListaClientes();
			break;
		case 6:
			añadirVehiculo();
			break;
		case 7:
			buscarVehiculo();
			break;
		case 8:
			eliminarVehiculo();
			break;
		case 9:
			actualizarVehiculo();
			break;
		case 10:
			getListaVehiculos();
			break;
		case 11:
			registrarMantenimiento();
			break;
		case 12:
			historialMantenimiento();
			break;
		case 13:
			registrarVenta();
			break;
		case 14:
			historialVentas();
			break;
		default:
			break;
		}
	}

	/*************************************************
	 * METODOS DE CLIENTES
	 * 
	 *************************************************/
	// Metodo para añadir un cliente
	private static void añadirCliente() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
		String direccion = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
		String telefono = JOptionPane.showInputDialog("Ingrese numero telefonico del cliente: ");
		String email = JOptionPane.showInputDialog("Ingrese el correo electronico del cliente: ");

		Cliente c = new Cliente(nombre, direccion, telefono, email);
		boolean estado = l.añadir(c);
		String mensaje;
		mensaje = estado == true ? "El cliente fue agregado con exito." : "El cliente ya existe.";
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// Metodo para buscar clientes
	private static void buscarCliente() {
		int tipoBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de busqueda:\n (1) Por Nombre. \n "
				+ "(2) Por Direccion. \n (3) Por Telefono. "));
		if(tipoBusqueda==1) {
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
			if(nombre!=null) {
				boolean estado= l.buscar(nombre, null, null);
				String mensaje;
				mensaje = estado == false ? "No hay Clientes con este nombre" : "No hay mas Clientes con este nombre";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "No se ingreso un nombre");
			}
			
		}else if(tipoBusqueda==2) {
			String direccion= JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
			if(direccion!=null) {
				boolean estado= l.buscar(null, direccion, null);
				String mensaje;
				mensaje = estado == false ? "No hay Clientes con esta direccion" : "No hay mas Clientes con esta direccion";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "No se ingreso una direccion");
			}
			
		}else if(tipoBusqueda==3) {
			String telefono= JOptionPane.showInputDialog("Ingrese numero telefonico del cliente: ");
			if(telefono!=null) {
				boolean estado= l.buscar(null, null, telefono);
				String mensaje;
				mensaje = estado == false ? "No hay Clientes con este numero de telefono" : "No existen mas Clientes con este numero "
						+ "de telefono";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "No se ingreso un telefono");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Opcion no valida");
		}
		
	}

	// Metodo para listar clientes
	private static void getListaClientes() {
		JOptionPane.showMessageDialog(null, "Lista de clientes:");
		l.imprimirClientes();
	}

	// Metodo para eliminar un cliente
	private static void eliminarCliente() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
		String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente:");
		boolean estado = l.eliminar(nombre, telefono);
		String mensaje = estado == true ? "Cliente eliminado." : "El cliente no existe.";
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// Metodo para actualizar datos de un cliente
	private static void actualizarCliente() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
		String direccion = JOptionPane.showInputDialog("Ingrese la direccion del cliente:");
		String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente:");
		Cliente clie = l.buscarPuntual(nombre, telefono);

		JOptionPane.showMessageDialog(null, "Cliente a actualizar:");

		if (clie != null) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
			direccion = JOptionPane.showInputDialog("Ingrese el direccion del cliente:");
			telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente:");
			String email = JOptionPane.showInputDialog("Ingrese el email del cliente:");

			l.ActualizarCliente(nombre, direccion, telefono, email, clie);
		} else {
			JOptionPane.showMessageDialog(null, "El cliente no existe");
		}

	}

	/*************************************************
	 * METODOS DE INVENTARIO
	 * 
	 *************************************************/
	// Metodo para añadir vehiculos
	private static void añadirVehiculo() {
		int tipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog(
				"Seleccione el tipo de vehiculo que desea ingresar: \n (1) para Automovil. \n " + "(2) para Motocicleta. \n "
						+ "(3) para Camion. "));
		String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo: ");
		String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
		String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
		String color = JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
		double kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del vehiculo: "));
		String año = JOptionPane.showInputDialog("Ingrese el año del vehiculo: ");
		if (tipoVehiculo == 1) {
			int numeroPuertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de puertas: "));
			String tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible: ");
			String transmision = JOptionPane.showInputDialog("Ingrese el tipo de transmision del vehiculo: ");
			String traccion = JOptionPane.showInputDialog("Ingrese el tipo de traccion del vehiculo: ");
			Automovil au = new Automovil(marca, modelo, vin, color, kilometraje, año, numeroPuertas, tipoCombustible,
					transmision, traccion);
			boolean estado =l.getInventario().añadir(au);
			String mensaje;
			mensaje = estado == true ? "El vehiculo fue agregado con exito." : "El vehiculo ya existe.";
			JOptionPane.showMessageDialog(null, mensaje);
		} else if (tipoVehiculo == 2) {
			String tipoManillar = JOptionPane.showInputDialog("Ingrese el tipo de manillar: ");
			int numeroRuedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ruedas: "));
			String tipoFreno = JOptionPane.showInputDialog("Ingrese el tipo de freno: ");
			String cilindrada = JOptionPane.showInputDialog("Ingrese el tipo de cilindraje: ");
			Motocicleta mo = new Motocicleta(marca, modelo, vin, color, kilometraje, año, tipoManillar, numeroRuedas,
					tipoFreno, cilindrada);
			boolean estado =l.getInventario().añadir(mo);
			String mensaje;
			mensaje = estado == true ? "El vehiculo fue agregado con exito." : "El vehiculo ya existe.";
			JOptionPane.showMessageDialog(null, mensaje);
		} else if (tipoVehiculo == 3) {
			double capacidadCarga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga: "));
			String tipoCamion = JOptionPane.showInputDialog("Ingrese el tipo de camion: ");
			int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud: "));
			int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes: "));
			Camion ca = new Camion(marca, modelo, vin, color, kilometraje, año, capacidadCarga, tipoCamion, longitud,
					numeroEjes);
			boolean estado =l.getInventario().añadir(ca);
			String mensaje;
			mensaje = estado == true ? "El vehiculo fue agregado con exito." : "El vehiculo ya existe.";
			JOptionPane.showMessageDialog(null, mensaje);
		}
	}

	// Metodo para buscar vehiculos
	private static void buscarVehiculo() {
		int tipoBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de busqueda:\n (1) para Marca. \n "
				+ "(2) para Modelo. \n (3) Tipo de vehiculo. "));
		if(tipoBusqueda==1) {
			String marca = JOptionPane.showInputDialog("Ingrese la marca de los vehiculos: ");
			if(marca!=null) {
				boolean estado= l.getInventario().buscar(marca, null, null);
				String mensaje;
				mensaje = estado == false ? "No hay vehiculos con esa marca" : "No hay mas vehiculos de esta marca";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "No se ingreso una marca");
			}	
		}else if(tipoBusqueda==2) {
			String modelo = JOptionPane.showInputDialog("Ingrese el modelo de los vehiculos: ");
			if(modelo!=null) {
				boolean estado= l.getInventario().buscar(null, modelo, null);
				String mensaje;
				mensaje = estado == false ? "No hay vehiculos con este modelo" : "No hay mas vehiculos de este modelo";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "No se ingreso un modelo");
			}
		}else if(tipoBusqueda==3) {
			boolean estado= l.getInventario().buscar(null, null, null);
			String mensaje;
			mensaje = estado == false ? "No hay vehiculos de este tipo" : "No hay mas vehiculos de este tipo";
			JOptionPane.showMessageDialog(null, mensaje);
			
		}else {
			JOptionPane.showMessageDialog(null, "Opcion no valida");
		}
	}

	// Metodo para listar vehiculos
	private static void getListaVehiculos() {
		if(l.getInventario().getVehiculos().size()>0) {
			JOptionPane.showMessageDialog(null, "Lista de vehiculos:");
			l.getInventario().imprimirVehiculos();
		}else {
			JOptionPane.showMessageDialog(null, "No hay vehiculos en el inventario:");
		}	
	}

	// Metodo para eliminar vehiculos
	private static void eliminarVehiculo() {
		String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
		boolean estado = l.getInventario().eliminar(null, vin);
		String mensaje = estado == true ? "Vehiculo eliminado." : "El vehiculo no existe.";
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// Metodo para acutualizar vehiculos
	private static void actualizarVehiculo() {
		String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
		Vehiculo vehi = l.getInventario().buscarPuntual(null,vin);
		if (vehi != null) {
			if(vehi instanceof Automovil) {
				JOptionPane.showMessageDialog(null, "El vehiculo es de tipo: Automovil "  );
			}else if(vehi instanceof Motocicleta) {
				JOptionPane.showMessageDialog(null, "El vehiculo es de tipo: Motocicleta "  );
			}else if (vehi instanceof Camion){
				JOptionPane.showMessageDialog(null, "El vehiculo es de tipo: Camion "  );
			}
			String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo: ");
			String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
			String color = JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
			double kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del vehiculo: "));
			String año = JOptionPane.showInputDialog("Ingrese el año del vehiculo: ");
			if (vehi instanceof Automovil) {
				int numeroPuertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de puertas: "));
				String tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible: ");
				String transmision = JOptionPane.showInputDialog("Ingrese el tipo de transmision del vehiculo: ");
				String traccion = JOptionPane.showInputDialog("Ingrese el tipo de traccion del vehiculo: ");
				l.getInventario().ActualizarVehiculo(marca, modelo, color, kilometraje, año, numeroPuertas,
						tipoCombustible, transmision, traccion, tipoCombustible, numeroPuertas, transmision, vin,
						kilometraje, traccion, numeroPuertas, numeroPuertas, vehi);
			} else if (vehi instanceof Motocicleta) {
				String tipoManillar = JOptionPane.showInputDialog("Ingrese el tipo de manillar: ");
				int numeroRuedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ruedas: "));
				String tipoFreno = JOptionPane.showInputDialog("Ingrese el tipo de freno: ");
				String cilindrada = JOptionPane.showInputDialog("Ingrese el tipo de cilindraje: ");
				l.getInventario().ActualizarVehiculo(marca, modelo, color, kilometraje, año, numeroRuedas, vin,
						color, año, tipoManillar, numeroRuedas, tipoFreno, cilindrada, kilometraje, cilindrada, numeroRuedas, 
						numeroRuedas, vehi);
			} else if (vehi instanceof Camion) {
				double capacidadCarga = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga (Kg): "));
				String tipoCamion = JOptionPane.showInputDialog("Ingrese el tipo de camion: ");
				int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud: "));
				int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes: "));
				l.getInventario().ActualizarVehiculo(marca, modelo, color, kilometraje, año, numeroEjes,
						tipoCamion, marca, modelo, color, numeroEjes, año, vin, capacidadCarga, tipoCamion, longitud,
						numeroEjes, vehi);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El vehiculo no existe");
		}
	}
	

	/*************************************************
	 * METODOS DE VENTAS
	 * 
	 *************************************************/

	// Metodo para registro de ventas
	private static void registrarVenta() {
		String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
		Vehiculo vehi = l.getInventario().buscarPuntual(null,vin);
		if (vehi != null) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
			String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente:");
			Cliente clie = l.buscarPuntual(nombre, telefono);
			if (clie != null) {
				double precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la venta: "));
				Ventas venta = new Ventas(0, vehi, clie, null, precio,0);
				l.registroVentas(venta);
				double valorFinal= l.costoVent(vehi, precio, venta);
				venta.setCostoFinal(valorFinal);
				l.getInventario().eliminar(null, vin);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro un cliente para el registro de la venta");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se encontro un vehiculo para el registro de la venta");
		}
	}

	// Metodo historial de ventas
	private static void historialVentas() {
		int elegido = Integer.parseInt(JOptionPane.showInputDialog(
				"Buscar por: \n (1) Cliente. \n (2) Vehiculo. \n " + "(3) Fecha de venta"));
		String etiqueta = "";
		if (elegido == 1) {
			etiqueta += "Cliente";
		} else if (elegido == 2) {
			etiqueta += "Vehiculo";
		} else {
			etiqueta += "Fecha de venta";
		}
		JOptionPane.showMessageDialog(null, "El historial de ventas por " + etiqueta + ":");
			if (elegido == 1) {
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
				String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente:");
				Cliente c = l.buscarPuntual(nombre, telefono);
				if(c!= null) {
					boolean estado= (boolean) l.imprimirVentas(c, null, null);
					String mensaje;
					mensaje = estado == false ? "No hay ventas asociadas a este cliente" : "No hay mas ventas asociadas";
					JOptionPane.showMessageDialog(null, mensaje);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro un cliente ");
				}	
			} else if (elegido == 2) {
				String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo: ");
				Vehiculo vehi = new Vehiculo(marca, null, null, null, 0, null);
				if (vehi.getMarca() != null) {
					boolean estado= (boolean) l.imprimirVentas(null, vehi, null);
					String mensaje;
					mensaje = estado == false ? "No hay ventas asociadas vehiculo" : "No hay mas ventas asociadas";
					JOptionPane.showMessageDialog(null, mensaje);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro un vehiculo ");
				}	
			} else if (elegido == 3) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String fecha= JOptionPane.showInputDialog("Ingrese una fecha (yyyy-MM-dd):");
				LocalDate fechaUsuario = LocalDate.parse(fecha, formatter);
				boolean estado= (boolean) l.imprimirVentas(null, null, fechaUsuario);
				String mensaje;
				mensaje = estado == false ? "No hay ventas realizadas en esta fecha" : "No hay mas ventas asociadas";
				JOptionPane.showMessageDialog(null, mensaje);
			}else {
				JOptionPane.showMessageDialog(null, "Opcion no valida");
			}
	}

	
	/*************************************************
	 * METODOS DE MANTENIMIENTO
	 * 
	 *************************************************/
	
	// Metodo para registro de mantenimientos
	private static void registrarMantenimiento() {
		String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
		Vehiculo vehi = l.getInventario().buscarPuntual(null,vin);
		if (vehi != null) {
				String tipoMantenimiento= JOptionPane.showInputDialog("Ingrese el concepto de mantenimiento realizado: ");
				int valorIngresado= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del mantenimiento"));
				Mantenimiento m= new Mantenimiento(vehi,tipoMantenimiento, null, valorIngresado, 0);
				l.crearMant(m);
				double valorFinal=l.costoMant(vehi,valorIngresado,m);
				m.setCostoFinal(valorFinal);
		}else {
			JOptionPane.showMessageDialog(null, "No se encontro un vehiculo para el registro de la mantenimiento");
		}
	}
	
	
	// Metodo historial de Mantenimiento
	private static void historialMantenimiento() {
			if(l.getMantenimientos().size()>0) {
				String vin = JOptionPane.showInputDialog("Ingrese el VIN del vehiculo: ");
				Vehiculo vehi = l.getInventario().buscarPuntual(null,vin);
				if (vehi!= null) {
					boolean estado= (boolean) l.imprimirMantenimiento( vehi);
					String mensaje;
					mensaje = estado == false ? "No hay mantenimientos asociadas vehiculo" : "No hay mas mantenimientos asociadas";
					JOptionPane.showMessageDialog(null, mensaje);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro un vehiculo ");
				}	
			}else {
				JOptionPane.showMessageDialog(null, "Sin registro de mantenimiento");
			}
			
		}
	
}

