package memento;

/**
 * Memento Saisir
 * 
 * @author Clément G., Paul C.
 */
public class MementoSaisir implements Memento {

	private StringBuffer texte;
	
	/**
	 * Constructeur
	 * @param texte
	 */
	public MementoSaisir(StringBuffer texte) {
		this.texte = texte;
	}

	/**
	 * Retourne le texte enregistré
	 * @return StringBuffer
	 */
	public StringBuffer getTexte() {
		return texte;
	}

	/**
	 * Met à jour le texte enregistré
	 * @param texte
	 */
	public void setTexte(StringBuffer texte) {
		this.texte = texte;
	}
}
