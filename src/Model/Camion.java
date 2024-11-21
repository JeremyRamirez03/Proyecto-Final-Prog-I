package Model;

public class Camion extends Vehiculo {
	
	private double capacidadCarga;
	private String tipoCamion;
	private int longitud;
	private int numeroEjes;
	
	public Camion(String marca, String modelo, String vin, String color, double kilometraje, String año, double capacidadCarga, 
			String tipoCamion, int longitud, int numeroEjes) {
		super(marca, modelo, vin, color, kilometraje, año);
		// TODO Auto-generated constructor stub
		this.capacidadCarga=capacidadCarga;
		this.tipoCamion=tipoCamion;
		this.longitud=longitud;
		this.numeroEjes=numeroEjes;
	}
	
	
	
	@Override
	public String toString() {
		return  "Tipo de vehiculo: Camion" + ", Marca: " + super.getMarca() + ", Modelo: " + super.getModelo() + ", Vin: " + super.getVin() + ", Color: " + super.getColor() + 
				", kilometraje: " + super.getKilometraje() + ", Año: " + super.getAño() +"\n"+ "Capacidad de carga: " + capacidadCarga + ", Tipo de camion:" + tipoCamion + ", Longitud: " + longitud
				+ ", Numero de ejes: " + numeroEjes;
	}



	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getTipoCamion() {
		return tipoCamion;
	}

	public void setTipoCamion(String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getNumeroEjes() {
		return numeroEjes;
	}

	public void setNumeroEjes(int numeroEjes) {
		this.numeroEjes = numeroEjes;
	}
	
}
