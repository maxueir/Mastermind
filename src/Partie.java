import java.io.Serializable;

public class Partie implements Serializable, Comparable{
	boolean difficile;
	int taille;
	
	public Partie() {
		
	}
	

	@Override
	public String toString() {
		return "taille: "+this.taille+" | difficile: "+this.difficile;
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


	@Override
	public int compareTo(Object o) {
		Partie pa=(Partie)o;
		if(pa.difficile==this.difficile && pa.taille==this.taille) {
			return 0;
		}
		return -1;
	}
	@Override
	public boolean equals(Object o) {
		Partie pa=(Partie) o;
		return pa.difficile==this.difficile && pa.taille==this.taille;
	}
}
