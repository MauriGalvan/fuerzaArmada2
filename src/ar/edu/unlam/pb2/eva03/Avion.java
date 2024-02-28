package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador {

	public Avion(int id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.Avion;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Double getProfundidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	protected Double getAltura() {
		// TODO Auto-generated method stub
		return 0.0;
	}
 

}
