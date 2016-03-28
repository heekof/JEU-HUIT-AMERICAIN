package fr.utt.lo02.jeu;
// Il faudrait rajouter un attribut boolean cartedestinee dans la methode joue 




import java.util.*;	

import fr.utt.lo02.controle.Fenetre;
import fr.utt.lo02.exception.erreurSaisieException;
import fr.utt.lo02.exception.mainVideException;
import fr.utt.lo02.exception.nbPointsException;
import fr.utt.lo02.exception.nbToursException;
import fr.utt.lo02.exception.talonVideException;
/**
 * 
 * La classe Reel : c est le joueur reel qui va joué contre la machine
 * @author BENRISS-NGUYEN
 *
 */
public class Reel extends Joueur  {

	/**
	 * cette variable indique le mode de jeu du joueur :
	 * console ou graphique
	 */
	String joueAvec;
	
		/**
		 * cette variable contiendra la valeur d entree 
		 * du joueur reel 
		 */
	String test;
	/**
	 * getteur de test 
	 * @return
	 */
		public String getTest() {
		return test;
	}
		/**
		 * setteur de test 
		 * @param test
		 */
	public void setTest(String test) {
		this.test = test;
	}
	/**
	 * scanner la reponse du joueur 	
	 */
	Scanner scan = new Scanner(System.in);
	/**
	 * le nom du joueur 
	 */
	private String nom;
	/**
	 * son scrore max
	 */
	private int scoremax;
	/**
	 * le score de la derniere partie
	 */
	private int score;
		
		/**
		 * getteur de score
		 * @return
		 */
		public int getScore() {
			return score;
		}
		/**
		 * setteur de score
		 * @param score
		 */
		public void setScore(int score) {
			this.score += score;
		}
		/*
		 * carte a joué
		 */
		Carte selecarte=null;
		/**
		 * si played est vrai le joueur a joué sinn il n a pas encore joué 
		 */
		boolean played=false;
		
		/**
		 * getteur nom 
		 * @return
		 */
		public String getnom()
		{
			return nom;
		}
		/**
		 * setteur nom 
		 * @param nom
		 */
		public void setnom(String nom)
		{
			 this.nom=nom;
		}
	
		/**
		 * getteur score max
		 * @return
		 */
		public int getscoremax()
		{
			return scoremax;
		}
		/**
		 * methode joue avec la console
		 * fonction qui doit etre redefinie et utilisé l polymorphisme
		 * @param P :La pile
		 * @param T :Le talon
		 * @param C :Le croupier 
		 * @throws mainVideException : si la main est vide 
		 * @throws talonVideException : exception si le talon est vide
		 * @throws nbPointsException :si le nombre 
		 * @throws nbToursException
		 * @return boolean true si le joueur a joué false s il y a un probleme 
		 */
		
