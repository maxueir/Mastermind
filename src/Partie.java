import java.io.Serializable;

public class Partie implements Serializable{
	boolean difficile;
	int taille;
	
	public Partie() {
		
	}
	
	public Partie(boolean b, int a ) {
		this.difficile=b;
		this.taille=a;
	}
	public boolean isDifficile() {
		return difficile;
	}
	public void setDifficile(boolean difficile) {
		this.difficile = difficile;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
}
