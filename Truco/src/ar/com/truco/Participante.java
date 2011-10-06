package ar.com.truco;

import org.json.simple.JSONObject;

import ar.com.truco.Partida.POSICION;

public class Participante {

	private String userName=null;
	private int id =0;
	private Partida partida = null;
	private POSICION posicion=null;
	
	public void setUserName(String name){
		this.userName = name;
	}
	public void setId(int i){
		this.id=i;
	}
	public void setPartidaId(Partida p){
		this.partida = p;
	}
	public void setPosicion(POSICION i){
		posicion = i;
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
