package ar.com.truco;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * Administración del juego.
 * @author Administrador
 *
 */
public class TrucoManager {

	/**
	 * Ver como manejarlo sincronizados.
	 * Cada usuario tiene cartas, y el oponente.
	 */
	private static HashMap usuarios = new HashMap();
	private static int count =0;
	/**
	 * El juego tiene los usuarios, puntos de cada uno,
	 * quien tira, quien canto, que debería seguir.
	 */
	private static HashMap juegos = new HashMap();
	
	public static String avarajar(){
		//TODO tiene que retornar una lista de cartas a jugar
		return "";
	}
	
	public static void addUser( String userName){
		Participante participante = new Participante();
		participante.setUserName(userName);
		participante.setId(count++);
		usuarios.put(count, participante);
	}
	public static void deleteUser(int id){}
	public static String getUsers(){
		return usuarios.entrySet().toString();
	}
	public static String getUser(int userId){
		return ((Participante)usuarios.get(userId)).toString();
	}
}
