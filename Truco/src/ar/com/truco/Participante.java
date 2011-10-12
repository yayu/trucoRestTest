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
	public void setPartidaId(Partida p){
		this.partida = p;
	}
	public void setPosicion(POSICION i){
		posicion = i;
	}
	
	/**
	 * Posicion del usuario en la Mesa de juego.
	 * @return
	 */
	public POSICION getPosicion(){
		return posicion;
	}
	
	public void invitar(Participante player) throws Exception{
		//TODO implementarlo.
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
		}
		return result;
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
