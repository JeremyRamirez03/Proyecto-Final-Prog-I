package Model;

import java.sql.Date;

public class Mantenimiento {
	private Vehiculo vehiculo;
	private String tipoMantenimiento;
	private Date fechaMantenimiento;
	private double costoMantenimiento;
	private double costoFinal;
	private final double auto=1000;
	private final double moto=500;
	private final double camion=5000;
	
	public Mantenimiento(Vehiculo vehiculo,String tipoMantenimiento, Date fechaMantenimiento, double costoMantenimiento, double costoFinal) {
		this.vehiculo= vehiculo;
		this.tipoMantenimiento = tipoMantenimiento;
		this.fechaMantenimiento = new Date(System.currentTimeMillis());
		this.costoMantenimiento = costoMantenimiento;
		this.costoFinal = costoFinal;
	}
	
	@Override
	public String toString() {
		return "Mantenimiento realizado: " + tipoMantenimiento + ", fecha del mantenimiento:" + fechaMantenimiento
				+ ", costo del mantenimiento:" + costoFinal + "\n";
	}
	
	public double costoMantenimientoAuto(double costoMantenimiento) {
		return (double) (auto + costoMantenimiento);
	}
	
	public double costoMantenimientoMoto(double costoMantenimiento) {
		return(double) (moto + costoMantenimiento);
	}
	
	public double costoMantenimientoCamion(double costoMantenimiento) {
		return(double) (camion + costoMantenimiento);
	}
	
	

	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public Date getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	public double getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public void setCostoMantenimiento(double costoMantenimiento) {
		this.costoMantenimiento = costoMantenimiento;
	}

	public double getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(double costoFinal) {
		this.costoFinal = costoFinal;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}
