package fr.utt.lo02.strategies;

import fr.utt.lo02.jeu.*;
import fr.utt.lo02.controle.Controle;
import fr.utt.lo02.controle.Fenetre;
import fr.utt.lo02.exception.*;

import java.util.ArrayList;

/**
 * la classe strategie avancée implemente l interface strategie 
 * cette classe contient la methode joue qui utilise un algorithme d'equilibre de couleur et se debarrasse des  carte qui ont le
 * plus grand nombre de point !!!  
 * @author BENDRISS - NGUYEN
 *
 */
public class strategieAvancee implements Strategy {
/**
 * cette arrayliste contient toutes les cartes jouables !
 */
	private ArrayList<Carte> cartejouable=new ArrayList<Carte>();
	/**
	 * cette arrayliste contient les cartes jouables dont leurs 
	 * nombre de couleur 
	 * est superieur aux autres cartes
	 */
	 private ArrayList<Carte> R=new ArrayList<Carte>();
	
	/**
	 * constructeur de ma classe strategieAvancée
	 */
	public strategieAvancee(){
		
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
	public boolean joue(Pile P,Talon T,Croupier C,Virtuel V)  throws talonVideException,mainVideException, nbPointsException, nbToursException 
	{
			
		
		
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
	
		//---------------------------------------------------------------debut code
		
		//si la pile est un AS 
		if (P.getpilecarte().getnumberCarte()=="AS" ) {
			
			// alors poser un AS  et incrementer le compteur des AS!
		                 if (V.nbcartematch(P)!=200)
		                 {V.posercarte(P,V.nbcartematch(P),C.getjoueur(C.getIndicejoueurprecedent()).getmain()); return true ;}
			
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
		
		// definition des cartes jouable
		cartejouable=cartejouable(P,V,T,C.getjoueur(C.getIndicejoueurprecedent()).getmain());
		   
		
		//s il n y a pas de carte jouable alors piocher  
		
		if(cartejouable==null || cartejouable.isEmpty()){V.piocher(T, C.getjoueur(C.getIndicejoueurprecedent()).getmain(), P); return true;}
		else  { 
			//Sinon afficher les cartes jouable    
			
			//for(int i=0;i<cartejouable.size();i++)
			//System.out.println(" \n Les cartes jouables sont :"+cartejouable.get(i).getnumberCarte()+"  "+cartejouable.get(i).gettypecarte()+"\t leurs point :"+nombrePoint(cartejouable.get(i)));	
		
		//-------------------------------Le controle des cartes jouables 
		int indicecartejouable=0;
	    //La fonction choixcouleur1 permet de retourner la couleur que l'on a en plus       
		String color=choixcouleur1();
		     
	          
	          for(int i=0;i<cartejouable.size();i++)
	          {
	        	  //Chercher les cartes qui ont une couleur en plus pour equilibre le jeu...
	        	  if(cartejouable.get(i).gettypecarte()==color ){R.add(cartejouable.get(i));}
	        	 
	          }
	   
	          
	          
	          
	       //  System.out.println("\n "+color+"    l indice est "+indicecartejouable+"\n");
	          
	          //Chercher la carte qui a le maximum de point 
	          // pour s'en débarasser
	          int max=this.nombrePoint(R.get(0));
	          int maxindice=0;
	          for(int i=0;i<R.size();i++)
	          {
	        	  if(max<this.nombrePoint(R.get(i))){max=this.nombrePoint(R.get(i)); maxindice=i; }
	          }
	          
	       
	          // poser la carte 
		posercarte(P,maxindice , V);
		//remettre les arratlist à 0 
		cartejouable.clear();
		R.clear();
		//fin du tour !
		return true;
		}
		
		
		
		
		
		
		
		
		
		
		//---------------------------------Fin code
		
		
	
	
	}
	/**
	 * Methode qui retourne une arraylist contenant toutes les cartes jouables !!! 
	 * @param P PILE
	 * @param V le joueur Virtuel
	 * @param T Talonn
	 * @return arrayliste de type carte
	 */
	public ArrayList<Carte> cartejouable(Pile P,Virtuel V,Talon T,Main M)throws mainVideException{
		
		// A contient les cartes jouables !
		ArrayList<Carte> A=new ArrayList<Carte>();
		
		// si la pile est un "7" alors aucune carte n'est jouable  
		if(P.getpilecarte().getnumberCarte()=="7" && Virtuel.sept!=0) return null;
		// si la pile est un joker...
		if (P.getpilecarte().getnumberCarte()=="Joker" ) {
           	                               
           	                                  	//Je peux joué un huit derrière un Joker
                                           if(V.jaiunhuit()!=200 && V.main.getmain().size()!=1){A.add((Carte) V.getmain().getmain().get(V.jaiunhuit())) ;}
       		 
                                           if(Virtuel.Joker==0){A.addAll(Standard(P,V,T,M));}
                                        // si la pile est un deux... 	                                            
                                           }
		if(P.getpilecarte().getnumberCarte()=="2" ){
	       	                              if (V.nbcartematch(P)!=200) {A.add((Carte) V.getmain().getmain().get(V.nbcartematch(P))) ;	}
	        	                          if(0==Virtuel.deux){A.addAll(Standard(P,V,T,M));	} 
		
	 // si j'ai un joker...                                 
	        	                          }
		if(V.jaiunJoker()!=200 && V.main.getmain().size()!=1){A.add((Carte) V.getmain().getmain().get(V.jaiunJoker())) ;  }
		// si j'ai un huit...	
		if(V.jaiunhuit()!=200 && V.main.getmain().size()!=1){ A.add((Carte) V.getmain().getmain().get(V.jaiunhuit())) ;   }
		// si j'ai pas de carte spéciale alors je cherche les cartes standards ..
		if(P.getpilecarte().getnumberCarte()!="Joker" && P.getpilecarte().getnumberCarte()!="2") A.addAll(Standard(P,V,T,M));
		 
		
		
		return A;
	}
	
	
	
	
	
	/**
	 * Methode qui retourne une arraylist contenant  les cartes  normales jouables  !!! 
	 * @param P pile
	 * @param V joueur virtuel
	 * @param T talon
	 * @param M main 
	 * @return
	 * @throws mainVideException
	 */
	
	public ArrayList<Carte> Standard(Pile P,Virtuel V,Talon T,Main M)throws mainVideException{
		
		ArrayList<Carte> A=new ArrayList<Carte>();
		
		//si  ma carte a la meme couleur que la pile 
		{
        if(couleurcartematch(P,Virtuel.choixcouleur,V) !=null    ){
        	
        	
        	
        	
        	
        	for(int j=0;j<couleurcartematch(P,Virtuel.choixcouleur,V).size();j++)
        	A.add((Carte) V.main.getmain().get(          couleurcartematch(P,Virtuel.choixcouleur,V).get(j)      ));
        	
        }
		// si ma carte a le meme hauteur que la pile
		if(nbcartematch(P,V)!=null){ 
			
			for(int j=0;j<nbcartematch(P,V).size();j++)
			A.add((Carte) V.getmain().getmain().get(nbcartematch(P,V).get(j)));   }
		}
		return A;
		
	}
	
	
	
	//---------------------------------------------------------------
	/**
	 * retourne toutes les cartes jouables qui ont le meme numero 
	 */
	public ArrayList<Integer> nbcartematch(Pile P,Virtuel V){
		ArrayList<Integer> T=new ArrayList<Integer>();
		
		//retourner toutes les cartes jouables qui ont le meme numero 
		for(int i=0;i<V.main.getmain().size();i++)
		{	if(P.getpilecarte().getnumberCarte()==((Carte)V.main.getmain().get(i)).getnumberCarte())
		                 T.add(i);            }
		return T;
		
	}
	/**
	 * retourne toutes les cartes jouables qui ont la meme couleur
	 * @param P pile
	 * @param choixcouleur
	 * @param V joueur virtuel 
	 * @return 
	 */
	public ArrayList<Integer> couleurcartematch(Pile P,String choixcouleur,Virtuel V){
		ArrayList<Integer> T=new ArrayList<Integer>();
		
		if ( Virtuel.couleur==1)
		{
		     // System.out.println(" J UTILISE LA NOUVELLE COULEUR  \t"+choixcouleur);
			for(int i=0;i<V.main.getmain().size();i++)
			{	if (choixcouleur==((Carte)V.main.getmain().get(i)).gettypecarte())
				{   //System.out.println("la carte que je vais posé est"+i);
				T.add(i);}} 
			     return T;
	}
		

		
		for(int i=0;i<V.main.getmain().size();i++)
		{	if(P.getpilecarte().gettypecarte()==((Carte)V.main.getmain().get(i)).gettypecarte())
			T.add(i); }
		return T;
	
		
		
		
	}
	
	
	
	/**
	 * Choix de la couleur en fonction des couleurs les plus nombreuses
	 * @return
	 */
	public String choixcouleur1(){
		int trefle=0;
		int pique=0;
		int carreau=0;int coeur=0 ;int jokerc=0;
		
	    //Cherche les couleurs qui se repetent le plus 
        for(int i=0;i<cartejouable.size();i++)
        {
        	if ( cartejouable.get(i).gettypecarte()=="trefle" ) trefle=trefle+1;
        	if (cartejouable.get(i).gettypecarte() =="coeur" ){ coeur++;
        	}
        	if ( cartejouable.get(i).gettypecarte()=="pique" ) pique++;
        	if ( cartejouable.get(i).gettypecarte()=="carreau" ) carreau++;
        	else jokerc++;
        }
        int max=0;
    	if (trefle>=pique)max=trefle;
    	else max=pique;
    	
    	if(max<coeur)max=coeur;
    	 if(max<carreau)max=carreau;
    	
    	 // renvoie le nom de la couleur qui se repete le plus
    	 
    	 
     if(max==0)return "";
    if(max==coeur)return"coeur";
    else if(max==trefle)return"trefle";
    else if(max==carreau)return"carreau";
    else if(max==pique) return"pique";
    else return ""; 
		
		
	}
	/**
	 * Pose une carte dans la pile en fonction de son indice 
	 * @param P
	 * @param j
	 * @param V
	 * @throws mainVideException
	 */
public void posercarte(Pile P,int j,Virtuel V) throws mainVideException{
		
		
		//ajouter  dans pile la carte qui match  
		P.getpile().add(((Carte)R.get(j)));
		if (Virtuel.couleur==1)Virtuel.couleur=0;
		
		//si la carte que je veux poser un joker ...
		if(((Carte)R.get(j)).getnumberCarte()=="Joker"){ Virtuel.choixcouleur=V.choixcouleur();Virtuel.couleur=1;System.out.println("  \ncouleur choisie : \n"+Virtuel.choixcouleur);
		if(Controle.interfacegraphique==true){
			Fenetre.setLabelAide("couleur choisie : "+Virtuel.choixcouleur);
		}Virtuel.Joker++; }
		//si la carte que je veux poser un deux....
		if(((Carte)R.get(j)).getnumberCarte()=="2"){Virtuel.deux++;  }
		
		//si la carte que je veux poser un AS....
		if(((Carte)R.get(j)).getnumberCarte()=="AS"){Virtuel. as++;  }
		//si la carte que je veux poser un sept....
		if(((Carte)R.get(j)).getnumberCarte()=="7"){ Virtuel.sept++;  }
		//si la carte que je veux poser un bien....
		if(((Carte)R.get(j)).getnumberCarte()=="8"){  Virtuel.choixcouleur=V.choixcouleur();Virtuel.couleur=1;System.out.println("  \ncouleur choisie : \n"+Virtuel.choixcouleur);
		if(Controle.interfacegraphique==true){
		Fenetre.setLabelAide("couleur choisie : "+Virtuel.choixcouleur);}  }
		
		
		
		mainVideException e1=new mainVideException();
		
		//supprimer de la main la carte que l on a ajouté
		
		V.main.getmain().remove(R.get(j));
	
		
		// Si je n ai plus qu'une carte declarer CARTE 

        
		if(V.main.getmain().size()==1){System.out.println("Carte !!!! ");
			
		}
		
		// si ma main est vise renvoyer une erreur 
		
		
		 if (V.main.getmain().isEmpty()==true ){  throw e1 ;}
		}
	
	/**
	 * retourne le nombre de point d une carte donnée
	 * @param carte
	 * @return
	 */
public   int nombrePoint(Carte carte) {
	int nbjoker=0,nbas=0,nbhuit=0,nbK=0,nbJ=0,nbQ=0,nbdeux=0,nbtrois=0,nbquatre=0,nbcinq=0,nbsix=0,nbsept=0,nbneuf=0,nbdix=0;
	
	// Calcul de nombre de points
	
	{
		if(  carte.getnumberCarte()=="Joker" ){nbjoker++;}
		else if(  carte.getnumberCarte()=="AS" ){nbas++;}
		else if(  carte.getnumberCarte()=="8" ){nbhuit++;}
		else if(  carte.getnumberCarte()=="K" ){nbK++;}
		else if(  carte.getnumberCarte()=="J" ){nbJ++;}
		else if(  carte.getnumberCarte()=="Q" ){nbQ++;}
		else if(  carte.getnumberCarte()=="2" ){nbdeux++;}
		else if(  carte.getnumberCarte()=="3" ){nbtrois++;}
		else if(  carte.getnumberCarte()=="4" ){nbquatre++;}
		else if(  carte.getnumberCarte()=="5" ){nbcinq++;}
		else if(  carte.getnumberCarte()=="6" ){nbsix++;}
		else if(  carte.getnumberCarte()=="7" ){nbsept++;}
		else if(  carte.getnumberCarte()=="9" ){nbneuf++;}
		else if(  carte.getnumberCarte()=="10" ){nbdix++;}
		 
	
	
	}
	
	
	
	
	 return ((nbjoker*50)+(20*nbas)+(32*nbhuit)+(10*nbK)+(10*nbJ)+(10*nbQ)+(2*nbdeux)+(3*nbtrois)+(4*nbquatre)+(5*nbcinq)+(6*nbsix)+(7*nbsept)+(9*nbneuf)+(10*nbdix));
}
	
	
	
	
	
	
	
	
	
	
	
	
}