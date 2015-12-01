package command_memento;

import command.Selectionner;
import invoker.IHMInterface;
import memento.Enregistreur;
import memento.Memento;
import memento.MementoSelection;
import receiver.MoteurEditionInterface;

/**
 * Version enregistrable de la commande S�lectionner
 * 
 * @author Cl�ment G., Paul C.
 */
public class SelectionnerEnregistrable extends Selectionner implements CommandeEnregistrable {
	
	private Enregistreur enregistreur;
	
	private MementoSelection m;

	/**
	 * Constructeur
	 * @param moteur
	 * @param ihm
	 * @param enregistreur
	 */
	public SelectionnerEnregistrable(MoteurEditionInterface moteur, IHMInterface ihm, Enregistreur enregistreur) {
		super(moteur, ihm);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Récupére le début et la longueur de la sélection saisi dans l'ihm
	 * Crée le memento avec ces paramètres
	 * Enregistre la commande
	 * Exécute la commande avec les paramétres récupérés
	 */
	@Override
	public void execute() {
		int debut = this.ihm.getDebut();
		int longueur = this.ihm.getLongueur();	
		
		this.m = new MementoSelection(debut, longueur);
		this.enregistreur.enregistrer(this);	
		this.moteurEditionInterface.selectionner(debut, longueur);
	}
	
	/**
	 * @return memento
	 */
	public MementoSelection getMemento() {
		return this.m;
	}

	/**
	 * Récupère la longueur du buffer avant de rejouer pour décaler la sélection
	 * Exécute la commande avec les paramètres enregistrés dans le memento et le décalage
	 */
	public void rejouerCommande() {
		this.moteurEditionInterface.selectionner(this.getMemento().getDebut(), this.getMemento().getLongueur());
	}
}
