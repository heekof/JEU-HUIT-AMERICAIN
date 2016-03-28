package fr.utt.lo02.strategies;

import fr.utt.lo02.controle.Controle;
import fr.utt.lo02.controle.Fenetre;
import fr.utt.lo02.exception.*;
import fr.utt.lo02.jeu.Croupier;
import fr.utt.lo02.jeu.Joueur;

import fr.utt.lo02.jeu.Pile;
import fr.utt.lo02.jeu.Talon;
import fr.utt.lo02.jeu.Virtuel;

/**
 * Classe strategie normale 
 * @author NGUYEN-BENDRISS
 *
 */
public class strategieStandard implements Strategy{

	
	
	/**
	 * Constructeur de la strategie standard
	 */
	public strategieStandard(){
		
	}
	
	/**
	 * methode joue qui contient l 'algorithme 
	 * elle retourne true si tout ce passe bien sinon elle propage des exceptions 
	 * @throws mainVideException : si la main est vide 
	 * @throws talonVideException : exception si le talon est vide
	 * @throws nbPointsException :si le nombre de point établie précédement a été ateind
	 * @throws nbToursException :si le nombre de tours prédéfinie a été ateind 
	 * 
	 * 
	 */
	public boolean joue(Pile P,Talon T,Croupier C,Virtuel V)  throws talonVideException,mainVideException, nbPointsException, nbToursException {
		

		
		
		
               talonVideException e=new talonVideException();
		
		//si le Talon est vide ou la main d un joueur est vide retourn false pour arreter le jeu	
	
		
		
		if (T.getcarte().isEmpty()==true ) {throw e;}
		
		nbToursException err=new nbToursException();
		nbPointsException err1=new nbPointsException();
		//ARRETER LA PARTIE EN NOMBRE DE POINTS
		
		
		
		
		
		if(Croupier.nombrePoint(V.main)<=Croupier.nbpoints){ throw err1;   }
		
		if(Croupier.nbtours==Joueur.nbtours && Joueur.nbtours!=0 ){throw err; }
		
		Joueur.nbtours++;
		
		
		
		
		//si le joueur precedent a oublié de dire carte
		for(int i=0;i<C.nbjoueurs;i++)
			if(C.getjoueur(i).getmain().getmain().size()==1 && C.getjoueur(i).carte==0)
			{for(int j=0;j<2;j++) C.getjoueur(i).piocher(T);
			
		}
	
	
	//si la pile est un AS 
	if (P.getpilecarte().getnumberCarte()=="AS" ) {
		
		// alors poser un AS  ne pa oublier d incrementer le compteur des AS!
	                 if (V.nbcartematch(P)!=200) {V.posercarte(P,V.nbcartematch(P),C.getjoueur(C.getIndicejoueurprecedent()).getmain()); return true ;}
		
	                             	else  if(0==Virtuel.as){
	                             		 return V.posestandard(P,T,C.getjoueur(C.getIndicejoueurprecedent()).getmain());   
	                             		       }
	                             	else{
	                             	// sinon piocher 5 fois
	                                   	for(int i=0; i<2*Virtuel.as;i++)
		                     	             V.piocher(T);
	                                   
	                                   	
	                                   	
	                                   	Virtuel.as=0;
	                     	                 return true;
	                                
	                             	}
	
	           
	
	
	
	}
	// si  un Joker est posé 
	else if (P.getpilecarte().getnumberCarte()=="Joker" ) {
	               	if (V.nbcartematch(P)!=200 ) {V.posercarte(P,V.nbcartematch(P),C.getjoueur(C.getIndicejoueurprecedent()).getmain());  return true ;	}
	               	  else {
	               		//Je peux joué un huit derrière un Joker
	               		  if(V.jaiunhuit()!=200 && V.main.getmain().size()!=1){V.posercarte(P,V.jaiunhuit(),C.getjoueur(C.getIndicejoueurprecedent()).getmain());System.out.println("  \ncouleur choisie : \n"+Virtuel.choixcouleur);
	               		if(Controle.interfacegraphique==true){
	               			Fenetre.setLabelAide("couleur choisie : "+Virtuel.choixcouleur);
	               		}
	               		  
	               		  return true;}
	           		 
	               	             if(Virtuel.Joker==0){return V.posestandard(P,T,C.getjoueur(C.getIndicejoueurprecedent()).getmain());
	               	            	 
	               	                              }
	               	                   
	               	  
	               	             else{ // sinon piocher 5 fois
                                     for(int i=0; i<5*Virtuel.Joker;i++)
	                                     	V.piocher(T);
                                    
                                     Virtuel.Joker=0;
                                        	return true;  }
	               	                                         }               		  
	               		
	}
	//si un deux est posé
	else if(P.getpilecarte().getnumberCarte()=="2" ){
       	if (V.nbcartematch(P)!=200) {V.posercarte(P,V.nbcartematch(P),C.getjoueur(C.getIndicejoueurprecedent()).getmain()); return true ;	}
        	else if(0==Virtuel.deux){
    		 return V.posestandard(P,T,C.getjoueur(C.getIndicejoueurprecedent()).getmain());   
    		       }
                                    else{
                                 	// sinon piocher 2 fois
                                   for(int i=0; i<2*Virtuel.deux;i++)
                                 	V.piocher(T);
                                   Virtuel.deux=0;
                                   	return true; 
                                        	}
	}
	//si un 7 est posé !!!!
	else if(P.getpilecarte().getnumberCarte()=="7" && Virtuel.sept!=0){ V.piocher(C.getjoueur(C.getIndicejoueurprecedent()).getmain());//surcharge de la
	//fonction piocher celle ci permet de piocher dans la main du joueur qui a posé le 7
	Virtuel.sept=0; return true;
	
	
	}
	
	
	
	// si j ai un Joker je le pose
	else if(V.jaiunJoker()!=200 && V.main.getmain().size()!=1){V.posercarte(P,V.jaiunJoker(),C.getjoueur(C.getIndicejoueurprecedent()).getmain()); System.out.println("  \ncouleur choisie : \n"+Virtuel.choixcouleur);
	if(Controle.interfacegraphique==true){
		Fenetre.setLabelAide("couleur choisie : "+Virtuel.choixcouleur);
	}
		return true;  }
	//si j ai un huit je le pose
	else if(V.jaiunhuit()!=200 && V.main.getmain().size()!=1){V.posercarte(P,V.jaiunhuit(),C.getjoueur(C.getIndicejoueurprecedent()).getmain());System.out.println("  \ncouleur choisie : \n"+Virtuel.choixcouleur);
	if(Controle.interfacegraphique==true){
		Fenetre.setLabelAide("couleur choisie : "+Virtuel.choixcouleur);
	}
	return true;}
		   
	
	
	//si la pile differente de AS alors....
	//cette fonction permet de poser une carte selon la couleur ou la hauteur
	else{return V.posestandard(P,T,C.getjoueur(C.getIndicejoueurprecedent()).getmain());}
		
	
		
	}
	
	
	
	
	}
	
	
	
	