		public boolean joue(Pile P,Talon T,Croupier C) throws talonVideException,mainVideException,nbPointsException,nbToursException		{ 
		
		// témoin d'erreur : cette valeur =1 si le joueur tappe n'importe quoi
		int temoin=0;
		
		// indique qu'on joue avec la console
		joueAvec="console";

		
		nbToursException err=new nbToursException();
		nbPointsException err1=new nbPointsException();
		//ARRETER LA PARTIE EN NOMBRE DE POINTS
		if(Croupier.nombrePoint(main)<=Croupier.nbpoints){ throw err1;   }
		//ARRETER LA PARTIE EN NOMBRE DE TOURS
		if(Croupier.nbtours==Joueur.nbtours && Joueur.nbtours!=0 ){throw err; }
		
		Joueur.nbtours++;
		
			
			talonVideException e=new talonVideException();
			
			
			
			
			
			//Initialisation de played a false
			played=false;
			//Tant que le joueur n a pas joue
			while(played!=true ){
			// si le talon est vide, propagation d'une erreur
			if (T.getcarte().isEmpty()==true ) {throw e;}
			else {
			System.out.println("\n --------------------------\n");
			//affichage derniere carte
			System.out.println(" \n La dernière carte de la  Pile est : "+Croupier.P.getpilecarte().getnumberCarte()+"\t"+Croupier.P.getpilecarte().gettypecarte()+"\n");
			
			
			
			System.out.println("\n");
			
			System.out.println("Le tour de : \t "+this.getnom()+"\n");
			
			//affichage de la main du joueur
			main.affichemain();
			
		
			//pour jouer une carte
			System.out.println("\n Veuillez sélectionner une carte (tappez l'index de la carte et tappez 100 pour piocher et passer) :");
			do{
			try{
				temoin=0;
			
			// saisie du parametre entré	
			 test=scan.nextLine();
			
			// si joueur declare carte
			if(test.compareToIgnoreCase("carte")==0){
				//si le joueur a une seule carte
				if(main.getmain().size()==1){carte=1; test=scan.nextLine();}//si il pioche remettre carte a 0
				// si le joueur a plus d'une carte, il doit piocher
				else {
					
					played=true;
					for(int i=0;i<2;i++)
					piocher(T);
					return true;
				}
				
			}
			//si joueur declare oublie : un des adversaires a oublie de dire carte
			else if(test.compareToIgnoreCase("oublie")==0){
				for(int i=0;i<C.nbjoueurs;i++)
				if(C.getjoueur(i).getmain().getmain().size()==1 && C.getjoueur(i).carte==0){for(int j=0;j<2;j++) C.getjoueur(i).piocher(T); test=scan.nextLine();break;}
				
			}
		
			
			          
			
			
			
			
			
			
			int select = Integer.parseInt(test); // cast test en int
			
			
			
			
			//initialisation
			selecarte=null;
			
			//si le joueur decide de pas piocher, et l'indice est correct
			if(select!=100 && select<main.getmain().size() && select >=0){
			
				//selection de la carte choisie
				selecarte=(Carte) main.getmain().get(select);
				//si les conditions pour poser la carte sont bonnes
				if(conditions(selecarte,P,C.getjoueur(C.getIndicejoueurprecedent()).getmain())==true)
				// alors on pose la carte 
				{posercarte(P, select, C.getjoueur(C.getIndicejoueurprecedent()).getmain(),T);played=true;}} // le joueur a joué
			//si il tappe 100, il pioche
			else if(select == 100){piocher(T,C.getjoueur(C.getIndicejoueurprecedent()).getmain(),P); played=true;}
			//si il tappe un index incorrect
			else {System.out.println("\nL'index que vous avez tappé n'est pas correct");  played=false;}
			}
			//si il tappe une chose incorrect
			catch(NumberFormatException e2){
				System.out.println("\n format erroné !!!!! \n");
				temoin=1;
			}}
			while(temoin==1);
			
			}
			
			
			
			
			
			}//acolade while
			if(played==true){
				// indique au croupier que le joueur a bien joué et fini ainsi son tour
				Croupier.tourFini();
			}
			return true;
			
		
			
		}
		
