package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Ventas {
	public static int venta=1;
	private int numeroDeVenta;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private LocalDate fechaVenta;
	private double precioVenta;
	private double costoFinal;
	private final double auto=10000;
	private final double moto=5000;
	private final double camion=50000;

	public Ventas(int numeroDeVenta, Vehiculo vehiculo, Cliente cliente, Date fechaVenta, double precioVenta, double costoFinal) {
		this.numeroDeVenta= venta;
		venta++;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaVenta = LocalDate.now();
		this.precioVenta = precioVenta;
		this.costoFinal=costoFinal;
	}
	
	

	@Override
	public String toString() {
		return "Venta #: " + numeroDeVenta + "\n" + vehiculo + "\n\n cliente: \n" + cliente
				+ "\n fechaVenta: " + fechaVenta + "\n precioVenta: " + costoFinal;
	}

	
	public double costoVentaAuto(double costoMantenimiento) {
		return (double) (auto + costoMantenimiento);
	}
	
	public double costoVentaMoto(double costoMantenimiento) {
		return(double) (moto + costoMantenimiento);
	}
	
	public double costoVentaCamion(double costoMantenimiento) {
		return(double) (camion + costoMantenimiento);
	}
	
	

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroDeVenta() {
		return numeroDeVenta;
	}

	public void setNumeroDeVenta(int numeroDeVenta) {
		this.numeroDeVenta = numeroDeVenta;
	}

	public double getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(double costoFinal) {
		this.costoFinal = costoFinal;
	}
	
	
	
}
