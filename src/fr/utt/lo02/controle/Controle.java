package fr.utt.lo02.controle;
import fr.utt.lo02.jeu.Croupier;

/**
 * 
 * La classe controle est le C du MVC :elle controle l'interface graphique et le programme
 * elle utilise pour cela un thread ! 
 * @author BENDRISS-NGUYEN 
 *
 */
public class Controle  {
/**
 * variable de type croupier 
 */
	private static Croupier C;
	/**
	 * si interfarcegraphique est vrai l'interface graphique est lancée 
	 * sinon le mode console demarre .
	 */
	public static boolean interfacegraphique=false;
	/**
	 * La méthode d'entrée dans le programme .
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 C=new Croupier();
		
	
		 C.executer(interfacegraphique);
	   
        
	}
    
	
	/**
	 * methode qui retourne le croupier crée par la classe controle 
	 * @return
	 */
	public static Croupier getCroupier(){
		return C;
	}

}
