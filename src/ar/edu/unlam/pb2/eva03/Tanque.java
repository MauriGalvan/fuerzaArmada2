package ar.edu.unlam.pb2.eva03;

public class Tanque extends Vehiculo implements Terrestre {

	public Tanque(int id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void avanzarSobreTierra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.Tanque;
	}

	@Override
	protected Double getProfundidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	protected Double getAltura() {
		// TODO Auto-generated method stub
		return null;
	}

}
