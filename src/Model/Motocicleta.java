package Model;

public class Motocicleta extends Vehiculo {
	
	private String tipoManillar;
	private int numeroRuedas;
	private String tipoFreno;
	private String cilindrada;
	
	public Motocicleta(String marca, String modelo, String vin, String color, double kilometraje, String año, String tipoManillar,
			int numeroRuedas, String tipoFreno, String cilindrada) {
		super(marca, modelo, vin, color, kilometraje, año);
		// TODO Auto-generated constructor stub
		this.tipoManillar=tipoManillar;
		this.numeroRuedas=numeroRuedas;
		this.tipoFreno=tipoFreno;
		this.cilindrada=cilindrada;
	}
	
	
	
	@Override
	public String toString() {
		
		return "Tipo de vehiculo: Motocicleta, " + "Marca: " + super.getMarca() + ", Modelo: " + super.getModelo() + ", Vin: " + super.getVin() + ", Color: " + super.getColor() + 
		", kilometraje: " + super.getKilometraje() + ", Año: " + super.getAño()+"\n"+ "tipo de manillar: " + tipoManillar + ", numero de ruedas: " + numeroRuedas + ", tipo de freno: "
				+ tipoFreno + ", cilindrada:" + cilindrada ;
	}



	public String getTipoManillar() {
		return tipoManillar;
	}

	public void setTipoManillar(String tipoManillar) {
		this.tipoManillar = tipoManillar;
	}

	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}

	public String getTipoFreno() {
		return tipoFreno;
	}

	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}
	
}
