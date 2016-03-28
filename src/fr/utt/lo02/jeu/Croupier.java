package fr.utt.lo02.jeu;
		import java.util.*;

//	import javax.persistence.OneToMany;
	//import javax.persistence.OneToOne;



import fr.utt.lo02.controle.*;
import fr.utt.lo02.exception.mainVideException;
import fr.utt.lo02.exception.nbPointsException;
import fr.utt.lo02.exception.nbToursException;
import fr.utt.lo02.exception.talonVideException;
import fr.utt.lo02.strategies.Strategy;
import fr.utt.lo02.strategies.strategieAvancee;
import fr.utt.lo02.strategies.strategieStandard;
    







/**
     *  Classe Croupier est  l'arbitre qui gère tout le jeu 
     *  @author BENDRISS-NGUYEN 
     */
	public class Croupier   {
		
		/**
		 * booleen qui indique si le joueur reel a joue pour l'interface graphique
		 */
		private static boolean tourFini;
		
		/**
		 * l'indice du joueur précédent
		 */
		 private int indicejoueurprecedent ;
		 
		 
		 /**
		 * Arraylist permettant de sélectionner les noms des joueurs reels pour l'interface graphique
		 */
		 private ArrayList<Integer> nomInterG= new  ArrayList<Integer>();
		 
		 /**
			 * Arraylist contenant les indices des joueurs reels
			 */
		private ArrayList<Integer> arrayLindiceJReel = new ArrayList<Integer>();
		
		/**
		 * L'indice du joueur réel en train de jouer
		 */
		private int indiceJReelJouant;
		
		 
		/**
		  *  nombre de tours maximale dans une partie 
		  *  0 : signifie que le nombre de tours n'est pas pris en compte 
		  */
		public static  int nbtours=0;
		 /**
		  *  nombre de Points minimale dans une partie 
		  *  0 : signifie que le nombre de Points n'est pas pris en compte 
		  */
		public static int nbpoints=0;
		/**
		 * Nombre de joueur reel dans une partie 
		 */
		public static int nbjr=0;
		/**
		 * Nombre de joueur Virtuel dans une partie 
		 */
		public static int nbjv=0;
	
		/**
		 * Nombre de Cartes dans une seule main 
		 */
		public static int nbcartemain=0;
	/**
	 * La Pile represente les Carte posées sur lesquelles on joue tapis
	 */
		public static  Pile P;
		
		/**
		 * Le Talon represente les cartes a piocher
		 */
		public static  Talon T;
		/**
		 * La difficulté du joueur virtuel 0 :facile 
		 * 1:difficile
		 */
		private Strategy s;
		/**
		 * lecture du choix de l utilisateur s il veut rejoué ou pas 
		 */
		Scanner rejoue=new Scanner(System.in);
		/**
		 * reponse a la question au dessus
		 */
		String reponse;
		/**
		 * la reponse a la question au dessus 
		 */
		boolean rejouer=false;
		/**
		 * Instanciation du joueur  virtuel 
		 */
    	 Virtuel V1;
    	 /**
 		 * Instanciation du joueur  reel 
 		 */
    	 Reel R1;
    	 
    	 /**
    	  * variable pour savoir si la boucle  principale
    	  *  du jeu est terminé ou pas
    	  */
    	 private int fin;
    	 /**
    	  * Arraylist qui contient tous les joueurs reels et virtuels
    	  */
    	public ArrayList<Joueur> J=null;
    	/**
    	 * ArrayList qui contient toutes les cartes du jeu
    	 */
    	static ArrayList<Carte> E1=null;
		
		 Croupier C ;
		 
		/**
		 *  variable pour incrementer joueur virtuel   et reel
		 */
		int iv=0;// variable pour incrementer joueur virtuel  
		int j=0;// variable pour incrementer reel 
		/**
		 * numero de partie 
		 */
		private static int numpartie=0;
	    /**
	     * le nombre total de joueur 
	     */
		 public int nbjoueurs ;
		 
		
		
		
		/**
		 * variable pour la boucle du sens normale
		 */
		//variable pour la boucle du sens normale
		int i=0;
		public Scanner getRejoue() {
			return rejoue;
		}



        /**
         * getteur rejoue voir variable rejoue
         * @param rejoue
         */
		public void setRejoue(Scanner rejoue) {
			this.rejoue = rejoue;
		}



/**
 * getteur Response voir variable response
 */
		public String getReponse() {
			return reponse;
		}



/**
 * Setteur response
 * @param reponse
 */
		public void setReponse(String reponse) {
			this.reponse = reponse;
		}



/**
 * Getteur rejouer 
 * @return
 */
		public boolean isRejouer() {
			return rejouer;
		}



/**
 * Setteur rejouer
 * @param rejouer
 */
		public void setRejouer(boolean rejouer) {
			this.rejouer = rejouer;
		}



/**
 * Getteur variable
 * @return
 */
		public int getVariable() {
			return variable;
		}



/**
 * Setteur variable
 * @param variable
 */
		public void setVariable(int variable) {
			this.variable = variable;
		}



/**
 * Getteur P
 * @return
 */
		public int getP() {
			return p;
		}



/**
 * Setteur P
 * @param p
 */
		public void setP(int p) {
			this.p = p;
		}
		// variable pour savoir dans quel sens onn est 
		int variable=0;
		//variable du sens inverse
		int p=0;
		
		/**
		 * Fonction principale du jeu ,c'est la fonction par laquelle le croupier controle toute la partie
		 * le sens,les prametres....
		 * @param interfacegraphique : si elle est vrai on bascule dans l'interface
		 * graphique sinon on joue dans le mode console
		 */
		public   void executer(boolean interfacegraphique) {
			
			//boucle de saisie des parametres
			do{
				//numero de la partie en cours
				numpartie++;
				
			boolean entrer=true ;
			 
			
			// tous les Scanners pour saisir les choix du joueurs 
			Scanner src=new Scanner(System.in);
			Scanner src1=new Scanner(System.in);
			Scanner src2=new Scanner(System.in);
			Scanner src3=new Scanner(System.in);
			Scanner src4=new Scanner(System.in);
			//variables des parametres
			int joueursreels=0,joueursvirtuels=0,nombtours=0,nombpoints=0,nbcartes=0,difficulte=0,temoin=0;
			
			// cette variable est vrai , si on veut joué avec l'interface graphique 
			if(interfacegraphique==false){
				
				do{temoin=1;
				
				try{	
				while(entrer){	
				System.out.println("ENTRER LE NOMBRE DE JOUEURS REELS ");
				joueursreels=src.nextInt();
				System.out.println("ENTRER LE NOMBRE DE JOUEURS VIRTUELS ");
				joueursvirtuels=src1.nextInt();
				// Les conditions sur le nombre de joueurs
				if(joueursreels+joueursvirtuels<=8 && joueursreels+joueursvirtuels>=2 )break;
				}
				
				System.out.println("ENTRER LE NOMBRE DE TOURS \nPour ne pas prendre ce parametre en considération taper 0 \n");
				nombtours=src2.nextInt();
				System.out.println("ENTRER LE NOMBRE DE POINTS \nPour ne pas prendre ce parametre en considération taper 0 \n");
				nombpoints=src3.nextInt();
				
				while(entrer)
				{System.out.println("ENTRER LE NOMBRE DE CARTES DANS UNE MAIN  \nVous avez le droit à 8 au min et 16 au max \n ");
				nbcartes=src4.nextInt();
				// Les conditions sur le nombre de cartes
				if(nbcartes<=16 && nbcartes>=8 && nbcartes*(joueursreels+joueursvirtuels)<105)break;
				}
				
				while(entrer)
				{System.out.println("ENTRER LE NIVEAU DE DIFFICULTE SOUHAITER  \n0 : difficulté standard \n1 : difficulté avancée \n ");
				difficulte=src4.nextInt();
				// Les conditions sur la difficulté
				if(difficulte==0 || difficulte==1)break;
				}
				}//acolade try
				
				
				
				// attrape une erreur s il y a erreur de format 
				catch(NumberFormatException e2){
					System.out.println("\n format erroné !!!!! \n");
					temoin=0;
				}
				// attrape une erreur s il y a erreur de saisie
				catch (InputMismatchException e3){
					System.out.println("\n format erroné !!!!! \n");
					temoin=0;
					// reinitialiser les scanners
			 src=new Scanner(System.in);
			 src1=new Scanner(System.in);
			 src2=new Scanner(System.in);
			 src3=new Scanner(System.in);
			 src4=new Scanner(System.in);
					
					}
			
			}while(temoin==0);
			
			//parametres pour le mode console
			parametres(joueursreels,joueursvirtuels,nbcartes,nombtours,nombpoints,difficulte);// 1 reel ,2 virtuels , nb carte ,nbtours ,nbpoints,difficulté
			}
			
			
			//parametres pour mode graphique
			if(interfacegraphique==true){
				FenetreParametres Fpara=new FenetreParametres();
				parametres(Integer.parseInt(FenetreParametres.nbjr),
						  	 Integer.parseInt(FenetreParametres.nbjv),
						  	 Integer.parseInt(FenetreParametres.nbcartes),
						  	 Integer.parseInt(FenetreParametres.nbtours),
						  	 Integer.parseInt(FenetreParametres.nbpoints),
						  	 Integer.parseInt(FenetreParametres.difficulte));
			}
			
				
			//met en place l'Arraylist des indices des joueurs réels
			setArrayLindiceJReel();
			
				
			//Création de l'ensemble des cartes ! qui va contenir toutes nos carte 106 CARTES
			EnsembleCartes E=new EnsembleCartes();
			//juste apres la création de l ensemble  il faut le melanger 
			//pour cela il faut une fonct random
			  melange(E);
			 
			  //Creation de la pile à partir de notre ensemble de carte
			   P=new Pile(E1);
			 //Creation des mains sous forme de collections array list 
				  // et en meme temps les attribuee a un joueur 
			  ArrayList<Main> M=new ArrayList<Main>();
			  
			  Scanner nom=new Scanner(System.in);
			  // Boucle pour le remplissage des mains 
			  System.out.println("\n C'est la partie Numero \t "+numpartie+"\n");
			  
			  //initialisation de b a 0
			  int b=0;
			  
			  //Creation des mains
			  for(int t=0;t<J.size();t++)
			  {
				  Main M1=new Main(E1,getnbcartemain());
				  M.add(M1);
				  getjoueur(t).setmain((Main)M.get(t)); 
				  // saisie du nom du joueur reel 
				  if(!interfacegraphique){ //si on joue pas avec l'interface graphique
					  if(getjoueur(t) instanceof Reel){// si c'est un joueur reel
						  System.out.println("\n Entree le nom du joueur "+t+"\n");
						  ((Reel)getjoueur(t)).setnom(nom.nextLine());
					  }
				  }else{// si on joue avec l'interface graphique
					  if(getjoueur(t) instanceof Reel){// si c'est un joueur reel
						  if(b<Integer.parseInt(FenetreParametres.nbjr)){ // on parcourt toute la liste des joueurs reels
							  if(nomInterG.contains(t)==false){ // si on a pas encore ajouté cette indice
								  ((Reel)getjoueur(t)).setnom(FenetreParametres.nom[b]);
								  nomInterG.add(t);
								  b++;
							  }
						  }
					  }
				  }
				  
				  
			  }
						
		// Création du talon
		  T=new Talon(E1,getnbcartemain());
		  
		// Creation de la fenetre
		  if(interfacegraphique==true){
			  Fenetre F=new Fenetre(Controle.getCroupier());
		  }
		  
	
		
		
			//£££££££££££££££££££££££££££ DEBUT DU JEU £££££££££££££££££££££££££££££££££££££££££
		
			// pour savoir si le 10 que le joueur a pose est a lui !
			int tour=0;
			
			int x=0;
			//debut de la boucle generale
			/**
			 * debut de la boucle generale du jeu
			 * 
			 */
			
			
			
						
			
			//Toute la boucle est susceptible de générer des erreurs
			try{
			while(getfin() !=1)
			{
				// affichage de la pile
				System.out.println(" \n  LA PILE :");
				P.affiche();
				
				
				/**
				 * affichage des mains 
				 */
			
				for( int t=0;t<J.size();t++)
				{ 
					if(getjoueur(t) instanceof Reel){
					System.out.println(" \n  La main de  : "+((Reel)getjoueur(t)).getnom()+"\n");
				    getjoueur(t).getmain().affichemain();
					}
					else {System.out.println(" \n  La main du joueur :"+t);
				    getjoueur(t).getmain().affichemain();
				}}
				
//---------------------------------------------------------------------------------------		
		
		// si on est ds le sens normale       alors variable =0		
		if(variable==0){	
			//Pour la transition  du sens inverse au sens normale 
			if(p!=J.size()-1 && x!=0){
				//la structure de cette boucle se repete souvent dans la suite
				for( i=p+1;i<J.size();i++)
				  {
					indicejoueurprecedent=i-1; 
					if(arrayLindiceJReel.contains(i) && interfacegraphique==true){ // si il s'agit de l'indice d'un joueur reel
						tourFini=false;
						indiceJReelJouant=i;
						if(interfacegraphique==true){ // si on joue avec l'interface graphique
						Fenetre.refresh(Controle.getCroupier());
						}
						//pour jouer avec l'interface
						while(tourFini==false){
							//pour jouer avec la console
							if(interfacegraphique==false){
								getjoueur(i).joue(P, T,this);
								
								if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
								else
								System.out.println("\n joueur \t"+i+"\t  a joué \n");
							
							
							}
						}
					}
					else{
						  getjoueur(i).joue(P, T,this);
						  if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
							else
						  System.out.println("\n joueur \t"+i+"\t  a joué \n");
						  
						 // P.affiche();
						  x=0;
						// si le joueur a poser un dix  plus une variable temoin     
				  	  if (poserdix(P,tour)==true ){variable=1; break; }
				  }
					
					
					
					
					}
			      }
		// pour contrer le fait qu un 10 soit posé apres un autre !!
		if(variable==0)	
		// boucle du sens normal
		for( i=0;i<J.size();i++)
			// ici la fonctionn la plus importante "joue" 
			//on affiche ensuite le joueur qui a joué et la pile pour 
			// des soucis de test
			  {
			
			if(i!=0){
				indicejoueurprecedent=i-1;
				if(arrayLindiceJReel.contains(i) && interfacegraphique==true){
					tourFini=false;
					indiceJReelJouant=i;
					if(interfacegraphique==true){
					Fenetre.refresh(Controle.getCroupier());
					}
					//pour jouer avec l'interface
					while(tourFini==false){
						if(interfacegraphique==false){
						//pour jouer avec la console
						getjoueur(i).joue(P, T,this);
						if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
						else
						System.out.println("\n joueur \t"+i+"\t a joué \n");
						}
					}
				}
				else{
					getjoueur(i).joue(P, T,this);
					
					if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
					else
					System.out.println("\n joueur \t"+i+"\t a joué \n");
					 // P.affiche();
			// si le joueur a poser un dix  plus une variable temoin     
	  	  if (poserdix(P,tour)==true ){variable=1; break; }}}
			else// si l indice 0 apparait le joueur d avant c est "V.size()-1" 
			{
				indicejoueurprecedent=J.size()-1;
				if(arrayLindiceJReel.contains(0)){
					tourFini=false;
					indiceJReelJouant=0;
					if(interfacegraphique==true){
					Fenetre.refresh(Controle.getCroupier());
					}
					//pour jouer avec l'interface
					while(tourFini==false){
						if(interfacegraphique==false){
						//pour jouer avec la console
						getjoueur(0).joue(P, T,this);
						
						if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(0)).getnom()+" \t a joué \n");}
						else
						System.out.println("\n joueur \t"+0+"\t a joué \n");
						}
					}
				}
				else{
					getjoueur(0).joue(P, T,this);
					
					if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(0)).getnom()+" \t a joué \n");}
					else System.out.println("\n joueur \t"+0+"\t a joué \n");
					 // P.affiche();
				// si le joueur a poser un dix  plus une variable temoin     
		  	  if (poserdix(P,tour)==true ){variable=1; break; }
			}}
			  
			  
			  
			  
			  
			  }
		     
		
		
		
		}
		
		// si on est dans le sens inverse 
		if (variable==1){
        // si i dif de 0 on commence par le joueur qui a joué avant 
		// pour eviter qu un joueur ne joue 2 fois de suite
			if(i!=0)
			      {
			      for(p=(i-1);p>=0;p--)
			      {
						indicejoueurprecedent=p+1;
						if(arrayLindiceJReel.contains(p)){
							tourFini=false;
							indiceJReelJouant=p;
							if(interfacegraphique==true){
							Fenetre.refresh(Controle.getCroupier());
							}
							//pour jouer avec l'interface
							while(tourFini==false){
								
								if(interfacegraphique==false){
								//pour jouer avec la console
								getjoueur(p).joue(P, T,this);System.out.println("\n joueur \t"+p+"\t a joué \n");
								}
							}
						}
						else{
			    	 getjoueur(p).joue(P, T,this);
			    	 if(getjoueur(p) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(p)).getnom()+" \t a joué \n");}
						else
			    	 System.out.println("\n joueur \t"+p+"\t a joué \n");
				//  P.affiche();
				  if (poserdix(P,tour)==true){variable=0;x=1; break;}
				  }}i=0;}
			// on est ds le sens inverse
			
			
			
			
			if (variable==1 && getfin() !=1)
			for( p=J.size()-1;p>=0;p--)
				//affichage du joueur qui a joué 
		  {
				
				if(p!=J.size()-1){
					indicejoueurprecedent=p+1;
					if(arrayLindiceJReel.contains(p)){
						tourFini=false;
						indiceJReelJouant=p;
						if(interfacegraphique==true){
						Fenetre.refresh(Controle.getCroupier());
						}
						//pour jouer avec l'interface
						while(tourFini==false){
							if(interfacegraphique==false){
							//pour jouer avec la console
							getjoueur(i).joue(P, T,this);
							if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
							else
							System.out.println("\n joueur \t"+i+"\t  a joué \n");
							}
						}
					}
					else{
							getjoueur(p).joue(P, T,this);
							if(getjoueur(p) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(p)).getnom()+" \t a joué \n");}
							else
							System.out.println("\n joueur \t"+p+"\t a joué \n");
					 // P.affiche();
					  if (poserdix(P,tour)==true){variable=0;x=1; break;}}}
				
				else{
					indicejoueurprecedent=0;
					if(arrayLindiceJReel.contains(p) && interfacegraphique==true){
						tourFini=false;
						indiceJReelJouant=p;
						if(interfacegraphique==true){
						Fenetre.refresh(Controle.getCroupier());
						}
						//pour jouer avec l'interface
						while(tourFini==false){
							if(interfacegraphique==false){
							//pour jouer avec la console
							getjoueur(i).joue(P, T,this);
							if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a joué \n");}
							else
							System.out.println("\n joueur \t"+i+"\t  a joué \n");
							}
						}
					}
					else{
						getjoueur(p).joue(P, T,this);
						if(getjoueur(p) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(p)).getnom()+" \t a joué \n");}
						else System.out.println("\n joueur \t"+p+"\t a joué \n");
						//  P.affiche();
						  if (poserdix(P,tour)==true){variable=0;x=1; break;}}}
				}
		 
		  
		  
		  
		  
		  
		  
		  
		
			}
