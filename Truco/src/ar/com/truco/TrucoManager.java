package ar.com.truco;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import ar.com.truco.Carta.Palo;
import ar.com.truco.exceptions.TrucoException;

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
	private static int idGames = 0;
	
	/**
	 * Retorna una lista de 4 distintas cartas. Para jugar 2 jugadores.
	 * @return 4 cartas distintas
	 */
	public static List<Carta> avarajar(int toReturn){
		//TODO tiene que retornar una lista de cartas a jugar
		boolean[] maso = new boolean[40];
		for(int i=0;i<40;i++){maso[i]=false;}
		
		Random r = new Random();
		List<Carta> res = new ArrayList<Carta>(toReturn);
		// selecciono las cartas.
		for (int i=0; i<toReturn ; i++){
			int palo = (r.nextInt(4) % 4);
			int nro = (r.nextInt(40) % 10);
			int index = palo*10+nro;
			if (!maso[index]){
				maso[index] = true;
			}else{
				while(maso[++index]){
					if(index == 41)
						index=0;
				}
				maso[index]=true;
			}
		}
		//Genero las cartas
		for(int i=0;i<40;i++){
			if (maso[i]){
				Carta carta = null;
				if (i<11){ //ESPADA
					int nro =0;
					switch(i){
					case 1-7: nro = i;break;
					default: nro = i+2;break;
					}
					carta = new Carta(Palo.ESPADA, nro);
				}else if(i <21){ //basto
					int nro =0;
					switch(i){
					  case 11-17: nro = i-10;break;
					  default: nro = (i-10)+2;break;
					}
					carta = new Carta(Palo.BASTO, nro);
				}else if (i < 31){ //ORO
					int nro =0;
					switch(i){
					  case 21-27: nro = i-20;break;
					  default: nro = (i-20)+2;break;
					}
					carta = new Carta(Palo.ORO, nro);
				}else{
					int nro =0;
					switch(i){
					  case 31-37: nro = i-30;break;
					  default: nro = (i-30)+2;break;
					}
					carta = new Carta(Palo.BASTO, nro);
				}
				res.add(carta);
			}
		}
		return res;
	}
	
	public static Participante addUser( String userName){
		Participante participante = new Participante();
		participante.setUserName(userName);
		participante.setId(++count);
		usuarios.put(count, participante);
		return participante;
	}
	public static void deleteUser(int id){
		usuarios.remove(id);
	}
	public static List<Participante> getUsers(){
		List<Participante> listP = new ArrayList<Participante>(usuarios.values());
		int len = usuarios.size();
		System.out.println("len="+len);
		//Participante[] arrPart = (Participante[])usuarios.entrySet().toArray();
/*		for(int i=0;i<len;i++){
			listP.add(arrPart[i]);
		} */
		return listP;
	}
	public static Participante getUser(int userId){
		return ((Participante)usuarios.get(userId));
	}
	
	public static void setPartida(Participante playerA, Participante playerB){
		Partida partida = new Partida();
		try{
			partida.setJugador(playerA);
			partida.setJugador(playerB);
			playerA.setPartida(partida);
			playerB.setPartida(partida);
			partida.darMano();
			//TODO ver si vale la pena contar con este valor.
			juegos.put(idGames++, partida); 
		}catch(Exception e){
			System.out.println("Error al setear una partida.");
		}
	}
}
