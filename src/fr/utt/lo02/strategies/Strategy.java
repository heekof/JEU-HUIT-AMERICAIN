package fr.utt.lo02.strategies;
import fr.utt.lo02.exception.mainVideException;

import fr.utt.lo02.exception.nbPointsException;
import fr.utt.lo02.exception.nbToursException;
import fr.utt.lo02.exception.talonVideException;
import fr.utt.lo02.jeu.Croupier;

import fr.utt.lo02.jeu.Pile;
import fr.utt.lo02.jeu.Talon;
import fr.utt.lo02.jeu.Virtuel;

/**
 * Notre interface strategy qui est implementé par strategieAvancée et strategieStandard
 * @author DANG-BENDRISS
 *
 */
public interface Strategy {
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
	public boolean joue(Pile P,Talon T,Croupier C,Virtuel V)  throws talonVideException,mainVideException, nbPointsException, nbToursException ;
}