//--------------------------------------------------------------------------------	
		       
		       // code pour differencier les jeux
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			
			//ARRETER LA PARTIE EN NOMBRE DE POINTS
		}
			}//acolade try
			
			
			
			
			//une erreur est provoquée quand la main d'un des joueurs est vide !    
			catch(mainVideException e1){
				
				
				System.out.println(" \n La main du  joueur est vide !!!  \n");
				System.out.println(" \n ----------------------FIN------------------");
				
					if(variable==1){
						if(getjoueur(p) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(p)).getnom()+" \t a gagné felicitation \n");}
						else System.out.println(" \n Le Joueur \t "+p+"\t a gagné felicitation \n");   }      		
					
					
					else {
						
						if(getjoueur(i) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(i)).getnom()+" \t a gagné felicitation \n");}
						
						else System.out.println(" \n Le Joueur \t "+i+"\t a gagné felicitation \n");}
				
				//affichage des points 
					for( int t=0;t<J.size();t++)
					{
						
						if(getjoueur(p) instanceof Reel){System.out.println(" \n  "+((Reel)getjoueur(t)).getnom()+" \t a eu: \t"+nombrePoint(getjoueur(t).getmain()));}
						
						else System.out.println(" \n  Le  joueur :"+t+"a eu \t :"+nombrePoint(getjoueur(t).getmain())+"Points");
					
					}
					
					
					
					System.out.println("\n \n Voulez vous rejouer ? \n Taper oui ; non \n Pour avoir plus d'information sur la partie taper entrer");
					 reponse=rejoue.nextLine();
			if(reponse.compareToIgnoreCase("oui")==0){rejouer=true;	 }
			if(reponse.compareToIgnoreCase("non")==0){ rejouer=false;}	
			
					
					
			
			
			}
			//Interruption du programme si lorsque le talon est vide !
			catch(talonVideException e){
				System.out.println("\n Le Talon est vide le jeu est terminé !! \n");
				System.out.println(" \n ----------------------FIN------------------");
			
				
				for( int t=0;t<J.size();t++)
				{if(getjoueur(t) instanceof Reel){((Reel)getjoueur(t)).setScore( nombrePoint(getjoueur(t).getmain()));     System.out.println(" \n  "+((Reel)getjoueur(t)).getnom()+" \t a eu: \t"+nombrePoint(getjoueur(t).getmain()));}
				
				else System.out.println(" \n  Le  joueur :"+t+"a eu \t :"+nombrePoint(getjoueur(t).getmain())+"Points");}
				// CALCUL DU NOMBRE MIN
				
				System.out.println(" \n Le Joueur \t "+min(C)+"\t a gagné felicitation \n");
				
				
				
			
				
				System.out.println("\n \n Voulez vous rejouer ?");
				
			
			}
			catch(NumberFormatException e2){
				System.out.println("\n format erroné !!!!! \n");
							}
			
			
			// Interruption du programme si le nombre de points Minimale a été atteint 
			catch(nbPointsException err){
				
				
				
				System.out.println("\n Programme terminé nombre de point a été atteind \n");
				
				
				
				for(int  t=0;t<J.size();t++)
				{
					
					if(getjoueur(t) instanceof Reel){((Reel)getjoueur(t)).setScore( nombrePoint(getjoueur(t).getmain()));     System.out.println(" \n  "+((Reel)getjoueur(t)).getnom()+" \t a eu: \t"+nombrePoint(getjoueur(t).getmain()));}
					
					else  System.out.println(" \n  Le nombre de point DU joueur"+t+" est de :"+nombrePoint(getjoueur(t).getmain()));
				
				}
				
				System.out.println(" \n Le Joueur \t "+min(C)+"\t a gagné felicitation \n");
				
				System.out.println("\n \n Voulez vous rejouer ?");
				 reponse=rejoue.nextLine();
					if(reponse.compareToIgnoreCase("oui")==0){rejouer=true;	 }
					if(reponse.compareToIgnoreCase("non")==0){ rejouer=false;}	
					
					
			
			}
			catch(nbToursException err1){
				
				
				System.out.println("\n Nombre de  tours maximum  atteint ---\n ");
				for(int  t=0;t<J.size();t++)
				{
					if(getjoueur(p) instanceof Reel){((Reel)getjoueur(t)).setScore( nombrePoint(getjoueur(t).getmain()));  System.out.println(" \n  "+((Reel)getjoueur(t)).getnom()+" \t a eu: \t"+nombrePoint(getjoueur(t).getmain()));}
					
					else System.out.println(" \n  Le nombre de point DU joueur"+t+" est de :"+nombrePoint(getjoueur(t).getmain()));
				
				}
				
				System.out.println(" \n Le Joueur \t "+min(C)+"\t a gagné felicitation \n");
			
			System.out.println("\n \n Voulez vous rejouer ?");
			 reponse=rejoue.nextLine();
				if(reponse.compareToIgnoreCase("oui")==0){rejouer=true;	 }
				if(reponse.compareToIgnoreCase("non")==0){ rejouer=false;}	
				
				
			}
			
		
			
			
		
			// Affichage des mains
		for( int t=0;t<J.size();t++)
		{ 
			if(getjoueur(t) instanceof Reel){
			System.out.println(" \n  La main de  : "+((Reel)getjoueur(t)).getnom()+"\n");
		    getjoueur(t).getmain().affichemain();
			}
			else {System.out.println(" \n  La main du joueur :"+t);
		    getjoueur(t).getmain().affichemain();
		}}
		//Affichage de la PILE
		System.out.println(" \n  LA PILE :");
		P.affiche();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}while(rejouer==true); // c'est la grande boucle !!!! si le joueur
			// a décidé de rejouer cettre variable est vraie
	
			
			
			
			
			
			
			
			
			
	
		}
	


