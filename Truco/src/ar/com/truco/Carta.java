package ar.com.truco;

public class Carta {

	public enum Palo {
		ESPADA, ORO, COPA, BASTO
	}
	private Palo palo;
	private int numero = 0;
	
	/**
	 * Valor de la carta con respecto a la de entrada.
	 * @param carta
	 * @return 0 = mismo valor <br> 1 = Menor <br> -1= Mayor
	 */
	public int isMayor(Carta carta){
		//TODO realizar la comparativa
		return getPos(this) - getPos(carta);
	}
	
	public int getNro(){
		return numero;
	}
	
	public Palo getPalo(){
		return palo;
	}
	
	public static int getPos(Carta carta){
		int value=-1;
		 switch (carta.getNro()){
		 case 1:
			 Palo p= carta.getPalo();
			 if (p == Palo.ESPADA){
				 value=0;
			 }else if(p==Palo.BASTO){
					 value=1;
			 }else{
					 value=6;
			 }break;
		 case 7:
			 Palo p2= carta.getPalo();
			 if (p2 == Palo.ESPADA){
				 value=2;
			 }else if(p2==Palo.ORO){
				 value=3;
			 }else{
				 value=10;
			 }break;
		 case 3:value=4;break;
		 case 2:value=5;break;
		 case 12:value= 7;break;
		 case 11:value=8;break;
		 case 10:value=9;break;
		 case 6:value=11;break;
		 case 5:value=12;break;
		 case 4:value=13;break;
		}
		
		return value;
	}
}
