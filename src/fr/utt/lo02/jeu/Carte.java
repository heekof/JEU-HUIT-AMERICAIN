package fr.utt.lo02.jeu;
/**
 * 	Classe Carte definition d une carte
 * @author NGUYEN-BENDRISS
 *
 *
 */
public class Carte {

		/**
		 * L'Ensemble de toutes mes cartes
		 */
		private EnsembleCartes ensembleCartes = null;
       
		/**
		 * Joker -Trefle -Coeur....
		 */
		private String typeCarte;
		/**
		 * numero de carte 8-10-7-A-K-Q....etc
		 */
		private String numberCarte;
		/**
		 * getteur type carte
		 */
		public String gettypecarte(){return this.typeCarte;
		
		}
		/**
		 * setteur type carte
		 */
		public void settypecarte(String typeCarte){
			this.typeCarte=typeCarte;
		}
		/**
		 *set numberCarte 
		 */
		public void setnumberCarte(String numberCarte){
			this.numberCarte=numberCarte;
		}
		/**
		 * get numberCarte
		 */
		public String getnumberCarte(){
			return this.numberCarte;
		}
		/**
		 * Getter of the property <tt>ensembleCartes</tt>
		 * 
		 * @return Returns the ensembleCartes.
		 * 
		 */
       
		public EnsembleCartes getEnsembleCartes() {
			return ensembleCartes;
		}

		/**
		 * Setter of the property <tt>ensembleCartes</tt>
		 * 
		 * @param ensembleCartes
		 *            The ensembleCartes to set.
		 * 
		 */
		public void setEnsembleCartes(EnsembleCartes ensembleCartes) {
			this.ensembleCartes = ensembleCartes;
		}

	
		/**
		 * methode afficher retourne un String 
		 */
		public String afficher(){
			return "La carte est :"+numberCarte+","+typeCarte;
		}
		/**
		 * Constructeur ss arguments
		 */
		public Carte(){}
		/**
		 * constructeur avec argument
		 */
		public Carte(String typeCarte,String numberCarte){
			
			this.typeCarte=typeCarte;
			this.numberCarte=numberCarte;
		}
	}
