package ar.com.truco;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	public enum POSICION {JUGADOR_A, JUGADOR_B}
	public enum CANTAR {NADA,ENVIDO,REALENVIDO,FALTAENVIDO,TRUCO,RETRUCO,VALE4}
	private enum MANO {START,MANO_1,MANO_2,MANO_3,END}

	private int turno=0;
	private Participante gamerA =null;
	private Participante gamerB=null;
	private int puntajeA =0;
	private int puntajeB=0;
	private MANO mano = MANO.START;
	private List<Carta> cartas_mesa = new ArrayList<Carta>(6);
	private CANTAR lastCanto = CANTAR.NADA;
	private CANTAR cantoTruco = CANTAR.NADA;
	
	public void setJugador(Participante jugador) throws Exception{
		if (gamerA == null){
			gamerA = jugador;
			jugador.setPosicion(POSICION.JUGADOR_A);
		}else if(gamerB == null){
			gamerB=jugador;
			jugador.setPosicion(POSICION.JUGADOR_B);
		}else{
			throw new Exception("La partida tiene todos los jugadores");
		}
	}
	
	public void tirarCarta(Participante gamer, Carta carta){
		
	}
	
	public void cantar(Participante gamer, CANTAR grito){
		
	}
}
