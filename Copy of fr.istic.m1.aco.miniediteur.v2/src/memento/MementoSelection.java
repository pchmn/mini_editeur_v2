package memento;

/**
 * Memento Selection
 * 
 * @author Clément G., Paul C.
 */
public class MementoSelection implements Memento{

	private int debut;
	
	private int longueur;	
	
	/**
	 * Constructeur
	 * @param debut
	 * @param longueur
	 */
	public MementoSelection(int debut, int longueur) {
		this.debut = debut;
		this.longueur = longueur;
	}

	/**
	 * Retourne le début de la sélection enregistrée
	 * @return Integer
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * Met à jour le début de la sélection enregistrée
	 * @param debut
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * Retourne la longueur de la sélection enregistrée
	 * @return Integer
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * Met à jour la longueur de la sélection enregistrée
	 * @param longueur
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
}
