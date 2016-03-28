package fr.utt.lo02.jeu;


import fr.utt.lo02.controle.Controle;
import fr.utt.lo02.controle.Fenetre;
import fr.utt.lo02.exception.mainVideException;
import fr.utt.lo02.exception.nbPointsException;
import fr.utt.lo02.exception.nbToursException;
import fr.utt.lo02.exception.talonVideException;
import fr.utt.lo02.strategies.Strategy;
/**
 * Classe du joueur virtuel elle herite de joueur 
 * 
 * @author BENDRISS-NGUYEN
 *
 */
public class Virtuel extends Joueur {
        
	
	   
		static	int   nbinstance=0 ;
		
		private int identifiant;
		
		private Strategy s;
		
		
		// protected Main main = null;
	public 	Virtuel(){
		
		
		
	}
	/**
	 * 
	 * @return identifiant du joueur virtuel 
	 */
	public int getidentifiant(){
		return identifiant;
	}
	/**
	 * 
	 * @return difficulte du joueur
	 */
	
	/**
	 * la methode de joueur appelle la fonction joue qui correspond a la strategie 
	 * @param P PILE
	 * @param T TALON
	 * @return bool 
	 * @throws mainVideException : si la main est vide 
	 * @throws talonVideException : exception si le talon est vide
	 * @throws nbPointsException :si le nombre 
	 * @throws nbToursException
	 */

	public boolean joue(Pile P,Talon T,Croupier C)  throws talonVideException,mainVideException, nbPointsException, nbToursException {
		
		// appelle la fonction joue correspondante selon la strategie
		return  s.joue(P,T,C,this);
		
		
		
		
	}
	/**
	 * setteur de la main du joueur 
	 */
	public void setmain(Main main){
		this.main=main;System.out.println("main du joueur virtuel créee");
	}
	
	
	/**
	 * 
	 * @param P: la pile en parametre
	 * @return i : retourne i : l'index ou les 2 cartes ont la meme valeur
	 * si je retourne 200 j ai rien trouvé
	 */
	public int nbcartematch(Pile P){
		for(int i=0;i<main.getmain().size();i++)
		{	if(P.getpilecarte().getnumberCarte()==((Carte)main.getmain().get(i)).getnumberCarte())
		                           return i; }
		return 200;
		
	}
	/**
	 * @param choix de la couleur par le huit!! 
	 * @param P
	 * @return retourne l indexe de la carte qui match dans la main 
	 * sinn retourn 200
	 * 
	 */
	public int couleurcartematch(Pile P,String choixcouleur){
		
		if ( couleur==1)
		{
		      System.out.println(" J UTILISE LA NOUVELLE COULEUR"+choixcouleur);
			for(int i=0;i<main.getmain().size();i++)
			{	if (choixcouleur==((Carte)main.getmain().get(i)).gettypecarte())
				{   System.out.println("la carte que je vais posé est"+i); return i;}} 
			     return 200;
		
		
		
		}
		
		
		
		
		
		for(int i=0;i<main.getmain().size();i++)
		{	if(P.getpilecarte().gettypecarte()==((Carte)main.getmain().get(i)).gettypecarte())
		                           return i; }
		return 200;
	
		
		
		
	}
	/**
	 * 
	 * @param T : le talon pour piocher 
	 */
	public void piocher(Talon T)
	{  
		
		//si le talon est plein je pioche 
		if(T.gettalon().isEmpty()==false)
		{
		// piocher dans talon et donc ajouter a la main une carte a partir de talon  
		Carte C=((Carte)T.gettalon().get(T.gettalon().size()-1));
		main.getmain().add(  C );
		
		
		//une fois terminé supprimé du talon la carte
		T.gettalon().remove(T.gettalon().size()-1);
		}
		//utilser random et mettre ajour la pile !!
	}
	/**
	 * FONCTION SURCHARGEE
	 * @param M : main du joueur précedent 
	 */
	public void piocher(Main M)
	{
		
		// je pioche la premiere carte du joueur qui a posé le 7 :
		main.getmain().add(M.getmain().get(0));
		M.getmain().remove(0);
	}
	
	
	
	
	/**
	 * 
	 * @param P pile
	 * @param j ;indice où on a trouvé la carte 
	 */
	public void posercarte(Pile P,int j,Main M) throws mainVideException{
		
		System.out.println("\n  joueur virtuel a joué \n");
		//ajouter  dans pile la carte qui match  
		P.getpile().add(((Carte)main.getmain().get(j)));
		if (couleur==1)couleur=0;
		
		//si je pose un joker, ou un 2,...
		if(((Carte)main.getmain().get(j)).getnumberCarte()=="Joker"){ choixcouleur=choixcouleur();couleur=1;System.out.println("  \ncouleur choisie : \n"+choixcouleur);if(Controle.interfacegraphique)Fenetre.setLabelAide("couleur choisie : "+choixcouleur);Joker++; System.out.println("joueur virtuel a pose un joker"); }
		if(((Carte)main.getmain().get(j)).getnumberCarte()=="2"){deux++; System.out.println("virtuel  a pose un 2 ----------------------------------------------------------------------------"); }
		if(((Carte)main.getmain().get(j)).getnumberCarte()=="AS"){ as++; System.out.println("vrtuel a pose un as"); }
		if(((Carte)main.getmain().get(j)).getnumberCarte()=="7"){ sept++; System.out.println("viertul a pose un 7"); }
		if(((Carte)main.getmain().get(j)).getnumberCarte()=="8"){  choixcouleur=choixcouleur();couleur=1;  }
		
		
		//supprimer de la main la carte que l on a ajouté
		mainVideException e1=new mainVideException();
		
		
		//retirer la carte jouée
		main.getmain().remove(j);
		//si le joueur a une carte, il declare carte
		if(main.getmain().size()==1){System.out.println("\n  Le joueur "+ getidentifiant()+  "\t declare  --------Carte-----");carte=1;}
				
		
		//a revoir choiw 

        
		if(main.getmain().size()==1){
			System.out.println("Carte !!!! ");
			if(Controle.interfacegraphique==true){
			Fenetre.setLabelAide("Carte !");
			}
		}
		
		
		
		// si main vide, cela progage une erreur
		 if (main.getmain().isEmpty()==true ){  throw e1 ;}
		}
	

