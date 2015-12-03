package memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.Command;
import command_memento.CommandeEnregistrable;

/**
 * Cette classe permet d'enrgistrer des commandes et de les rejouer
 * 
 * @author Clément G., Paul C.
 */
public class Enregistreur {
	
	private boolean enregistrement;
	private List<CommandeEnregistrable> listeCommandes;
	
	/**
	 * Constructeur
	 */
	public Enregistreur() {
		this.enregistrement = false;
		this.listeCommandes = new ArrayList<CommandeEnregistrable>();
	}
	
	/**
	 * Vérifie s'il y a un enregistrement en cours
	 * @return Boolean
	 */
	public boolean isEnregistrement() {
		return enregistrement;
	}

	/**
	 * Met à jour l'état de l'enregistrement
	 * @param enregistrement
	 */
	public void setEnregistrement(boolean enregistrement) {
		this.enregistrement = enregistrement;
	}
	
	/**
	 * Retourne la liste des commandes enregistrées
	 * @return List
	 */
	public List<CommandeEnregistrable> getListeCommandes() {
		return listeCommandes;
	}

	/**
	 * Met à jour la liste des commandes enregistrées
	 * @param listeCommandes
	 */
	public void setListeCommandes(List<CommandeEnregistrable> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	/**
	 * Vide la liste des commandes enregistrées
	 * Démarre l'enregistrement
	 */
	public void demarrer() {
		listeCommandes.clear();
		this.enregistrement = true;
	}
	
	/**
	 * Arrête l'enregistrement
	 */
	public void arreter() {
		this.enregistrement = false;
	}
	
	/**
	 * Ajoute une commande à la liste des commandes enregistrées
	 * @param c
	 */
	public void enregistrer(CommandeEnregistrable c) {
		if(this.enregistrement) {
			listeCommandes.add(c);
		}
	}
	
	/**
	 * Rejoue les commandes qui sont dans la liste des commandes enregistrées
	 */
	public void rejouer() {
		if(!this.enregistrement) {
			for(CommandeEnregistrable c : listeCommandes) {
				c.rejouerCommande();
			}			
		}
	}

}
