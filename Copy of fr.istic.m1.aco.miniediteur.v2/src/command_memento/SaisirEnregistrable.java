package command_memento;

import command.Saisir;
import invoker.IHMInterface;
import memento.Enregistreur;
import memento.Memento;
import memento.MementoSaisir;
import memento.MementoSelection;
import receiver.MoteurEditionInterface;

/**
 * Version enregistrable de la commande Saisir
 * 
 * @author Clément G., Paul C.
 */
public class SaisirEnregistrable extends Saisir implements CommandeEnregistrable {
	
	private Enregistreur enregisteur;
	
	private MementoSaisir m;

	/**
	 * Constructeur
	 * @param moteurEdition
	 * @param iHM
	 * @param enregistreur
	 */
	public SaisirEnregistrable(MoteurEditionInterface moteurEdition, IHMInterface iHM, Enregistreur enregistreur) {
		super(moteurEdition, iHM);
		this.enregisteur = enregistreur;
	}
	
	/**
	 * Récupère le texte saisi dans l'ihm <br>
	 * Crée le memento avec ce texte <br>
	 * Enregistre la commande <br>
	 * Exécute la commande avec le texte récupéré
	 */
	@Override
	public void execute() {
		StringBuffer texte = this.ihm.getTexte();
		
		this.m = new MementoSaisir(texte);
		this.enregisteur.enregistrer(this);		
		this.moteurEditionInterface.saisir(texte);
	}
	
	/**
	 * @return memento
	 */
	public MementoSaisir getMemento() {
		return this.m;
	}
	
	/**
	 * Exécute la commande lorsque la macro est rejouée 
	 * en utilisant le texte enregistré dans le memento
	 */
	public void rejouerCommande() {	
		this.moteurEditionInterface.saisir(this.getMemento().getTexte());
	}

}
