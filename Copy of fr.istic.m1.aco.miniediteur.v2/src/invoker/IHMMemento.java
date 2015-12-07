package invoker;

import client.EditeurMemento;
import command.Command;
import command_memento.CommandeEnregistrable;

/**
 * Classe IHM pour la version 2
 * 
 * @author Clément G., Paul C.
 */
public class IHMMemento implements IHMInterface {
	
	public CommandeEnregistrable commandeEnregistrable;
	
	public EditeurMemento editeur;
	
	/**
	 * Constructeur
	 */
	public IHMMemento() {
		this.editeur = new EditeurMemento();
	}
	
	/**
	 * Impression des commandes possibles
	 */
	public void menu(){
		System.out.println("Sélectionner l'action désirée : ");
		System.out.println(" - Saisir (W)");
		System.out.println(" - Copier (C)");
		System.out.println(" - Coller (P)");
		System.out.println(" - Couper (X)");
		System.out.println(" - Sélectionner (S)");
		System.out.println(" - Démarrer Enregistrement (D)");
		System.out.println(" - Arrêter Enregistrement (A)");
		System.out.println(" - Rejouer (R)");
		System.out.println(" - Quitter (Q) ");		
	}
	
	/**
	 * Retourne le texte saisi
	 * @return StringBuffer
	 */
	public StringBuffer getTexte(){
		StringBuffer texte = editeur.getTexte();
		return texte;		
	}
	
	/**
	 * Retourne le début de la sélection saisi
	 * @return Integer
	 */
	public int getDebut(){
		return editeur.getDebut();
	}
	
	/**
	 * Retourne la longueur de la sélection saisie
	 * @return Integer
	 */
	public int getLongueur(){
		return editeur.getLongueur();
	}	
}
