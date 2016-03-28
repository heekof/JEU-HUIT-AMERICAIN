package fr.utt.lo02.jeu;
/**

 * 
 */
	import java.util.Collection;
import java.util.Iterator;
import java.util.*;





/**
 * Classe qui represente toutes nos cartes !
 * @author NGUYEN BENDRISS
 *
 */
	public class EnsembleCartes {

		/**
 *
 */
		protected ArrayList<Carte> carte = null;

		/**
		 * Getter of the property <tt>carte</tt>
		 * 
		 * @return Returns the carte.
		 * 
		 */
		
        public EnsembleCartes(){
        	//Création de l'arraylist qui va contenir  toutes les cartes du jeu
        	
        carte=new ArrayList<Carte>();	
         Carte[] C=new Carte[106];
        // Création des cartes
         for(int i=0;i<=12;i++)
        {	
        switch(i){
        case 0:  C[i]=new Carte("coeur","AS"); break;
        case 1: C[i]=new Carte("coeur","2"); break;
        case 2: C[i]=new Carte("coeur","3"); break;
        case 3: C[i]=new Carte("coeur","4"); break;
        case 4: C[i]=new Carte("coeur","5"); break;
        case 5: C[i]=new Carte("coeur","6"); break;
        case 6: C[i]=new Carte("coeur","7"); break;
        case 7: C[i]=new Carte("coeur","8"); break;
        case 8: C[i]=new Carte("coeur","9"); break;
        case 9: C[i]=new Carte("coeur","10"); break;
        case 10: C[i]=new Carte("coeur","J"); break;
        case 11: C[i]=new Carte("coeur","Q"); break;
        case 12: C[i]=new Carte("coeur","K"); break;
        
        }      
                
        }
         
         for(int i=13;i<=25;i++)
         {	
         switch(i){
         case 13:  C[i]=new Carte("trefle","AS"); break;
         case 14: C[i]=new Carte("trefle","2"); break;
         case 15: C[i]=new Carte("trefle","3"); break;
         case 16: C[i]=new Carte("trefle","4"); break;
         case 17: C[i]=new Carte("trefle","5"); break;
         case 18: C[i]=new Carte("trefle","6"); break;
         case 19: C[i]=new Carte("trefle","7"); break;
         case 20: C[i]=new Carte("trefle","8"); break;
         case 21: C[i]=new Carte("trefle","9"); break;
         case 22: C[i]=new Carte("trefle","10"); break;
         case 23: C[i]=new Carte("trefle","J"); break;
         case 24: C[i]=new Carte("trefle","Q"); break;
         case 25: C[i]=new Carte("trefle","K"); break;
         
         }
                          
         }
         
         for(int i=26;i<=38;i++)
         {	
         switch(i){
         case 26:  C[i]=new Carte("pique","AS"); break;
         case 27: C[i]=new Carte("pique","2"); break;
         case 28: C[i]=new Carte("pique","3"); break;
         case 29: C[i]=new Carte("pique","4"); break;
         case 30: C[i]=new Carte("pique","5"); break;
         case 31: C[i]=new Carte("pique","6"); break;
         case 32: C[i]=new Carte("pique","7"); break;
         case 33: C[i]=new Carte("pique","8"); break;
         case 34: C[i]=new Carte("pique","9"); break;
         case 35: C[i]=new Carte("pique","10"); break;
         case 36: C[i]=new Carte("pique","J"); break;
         case 37: C[i]=new Carte("pique","Q"); break;
         case 38: C[i]=new Carte("pique","K"); break;
         
         }
                           
         }
         
         for(int i=39;i<=51;i++)
         {	
         switch(i){
         case 39:  C[i]=new Carte("carreau","AS"); break;
         case 40: C[i]=new Carte("carreau","2"); break;
         case 41: C[i]=new Carte("carreau","3"); break;
         case 42: C[i]=new Carte("carreau","4"); break;
         case 43: C[i]=new Carte("carreau","5"); break;
         case 44: C[i]=new Carte("carreau","6"); break;
         case 45: C[i]=new Carte("carreau","7"); break;
         case 46: C[i]=new Carte("carreau","8"); break;
         case 47: C[i]=new Carte("carreau","9"); break;
         case 48: C[i]=new Carte("carreau","10"); break;
         case 49: C[i]=new Carte("carreau","J"); break;
         case 50: C[i]=new Carte("carreau","Q"); break;
         case 51: C[i]=new Carte("carreau","K"); break;
         
         }
                   
         }
         
         C[52]=new Carte("","Joker");
         C[53]=new Carte("","Joker");
        
         
         for(int i=54;i<=66;i++)
         {	
         switch(i){
         case 54:  C[i]=new Carte("coeur","AS"); break;
         case 55: C[i]=new Carte("coeur","2"); break;
         case 56: C[i]=new Carte("coeur","3"); break;
         case 57: C[i]=new Carte("coeur","4"); break;
         case 58: C[i]=new Carte("coeur","5"); break;
         case 59: C[i]=new Carte("coeur","6"); break;
         case 60: C[i]=new Carte("coeur","7"); break;
         case 61: C[i]=new Carte("coeur","8"); break;
         case 62: C[i]=new Carte("coeur","9"); break;
         case 63: C[i]=new Carte("coeur","10"); break;
         case 64: C[i]=new Carte("coeur","J"); break;
         case 65: C[i]=new Carte("coeur","Q"); break;
         case 66: C[i]=new Carte("coeur","K"); break;
         
         }      
                 
         }
          
          for(int i=67;i<=79;i++)
          {	
          switch(i){
          case 67:  C[i]=new Carte("trefle","AS"); break;
          case 68: C[i]=new Carte("trefle","2"); break;
          case 69: C[i]=new Carte("trefle","3"); break;
          case 70: C[i]=new Carte("trefle","4"); break;
          case 71: C[i]=new Carte("trefle","5"); break;
          case 72: C[i]=new Carte("trefle","6"); break;
          case 73: C[i]=new Carte("trefle","7"); break;
          case 74: C[i]=new Carte("trefle","8"); break;
          case 75: C[i]=new Carte("trefle","9"); break;
          case 76: C[i]=new Carte("trefle","10"); break;
          case 77: C[i]=new Carte("trefle","J"); break;
          case 78: C[i]=new Carte("trefle","Q"); break;
          case 79: C[i]=new Carte("trefle","K"); break;
          
          }
                           
          }
          
          for(int i=80;i<=92;i++)
          {	
          switch(i){
          case 80:  C[i]=new Carte("pique","AS"); break;
          case 81: C[i]=new Carte("pique","2"); break;
          case 82: C[i]=new Carte("pique","3"); break;
          case 83: C[i]=new Carte("pique","4"); break;
          case 84: C[i]=new Carte("pique","5"); break;
          case 85: C[i]=new Carte("pique","6"); break;
          case 86: C[i]=new Carte("pique","7"); break;
          case 87: C[i]=new Carte("pique","8"); break;
          case 88: C[i]=new Carte("pique","9"); break;
          case 89: C[i]=new Carte("pique","10"); break;
          case 90: C[i]=new Carte("pique","J"); break;
          case 91: C[i]=new Carte("pique","Q"); break;
          case 92: C[i]=new Carte("pique","K"); break;
          
          }
                            
          }
          
          for(int i=93;i<=105;i++)
          {	
          switch(i){
          case 93:  C[i]=new Carte("carreau","AS"); break;
          case 94: C[i]=new Carte("carreau","2"); break;
          case 95: C[i]=new Carte("carreau","3"); break;
          case 96: C[i]=new Carte("carreau","4"); break;
          case 97: C[i]=new Carte("carreau","5"); break;
          case 98: C[i]=new Carte("carreau","6"); break;
          case 99: C[i]=new Carte("carreau","7"); break;
          case 100: C[i]=new Carte("carreau","8"); break;
          case 101: C[i]=new Carte("carreau","9"); break;
          case 102: C[i]=new Carte("carreau","10"); break;
          case 103: C[i]=new Carte("carreau","J"); break;
          case 104: C[i]=new Carte("carreau","Q"); break;
          case 105: C[i]=new Carte("carreau","K"); break;
          
          		}
          }
         
        
          // integration des cartes dans l'arraylist
         for(int i=0;i<=105;i++) // a changer 104 carte + 2jokers
           carte.add(C[i]);
       
        //	System.out.println(C[0].getnumberCarte());
        }
		public Collection<Carte> getCarte() {
			return carte;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Carte> carteIterator() {
			return carte.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isCarteEmpty() {
			return carte.isEmpty();
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
		public boolean containsCarte(Carte carte) {
			return this.carte.contains(carte);
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
		public boolean containsAllCarte(Collection<Carte> carte) {
			return this.carte.containsAll(carte);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int carteSize() {
			return carte.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		//public Carte[] carteToArray() {
			//return carte.toArray(new Carte[carte.size()]);
		//}

		/**
		 * Setter of the property <tt>carte</tt>
		 * 
		 * @param carte
		 *            the carte to set.
		 * 
		 */
		public void setCarte(ArrayList<Carte> carte) {
			this.carte = carte;
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
		public boolean addCarte(Carte carte) {
			return this.carte.add(carte);
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
		public boolean removeCarte(Carte carte) {
			return this.carte.remove(carte);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearCarte() {
			this.carte.clear();
		}
		public ArrayList<Carte> getcarte(){
			return carte;
		}

	}
