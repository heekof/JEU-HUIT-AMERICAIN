package fr.utt.lo02.jeu;
import java.util.ArrayList;



/**
 * 	La Classe Talon 
 * @author BENDRISS-NGUYEN
 *
 */
public class Talon extends EnsembleCartes {

		/**
		 * La main du joueur 
		 */
		private Main main = null;
     /**
      * L'arrayliste qui contient toutes les cartes du talon
      */
		ArrayList<Carte>  T=null;
		/**
		 * Constructeur talon 
		 */
		public Talon() {

		}
		/**
		 * Constructeur avec argument  
		 * @param E   les cartes
		 * @param nbcartemain nombre de main autorisé
		 */
		
		public  Talon(ArrayList<Carte> E, int nbcartemain) {
			//arraylist qui contient les cartes du talon
		T=new ArrayList<Carte>();
			//ajoute des cartes dans le talon
				for(int i=Main.nbmain*nbcartemain+1;i<105;i++)
				{ Carte C1= (Carte)E.get(i);
					T.add(C1);
				
				}
              		
		}
        /**
         * Affichage du talon
         */
		public void affichetalon(){
			for(int i=0;i<T.size();i++)
			{
			Carte Cz=(Carte)T.get(i);
			System.out.println(Cz.getnumberCarte()+"  "+Cz.gettypecarte()+"  \t "+i );
			}
		}
		public ArrayList<Carte> gettalon(){
			
			return T;
		}
		/**
		 * Getter of the property <tt>main</tt>
		 * 
		 * @return Returns the main.
		 * 
		 */
		//@ManyToOne
		public Main getMain() {
			return main;
		}

		/**
		 * Setter of the property <tt>main</tt>
		 * 
		 * @param main
		 *            The main to set.
		 * 
		 */
		public void setMain(Main main) {
			this.main = main;
		}

	}
