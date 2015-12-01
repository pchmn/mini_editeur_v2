package command_memento;

import command.Command;
import memento.Enregistreur;

/**
 * Commande permettant de démarrer l'enregistrement
 * 
 * @author Clément G., Paul C.
 */
public class DemarrerEnregistrement implements Command {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public DemarrerEnregistrement(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		this.enregistreur.demarrer();
	}

}
