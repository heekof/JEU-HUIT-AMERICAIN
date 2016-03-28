package fr.utt.lo02.jeu;
import fr.utt.lo02.exception.mainVideException;
import fr.utt.lo02.exception.nbPointsException;
import fr.utt.lo02.exception.nbToursException;
import fr.utt.lo02.exception.talonVideException;


	
/**
 * classe mere  joueur
 * 
 * @author NGUYEN BENDRISS
 * 
 */
	public   class Joueur {
		/**
		 * nombre de tour qu'a joué ce joueur
		 */
		public  static int nbtours=0;
		/**
		 * La main du joueur 
		 */
		public Main main = null;
		/**
		 * La couleur qu'a choisie ce joueur si jamais il pose un
		 * huit ou un joker
		 */
		public static  String choixcouleur="null";
		/**
		 * temoin joker : si le joueur pose un joker on la met à 1
		 * sert aussi à calculer l'accumulation 
		 */
		public static int Joker=0;
		/**
		 * Carte
		 */
		public int carte ;
		/**
		 * temoin de la couleur si le joueur a choisie une couleur on  la met à 1 sinon à 0
		 */
		public static int couleur=0;
			
		/**
		 * accumulation as
		 * et temoin as 
		 */
		public static int as=0 ;
		
		/**
		 * le comptage de 7
		 */
		public static int sept ;
		
		/**
		 * accumulation deux
		 * et temoin deux
		 */
		public static int deux=0 ;
		/**
		 * TEMOIN du huit
		 */
		public static int huit=0 ;  
		
	
	/**
	 * La main du joueur 
	 * @param main 
	 */
	public void	setmain(Main main){this.main=main; System.out.println("main du joueur reel créee !");};
	
	/**
	 * 
	 * @return La main du joueur 
	 */
	public Main getmain(){return main;}
		
	
/**
 * Constructeur Joueur
 */
		public Joueur(){
			
		}
		
		/**
		 * pour la console
		 * methode qui permet au joueur de jouer methode abstraite 
		 * @throws mainVideException interruption du jeu si la main est vide
		 * @throws talonVideException interruption du jeu si le Talon est vide 
		 * @throws nbPointsException  interruption du jeu si le nbre de point est atteint
		 * @throws nbToursException interruption du jeu si le nombre de tours est atteint
		 */
		public boolean joue(Pile P,Talon T,Croupier C) throws talonVideException, mainVideException, nbPointsException, nbToursException{return true;};
		
		/**
		 * pour l'interface graphique
		 * methode qui permet au joueur de jouer methode abstraite 
		 * @throws mainVideException interruption du jeu si la main est vide
		 * @throws talonVideException interruption du jeu si le Talon est vide 
		 * @throws nbPointsException  interruption du jeu si le nbre de point est atteint
		 * @throws nbToursException interruption du jeu si le nombre de tours est atteint
		 */
		public boolean joue(Pile P,Talon T,Croupier C, String index) throws talonVideException, mainVideException, nbPointsException, nbToursException{return true;};
		
		/**
		 * methode abstraite qui permet de recuperer un nom 
		 */
		public String getnom(){
			return "";
		}
	 /**
	  * Utiliser par les joueurs reels et virtuels pour piocher 
	  * @param T Talon d'où on pioche
	  */
	 public void piocher(Talon T)
	 {  
	 	
	 	//si le talon est plein je pioche 
	 	if(T.gettalon().isEmpty()==false)
	 	{
	 	// piocher dans talon et donc ajouter a la main une carte a partir detalon  
	 	Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
	 	main.getmain().add(  C );
	 	
	 	
	 	//une fois terminé supprimé du talon la carte
	 	T.gettalon().remove(T.gettalon().size()-1);
	 	}
	 	//utilser random et mettre ajour la pile !!
	 }

	}
