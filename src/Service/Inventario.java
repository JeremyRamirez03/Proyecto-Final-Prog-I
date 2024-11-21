package Service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.Crud;
import Model.Automovil;
import Model.Camion;
import Model.Motocicleta;
import Model.Vehiculo;

public class Inventario implements Crud{
	private ArrayList<Vehiculo> vehiculos;

	public Inventario() {
		this.vehiculos = new ArrayList<>();
	}
	
	//Metodo agregar vehiculo
	@Override
	public boolean añadir(Object o) {
		boolean esta= false;
		if(o instanceof Object) {
			Vehiculo vehiculo = (Vehiculo) o;
			boolean estado= isVehiculoExistente(vehiculo);
			if(estado==false) {
				vehiculos.add(vehiculo);
			}
			esta= !estado;
		}
		return esta;
	}
	
	private boolean isVehiculoExistente(Vehiculo vehiculo) {
		String vin = vehiculo.getVin();
		for (Vehiculo v : this.vehiculos) {
			if(v.getVin().equalsIgnoreCase(vin)) {
				return true;
			}
		}
		return false;
	}
	
	
	//Metodo buscar vehiculos
	@Override
	public boolean buscar( String marca, String modelo, String tipoVehiculo) {
		boolean estado=false;
		if(marca!=null) {
			for (Vehiculo c : getVehiculos()) {			
				if(c.getMarca().equals(marca)) {
					JOptionPane.showMessageDialog(null, c.toString());
					estado= true;
				}
			}
		}else if(modelo!=null) {
			for (Vehiculo c : getVehiculos()) {			
				if(c.getModelo().equals(modelo)) {
					JOptionPane.showMessageDialog(null, c.toString());
					estado= true;
				}
			}	
		}else if(marca==null && modelo==null) {
			int tipo= Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de vehiculo:\n (1) Automovil. \n "
					+ "(2) Motocicleta. \n (3) camion. "));
			for (Vehiculo c : getVehiculos()) {
				if(tipo>=1 && tipo<=3) {
					if(tipo==1) {
						if(c instanceof Automovil) {
							Automovil au= (Automovil)c;
							JOptionPane.showMessageDialog(null, au.toString());
							estado= true;
						}
					}else if(tipo==2) {
						if(c instanceof Motocicleta) {
							Motocicleta mo=(Motocicleta)c;
							JOptionPane.showMessageDialog(null, mo.toString());
							estado= true;
						}
					}else if(tipo==3) {
						if(c instanceof Camion) {
							Camion ca= (Camion)c; 
							JOptionPane.showMessageDialog(null, ca.toString());
							estado= true;
						}
					}
				}
			}
		}
		return estado;	
	}
	
	
	//Metodo buscar vehiculos
	@Override
	 public Vehiculo buscarPuntual(String marca,String vin) {
		for (Vehiculo c : this.vehiculos) {			
			if(c.getVin().equals(vin)) {
				return c;
			}
		}
		return null;
	}
	 
	
	//Imprimir lista vehiculos
	public void imprimirVehiculos() {
		for (Vehiculo c : vehiculos) {
			if(c instanceof Automovil) {
				Automovil a= (Automovil) c;
				JOptionPane.showMessageDialog(null,"Numero de vehiculos en inventario: "+ " " + vehiculos.size() + "\n" + a.toString());
			}else if(c instanceof Motocicleta) {
				Motocicleta m =(Motocicleta) c;
				JOptionPane.showMessageDialog(null,"Numero de vehiculos en inventario: "+ " " + vehiculos.size() + "\n" + m.toString());
			}else if(c instanceof Camion) {
				Camion ca=(Camion) c;
				JOptionPane.showMessageDialog(null,"Numero de vehiculos en inventario: "+ " " + vehiculos.size() + "\n" + ca.toString());
			}else {
				JOptionPane.showMessageDialog(null,"No hay vehiculos en inventario");
			}
			
		}
	}
	
	//Metodo eliminar vehiculo
	@Override
	public boolean eliminar(String marca, String vin) {
		Vehiculo v = buscarPuntual(null,vin);
		if(v == null) {
			return false;
		}
		vehiculos.remove(v);
		return true;
	}
	
	//Metodo actualizar vehiculo
	public void ActualizarVehiculo(String marca, String modelo, String color, double kilometraje, String año,
		int numeroPuertas, String tipoCombustible, String transmision, String traccion, String tipoManillar,
		int numeroRuedas, String tipoFreno, String cilindrada, double capacidadCarga, 
		String tipoCamion, int longitud, int numeroEjes, Vehiculo v) {
		
		v.setMarca(marca);
		v.setModelo(modelo); 
		 
		v.setColor(color); 
		v.setKilometraje(kilometraje); 
		v.setAño(año); 
		
		if(v instanceof Automovil) {
			Automovil au = (Automovil) v;
			au.setNumeroPuertas(numeroPuertas);
			au.setTipoCombustible(tipoCombustible); 
			au.setTransmision(transmision); 
			au.setTraccion(traccion);
			
		}else if(v instanceof Motocicleta) {
			Motocicleta mo = (Motocicleta) v;
			mo.setTipoManillar(tipoManillar);
			mo.setNumeroRuedas(numeroRuedas); 
			mo.setTipoFreno(tipoFreno);
			mo.setCilindrada(cilindrada); 
			
		}else if (v instanceof Camion){
			Camion ca = (Camion) v;
			ca.setCapacidadCarga(capacidadCarga); 
			ca.setTipoCamion(tipoCamion); 
			ca.setLongitud(longitud); 
			ca.setNumeroEjes(numeroEjes); 
			
		}
	}
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	

	
	

	

}
	
	
	

