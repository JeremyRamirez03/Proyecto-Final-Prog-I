package Model;



public class Vehiculo {
	private String marca; 
	private String modelo;
	private String vin;
	private String color;
	private double kilometraje;
	private String año;
	
	public Vehiculo(String marca, String modelo, String vin, String color, double kilometraje, String año) {
		this.marca = marca;
		this.modelo = modelo;
		this.vin = vin;
		this.color = color;
		this.kilometraje = kilometraje;
		this.año = año;
	}
	
	

	@Override
	public String toString() {
		return "Vehiculo: " + marca + ", modelo: " + modelo + ", vin: " + vin + ", color: " + color
				+ ", kilometraje: " + kilometraje + ", año: " + año;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

}
