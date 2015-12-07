package command_memento;

import command.Command;
import memento.Enregistreur;

/**
 * Commande permettant de rejouer les commandes enregistrées
 * 
 * @author Clément G., Paul C.
 */
public class Rejouer implements Command {
	
	private Enregistreur enregistreur;
	
	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public Rejouer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		this.enregistreur.rejouer();
	}	

}