/**
 * getteur de la variable i
 * @return
 */
		public int getI() {
			return i;
		}



/**
 * Setteur de la variable i 
 * @param i
 */
		public void setI(int i) {
			this.i = i;
		}




		/**
		 * 
		 * @param C Croupier :arbitre du jeu
		 * @return l'indice du joueur ayant la valeur Minimale de points .
		 */
			public int min(Croupier C) {
                 //variable min contiendra l'indice du joueur qui
				//a le plus petit nombre de points
				int min=nombrePoint(getjoueur(0).getmain());
				//Parcours de toutes les mains des joueurs 
				// pour trouver celle qui a le nombre minimale de points
				for(int t=0;t<J.size();t++)
				{
				if(min>=nombrePoint(getjoueur(t).getmain()))
				min=nombrePoint(getjoueur(t).getmain());
				
				
				}
				//Parcours des mains des joueurs pour trouver la main qui correspond 
				//à min
				for(int t=0;t<J.size();t++)
				{ if(min==nombrePoint(getjoueur(t).getmain()))
				      return t;	
				}
				return 0;
		}


/**
 * 
 * @param getmain : La main du joueur 
 * @return entier represente le nombre de point de sa main
 */
			public static  int nombrePoint(Main getmain) {
			// variable qui representent les couleurs
			int nbjoker=0,nbas=0,nbhuit=0,nbK=0,nbJ=0,nbQ=0,nbdeux=0,nbtrois=0,nbquatre=0,nbcinq=0,nbsix=0,nbsept=0,nbneuf=0,nbdix=0;
			// boucle pour incrementer les variables
			for (int i=0;i<getmain.getmain().size();i++){
				if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="Joker" ){nbjoker++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="AS" ){nbas++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="8" ){nbhuit++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="K" ){nbK++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="J" ){nbJ++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="Q" ){nbQ++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="2" ){nbdeux++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="3" ){nbtrois++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="4" ){nbquatre++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="5" ){nbcinq++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="6" ){nbsix++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="7" ){nbsept++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="9" ){nbneuf++;}
				else if(  ((Carte)getmain.getmain().get(i)).getnumberCarte()=="10" ){nbdix++;}
				 
			
			
			}
			
			
			// si la main est vide alors le nombre de point est 0
			if(getmain.isCarteEmpty()){return 0;}
			//Comptage des points d une main donnée 
			else return ((nbjoker*50)+(20*nbas)+(32*nbhuit)+(10*nbK)+(10*nbJ)+(10*nbQ)+(2*nbdeux)+(3*nbtrois)+(4*nbquatre)+(5*nbcinq)+(6*nbsix)+(7*nbsept)+(9*nbneuf)+(10*nbdix));
		}



		/**
     * Constructeur Croupier 
      */
			public Croupier(){
				
			}