		//////////////////////////////////////SURCHARGE JOUE /////////////////////////////////////////////////
		/**
		 * methode joue avec l'interface graphique
		 * fonction qui doit etre redefinie et utilisé l polymorphisme
		 * @param P :La pile
		 * @param T :Le talon
		 * @param C :Le croupier
		 * @throws mainVideException : si la main est vide 
		 * @throws talonVideException : exception si le talon est vide
		 * @throws nbPointsException :si le nombre 
		 * @throws nbToursException
		 * @return boolean true si le joueur a joué false s il y a un probleme 
		 */
		// meme fonction que joue situé en haut mais pour l'interface graphique
		public boolean joue(Pile P,Talon T,Croupier C,String index) throws talonVideException,mainVideException,nbPointsException,nbToursException		{ 
		
		int temoin=0;
		
		System.out.println(index);
		
		// indique qu'on joue avec l'interface graphique
		joueAvec="interface";
		
		nbToursException err=new nbToursException();
		nbPointsException err1=new nbPointsException();
		//ARRETER LA PARTIE EN NOMBRE DE POINTS
		if(Croupier.nombrePoint(main)<=Croupier.nbpoints){ throw err1;   }
		
		if(Croupier.nbtours==Joueur.nbtours && Joueur.nbtours!=0 ){throw err; }
		
		Joueur.nbtours++;
		
			
			talonVideException e=new talonVideException();
			
			
			
			
			
			
			played=false;
			if (T.getcarte().isEmpty()==true ) {throw e;}
			else {
			System.out.println("\n --------------------------\n");
			System.out.println("Le tour de : \t "+this.getnom()+"\n");
			main.affichemain();
			
			// NE PAS OUBLIER L ACCUMULATION
			
			do{
			try{
				temoin=0;
									
			if(index.compareToIgnoreCase("carte")==0){
				
				if(main.getmain().size()==1){carte=1;Fenetre.setLabelAide("J'ai dit Carte !");}//si il pioche remettre carte a 0
				else {
					//pour afficher sur l'interface graphique
					Fenetre.setLabelAide("Vous vous êtes trompé et ne pouvez plus jouer ce tour");
					played=true;
					for(int i=0;i<2;i++){
						piocher(T);
					}
					Fenetre.refresh(C);
					Fenetre.mettreaJoueTrue();
					return true;
				}
				
			}
			else if(index.compareToIgnoreCase("oublie")==0){
				for(int i=0;i<C.nbjoueurs;i++){
					if(C.getjoueur(i).getmain().getmain().size()==1 && C.getjoueur(i).carte==0){
						Fenetre.setLabelAide("Vous avez reperé le joueur"+i);
						for(int j=0;j<2;j++){ 
							C.getjoueur(i).piocher(T);
						}
						Fenetre.refresh(C);
						break;
					}
					else{
						Fenetre.setLabelAide("Tous vos adversaires ont plus d'une carte ou ont déja dit 'Carte'");
					}
				}
			}
		
			
			          
			
			
			
			
			
			else{
			int select = Integer.parseInt(index); // scan
			
			
			
			
			
			selecarte=null;
			if(select!=100 && select<main.getmain().size() && select >=0){
			
				selecarte=(Carte) main.getmain().get(select);
				if(selecarte.getnumberCarte()=="Joker" || selecarte.getnumberCarte()=="8"){
					if(Fenetre.getAChoisiCouleur()==false){
						System.out.println("Vous devez choisir une couleur avant de jouer un 8 ou un joker");
						Fenetre.setLabelAide("Vous devez choisir une couleur avant de jouer un 8 ou un joker");
						break;
					}
				}
				if(conditions(selecarte,P,C.getjoueur(C.getIndicejoueurprecedent()).getmain())==true){
					posercarte(P, select, C.getjoueur(C.getIndicejoueurprecedent()).getmain(),T);
					played=true;
				}
			}
			
			else if(select == 100){piocher(T,C.getjoueur(C.getIndicejoueurprecedent()).getmain(),P); played=true;}
			else {System.out.println("\nL'index que vous avez tappé n'est pas correct");  played=false;}
			}}
			catch(NumberFormatException e2){
				System.out.println("\n format erroné !!!!! \n");
				temoin=1;
			}}
			while(temoin==1);
			
			}
			
		
			if(played==true){
				//pour dire que le joueur a effectuer son action et qu il peut maintenant passer au prochain tour
				Fenetre.mettreaJoueTrue();
			}
			return true;
			
		
			
		}
		
		
		
		
		/**
		 * 
		 * @param selecarte La carte selectionnée
		 * @param P pile 
		 * @param M main precedente
		 * @return true si la carte selectionée est jouable !
		 */
		public boolean conditions(Carte selecarte,Pile P,Main M){
			
			
			// ATTENTION PEUT ETRE QUE J AI OUBLIE UNE CONDITION !!!!
			
			
			if (P.getpilecarte().getnumberCarte()=="AS" ) 
              {
				if (selecarte.getnumberCarte()=="AS") { return true ;}
				 else if(as==0){return true;}
				 else return false ;
				
              
              
              
              }
			
			if(selecarte.getnumberCarte()=="Joker" && main.getmain().size()!=1){ return true ;}
			if(selecarte.getnumberCarte()=="8" && main.getmain().size()!=1){return true ;}
			
	       
	        if (P.getpilecarte().getnumberCarte()=="Joker" ) 
	     						{
	        if((selecarte.getnumberCarte()=="Joker" || selecarte.getnumberCarte()=="8")&& main.getmain().size()!=1){return true;}
	        else if(Joker==0 && main.getmain().size()!=1){return true;}
	        else return false ;
	                              
	     						}
	       // if(selecarte.getnumberCarte()=="2"){return true ;}
			
	        if (P.getpilecarte().getnumberCarte()=="2" ) 
	                            {
	        	if(selecarte.getnumberCarte()=="Joker" || selecarte.getnumberCarte()=="8" || selecarte.getnumberCarte()=="2"){return true;}
	        	else if(deux==0){return true;}
	        	else return false ;
	        	     }
	         
	        if (P.getpilecarte().getnumberCarte()=="7" && sept!=0 ){System.out.println(" RIEN NE PEUT CONTRER LE SEPT");
	        	 
	        return false;}
					
			if( P.getpilecarte().getnumberCarte()==selecarte.getnumberCarte() || couleurcartematch(P,choixcouleur) ==selecarte.gettypecarte())return true;
			
			
			
	
			
			
			
			return false  ;//LE JOUEUR NE PEUT ALORS RIEN JOUER
		}
		/**
		 * 
		 * @param P:Ple
		 * @param j :indice de la carte a poser 
		 * @param M : La main du joueur précedent
		 * @param T : Le talon 
		 * @throws mainVideException :si la main est vide 
		 */
		public void posercarte(Pile P,int j,Main M,Talon T)throws mainVideException
		{ 
			int piocher=0;
			erreurSaisieException e;
			int temoin=0;
			String pressentry="" ;
			if(joueAvec=="console"){ //le joueur joue avec la console
				do{try{
					temoin=0;
					
					System.out.println("Taper entrée pour continuer ou carte ou oublie");
				String test2=scan.nextLine();
				pressentry=test2;
				
				
				
				if(test2.length()==0)	{pressentry="entre"; }
				if( test2.compareToIgnoreCase("carte")==0){
					if(main.getmain().size()<=2)carte=1;
					
					else if(main.getmain().size()!=1){piocher=1;for(int i=0;i<2;i++)piocher(T);}	}			  
				   
					
				else if(test2.compareToIgnoreCase("oublie")==0){
						if(M.getcarte().size()==1){for(int i=0;i<2;i++) M.getJoueur().piocher(T);}
						 else if (M.getcarte().size()!=1){piocher=1; for(int i=0;i<2;i++)piocher(T);}}
				
						
						
						
					
				else { throw e=new erreurSaisieException();}
				 
				}
				catch(erreurSaisieException e3){
					{if(pressentry!="entre"){System.out.println("\n format erroné !!!!! \n");
								temoin=1;}
					}			
				}}while(temoin==1);	
			} // fin if de joue avec la console
		
			
			
		
			
		if(piocher==0){	
			// jouer la carte dans la pile
			P.getpile().add((main.getmain().get(j)));// j indice
			System.out.println("\n  joueur reel  a joué \n");
			if (couleur==1)couleur=0;
		
			if(((Carte)main.getmain().get(j)).getnumberCarte()=="Joker"){  Joker++;choixcouleur=choixCouleur(); couleur=1;System.out.println(" \n couleur choisie : \n"+choixcouleur); System.out.println("joueur reel a pose un joker"); }
			if(((Carte)main.getmain().get(j)).getnumberCarte()=="2"){deux++;  System.out.println("joueuer reel a pose un deux ------------------------------------------------------------");}
			if(((Carte)main.getmain().get(j)).getnumberCarte()=="AS"){ as++; System.out.println("joueur reel a pose un as  "); }
			if(((Carte)main.getmain().get(j)).getnumberCarte()=="7"){ sept++;  System.out.println("joueur reel a pose un sept");}
			if(((Carte)main.getmain().get(j)).getnumberCarte()=="8"){ choixcouleur=choixCouleur();couleur=1;System.out.println(" \n couleur choisie : \n"+choixcouleur);  System.out.println("joueur reel a pose un sept");}
			
			//supprimer de la main la carte que l on a ajouté
			mainVideException e1=new mainVideException();

			main.getmain().remove(j);		//supprimer de la main la carte que l on a joué
			if (main.getmain().isEmpty()==true ){  throw e1 ;}
		}
		
		
		
		
		
		}
		
