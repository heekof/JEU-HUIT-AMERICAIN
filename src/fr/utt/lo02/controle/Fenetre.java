package fr.utt.lo02.controle;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.utt.lo02.exception.*;
import fr.utt.lo02.jeu.*;
/**
 * C'est le classe qui génére l'interfave graphique 
 * @author NGUYEN-BENDRISS
 *
 */
public class Fenetre {
	
	
	
	/**
	 * Croupier
	 */
	Croupier C;
	/**
	 * Le nom de la photo 
	 */
	private static String photo;
	/**
	 * Si le joueur a effectué son action sans passer son tour
	 */
	private static boolean aJoue=false;
	/**
	 * L'indice de la couleur choisie 
	 */
	private static int indiceChoixCouleur;
	/**
	 * Vrai si le joueur a choisie une couleur
	 */
	private static boolean aChoisiCouleur=false;
	/**
	 * La liste déroulante des cartes du joueur
	 */
	private static JComboBox comboxVosCartes = new JComboBox();
	/**
	 * Liste déroulante des couleurs
	 */
	private static JComboBox comboxChoixCouleur = new JComboBox();
	/**
	 * Pour afficher le nom du joueur qui est en train de joueur 
	 */
    private static JLabel labelJoueur;
    /**
     * Indications sur :
     * Qui a gagné ,la couleur choisie... 
     */
	private static JLabel labelAide;
	/**
	 * Image de la Pile
	 */
    private static JLabel labelPile;
    /**
     * Indiquer le nom de l adversaire et le nombre de cartes qui lui reste
     */
    private static JLabel[] labelMains;
    /**
     * Pour signaler que l'advesaire a oublié de dire carte
     */
    private static JButton boutonCarteAdversaire;
    /**
     * Pour dire carte
     */
    private static JButton boutonCarteJReel;
    /**
     * Bouton pour passer son tour
     */
    private static JButton boutonProchainTour;
   /**
    * Bouton pour piocher
    */
    private static JButton boutonPioche;
    
    
    
    /**
     * getteur Jop1
     * @return
     */
  public JOptionPane getJop1() {
	return jop1;
}
/**
 * Setteur Jop2
 * @param jop1
 */
public void setJop1(JOptionPane jop1) {
	this.jop1 = jop1;
}


//Déclaration des objets
   private JOptionPane jop1= new JOptionPane();
        
