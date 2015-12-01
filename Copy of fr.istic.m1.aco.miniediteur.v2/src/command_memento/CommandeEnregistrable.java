package command_memento;

import memento.Enregistreur;
import memento.Memento;

/**
 * Interface pour les commandes enregistrables
 * 
 * @author Clément G., Paul C.
 */
public interface CommandeEnregistrable {
	
	public void execute();
	
	public Memento getMemento();
	
	public void rejouerCommande();
}
