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

@Path("/game")
public class Juego {

	/**
	 * Id del oponente del juego.
	 */
	private int oponente = -1;
	/**
	 * indico el id del jugador que debe jugar.
	 */
	private int turno = 0;
	
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
		TrucoManager.addUser(name);	
		return "debo agregar una persona";
	}
	
	@Path("/delete")
	@GET
	@Produces("text/plain")
	public String deleteUser(){
		//TODO agregar una persona al juego.
		return "debo eliminar a un usuario del juego";
	}
	
	public List<Participante> gamers(){
		List<Participante> res = new ArrayList<Participante>();
		
		return res;
	}
}