	/**
	 * Constructeur de la classe fenetre
	 * @param C
	 */
	public Fenetre(Croupier C){
		
		this.C=C;
		
		//////////////////////////////////////////////////////////////////////////////Parametres de la fenetre
		JFrame fenetre = new JFrame();
		//Définit un titre pour votre fenêtre
        fenetre.setTitle("Jeu du 8 américain");
        //Définit une taille pour celle-ci ; ici, 600 px de large et 600 px de haut
        fenetre.setSize(600, 600);
        //Nous allons maintenant dire à notre fenetre de se centrer
        fenetre.setLocationRelativeTo(null);
        //Terminer le processus lorsqu'on clique sur "Fermer"
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre a une taille fixe
        fenetre.setResizable(false);
      		
        
        //Construction des panels qui vont constituer la fenetre
        JPanel panelBas = new JPanel();
        JPanel panelHaut = new JPanel();
        JPanel panelGauche = new JPanel();
        JPanel panelCentre = new JPanel(new GridBagLayout ()); //Pour centrer les composants au milieu du panel
        //Dimension des panels
        panelHaut.setPreferredSize(new Dimension(430, 90));
        panelGauche.setPreferredSize(new Dimension(150, 500));
        
        /////////////////////////////////////////////////////////////////////////////Creation des composants
        
          
        //////////////////////////////////////////////////////////Composants en bas
        //label vos cartes
        labelJoueur = new JLabel();
        //Bouton Carte du joueur reel
        boutonCarteJReel = new JButton("Carte");
        //Listener bouton carte joueur reel
        boutonCarteJReel.addActionListener(new boutonCarteJReelListener());
        //Bouton tour suivant
        boutonProchainTour = new JButton("Prochain tour");
        boutonProchainTour.addActionListener(new BoutonProchainTourListener());
        boutonProchainTour.setVisible(false);
        //Définit dimension de la combobox
        comboxVosCartes.setPreferredSize(new Dimension(130,30));
        //Ajout du listener de la combobox
        comboxVosCartes.addItemListener(new comboxVosCartesListener());
        //Ajoute du nom de la combobox
   
		
		//combobox choix couleur
		comboxChoixCouleur.setPreferredSize(new Dimension(130,30));
		//Ajout du listener de la combobox
        comboxChoixCouleur.addItemListener(new comboxChoixCouleurListener());
        //Affichage choix couleur
        comboxChoixCouleur.addItem("Choix Couleur");
        //Ajout des couleurs dans la combobox
        comboxChoixCouleur.addItem("1) trefle ");
        comboxChoixCouleur.addItem("2) coeur ");
        comboxChoixCouleur.addItem("3) carreau ");
        comboxChoixCouleur.addItem("4) pique ");
		
        //////////////////////////////////////////////////////////Composants en haut
        labelAide=new JLabel();
        
		
		//////////////////////////////////////////////////////////Composants au centre
		//(le talon) bouton pioche
		boutonPioche=new JButton(new ImageIcon("images/talon.png"));
		boutonPioche.setContentAreaFilled(false);
		boutonPioche.setBorderPainted(false);
		//Ajout du listener du boution pioche
        boutonPioche.addActionListener(new BoutonPiocheListener());
		//la pile
        photo=photo(C.getPile().getpilecarte());
        labelPile = new JLabel(new ImageIcon(photo)); // label pile
		
		
		//////////////////////////////////////////////////////////Composant a gauche
		//tableau label main
		labelMains=new JLabel[C.nbjoueurs];
		//bouton oublie
        boutonCarteAdversaire=new JButton("Carte");
        //Listener du bouton carte
        boutonCarteAdversaire.addActionListener(new BoutonCarteAdversaireListener());
        
        panelGauche.add(boutonCarteAdversaire);
        for(int i=0;i<C.nbjoueurs;i++){
        	//Creation d'un label main
        	//Ce label sert à indiquer le nombre de cartes restant
        	labelMains[i]=new JLabel("Main "+i+" ("+C.getjoueur(i).getmain().getmain().size()+" cartes)");
        	//Ajout des composants dans le panel gauche
        	panelGauche.add(labelMains[i]);
     	}
		
		
		//Ajout des composants dans le panel bas
        panelBas.add(labelJoueur);
        panelBas.add(comboxChoixCouleur);
		panelBas.add(comboxVosCartes);
		panelBas.add(boutonCarteJReel);
		panelBas.add(boutonProchainTour);
		
		//Ajout des composants dans le panel haut
		panelHaut.add(labelAide);
				
		
		//Ajout des composants dans le panel centre
		panelCentre.add(boutonPioche);
		panelCentre.add(labelPile);
		
		//Ajout des panels sur la fenetre
		fenetre.getContentPane().add(panelBas,BorderLayout.SOUTH);
		fenetre.getContentPane().add(panelCentre,BorderLayout.CENTER);
		fenetre.getContentPane().add(panelGauche,BorderLayout.WEST);
		fenetre.getContentPane().add(panelHaut,BorderLayout.NORTH);
		
		//fenetre visible
        fenetre.setVisible(true);
	}
	
	
	/**
	 * rafraichir la fenetre
	 * @param C
	 */
	public static void refresh(Croupier C){
    	
		//Rafraichir les composants du panel gauche
		
    	for(int i=0;i<C.nbjoueurs;i++){
    		
    			if(C.getjoueur(i).getmain().getmain().isEmpty()==true){
    				if(C.getjoueur(i) instanceof Reel){
    					labelMains[i].setText(C.getjoueur(i).getnom()+" (0 cartes)");
    				}
    				else{
    					labelMains[i].setText("Main "+i+" (0 cartes)");
    				}
    				if(i == C.getIndiceJReelJouant()){
    					labelMains[i].setVisible(false);
    				}
    			}
    			else{
    				if(C.getjoueur(i) instanceof Reel){
    					labelMains[i].setText(C.getjoueur(i).getnom()+" ("+C.getjoueur(i).getmain().getmain().size()+" cartes)");
    				}
    				else{
    					labelMains[i].setText("Main "+i+" ("+C.getjoueur(i).getmain().getmain().size()+" cartes)");
    				}
			    	if(i == C.getIndiceJReelJouant()){
    					labelMains[i].setVisible(false);
    				}
    			}
    		
    	}
    	
    	//Rafraichir les composants du panel centre
    	photo=photo(C.getPile().getpilecarte());
    	labelPile.setIcon(new ImageIcon(photo));
    	
    	//Rafraichir les composants du panel bas
    	labelJoueur.setText(C.getjoueur(C.getIndiceJReelJouant()).getnom());
    	comboxVosCartes.removeAllItems();
    	comboxVosCartes.addItem("Vos Cartes");
    	for(int i=0;i<C.getjoueur(C.getIndiceJReelJouant()).getmain().getmain().size();i++){
    		Carte CV= (Carte) C.getjoueur(C.getIndiceJReelJouant()).getmain().getmain().get(i);
            comboxVosCartes.addItem(i+") "+CV.getnumberCarte()+" "+CV.gettypecarte());
    	}
    	
    	//combobox choix couleur
    	comboxChoixCouleur.removeAllItems();
    	//Affichage choix couleur
        comboxChoixCouleur.addItem("Choix Couleur");
        //Ajout des couleurs dans la combobox
        comboxChoixCouleur.addItem("1) trefle ");
        comboxChoixCouleur.addItem("2) coeur ");
        comboxChoixCouleur.addItem("3) carreau ");
        comboxChoixCouleur.addItem("4) pique ");
    	
    	boutonProchainTour.setVisible(false);
        
    }
	
