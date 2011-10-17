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
	
	public boolean turnoPlayer(Participante player){
		//TODO Terminar de calcular el turno.
		// turnoPlayerA && (player.getId == gamerA.getId()) 
		return turnoPlayerA;
	}
	
	public void darMano(){
		List<Carta> cartas =  TrucoManager.avarajar(6);
		List<Carta> l1 = new ArrayList<Carta>(3);
		List<Carta> l2 = new ArrayList<Carta>(3);
		for (int i=0; i<3; i++)
			l1.add(cartas.get(i));
		for(int i=3; i<6; i++)
			l2.add(cartas.get(i));
		System.out.println("cartas gamerA: "+ l1.size());
		System.out.println("cartas gamerB: "+ l2.size());
		gamerA.setCartas(l1);
		gamerB.setCartas(l2);
	}
	public void tirarCarta(Participante gamer, Carta carta) {
		if (turnoPlayerA && gamer.getPosicion() == POSICION.JUGADOR_A){
			//TODO terminar de implementar.
			turnoPlayerA = false;
		}else if ((!turnoPlayerA) && (gamer.getPosicion() == POSICION.JUGADOR_B)){//turno del jugador B
			turnoPlayerA=true;
		}else{
			System.out.println("Arrojo la carta cuando no es mi turno.");
			//TODO terminar de implementar.
		}
		cartas_mesa.add(carta);
		if (cartas_mesa.size() % 2 == 0){
			mano = mano.getNext();
		}
		evaluarPuntos();
	}
	
	public int getPuntaje(Participante player){
		//TODO devolver el puntaje del jugador.
		int resultado = -1;
		if (player.equals(gamerA)){
			resultado = this.puntajeA;
		}else if (player.equals(gamerB)){
			resultado = this.puntajeB;
		}
		return resultado;
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
