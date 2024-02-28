package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Acuatico,Volador{

	public HidroAvion(int id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sumergir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Double getProfundidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.HidroAvion;
	}

	@Override
	protected Double getAltura() {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
