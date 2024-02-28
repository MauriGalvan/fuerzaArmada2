package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;
TipoDeBatalla tipo;
	
	public FuerzaArmada() {
	
		this.convoy = new HashSet<Vehiculo>();
		this.batallas = new HashMap<String, Batalla>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
	
		convoy.add(vehiculo);
		
	} 
	
	public Vehiculo buscarVehiculoPorID(Integer id) throws VehiculoInexistenteException {
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getId().equals(id)) {
				return vehiculo;
			}	
	}
			throw new VehiculoInexistenteException();
}
	
	
	
	
	
	

	public Map<String, Batalla> getBatallas() {
		return batallas;
	}

	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}
	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void crearBatalla(String string, TipoDeBatalla tipoBatalla, Double latitud, Double longitud) {

		batallas.put(string, new Batalla(tipoBatalla , latitud , longitud));
		
		
	}

	public void presentarBatalla(String nombreBatalla) throws batallaInexistente {
		
		if(batallas.containsKey(nombreBatalla)) {
			Batalla batalla = batallas.get(nombreBatalla);
		
			System.out.println("Detalles de la batalla: "+ nombreBatalla);
			System.out.println("Tipo de batalla: " + batalla.getTipo() );
			System.out.println("latitud: " + batalla.getLatitud());
			System.out.println("Longitud: " + batalla.getLongitud());
		} else {
			throw new batallaInexistente();
		}
		
		
		
	}

	public boolean enviarALaBatalla(String nombreBatalla, Integer idVehiculo) throws batallaInexistente, VehiculoInexistente, VehiculoIncompatible {
		Batalla batalla = buscarBatallaPorNombre(nombreBatalla);
		Vehiculo vehiculo = buscarVehiculo(idVehiculo);
	
//		batalla.agregarVehiculo(vehiculo);
//	
//		return true;
		  if (!esCompatible(vehiculo, batalla.getTipo())) {
		        throw new VehiculoIncompatible();
		    }
		    
		    batalla.agregarVehiculo(vehiculo);
		    return true;
		}

		private boolean esCompatible(Vehiculo vehiculo, TipoDeBatalla tipoBatalla) {
		    if (tipoBatalla == TipoDeBatalla.TERRESTRE && vehiculo instanceof Submarino) {
		        return false;
		    }

			return true;
	    }
		

	

	private Vehiculo buscarVehiculo(Integer idVehiculo) throws VehiculoInexistente {
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getId().equals(idVehiculo)) {
				return vehiculo;
			}
		}
		throw new VehiculoInexistente("vehiculo inexistente");
	}

	private Batalla buscarBatallaPorNombre(String nombreBatalla) throws batallaInexistente {
		if(batallas.containsKey(nombreBatalla)) {
			return this.batallas.get(nombreBatalla);
		}
		throw new batallaInexistente();
		
	}

	
	

	
}
	