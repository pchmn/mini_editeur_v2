package command_memento;

import command.Copier;
import memento.Enregistreur;
import memento.Memento;
import memento.MementoCopier;
import receiver.MoteurEditionInterface;

/**
 * Version enregistrable de la commande Copier
 * 
 * @author Clément G., Paul C.
 */
public class CopierEnregistrable extends Copier implements CommandeEnregistrable  {
	
	private Enregistreur enregistreur;
	
	private Memento m;

	/**
	 * Constructeur
	 * @param moteurEditionInterface
	 * @param enregistreur
	 */
	public CopierEnregistrable(MoteurEditionInterface moteurEditionInterface, Enregistreur enregistreur) {
		super(moteurEditionInterface);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Crée le memento <br>
	 * Enregistre la commande <br>
	 * Exécute la commande
	 */
	@Override
	public void execute() {
		this.m = new MementoCopier();
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
