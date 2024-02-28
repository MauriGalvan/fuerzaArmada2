package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;



public class Batalla {
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	
	
	

	public Batalla(TipoDeBatalla tipo, Double latitud,Double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
		this.vehiculosEnLaBatalla = new HashSet<Vehiculo>();
	}
	
	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	public TipoDeBatalla getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}


	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}


	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public void agregarVehiculo(Vehiculo vehiculo) throws VehiculoIncompatible {
		validarVehiculo(vehiculo);
		vehiculosEnLaBatalla.add(vehiculo);
		
	}

	public boolean validarVehiculo(Vehiculo vehiculo) throws VehiculoIncompatible {
	
		
			switch(tipo) {
		
		case TERRESTRE: {
			if((vehiculo.getTipo().equals(TipoVehiculo.Tanque))) 
				return true;
			
		}
		case Acuatica:{
			if(vehiculo.getTipo().equals(TipoVehiculo.SubMarino) || (vehiculo.getTipo().equals(TipoVehiculo.HidroAvion)||(vehiculo.getTipo().equals(TipoVehiculo.Anfibio))))
				return true;
			
		}
		case NAVAL:{
			if(vehiculo.getTipo().equals(TipoVehiculo.SubMarino) || (vehiculo.getTipo().equals(TipoVehiculo.HidroAvion)||(vehiculo.getTipo().equals(TipoVehiculo.Anfibio)|| (vehiculo.getTipo().equals(TipoVehiculo.Avion)))))
				return true;
			
		}
		
		}
	
		throw new VehiculoIncompatible();
		
	}


	
}