	//Listener bouton pioche
	/**
	 * La classe qui determine l'action du bouton
	 */
	class BoutonPiocheListener  implements ActionListener{
   	 
        public void actionPerformed(ActionEvent e) {
        	
        	try {
        		if(aJoue==false){
        			mettreaJoueTrue();
        			C.getjoueur(C.getIndiceJReelJouant()).joue(C.getPile(), C.getTalon(), C, "100");
					//Refresh pour voir la carte piochee
					Fenetre.refresh(C);
					setLabelAide("Vous avez pioché !");
					boutonProchainTour.setVisible(true);
        		}
			} catch (talonVideException e1) {
				for( int t=0;t<C.J.size();t++)
				{if(C.getjoueur(t) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));     Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
				
				else Fenetre.setLabelAide("   Le  joueur :"+t+"a eu  :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
				// CALCUL DU NOMBRE MIN
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				
			} catch (mainVideException e1) {
				System.out.println(" \n La main du  joueur est vide !!!  \n");
				System.out.println(" \n ----------------------FIN------------------");
				JOptionPane.showMessageDialog(null, "Partie Terminée :Main vide", "Information", JOptionPane.INFORMATION_MESSAGE);

					if(C.getVariable()==1){
						if(C.getjoueur(C.getP()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getP())).getnom()+" \t a gagné felicitation \n");}
						else {
						
						JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getP()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
						
						;Fenetre.setLabelAide("  Le Joueur  "+C.getP()+" a gagné felicitation");}  }      		
					
					
					else {
						
						if(C.getjoueur(C.getI()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n");;Fenetre.setLabelAide("\n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n"); }
						
						else {System.out.println();
						JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
						
						Fenetre.setLabelAide(" \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n");}}
				
				//affichage des points 
					for( int t=0;t<C.J.size();t++)
					{
						
						if(C.getjoueur(C.getP()) instanceof Reel){
							
							JOptionPane.showMessageDialog(null, " \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
							
							System.out.println();Fenetre.setLabelAide(" \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
						
						else {
							JOptionPane.showMessageDialog(null, " \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points", null, JOptionPane.INFORMATION_MESSAGE);
							
							System.out.println();;Fenetre.setLabelAide(" \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
					
					}
			} catch (nbPointsException e1) {

				
				JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de Points ", "Information", JOptionPane.INFORMATION_MESSAGE);
				for(int  t=0;t<C.J.size();t++)
				{
					
					if(C.getjoueur(t) instanceof Reel){
						((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));   
						Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));  
					JOptionPane.showMessageDialog(null, "   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					}
					else { Fenetre.setLabelAide("  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
					
					JOptionPane.showMessageDialog(null, "  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				JOptionPane.showMessageDialog(null, "  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
				
				
				
					
			
			} catch (nbToursException e1) {
				JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de Tours", "Information", JOptionPane.INFORMATION_MESSAGE);
				for(int  t=0;t<C.J.size();t++)
				{
					if(C.getjoueur(C.getP()) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));
					
					JOptionPane.showMessageDialog(null, " Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					
					Fenetre.setLabelAide(" Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
					
					else {Fenetre.setLabelAide("   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
					
					JOptionPane.showMessageDialog(null,"   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				JOptionPane.showMessageDialog(null,"  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			    
        }
        
	}
			
		
	//Listener combobox vos cartes
	/**
	 * Décrit les action qu il y a dans la liste déroulante
	 */
    class comboxVosCartesListener implements ItemListener{
    	
    	String test="";
        public void itemStateChanged(ItemEvent e) {
        	
        	if(e.getItem().toString()!="Vos Cartes" && e.getItem().toString()!=test){ // car probleme de doublon (2 executions ds la console) d'ou le string test
        			test=e.getItem().toString();
        			StringTokenizer recupString=new StringTokenizer(e.getItem().toString(), ")" );
                    try {
                    	if(aJoue==false){
							C.getjoueur(C.getIndiceJReelJouant()).joue(C.getPile(), C.getTalon(), C, recupString.nextToken());
							//Refresh pour voir la carte qu'on a joue
							Fenetre.refresh(C);
							if(aJoue==true){
								boutonProchainTour.setVisible(true);
							}
                    	}
					} catch (talonVideException e1) {
						for( int t=0;t<C.J.size();t++)
						{if(C.getjoueur(t) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));     Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
						
						else Fenetre.setLabelAide("   Le  joueur :"+t+"a eu  :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
						// CALCUL DU NOMBRE MIN
						
						Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
						
					} catch (mainVideException e1) {
						System.out.println(" \n La main du  joueur est vide !!!  \n");
						System.out.println(" \n ----------------------FIN------------------");
						JOptionPane.showMessageDialog(null, "Partie Terminée:Main vide ", "Information", JOptionPane.INFORMATION_MESSAGE);

							if(C.getVariable()==1){
								if(C.getjoueur(C.getP()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getP())).getnom()+" \t a gagné felicitation \n");}
								else {
								
								JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getP()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
								
								;Fenetre.setLabelAide("  Le Joueur  "+C.getP()+" a gagné felicitation");}  }      		
							
							
							else {
								
								if(C.getjoueur(C.getI()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n");;Fenetre.setLabelAide("\n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n"); }
								
								else {System.out.println();
								JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
								
								Fenetre.setLabelAide(" \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n");}}
						
						//affichage des points 
							for( int t=0;t<C.J.size();t++)
							{
								
								if(C.getjoueur(C.getP()) instanceof Reel){
									
									JOptionPane.showMessageDialog(null, " \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
									
									System.out.println();Fenetre.setLabelAide(" \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
								
								else {
									JOptionPane.showMessageDialog(null, " \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points", null, JOptionPane.INFORMATION_MESSAGE);
									
									System.out.println();;Fenetre.setLabelAide(" \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
							
							}
					} catch (nbPointsException e1) {
						

						
						JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de Points", "Information", JOptionPane.INFORMATION_MESSAGE);
						for(int  t=0;t<C.J.size();t++)
						{
							
							if(C.getjoueur(t) instanceof Reel){
								((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));   
								Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));  
							JOptionPane.showMessageDialog(null, "   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
							}
							else { Fenetre.setLabelAide("  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
							
							JOptionPane.showMessageDialog(null, "  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
							
							}
						}
						
						Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
						JOptionPane.showMessageDialog(null, "  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
						
						
						
					} catch (nbToursException e1) {
						JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de tours", "Information", JOptionPane.INFORMATION_MESSAGE);
						for(int  t=0;t<C.J.size();t++)
						{
							if(C.getjoueur(C.getP()) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));  Fenetre.setLabelAide(" Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
							
							else Fenetre.setLabelAide("   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
						
						}
						
						Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
					}
                                       
                }
        }             
    }
    
	//Listener combobox choix couleur
    /**
     * Liste déroulante des couleurs
     */
    class comboxChoixCouleurListener implements ItemListener{
    	
    	String test="";
        public void itemStateChanged(ItemEvent e) {
        	
        	if(e.getItem().toString()!="Choix Couleur" && e.getItem().toString()!=test){ // car probleme de doublon (2 executions ds la console) d'ou le string test
    			test=e.getItem().toString();
    			StringTokenizer recupString=new StringTokenizer(e.getItem().toString(), ")" );
    			indiceChoixCouleur = Integer.parseInt(recupString.nextToken());
    			aChoisiCouleur=true;
        	}
        }
    }
    
    
        	//Listener bouton prochain tour
    /**
     * Pour passer au prochain tour
     */
  	class BoutonProchainTourListener implements ActionListener{
  		
  		public void actionPerformed(ActionEvent e) {
  			if(aJoue==true){
  				for(int i=0;i<C.nbjoueurs;i++){
  					labelMains[i].setVisible(true);
  				}
  				C.tourFini();
  				aJoue=false;
  				aChoisiCouleur=false;
  				Fenetre.setLabelAide("");
  			}
  		}
  	}
  	
  	//Listener bouton carte adversaire
  	/**
  	 * L'action générer apres avoir cliquer sue le bouton Carteadversaire 
  	 */
	class BoutonCarteAdversaireListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try {
				C.getjoueur(C.getIndiceJReelJouant()).joue(C.getPile(), C.getTalon(), C, "oublie");
			} catch (talonVideException e1) {
				for( int t=0;t<C.J.size();t++)
				{if(C.getjoueur(t) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));     Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
				
				else Fenetre.setLabelAide("   Le  joueur :"+t+"a eu  :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
				// CALCUL DU NOMBRE MIN
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				
			} catch (mainVideException e1) {System.out.println(" \n La main du  joueur est vide !!!  \n");
			System.out.println(" \n ----------------------FIN------------------");
			JOptionPane.showMessageDialog(null, "Partie Terminée : Main vide !", "Information", JOptionPane.INFORMATION_MESSAGE);

				if(C.getVariable()==1){
					if(C.getjoueur(C.getP()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getP())).getnom()+" \t a gagné felicitation \n");}
					else {
					
					JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getP()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
					
					;Fenetre.setLabelAide("  Le Joueur  "+C.getP()+" a gagné felicitation");}  }      		
				
				
				else {
					
					if(C.getjoueur(C.getI()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n");;Fenetre.setLabelAide("\n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n"); }
					
					else {System.out.println();
					JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
					
					Fenetre.setLabelAide(" \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n");}}
			
			//affichage des points 
				for( int t=0;t<C.J.size();t++)
				{
					
					if(C.getjoueur(C.getP()) instanceof Reel){
						
						JOptionPane.showMessageDialog(null, " \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
						
						System.out.println();Fenetre.setLabelAide(" \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
					
					else {
						JOptionPane.showMessageDialog(null, " \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points", null, JOptionPane.INFORMATION_MESSAGE);
						
						System.out.println();;Fenetre.setLabelAide(" \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
				
				}
			} catch (nbPointsException e1) {
				
				JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de points", "Information", JOptionPane.INFORMATION_MESSAGE);
				for(int  t=0;t<C.J.size();t++)
				{
					
					if(C.getjoueur(t) instanceof Reel){
						((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));   
						Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));  
					JOptionPane.showMessageDialog(null, "   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					}
					else { Fenetre.setLabelAide("  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
					
					JOptionPane.showMessageDialog(null, "  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				JOptionPane.showMessageDialog(null, "  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
				
				
				
			} catch (nbToursException e1) {		JOptionPane.showMessageDialog(null, "Partie Terminée : En nombre de tours", "Information", JOptionPane.INFORMATION_MESSAGE);
			for(int  t=0;t<C.J.size();t++)
			{
				if(C.getjoueur(C.getP()) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));
				
				JOptionPane.showMessageDialog(null, " Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
				
				Fenetre.setLabelAide(" Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
				
				else {Fenetre.setLabelAide("   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
				
				JOptionPane.showMessageDialog(null,"   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
			
			Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
			JOptionPane.showMessageDialog(null,"  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
			
			}
		}
	}
	
	//Listener bouton carte joueur reel
	class boutonCarteJReelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try {
				
				
				C.getjoueur(C.getIndiceJReelJouant()).joue(C.getPile(), C.getTalon(), C, "carte");
				boutonProchainTour.setVisible(true);
		
			
			} catch (talonVideException e1) {
				
				for( int t=0;t<C.J.size();t++)
				{if(C.getjoueur(t) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));     Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
				
				else Fenetre.setLabelAide("   Le  joueur :"+t+"a eu  :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
				// CALCUL DU NOMBRE MIN
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				
				
				
				
			} catch (mainVideException e2) {System.out.println(" \n La main du  joueur est vide !!!  \n");
			System.out.println(" \n ----------------------FIN------------------");
			JOptionPane.showMessageDialog(null, "Partie Terminée :Main vide", "Information", JOptionPane.INFORMATION_MESSAGE);

				if(C.getVariable()==1){
					if(C.getjoueur(C.getP()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getP())).getnom()+" \t a gagné felicitation \n");}
					else {
					
					JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getP()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
					
					;Fenetre.setLabelAide("  Le Joueur  "+C.getP()+" a gagné felicitation");}  }      		
				
				
				else {
					
					if(C.getjoueur(C.getI()) instanceof Reel){System.out.println(" \n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n");;Fenetre.setLabelAide("\n  "+((Reel)C.getjoueur(C.getI())).getnom()+" \t a gagné felicitation \n"); }
					
					else {System.out.println();
					JOptionPane.showMessageDialog(null, " \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n", null, JOptionPane.INFORMATION_MESSAGE);
					
					Fenetre.setLabelAide(" \n Le Joueur \t "+C.getI()+"\t a gagné felicitation \n");}}
			
			//affichage des points 
				for( int t=0;t<C.J.size();t++)
				{
					
					if(C.getjoueur(C.getP()) instanceof Reel){
						
						JOptionPane.showMessageDialog(null, " \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
						
						System.out.println();Fenetre.setLabelAide(" \n  "+((Reel)C.getjoueur(t)).getnom()+" \t a eu: \t"+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
					
					else {
						JOptionPane.showMessageDialog(null, " \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points", null, JOptionPane.INFORMATION_MESSAGE);
						
						System.out.println();;Fenetre.setLabelAide(" \n  Le  joueur :"+t+"a eu \t :"+Croupier.nombrePoint(C.getjoueur(t).getmain())+"Points");}
				
				}
				
				
			} catch (nbPointsException e3) {
				
				JOptionPane.showMessageDialog(null, "Partie Terminée :En Nombre de points", "Information", JOptionPane.INFORMATION_MESSAGE);
				for(int  t=0;t<C.J.size();t++)
				{
					
					if(C.getjoueur(t) instanceof Reel){
						((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));   
						Fenetre.setLabelAide("   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));  
					JOptionPane.showMessageDialog(null, "   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					}
					else { Fenetre.setLabelAide("  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
					
					JOptionPane.showMessageDialog(null, "  Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
				Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
				JOptionPane.showMessageDialog(null, "  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
				
				
				
				
				
				
			} catch (nbToursException e3) {		JOptionPane.showMessageDialog(null, "Partie Terminée : en Nombre de Tours", "Information", JOptionPane.INFORMATION_MESSAGE);
			for(int  t=0;t<C.J.size();t++)
			{
				if(C.getjoueur(C.getP()) instanceof Reel){((Reel)C.getjoueur(t)).setScore( Croupier.nombrePoint(C.getjoueur(t).getmain()));
				
				JOptionPane.showMessageDialog(null, " Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
				
				Fenetre.setLabelAide(" Le joueur   "+((Reel)C.getjoueur(t)).getnom()+"  a eu: "+Croupier.nombrePoint(C.getjoueur(t).getmain()));}
				
				else {Fenetre.setLabelAide("   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()));
				
				JOptionPane.showMessageDialog(null,"   Le nombre de point DU joueur"+t+" est de :"+Croupier.nombrePoint(C.getjoueur(t).getmain()), null, JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
			
			Fenetre.setLabelAide("  Le Joueur  "+C.min(C)+" a gagné felicitation ");
			JOptionPane.showMessageDialog(null,"  Le Joueur  "+C.min(C)+" a gagné felicitation ", null, JOptionPane.INFORMATION_MESSAGE);
			
				
			}
		}
	}
    /**
     * Getteur oublie
     * @return
     */
	public static String getStringOublie(){
    	return "oublie";
    }
	/**
	 * Getteur indice choix couleur
	 * @return
	 */
  	public static int getIndiceChoixCouleur(){
    	return indiceChoixCouleur;
    }
  	/***
  	 * Getteur d'aChoisiCouleur
  	 * @return
  	 */
  	public static boolean getAChoisiCouleur(){
    	return aChoisiCouleur;
    }  	
  	/**
  	 * Retourne la variable aJoue et lui affecté true
  	 * @return
  	 */
    public static boolean mettreaJoueTrue(){
    	return aJoue=true;
    }
	/**
	 * Getteur aJoue
	 * @return
	 */
    public static boolean getaJoue(){
    	return aJoue;
    }
    
    /**
     * Setteur LabelAide
     * @param text
     */
    public static void setLabelAide(String text){
    	labelAide.setText(text);
    }
    /**
     * Fonction qui retourne le nom de la carte choisie
     * @param carte
     * @return
     */
    public static String photo(Carte carte){
    	
    	String num=carte.getnumberCarte();
		String type=carte.gettypecarte();
    	
		if(num=="AS" && type =="trefle" ) return "images/as_trefle.png";
		else if (num=="AS" && type =="coeur" ) return "images/as_coeur.png";
		else if (num=="AS" && type =="pique" ) return "images/as_pique.png";
		else if (num=="AS" && type =="carreau" ) return "images/as_carreau.png";
		
		else if (num=="2" && type =="coeur" ) return "images/deux_coeur.png";
		else if (num=="2" && type =="trefle" ) return "images/deux_trefle.png";
		else if (num=="2" && type =="pique" ) return "images/deux_pique.png";
		else if (num=="2" && type =="carreau" ) return "images/deux_carreau.png";
		
		else if (num=="3" && type =="coeur" ) return "images/trois_coeur.png";
		else if (num=="3" && type =="trefle" ) return "images/trois_trefle.png";
		else if (num=="3" && type =="pique" ) return "images/trois_pique.png";
		else if (num=="3" && type =="carreau" ) return "images/trois_carreau.png";
		
		else if (num=="4" && type =="coeur" ) return "images/quatre_coeur.png";
		else if (num=="4" && type =="trefle" ) return "images/quatre_trefle.png";
		else if (num=="4" && type =="pique" ) return "images/quatre_pique.png";
		else if (num=="4" && type =="carreau" ) return "images/quatre_carreau.png";
		
		else if (num=="5" && type =="coeur" ) return "images/cinq_coeur.png";
		else if (num=="5" && type =="trefle" ) return "images/cinq_trefle.png";
		else if (num=="5" && type =="pique" ) return "images/cinq_pique.png";
		else if (num=="5" && type =="carreau" ) return "images/cinq_carreau.png";
		
		else if (num=="6" && type =="coeur" ) return "images/six_coeur.png";
		else if (num=="6" && type =="trefle" ) return "images/six_trefle.png";
		else if (num=="6" && type =="pique" ) return "images/six_pique.png";
		else if (num=="6" && type =="carreau" ) return "images/six_carreau.png";
		
		else if (num=="7" && type =="coeur" ) return "images/sept_coeur.png";
		else if (num=="7" && type =="trefle" ) return "images/sept_trefle.png";
		else if (num=="7" && type =="pique" ) return "images/sept_pique.png";
		else if (num=="7" && type =="carreau" ) return "images/sept_carreau.png";
		
		else if (num=="8" && type =="coeur" ) return "images/huit_coeur.png";
		else if (num=="8" && type =="trefle" ) return "images/huit_trefle.png";
		else if (num=="8" && type =="pique" ) return "images/huit_pique.png";
		else if (num=="8" && type =="carreau" ) return "images/huit_carreau.png";
		
		else if (num=="9" && type =="coeur" ) return "images/neuf_coeur.png";
		else if (num=="9" && type =="trefle" ) return "images/neuf_trefle.png";
		else if (num=="9" && type =="pique" ) return "images/neuf_pique.png";
		else if (num=="9" && type =="carreau" ) return "images/neuf_carreau.png";
		
		else if (num=="K" && type =="coeur" ) return "images/K_coeur.png";
		else if (num=="K" && type =="trefle" ) return "images/K_trefle.png";
		else if (num=="K" && type =="pique" ) return "images/K_pique.png";
		else if (num=="K" && type =="carreau" ) return "images/K_carreau.png";
		
		else if (num=="J" && type =="coeur" ) return "images/J_coeur.png";
		else if (num=="J" && type =="trefle" ) return "images/J_trefle.png";
		else if (num=="J" && type =="pique" ) return "images/J_pique.png";
		else if (num=="J" && type =="carreau" ) return "images/J_carreau.png";
		
		else if (num=="Q" && type =="coeur" ) return "images/Q_coeur.png";
		else if (num=="Q" && type =="trefle" ) return "images/Q_trefle.png";
		else if (num=="Q" && type =="pique" ) return "images/Q_pique.png";
		else if (num=="Q" && type =="carreau" ) return "images/Q_carreau.png";
		
		else if (num=="10" && type =="coeur" ) return "images/dix_coeur.png";
		else if (num=="10" && type =="trefle" ) return "images/dix_trefle.png";
		else if (num=="10" && type =="pique" ) return "images/dix_pique.png";
		else if (num=="10" && type =="carreau" ) return "images/dix_carreau.png";
		
		
		else return "images/joker.png";
		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
}