package client;

import java.util.Scanner;

import command.*;
import command_memento.*;
import invoker.IHMMemento;
import memento.Enregistreur;
import receiver.*;

/**
 * Classe EditeurMemento <br>
 * C'est le main de la version 2 <br>
 * Elle permet de lancer le programme
 * 
 * @author Clément G., Paul C.
 *
 */
public class EditeurMemento {
	
	public MoteurEditionInterface moteurEditionInterface;
	
	public IHMMemento ihm;
	
	public Enregistreur enregistreur;
	

	public EditeurMemento() {
		super();
	}
	
	
	/**
	 * Demande le texte à saisir et le retourne
	 * 
	 * @return StringBuffer
	 */
	public StringBuffer getTexte(){
		StringBuffer texte = new StringBuffer();		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez quelque chose : ");
		return texte.append(sc.nextLine());
	}
	
	
	/**
	 * Demande le numero du caractère de debut de sélection et le retourne
	 * 
	 * @return int
	 */
	public int getDebut(){
		Scanner sc = new Scanner(System.in);
		boolean isInteger = false;
		
		while(!isInteger) {
			System.out.println("Entrez le numero du 1er caractere de la sélection : ");
			if(sc.hasNextInt()) {
				isInteger = true;
			}
			else {
				isInteger = false;
				System.err.println("Erreur, veuillez rentrer un nombre");
				sc.nextLine();
			}
		}
		
		return sc.nextInt();
	}
	
	/**
	 * Demande le nombre de caractères à sélectionner et le retourne
	 * 
	 * @return int
	 */
	public int getLongueur(){
		Scanner sc = new Scanner(System.in);
		boolean isInteger = false;
		
		while(!isInteger) {
			System.out.println("Entrez le nombre de caractere à sélectionner : ");
			if(sc.hasNextInt()) {
				isInteger = true;
			}
			else {
				isInteger = false;
				System.err.println("Erreur, veuillez rentrer un nombre");
				sc.nextLine();
			}
		}
		
		return sc.nextInt();
	}
	
	/**
	 * La fonction main de la version 2 <br>
	 * Lance le programme
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		// Initialisation
		IHMMemento ihm = new IHMMemento();	
		MoteurEdition moteur = new MoteurEdition();
		Enregistreur enregistreur = new Enregistreur();
		Scanner sc = new Scanner(System.in);
		String choix;
		
		do {
			
			// Menu
			System.out.println("\nVotre texte : " + moteur.getSelection());
			ihm.menu();
			
			// En attente du choix
			choix = sc.nextLine();
			Command cmd = null;
			
			System.out.println(choix);
			
			// Saisir
			if (choix.equalsIgnoreCase("w")) {
				cmd = new SaisirEnregistrable(moteur, ihm, enregistreur);
				cmd.execute();
				
			// Copier
			} else if (choix.equalsIgnoreCase("c")) {
				cmd = new CopierEnregistrable(moteur, enregistreur);
				cmd.execute();
				
			// Coller
			} else if (choix.equalsIgnoreCase("p")) {
				cmd = new CollerEnregistrable(moteur, enregistreur);
				cmd.execute();
				
			// Couper
			} else if (choix.equalsIgnoreCase("x")) {
				cmd = new CouperEnregistrable(moteur, enregistreur);	
				cmd.execute();
				
			// Sélectionner
			} else if (choix.equalsIgnoreCase("s")) {
				cmd = new SelectionnerEnregistrable(moteur, ihm, enregistreur);
				cmd.execute();
			
			// Démarrer Enregistrement
			} else if (choix.equalsIgnoreCase("d")) {
				System.out.println("Démarrage de l'enregistrement \n");
				enregistreur.demarrer();
				
			// Arrêter Enregistrement
			} else if (choix.equalsIgnoreCase("a")) {
				if(!enregistreur.isEnregistrement()) {
					System.err.print("\nL'enregistrement n'avait pas été démarré\n");
				}
				else {
					System.out.println("Arrêt de l'enregistrement \n");
					enregistreur.arreter();
				}
			
			// Rejouer
			} else if (choix.equalsIgnoreCase("r")) {
				if(enregistreur.isEnregistrement()) {
					System.err.print("\nL'enregistrement doit être arreté avant d'être rejoué\n");
				}
				else {
					System.out.println("Les commandes vont être rejouées \n");
					enregistreur.rejouer();
				}
			}
			
		// Quitte quand on écrit q
		} while (!choix.equalsIgnoreCase("q"));
		
	}
}
