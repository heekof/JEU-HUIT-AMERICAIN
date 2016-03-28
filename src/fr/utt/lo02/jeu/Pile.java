package fr.utt.lo02.jeu;
	import java.util.*;

	/**
	 * 
	 * La classe Pile represente toutes les cartes qui sont 
	 * posées sur le tapis 
	 * on s interesse seulement a la derniere 
	 * @author DONG-BENDRISS
	 *
	 */
	public class Pile extends EnsembleCartes {


		/**
		 * l'arraylist qui contient toutes les cartes dans la
		 * PILE 
		 */
		ArrayList<Carte> P=null;
		
		/**
		 * Constructeur de la pile
		 * @param E1
		 */
		public Pile(ArrayList<Carte> E1) {
		//Creation de l arraylist qui va contenir les cartes de la pile
           P=new ArrayList<Carte>();
           
           
        
           //integration de la premiere carte dans la pile
           for(int i=0;i<10;i++)
           {
           Carte C1= (Carte)E1.get(i);
           // NE PAS AVOIR UNE CARTE SPECIALE COMME BERGERE
           	if(!C1.getnumberCarte().matches("AS") && !C1.getnumberCarte().matches("7") && !C1.getnumberCarte().matches("2") && !C1.getnumberCarte().matches("8") && ! C1.getnumberCarte().matches("Joker") && ! C1.getnumberCarte().matches("10") && ! C1.getnumberCarte().matches("8") )
                    {P.add(C1);
                    //On retire cette carte de l'ensemble de cartes
                    E1.remove(i);
                    break;
                    }
			
           }
           
		}
		
		
		
		
		
		
		/**
		 * fonction qui affiche la pile 
		 */
		public void affiche(){
			for(int i=0;i<P.size();i++)
			{Carte Cz=(Carte)P.get(i);
			System.out.println(Cz.getnumberCarte()+"  "+Cz.gettypecarte()+"  \t " );
			}
		}
		/**
		 * fonct qui retourne la derniere carte de la pile
		 */
		public Carte getpilecarte(){
			Carte Cz=(Carte)P.get(P.size()-1);
			return Cz;	
		}
		/**
		 * getteur de la pile 
		 * @return
		 */
		public ArrayList<Carte> getpile(){
					return P;	
		}
		
		
	}
