package command_memento;

import command.Coller;
import memento.Enregistreur;
import memento.Memento;
import memento.MementoColler;
import receiver.MoteurEditionInterface;

/**
 * Version enregistrable de la commande Coller
 * 
 * @author Clément G., Paul C.
 */
public class CollerEnregistrable extends Coller implements CommandeEnregistrable {
	
	private Enregistreur enregistreur;
	
	private Memento m;

	/**
	 * Constructeur
	 * @param moteurEditionInterface
	 * @param enregistreur
	 */
	public CollerEnregistrable(MoteurEditionInterface moteurEditionInterface, Enregistreur enregistreur) {
		super(moteurEditionInterface);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Crée le memento
	 * Enregistre la commande
	 * Exécute la commande
	 */
	@Override
	public void execute() {
		this.m = new MementoColler();
		this.enregistreur.enregistrer(this);
		super.execute();
	}
	
	/**
	 * @return memento
	 */
	public Memento getMemento() {
		return this.m;
	}
	
	/**
	 * Exécute la commande lorsque la macro est rejouée
	 */
	public void rejouerCommande() {
		super.execute();
	}
	
}
