package Model;

public class Automovil extends Vehiculo  {
	
	private int numeroPuertas;
	private String tipoCombustible;
	private String transmision;
	private String traccion;

	public Automovil(String marca, String modelo, String vin, String color, double kilometraje, String año, int numeroPuertas, 
			String tipoCombustible, String transmision, String traccion) {
		super(marca, modelo, vin, color, kilometraje, año);
		// TODO Auto-generated constructor stub
		this.numeroPuertas = numeroPuertas;
		this.tipoCombustible=tipoCombustible;
		this.transmision=transmision;
		this.traccion=traccion;
	}
	
	
	
	
	@Override
	public String toString() {
		return " Tipo de vehiculo: Automovil, "+"Marca: " + super.getMarca() + ", Modelo: " + super.getModelo() + ", Vin: " + super.getVin() + ", Color: " + super.getColor() + 
				", kilometraje: " + super.getKilometraje() + ", Año: " + super.getAño() +"\n"+ "Numero de puertas: " + numeroPuertas + 
				", Tipo de combustible: " + tipoCombustible + ", Transmision: " + transmision + ", Traccion: " + traccion ;
	}




	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}

	

	
	
}