	/**
	 * cette fonction permet de poser une carte selon la couleur ou la hauteur
	 * @param P
	 * @param T
	 * @return boolean
	 */
	public boolean posestandard(Pile P,Talon T ,Main M ) throws mainVideException{
		// si la pile n est pa AS ... il faut voir la hauteur match
		 
		
		
		
		//sinn si la couleur match 
		if(couleurcartematch(P,Virtuel.choixcouleur) !=200){posercarte(P,couleurcartematch(P,choixcouleur),M) ;
		return true; }
		
		if(nbcartematch(P)!=200){posercarte(P,nbcartematch(P),M); 
		return true ;}//ATTENTION A L UTILISATION DE LA COMPARAISON ENTRE STRING
		
		//sinn piocher 
		else  { piocher(T); return true; }
	}
	/**
	 * jai un huit dans ma main	
	 * @return
	 */
	public int jaiunhuit(){
		for(int i=0;i<main.getmain().size();i++)
		{	if("8"==((Carte)main.getmain().get(i)).getnumberCarte())
		                           return i; }
		return 200;
		
	}
	/**
	 * j ai un Joker ds ma main
	 * @return
	 */
	public int jaiunJoker(){
		for(int i=0;i<main.getmain().size();i++)
		{	if("Joker"==((Carte)main.getmain().get(i)).getnumberCarte())
		                           return i; }
		return 200;
		
	}
	/**
	 * 
	 * @return le nombre de Joker poser
	 */
	public int nbJoker(Pile P){
		
		int i=P.getpile().size();
		int nbj=0;	
			
			while(((Carte)P.getpile().get(i-1)).getnumberCarte()=="Joker" )
			{
				i--;
				nbj++;
				if (i==0)break;
			}
			return nbj;
			
			
	}
	/**
	 * 
	 * @return le nombre d AS poser
	 */
	public int nbAS(Pile P){
		int i=	P.getpile().size();
		int nbas=0;	
			
			while(((Carte)P.getpile().get(i-1)).getnumberCarte()=="AS" )
			{
				i--;
				nbas++;
				if (i==0)break;
			}
			return nbas;
		
	}
	/**
	 * 
	 * @return nombre de deux poser 
	 */
	public int nbdeux(Pile P){
		int i=	P.getpile().size();
		int nbd=0;	
			
			while(((Carte)P.getpile().get(i-1)).getnumberCarte()=="2" )
			{
				i--;
				nbd++;
				if (i==0)break;
				
			}
			return nbd;
	}
	
	
	/**
	 * 
	 * @return Main du joueur 
	 */
	public Main getmain(){
		return main;
	}
	/**
	 * 
	 * @return la couleur qui se repete le plus dans la main
	 */
	public String choixcouleur(){
		int trefle=0;
		int pique=0;
		int carreau=0;int coeur=0;
		
	    
        for(int i=0;i<main.getmain().size();i++)
        {
        	if ( ((Carte)main.getmain().get(i)).gettypecarte()=="trefle" ) trefle=trefle+1;
        	if ( ((Carte)main.getmain().get(i)).gettypecarte()=="coeur" ){ coeur++;
        	}
        	if ( ((Carte)main.getmain().get(i)).gettypecarte()=="pique" ) pique++;
        	if ( ((Carte)main.getmain().get(i)).gettypecarte()=="carreau" ) carreau++;
        	
        }
        int max=0;
    	if (trefle>=pique)max=trefle;
    	else max=pique;
    	
    	if(max<coeur)max=coeur;
    	
        if(max<carreau)max=carreau;
     
    if(max==coeur)return"coeur";
    else if(max==trefle)return"trefle";
    else if(max==carreau)return"carreau";
    else return"pique";
    
		
		
	}
	/**
	 * Constructeur avec argument
	 * @param s La strategie
	 */
	public Virtuel(Strategy s){
		this.s=s;
		identifiant=nbinstance;
		nbinstance++;
	}
	
	
	/**
	 * cette fonction pioche automatiquement en fonction de la derrniere carte de la  pile 
	 * @param T talon
	 * @param M main du joueur precedent 
	 * @param P pile
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
	
	
	}
