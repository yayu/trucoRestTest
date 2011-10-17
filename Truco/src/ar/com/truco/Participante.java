package ar.com.truco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;

import ar.com.truco.Partida.POSICION;

public class Participante {

	private String userName=null;
	private int id =0;
	private Partida partida = null;
	private POSICION posicion=null;
	private Set<Participante> interesados = new HashSet<Participante>();
	private List<Carta> cartas = null;
	
	public void setUserName(String name){
		this.userName = name;
	}
	public String getUserName(){
		return userName;
	}
	public void setId(int i){
		this.id=i;
	}
	public int getId(){
		return id;
	}
	public void setPartida(Partida p) throws Exception{
		if (partida != null)
			throw new Exception("Ya se encuentra Jugando");
		this.partida = p;
	}
	public void setPosicion(POSICION i){
		posicion = i;
	}
	
	public void setCartas(List<Carta> cartas){
		this.cartas = cartas;
	}
	
	public List<Carta> getCartas(){
		return cartas;
	}
	
	/**
	 * Posicion del usuario en la Mesa de juego.
	 * @return
	 */
	public POSICION getPosicion(){
		return posicion;
	}
	
	public void invitarAJugar(Participante player) throws Exception{
		if (partida == null){
			player.addSolicitudJuego(this);
		}else{
			throw new Exception("Estoy jugando.");
		}
	}
	
	public void addSolicitudJuego(Participante player) throws Exception{
		if (partida == null){
			interesados.add(player);
		}else{
			throw new Exception("Estoy jugando.");
		}
	}
	
	public Set<Participante> getSolicitudes(){
		return interesados;
	}
	
	public boolean isGaming(){
		return (partida != null);
	}
	
	/**
	 * Acepta la invitacion  a un juego.
	 * @param playerId
	 * @return En caso de poder aceptar la jugada retorna false, sino true.
	 * @throws Exception
	 */
	public boolean aceptarInvitacion(int playerId) throws Exception{
		boolean result = false;
		if (playerId == this.id ){
			throw new Exception("Se llamo a si mismo.");
		}
		Participante player = TrucoManager.getUser(playerId);
		if (!player.isGaming()){
			//TODO
			TrucoManager.setPartida(this, player);
			interesados.remove(player);
			result = true;
		}
		return result;
	}
	
	public boolean miTurno(){
		boolean result = false;
		if (partida != null){
			//TODO: Terminar de resolver miTurno.
			//partida.turnoPlayer(posicion);
		}
		return result;
	}
	
	/**
	 * Se arroja la carta de la posicion 'cartaPos' a la mesa.
	 * @param cartaPos
	 * @throws IndexOutOfBoundsException
	 */
	public void tirarCarta(int cartaPos) throws IndexOutOfBoundsException {
		if (partida != null){
			partida.tirarCarta(this, this.cartas.get(cartaPos));
			cartas.remove(cartaPos);
		}else{
			//TODO lanza excepcion
			System.out.println("El juegados no tiene partida asociada e intenta tirar una carta.");
		}
	}
	
	public int getPuntaje(){
		int resultado = -1;
		if (partida != null){
			resultado = partida.getPuntaje(this);
		}
		return resultado;
	}
	
	/**
	 * retorna un objecto JSON
	 */
	public String toString(){
		JSONObject json = new JSONObject();
		json.put("userName",userName);
		json.put("id", id);
		System.out.println(json.toJSONString());
		return json.toJSONString();
	}
}
