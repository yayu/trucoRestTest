package ar.com.truco;

import java.util.ArrayList;
import java.util.List;

import ar.com.truco.exceptions.CantoNoExisteException;
import ar.com.truco.exceptions.TrucoException;

public class Partida {

	public enum POSICION {NULO,JUGADOR_A, JUGADOR_B}
	public enum CANTAR {NADA,ENVIDO,ENVIDO2,ENVIDO3,REALENVIDO,FALTAENVIDO,CANTAR_ENVIDO,CANTARON_ENVIDO,TRUCO,RETRUCO,VALE4	}
	private enum MANO {START,MANO_1,MANO_2,MANO_3,END;
	public MANO getNext() {
	     return this.ordinal() < MANO.values().length - 1
	         ? MANO.values()[this.ordinal() + 1]
	         : null;
	   }
	}

	private boolean turnoPlayerA=true;
	private Participante gamerA =null;
	private Participante gamerB=null;
	private int puntajeA =0;
	private int puntajeB=0;
	private MANO mano = MANO.START;
	private List<Carta> cartas_mesa = new ArrayList<Carta>(6);
	private CANTAR lastCanto = CANTAR.NADA;
	private POSICION cantorEnvido = POSICION.NULO;
	private CANTAR cantoTruco = CANTAR.NADA;
	private POSICION cantorTruco = POSICION.NULO;
	
	public void setJugador(Participante jugador) throws Exception{
		if (gamerA == null){
			gamerA = jugador;
			jugador.setPosicion(POSICION.JUGADOR_A);
		}else if(gamerB == null){
			gamerB=jugador;
			jugador.setPosicion(POSICION.JUGADOR_B);
			mano = MANO.MANO_1;
		}else{
			//TODO Crear Excepcion propias del juego.
			throw new Exception("La partida tiene todos los jugadores");
		}
	}
	
	public void tirarCarta(Participante gamer, Carta carta){
		if (turnoPlayerA){
			turnoPlayerA = false;
		}else{//turno del jugador B
			turnoPlayerA=true;
		}
		mano = mano.getNext();
		cartas_mesa.add(carta);
		evaluarPuntos();
	}
	
	private void evaluarPuntos() {
		
	}

	public void cantar(Participante gamer, CANTAR grito) throws TrucoException{
		//TODO Terminar de impletar las reglas del truco.
		switch(grito){
		case ENVIDO: 
			evaluarEnvido(gamer);
			break;
		case FALTAENVIDO:
			evaluarFaltaEnvido(gamer);
			break;
		case REALENVIDO: 
			evaluarRealEnvido(gamer);
			break;
		case TRUCO:
			evaluarTruco(gamer);
			break;
		case RETRUCO:
			evaluarRetruco(gamer);
			break;
		case VALE4:
			evaluarVale4(gamer);
			break;
		default:
			throw new CantoNoExisteException();
		}
	}


	private void evaluarVale4(Participante gamer) {
		// TODO Auto-generated method stub
		
	}

	private void evaluarRetruco(Participante gamer) {
		// TODO Auto-generated method stub
		
	}

	private void evaluarTruco(Participante gamer) {
		// TODO Auto-generated method stub
		
	}

	private void evaluarFaltaEnvido(Participante gamer) {
		// TODO Auto-generated method stub
		
	}

	private void evaluarEnvido(Participante gamer) {
		//TODO Contemplar envido-envido-envido.
		if (mano == MANO.MANO_1 && lastCanto == CANTAR.NADA){
			lastCanto = CANTAR.ENVIDO;
			cantorEnvido = gamer.getPosicion();
		}else{
			//TODO lanzar una excepcion.
			System.out.println("Error al evaluar el envido.");
		}
	}
	private void evaluarRealEnvido(Participante gamer) {
		if(lastCanto == CANTAR.ENVIDO && (gamer.getPosicion() != cantorEnvido)){
			lastCanto = CANTAR.REALENVIDO;
			cantorEnvido = gamer.getPosicion();
		}else{
			//TODO Lanzar Exception
			System.out.println("Se produjo un error al evaluar Real envido.");
		}
	}
}
