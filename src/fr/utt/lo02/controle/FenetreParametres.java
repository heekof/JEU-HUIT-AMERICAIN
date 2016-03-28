package fr.utt.lo02.controle;

import javax.swing.JOptionPane;
/**
 * C'est la fenetre  qui permet d'entrer les paramètres du jeu  
 * @author NGUYEN-BENDRISS
 *
 */
public class FenetreParametres {
/**
 * Nombre de joueurs reels
 */
	public static String nbjr;
    /**
     * Nombre de joueurs virtuels 
     */
	public static String nbjv;
	/**
	 * Nombre de tours dans la partie
	 */
    public static String nbtours;
    /**
     * Nombre de points minimale
     */
    public static String nbpoints;
    /**
     * Nombre de cartes dans une main 
     */
    public static String nbcartes;
    /**
     * La difficulté du jeu 0 :standard
     * 1: avancé
     */
    public static String difficulte;
    /**
     * Les noms de tous les joueurs .
     */
    public static String[] nom;
	
	
	
	/**
	 *Constructeur de la classe FentreParametre
	 */
	public FenetreParametres(){
		
		JOptionPane jop = new JOptionPane();
		
		
		
		
		////////////////////////////////////////combobox du choix nombre joueurs réels /////////////////////////////////
        String[] choix = {"0", "1", "2","3", "4", "5","6", "7", "8",};
				
		// choix du nombre de joueurs reels
		nbjr = (String)jop.showInputDialog(null, 
										"Veuillez choisir le nombre de joueur reel",
										"Jeu huit americain",
										JOptionPane.QUESTION_MESSAGE,
										null,
										choix,
										choix[2]);
		
		//jop.showMessageDialog(null, "Votre choix est : " + nbjr, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		//---------------------------------------------------------------------------------------------------------------
		
		////////////////////////////////////////combobox du choix nombre joueurs virtuels /////////////////////////////////
		 // combobox
        String[] choix1 = {"0", "1", "2","3", "4", "5","6", "7", "8",};		
		
		// choix du nombre de joueurs virtuels
		
		nbjv = (String)jop.showInputDialog(null, 
										"Veuillez choisir le nombre de joueur Virtuel ",
										"Jeu huit americain",
										JOptionPane.QUESTION_MESSAGE,
										null,
										choix1,
										choix1[2]);
		
		
		//jop.showMessageDialog(null, "Votre choix est : " + nbjv, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		//------------------------------------------------------------------------------------------------------------
		
		
		//////////////////////////////////////parametres jeu//////////////////////////////////////////////////////////////
		
		nbtours = jop.showInputDialog(null, "Veuillez choisir le nombre de tours ! ", "Jeux de huit americain", JOptionPane.QUESTION_MESSAGE);
		//jop.showMessageDialog(null, "nombre de tours est " + nbtours, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		nbpoints = jop.showInputDialog(null, "Veuillez choisir le nombre de points ! ", "Jeux de huit americain", JOptionPane.QUESTION_MESSAGE);
		//jop.showMessageDialog(null, "nombre de points est " + nbpoints, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		nbcartes = jop.showInputDialog(null, "Veuillez choisir le nombre de cartes ! ", "Jeux de huit americain", JOptionPane.QUESTION_MESSAGE);
		//jop.showMessageDialog(null, "nombre de points est " + nbcartes, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		difficulte = jop.showInputDialog(null, "Veuillez choisir la difficulté !\n 0 : standart \n 1 : avancé", "Jeux de huit americain", JOptionPane.QUESTION_MESSAGE);
		//jop.showMessageDialog(null, "nombre de points est " + difficulte, "Choix", JOptionPane.INFORMATION_MESSAGE);
		
		//////////////////////////////////// nom joueurs réels//////////////////////////////////////////////////:
		nom = new String[Integer.parseInt(nbjr)];
		for(int i=0 ; i<Integer.parseInt(nbjr); i++){
			nom[i] = jop.showInputDialog(null, "Veuillez entre le nom du joueur ! ", "Jeux de huit americain", JOptionPane.QUESTION_MESSAGE);
		}
		
		
		
		
		
		
		
		//------------------------------------------------------------------------------------------------------------
	}
	
}