		/**
		 * la fonction pour piocher dans une main ou dans le talon 
		 * @param T Talon 
		 * @param M Main 
		 * @param P Pile 
		 */
		public void piocher(Talon T,Main M,Pile P){
			if (P.getpilecarte().getnumberCarte()=="AS" && as!=0){
				               for (int i=0;i<2*as;i++)
				               {
				            	   if(T.gettalon().isEmpty()==false)
				           		{
				           		// piocher dans talon et donc ajouter a la main une carte a partir detalon  
				           		Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
				           		main.getmain().add(  C );
				           		
				           		
				           		//une fois terminé supprimé du talon la carte
				           		T.gettalon().remove(T.gettalon().size()-1);
				           		}
				            	   
				            	   
				               }
				               as=0;
			}
			
			else if (P.getpilecarte().getnumberCarte()=="Joker"  && Joker!=0){
				
				               for (int i=0;i<5*Joker;i++)
	                          {
	            	           if(T.gettalon().isEmpty()==false)
	           		         {
	           		            // piocher dans talon et donc ajouter a la main une carte a partir detalon  
	           		            Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
	           		           main.getmain().add(  C );
	           		
	           		
	           		          //une fois terminé supprimé du talon la carte
	           		           T.gettalon().remove(T.gettalon().size()-1);
	           		          }
	            	         
	            	   
	                           }
				               Joker=0;	
			}
			else if (P.getpilecarte().getnumberCarte()=="2"  && deux !=0){
		 		 
		                  		for (int i=0;i<2*deux;i++)
                                {
  	                       if(T.gettalon().isEmpty()==false)
 		                       {
         		            // piocher dans talon et donc ajouter a la main une carte a partir detalon  
 		                     Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
 		                    main.getmain().add(  C );
 		
 		
 		                   //une fois terminé supprimé du talon la carte
 		                       T.gettalon().remove(T.gettalon().size()-1);
 		                       }
  	                           
  	   
                                 }
		                  		deux=0;
                   }
			
			else	if (P.getpilecarte().getnumberCarte()=="7"  &&  sept!=0 ){
		 		
		 		main.getmain().add(M.getmain().get(0));
				M.getmain().remove(0);
                sept=0;
		 		
			}
		 	
			else {
				if(T.gettalon().isEmpty()==false)
				{
				// piocher dans talon et donc ajouter a la main une carte a partir detalon  
				Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
				main.getmain().add(  C );
				
				
				//une fois terminé supprimé du talon la carte
				T.gettalon().remove(T.gettalon().size()-1);
				}
				}
		 	}
		/**
		 * fonction pour le choix des couleurs de l utilisateur
		 * @return un String couleur
		 */
		public String choixCouleur(){
			//erreurSaisieException e;
			int choix=0;
			while(choix!=1 || choix!=2 || choix!=3 || choix!=4)
			{
				if(joueAvec=="console"){ // si on joue avec la console
					System.out.println("veuiller choisir votre couleur ! :    1-TREFLE 2-COEUR 3-CARREAU 4-PIQUE ");
					Scanner scan = new Scanner(System.in);
					choix=scan.nextInt();
				}
				else{ // si on joue avec l'interface graphique
					choix=Fenetre.getIndiceChoixCouleur();
				}
				couleur=1;
				if(choix==1)
				 return "trefle" ;
				if(choix==2)
					 return "coeur" ;
					
				if(choix==3)
					 return "carreau" ;
				if(choix==4)
					 return "pique" ;
				}
				return "trefle";
		}	
		/**
		 * Fonction qui retourne la couleur de la carte qui peut etre jouer en fonction de la pile et de la couleur choisie 
		 * @param P PILE 
		 * @param choixcouleur couleur choisie
		 * @return String
		 */
public String couleurcartematch(Pile P,String choixcouleur){
			
			if (couleur==1)
			{
				couleur =0;return choixcouleur;
			}
			else  return (P.getpilecarte().gettypecarte());
			
			
			}
/**
 * Fonction pour piocher seulement dans le talon 
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