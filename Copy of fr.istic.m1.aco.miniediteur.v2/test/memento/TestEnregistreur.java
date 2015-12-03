package memento;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import command_memento.CollerEnregistrable;
import command_memento.CommandeEnregistrable;
import command_memento.CopierEnregistrable;
import command_memento.SaisirEnregistrable;
import invoker_memento.IHMMemento;
import junit.framework.TestCase;
import receiver.Buffer;
import receiver.MoteurEdition;
import receiver.MoteurEditionInterface;
import receiver.PressePapier;
import receiver.Selection;

public class TestEnregistreur extends TestCase {

	/**
	 * --- Demarrer ---
	 */
	// Test si le booléen est bien mis a true
	public void testDemarrer() {
		Enregistreur enregistreur = new Enregistreur();

		enregistreur.demarrer();

		assertTrue(enregistreur.isEnregistrement());
	}

	// Test si la liste de commande est bien réinitialisée
	public void testDemarrer2() {
		Enregistreur enregistreur = new Enregistreur();
		MoteurEdition moteurEdition = new MoteurEdition();

		List<CommandeEnregistrable> listeCommandes = new ArrayList<CommandeEnregistrable>();
		listeCommandes.add(new CopierEnregistrable(moteurEdition, enregistreur));
		enregistreur.setListeCommandes(listeCommandes);

		enregistreur.demarrer();

		assertTrue(enregistreur.getListeCommandes().isEmpty());
	}

	/**
	 * --- Enregistrer ---
	 */

	// Test si les commandes sont bien ajouter
	public void testEnregistrer1() {
		Enregistreur enregistreur = new Enregistreur();
		MoteurEdition moteurEdition = new MoteurEdition();

		enregistreur.setEnregistrement(true);
		CommandeEnregistrable copieEnregistrable = new CopierEnregistrable(moteurEdition, enregistreur);
		enregistreur.enregistrer(copieEnregistrable);

		assertTrue(!enregistreur.getListeCommandes().isEmpty());
		assertEquals(copieEnregistrable, enregistreur.getListeCommandes().get(0));
	}

	//Test le memento d'une commande enregistrable
	public void testEnregister2(){
		Enregistreur enregistreur = new Enregistreur();
		MoteurEditionInterface moteurEdition = new MoteurEdition();
		IHMMemento ihmMemento = new IHMMemento();
		StringBuffer texte = new StringBuffer("Bonjour");

		//TODO Voir comment initialiser la variable texte au mementoSaisir
		
		enregistreur.setEnregistrement(true);
		CommandeEnregistrable saisirEnregistrable = new SaisirEnregistrable(moteurEdition, ihmMemento, enregistreur);
		enregistreur.enregistrer(saisirEnregistrable);
		
		MementoSaisir mTestSaisir = (MementoSaisir) enregistreur.getListeCommandes().get(0).getMemento();
		
		assertEquals(texte, mTestSaisir.getTexte());
	}

	/**
	 * --- Arreter ---
	 */

	// Test si l'arret de l'enregistrement est bien pris en compte
	public void testArreter1() {
		Enregistreur enregistreur =  new Enregistreur();

		enregistreur.setEnregistrement(true);

		enregistreur.arreter();

		assertTrue(!enregistreur.isEnregistrement());
	}

	// Test si l'enregistrement est bien arreté et ne prend pas de commande en plus
	public void testArreter2(){
		Enregistreur enregistreur = new Enregistreur();

		enregistreur.setEnregistrement(true);

		enregistreur.arreter();

		MoteurEdition moteurEdition = new MoteurEdition();
		CommandeEnregistrable copieEnregistrable = new CopierEnregistrable(moteurEdition, enregistreur);
		enregistreur.enregistrer(copieEnregistrable);

		assertTrue(enregistreur.getListeCommandes().isEmpty());		
	}
	
	/**
	 * Rejouer
	 */
	
	// Test si rejouer coller fonctionne
	public void testRejouer1(){
		
		// Valeur a comparer
		String texte = "Bonjour";
		
		// Démarre un enregistrement
		Enregistreur enregistreur = new Enregistreur();
		enregistreur.setEnregistrement(true);
		
		// Initialise le moteur dans le cas d'une copie
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.pressePapier.setContenu(texte);
	
		// Rajoute la commande coller à l'enregistreur
		CommandeEnregistrable collerEnregistrable = new CollerEnregistrable(moteurEdition, enregistreur);
		List<CommandeEnregistrable> listeCommandes =  new ArrayList<CommandeEnregistrable>();
		listeCommandes.add(collerEnregistrable);
		enregistreur.setListeCommandes(listeCommandes);
		
		// On arrete l'enregistrement
		enregistreur.setEnregistrement(false);
		
		// Lance la commande à tester
		enregistreur.rejouer();
		assertEquals(texte, moteurEdition.buffer.getContenu().toString());
	}
	
	// Test si rejouer saisir fonctionne
	public void testRejouer2(){
		
		// Valeur a comparer
		String texte = "Bonjour";
		
		// Démarre un enregistrement
		Enregistreur enregistreur = new Enregistreur();
		enregistreur.setEnregistrement(true);
		
		// Initialise le moteur dans le cas d'une copie
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.buffer.setContenu(new StringBuffer(texte));
		IHMMemento ihmMemento = new IHMMemento();
	
		// Rajoute la commande coller à l'enregistreur
		// TODO Voir comment rajouter un texte au mementoSaisir
		CommandeEnregistrable saisirEnregistrable = new SaisirEnregistrable(moteurEdition, ihmMemento, enregistreur);
		List<CommandeEnregistrable> listeCommandes =  new ArrayList<CommandeEnregistrable>();
		listeCommandes.add(saisirEnregistrable);
		enregistreur.setListeCommandes(listeCommandes);
		
		// On arrete l'enregistrement
		enregistreur.setEnregistrement(false);
		
		// Lance la commande à tester
		enregistreur.rejouer();
		assertEquals(texte + texte, moteurEdition.buffer.getContenu().toString());
	}
}	