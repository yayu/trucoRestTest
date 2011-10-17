package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ar.com.truco.Carta;
import ar.com.truco.Participante;
import ar.com.truco.Partida;
import ar.com.truco.TrucoManager;

public class PartidaSimpleTest {

	@Test
	public void addUser() {
		// fail("Not yet implemented");
		Participante p1 = TrucoManager.addUser("pepe");
		assertNotNull(p1);
		List listUsers = TrucoManager.getUsers();
		int len = listUsers.size();
		assertEquals(len,1);
		Participante p2 = (Participante)listUsers.get(0);
		assertEquals(p2.getId(),p1.getId());
		assertEquals(p1.getUserName(),p2.getUserName());
		TrucoManager.deleteUser(p1.getId());
		assertEquals(TrucoManager.getUsers().size(),0);
	}
	
	@Test
	public void tirarCartas(){
		List<Carta> cartas = TrucoManager.avarajar(6);
		int len = cartas.size();
		System.out.println("Long de cartas avarajadas: " + len);
		assertEquals(6,len);
		// comparo todas las cartas!
		for(int i = 0; i<3 ; i++){
			for(int j=i+1; j<4; j++){
				assertEquals((Carta)cartas.get(i), (Carta)cartas.get(i));
			}
		}
	}
	
	@Test
	public void agregarUsuarios(){
		// no interesa el nombre agregado.
		for(int i=0; i < 3; i++)
			TrucoManager.addUser("pepe");
		assertEquals(TrucoManager.getUsers().size(),3);
	}
	
	@Test
	public void invitarAlJuego() throws Exception{
		Participante p1 = TrucoManager.addUser("pepe");
		Participante p2 = TrucoManager.addUser("matias");
		Participante p3 = TrucoManager.addUser("tito");
		p1.invitarAJugar(p2);
		p1.invitarAJugar(p2);
		p1.invitarAJugar(p3);
//		p2.aceptarJuego();
		assertEquals(p1.getSolicitudes().size(),0);
		assertEquals(p2.getSolicitudes().size(),1);
	}
	
	@Test
	public void aceptarInvitacion() throws Exception{
		Participante p1 = TrucoManager.addUser("pepe");
		Participante p2 = TrucoManager.addUser("matias");
		assertFalse(p1.isGaming());
		assertFalse(p2.isGaming());
		p1.invitarAJugar(p2);
		assertFalse(p1.isGaming());
		assertFalse(p2.isGaming());
		assertEquals(p1.getSolicitudes().toArray().length,0);
		assertEquals(p2.getSolicitudes().toArray().length,1);
		int id_ = ((Participante)p2.getSolicitudes().toArray()[0]).getId();
		p2.aceptarInvitacion(id_);
		System.out.println(p2.getSolicitudes().size());
		assertEquals(p1.getSolicitudes().size(),0);
		assertEquals(p2.getSolicitudes().size(),0);
		assertTrue(p1.isGaming());
//		System.out.println("cantidad de cartas del playerA=" + p1.getCartas().size());
		assertEquals(p1.getCartas().size(),3);
		assertEquals(p2.getCartas().size(),3);
		// valido que las cartas sean distintas.
		List<Carta> l1 = p1.getCartas();
		List<Carta> l2 = p2.getCartas();
		for(int i=0; i < 3; i++){
			for(int j=0; j< 3; j++){
				assertTrue(!(l1.get(i).equals(l2.get(j))));
			}
		}
	}
	
	@Test
	public void testTirarCarta() throws Exception{
		Participante p1 = TrucoManager.addUser("pepe");
		Participante p2 = TrucoManager.addUser("matias");
		Partida partida = new Partida();
		partida.setJugador(p1);
		partida.setJugador(p2);
		p1.setPartida(partida);
		p2.setPartida(partida);
		partida.darMano();
		p1.tirarCarta(0);
		System.out.println("Cantidad de cartas:" + p2.getCartas().size());
		System.out.println("Cantidad de cartas:" + p1.getCartas().size());
		
		assertEquals(p1.getCartas().size(), 2);
		assertEquals(p2.getCartas().size(), 3);
		assertTrue(p1.getPuntaje()> -1);
		assertTrue(p2.getPuntaje()> -1);
	}
	
	@Test
	public void ejecutarPrimerMano() throws Exception{
		Participante p1 = TrucoManager.addUser("pepe");
		Participante p2 = TrucoManager.addUser("matias");
		p1.invitarAJugar(p2);
		int id_ = ((Participante)p2.getSolicitudes().toArray()[0]).getId();
		p2.aceptarInvitacion(id_);
		// ya estan jugando.
		assertTrue(p1.isGaming());
		assertTrue(p2.isGaming());
		p1.tirarCarta(0);
		assertEquals(p1.getCartas().size(),2);
		assertEquals(p2.getCartas().size(),3);
		p2.tirarCarta(0);
		// 2da mano.
		assertEquals(p1.getCartas().size(),2);
		assertEquals(p2.getCartas().size(),2);	
		p1.tirarCarta(0);
		p2.tirarCarta(0);
		assertEquals(p1.getCartas().size(),1);
		assertEquals(p2.getCartas().size(),1);
		// 3er mano.
		p1.tirarCarta(0);
		p2.tirarCarta(0);
		assertEquals(p1.getCartas().size(),0);
		assertEquals(p2.getCartas().size(),0);
		
		assertTrue(p1.getPuntaje() > -1);
		assertTrue(p2.getPuntaje() > -1);
	}

}
