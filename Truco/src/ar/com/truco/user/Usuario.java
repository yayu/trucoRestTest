package ar.com.truco.user;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.simple.JSONArray;

import ar.com.truco.Participante;
import ar.com.truco.TrucoManager;

@Path("/user/{userID: [0-9]+}")
public class Usuario {
	
	@GET
	@Produces("application/json")
	public String getUsuario(@PathParam("userID") int userId){
		Participante p = TrucoManager.getUser(userId);
		return p.toString();
	}
	
	@Path("/invitar")
	@POST
	@Produces("application/json")
	public String invitar(@PathParam("userID") int userId, @FormParam("toUser") int name){
		JSONArray res = new JSONArray();
		Participante p = TrucoManager.getUser(userId);
		
		return res.toJSONString();
	}
		
	@Path("/game")
	@Produces("application/json")
	@GET
	public String getGame(@PathParam("userID") int userId){
		Participante p = TrucoManager.getUser(userId);
		return "Debo retornar los datos del juego.";
	}
	
	@Path("/game/truco")
	@Produces("text/plain")
	@GET
	public String cantarTruco(@PathParam("userID") int userId){
		return "soy el usuario "+ userId +" y le canto truco.";
	}
	
	@Path("/game/envido")
	@Produces("application/json")
	@GET
	public String cantarEnviado(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" y le canto envido.";
	}
	
	@Path("/game/realenvido")
	@Produces("text/plain")
	@GET
	public String cantarRealEnvido(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" y canto real envido.";
	}
	
	@Path("/game/faltaenvido")
	@Produces("text/plain")
	@GET
	public String cantarFaltaEnvido(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" y  canto falta envido.";
	}
	
	@Path("/game/retruco")
	@Produces("text/plain")
	@GET
	public String cantarRetruco(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" y canto retruco.";
	}
	
	@Path("/game/vale4")
	@Produces("text/plain")
	@GET
	public String cantarTrucoVale4(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" y canto truco vale 4.";
	}
	
	@Path("/game/si")
	@Produces("text/plain")
	@GET
	public String aceptarMano(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" acepto lo cantado.";
	}
	
	@Path("/game/no")
	@Produces("text/plain")
	@GET
	public String negarMano(@PathParam("userID") int userName){
		return "soy el usuario "+ userName +" no quiero lo cantado.";
	}
	
	@Path("quit")
	@GET
	@Produces("text/plain")
	public String salirJuego(){
		return "Sale del juego";
	}
}
