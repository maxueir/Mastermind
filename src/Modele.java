import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Modele extends Observable {
	static Color[] Couleurs = {Color.BLUE,Color.YELLOW,Color.GREEN,Color.MAGENTA,Color.RED,Color.ORANGE,Color.WHITE,Color.BLACK};
	static int nb_tentatives=10;
	static int DIFFICULTE=4;
	static enum Etat {EN_COURS,GAGNE,PERDU};
	Vue v;
	Controleur ctrl;
	Etat etat;
	Rangee combinaison;
	ArrayList<Rangee> propositions;
	int tentative;
	
	public Modele() {
		ctrl =new Controleur(this);
		v= new Vue(this,ctrl);
		
		Random r = new Random();
		Color[] c = new Color[DIFFICULTE];
		for(int i=0;i<DIFFICULTE;i++) {
			c[i]=(Couleurs[i%2]);
		}
		this.etat=Etat.EN_COURS;
		this.combinaison= new Rangee(this,c);
		propositions= new ArrayList<Rangee>();
		Color[] co= {};
		propositions.add(new Rangee(this));
		tentative=0;
	}
	public void actualiser() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public static void main(String[] args) {
		Modele m = new Modele();
		
		
	}

	
	
	

}
