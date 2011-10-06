package ar.com.truco.user;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/user/{username: [0-9]+}")
public class Usuario {
	
	@GET
	@Produces("text/plain")
	public String getUsuario(@PathParam("username") String userName){
		return "Soy el usuario " + userName;
	}
		
	@Path("/game")
	@Produces("application/json")
	@GET
	public String getGame(@PathParam("username") String userName){
		return "Debo retornar los datos del juego.";
	}
	
	@Path("/game/truco")
	@Produces("text/plain")
	@GET
	public String cantarTruco(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y le canto truco.";
	}
	
	@Path("/game/envido")
	@Produces("application/json")
	@GET
	public String cantarEnviado(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y le canto envido.";
	}
	
	@Path("/game/realenvido")
	@Produces("text/plain")
	@GET
	public String cantarRealEnvido(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y canto real envido.";
	}
	
	@Path("/game/faltaenvido")
	@Produces("text/plain")
	@GET
	public String cantarFaltaEnvido(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y  canto falta envido.";
	}
	
	@Path("/game/retruco")
	@Produces("text/plain")
	@GET
	public String cantarRetruco(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y canto retruco.";
	}
	
	@Path("/game/vale4")
	@Produces("text/plain")
	@GET
	public String cantarTrucoVale4(@PathParam("username") String userName){
		return "soy el usuario "+ userName +" y canto truco vale 4.";
	}
	
	@Path("/game/si")
	@Produces("text/plain")
	@GET
	public String aceptarMano(@PathParam("username") String userName, @PathParam("gameId") String gameId){
		return "soy el usuario "+ userName +" jugando el juego "+ gameId +" y acepto lo cantado.";
	}
	
	@Path("/game/no")
	@Produces("text/plain")
	@GET
	public String negarMano(@PathParam("username") String userName, @PathParam("gameId") String gameId){
		return "soy el usuario "+ userName +" jugando el juego "+ gameId +" y no quiero lo cantado.";
	}
	
	@Path("quit")
	@GET
	@Produces("text/plain")
	public String salirJuego(){
		return "Sale del juego";
	}
}
