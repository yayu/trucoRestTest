package ar.com.truco;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Path("/game")
public class Juego {
	
	@GET
	@Produces("text/plain")
	public String juego(){
		return "listar los jugadores";
	}
	
	@Path("/add")
	@POST
	@Produces("text/plain")
	public String addUser(@FormParam("name") String name){
		//TODO agregar una persona al juego.
		Participante jug = TrucoManager.addUser(name);	
		return jug.toString();
	}
	
	@Path("/delete")
	@GET
	@Produces("text/plain")
	public String deleteUser(){
		//TODO agregar una persona al juego.
		return "debo eliminar a un usuario del juego";
	}
	
	@Path("/users")
	@GET
	@Produces("text/plain")
	public String gamers(){
		JSONArray res = new JSONArray();
		for(Participante p : TrucoManager.getUsers()){
			res.add(p);
		}
		return res.toJSONString();
	}
}
