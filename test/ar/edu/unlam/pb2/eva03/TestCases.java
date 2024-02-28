package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TestCases {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Volador avion = new Avion(1, "A-10");
		assertNotNull(avion);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Terrestre tanque = new Tanque(5, "Renault FT");

		
		assertEquals(0.0, ((Vehiculo) tanque).getVelocidad(), 0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Acuatico submarino = new Submarino(8, "ARA - San Juan");

		
		assertEquals(0.0, ((Vehiculo) submarino).getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio var = new Anfibio(12, "LARC-5");

		
		assertEquals(0.0, var.getVelocidad(), 0.01);
		assertEquals(0.0, var.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		HidroAvion ag600 = new HidroAvion(12, "AG600");

		
		assertEquals(0.0, ((Vehiculo) ag600).getAltura(), 0.01);
		assertEquals(0.0, ag600.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		
		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Submarino(6, "ARA - San Juan"));
		argentina.agregarVehiculo(new HidroAvion(7, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(8, "LARC-5"));
		 
		Integer cantidadVehiculos = argentina.getConvoy().size();
		Integer ve = 8;
		assertEquals( ve, cantidadVehiculos);
		

	}

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.getBatallas().get("San Lorenzo").getLatitud()==100.5);
		assertTrue( argentina.getBatallas().get("San Lorenzo").getLongitud() == 20.3);

	}



	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistente, VehiculoIncompatible, batallaInexistente {
		FuerzaArmada argentina = new FuerzaArmada();

		

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Tanque(6, "T-72"));
		argentina.agregarVehiculo(new Tanque(7, "T-72"));
		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5 , 20.4);
		
		argentina.presentarBatalla("San Lorenzo");
		

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}

	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible, batallaInexistente {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));		
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnSubmarino() throws VehiculoInexistente, VehiculoIncompatible, batallaInexistente {
		FuerzaArmada argentina = new FuerzaArmada();

//		argentina.agregarVehiculo(new Submarino(5, "Renault FT"));
//	
//
//		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
//
//		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		argentina.agregarVehiculo(new HidroAvion(10, "A-10"));
		argentina.agregarVehiculo(new Anfibio(11, "A-10"));
		argentina.agregarVehiculo(new Avion(12, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
	//	assertEquals(12, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.Acuatica, 200.5, 45.8);

	assertTrue(argentina.enviarALaBatalla("Pacifico", 5));
			
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));	
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		

	}

	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible, batallaInexistente {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		


		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 4));
	}
}
