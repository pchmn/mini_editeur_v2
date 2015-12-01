package command_memento;

import command.Command;
import memento.Enregistreur;

/**
 * Commande permettant d'arrêter l'enregistrement
 * 
 * @author Clément G., Paul C.
 */
public class ArreterEnregistrement implements Command {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public ArreterEnregistrement(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		this.enregistreur.arreter();
	}

}