/**
 * 
 * @param nbreel nombre de joueurs reels
 * @param nbvirtuel     nombre de joueurs virtuels
 * @param nbcartemain     nombre maximale associé a une main
 * @param nbtours          nombre de tours maximum   
 * @param nbpoints         nombre de points maximum
 */
	
		public  void parametres(int nbreel,int nbvirtuel,int nbcartemain,int nbtours,int nbpoints,int difficulte){
			nbjoueurs=nbreel+nbvirtuel;		
			
			
			//Copie des parametres dans les variables privées de Croupier
		    Croupier.nbtours=nbtours;
			Croupier.nbpoints=nbpoints;
			Croupier.nbjv=nbvirtuel;
			Croupier.nbjr=nbreel;
			Croupier.nbcartemain=nbcartemain;
			
			
			
			// Choix de la difficulté
			if(difficulte==0)
			 s=new strategieStandard();
			else
			 s=new strategieAvancee();
			
			
			// Création de tous les joueurs 
			if (nbjoueurs<=8 && nbjoueurs>=2 && nbcartemain<=16 && nbcartemain>=8 )
			{
			this.nbjoueurs=nbjoueurs;
			J=new ArrayList<Joueur>();
			
			
			//Création des joueurs Virtuels 
			for(int iv=0;iv<nbvirtuel;iv++)
			{ V1=new Virtuel(s);
			 // V1.setStrategy(s);   	
			J.add(V1);
			     	}
			// Le nombre de cartes dans une main autorisé au début de la partie 
			Croupier.nbcartemain=nbcartemain;
			if(nbreel!=0)
			//Création des joueurs réels 
				for(int iv=0;iv<nbreel;iv++)
			{ R1=new Reel();
			     	
			J.add(R1);              
			     	}
			
			
			
			}
	
		}
	
		/**
		 * Fonction qui sera utilisée par la fonction mélange pour eviter d avoir des doublons
		 * @param T Tableau
		 * @param R Valeur du melange
		 * @return
		 */
		public static boolean compare(int[] T,int R )
		{
			
			// Fonction qui veille a ce qu on n 'est pas de doublons
			for(int i=0;i<T.length;i++)
			{
			  if (T[i]==R) return true;
			}
			return false ;
		}
		
		/**
		 * Cette fonction fait le melange de toutes les cartes !
		 * @param E : notre ensemble de carte 106 cartes
		 */
		public void melange(EnsembleCartes E){
			
			// ICI L'algorithme de melange des cartes
			int[] Y=new int[106];
			//Pour Toutes les cartes faire...
			for(int i=0;i<106;i++)
			{
				Y[i]=200;
			}
			int R;
			 E1=new ArrayList<Carte>();
			int j=0;
			int p=0;
			while(p<106)
			{	R=(int)(Math.random()*106); /// METTRE A 106
			if(compare(Y,R)==false)
			{      Carte C1= (Carte)E.getcarte().get(R);
				       E1.add(C1);
			             Y[j]=R;
		                  p++;j++;		
			}}
			
		}
		/**
		 * 
		 * @param a   indice du joueur que l on veut 
		 * @return Le joueur qui correspond a l indice
		 */
		public Joueur getjoueur(int a){
			return J.get(a);
		}
		
		
		/**
		 * Methode pour savoir si un 10 a été posé ou pas 
		 * @param P Pile
		 * @param tour   nombre de tours restant
		 * @return true si un 10 a été posé sinon false
		 */
		public boolean poserdix(Pile P,int tour)
		{
			
			// si un dix a été posé retourne vrai sinon faux
			if(((Carte)(P.getpile().get(P.getpile().size()-1))).getnumberCarte()=="10" && tour!=P.getpile().size()-1)
			{ tour=P.getpile().size()-1;   return true;}
			return false;
			
		}
		/**
		 * 
		 * @return Nombre de carte dans une main
		 */
		public int getnbcartemain(){
			return Croupier.nbcartemain;
		}
		/**
		 * getteur de la variable fin
		 * @return
		 */
	public int getfin(){
		return fin;
	}
	/**
	 * 
	 * @return l'indice du joueur precedent
	 */
	public int getIndicejoueurprecedent() {
		return indicejoueurprecedent;
	}
	
	/**
	 * 
	 * Met en place l'ArrayList des indices des joueurs reels
	 */
	public void setArrayLindiceJReel(){
		for(int i=0;i<nbjoueurs;i++)
			if (getjoueur(i) instanceof Reel ){arrayLindiceJReel.add(i);  }
	}
	
	/**
	 * 
	 * @return l'indice du joueur réel en train de jouer
	 */
	public int getIndiceJReelJouant(){
		return indiceJReelJouant;
	}


	/**
	 * fixe l'indice du joueur precedent
	 * 
	 */
	public void setIndicejoueurprecedent(int indicejoueurprecedent) {
		this.indicejoueurprecedent = indicejoueurprecedent;
	}
	
	public Pile getPile(){
		return P;
	}
	
	/**
	 * 
	 * @return le Talon
	 */
	public Talon getTalon(){
		return T;
	}
	
	/**
	 * methode pour indiquer que le joueur reel a joue
	 * 
	 */
	public static void tourFini(){
		tourFini=true;
	}
	/**
	 * 
	 * @param fin
	 */
	public void setfin(int fin){
		this.fin=fin;
	}}
