package fr.utt.lo02.jeu;
	import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
	//import javax.persistence.OneToMany;
	//import javax.persistence.OneToOne;
/**
 * Classe  Main du joueur
 * @author NGUYEN BENDRISS
 */
	public class Main extends EnsembleCartes {

		/**
		 * nombre de cartes par main autorisé
		 */
		public static int nbmain=0;
		/**
		 * carte 
		 */
		Carte C;
		/**
		 * cette arraylist contient toutes les cartes
		 * dans une  La main 
		 */
		private ArrayList<Carte> M=null;
		/**
		 * Le joueur
		 */
		private Joueur joueur = null;

		/**
 *Le talon
 */
		private Collection<Talon> talon = null;


		
		
		/**
		 * MOn CONSTRUCTEUR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		public Main(ArrayList<Carte> E1,int nbcartemain){
			//Creation de l'arraylist qui va contenir les cartes de la main
			M=new ArrayList<Carte>();
		
			//Ajout des cartes dans l'arraylist
			for(int i=0+nbmain*nbcartemain+1;i<=(nbcartemain+nbmain*nbcartemain);i++)

			{C=(Carte)E1.get(i);
				
			M.add(C);
			}
			Main.nbmain++;
		}
		/**
		 * affiche la main 
		 */
		public void affichemain()
		{
            
			for(int i=0;i<M.size();i++)
			{
			
			Carte Cz=(Carte)M.get(i);
			System.out.println(Cz.getnumberCarte()+"  "+Cz.gettypecarte()+"  \t "+i );
			}
			
			
		}
		/**
		 * 
		 * retourne main
		 */
	//*	
		public ArrayList<Carte> getmain()
		{

		 return M ;
			
		}

		//@OneToOne
		
		public Joueur getJoueur() {
			return joueur;
		}

		/**
		 * Setter of the property <tt>joueur</tt>
		 * 
		 * @param joueur
		 *            The joueur to set.
		 * 
		 */
		public void setJoueur(Joueur joueur) {
			this.joueur = joueur;
		}

		/**
		 * Getter of the property <tt>talon</tt>
		 * 
		 * @return Returns the talon.
		 * 
		 */
		//@OneToMany(mappedBy = "main")
		public Collection<Talon> getTalon() {
			return talon;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Talon> talonIterator() {
			return talon.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isTalonEmpty() {
			return talon.isEmpty();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains the specified
		 * element.
		 * 
		 * @param element
		 *            whose presence in this collection is to be tested.
		 * @see java.util.Collection#contains(Object)
		 * 
		 */
		public boolean containsTalon(Talon talon) {
			return this.talon.contains(talon);
		}

		/**
		 * Returns <tt>true</tt> if this collection contains all of the elements
		 * in the specified collection.
		 * 
		 * @param elements
		 *            collection to be checked for containment in this
		 *            collection.
		 * @see java.util.Collection#containsAll(Collection)
		 * 
		 */
		public boolean containsAllTalon(Collection<Talon> talon) {
			return this.talon.containsAll(talon);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int talonSize() {
			return talon.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Talon[] talonToArray() {
			return talon.toArray(new Talon[talon.size()]);
		}

		/**
		 * Setter of the property <tt>talon</tt>
		 * 
		 * @param talon
		 *            the talon to set.
		 * 
		 */
		public void setTalon(Collection<Talon> talon) {
			this.talon = talon;
		}

		/**
		 * Ensures that this collection contains the specified element (optional
		 * operation).
		 * 
		 * @param element
		 *            whose presence in this collection is to be ensured.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean addTalon(Talon talon) {
			return this.talon.add(talon);
		}

		/**
		 * Removes a single instance of the specified element from this
		 * collection, if it is present (optional operation).
		 * 
		 * @param element
		 *            to be removed from this collection, if present.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean removeTalon(Talon talon) {
			return this.talon.remove(talon);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearTalon() {
			this.talon.clear();
		}

		

	}
