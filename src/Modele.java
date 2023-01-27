import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.UnsupportedLookAndFeelException;

public class Modele extends Observable {
	static Color[] Couleurs = {Color.BLUE,Color.YELLOW,Color.GREEN,Color.MAGENTA,Color.RED,Color.ORANGE,Color.WHITE,Color.BLACK};
	int nb_tentatives=5;
	int DIFFICULTE=4;
	Boolean difficile;
	static enum Etat {EN_COURS,GAGNE,PERDU};
	Vue v;
	Controleur ctrl;
	Etat etat;
	Rangee combinaison;
	ArrayList<Rangee> propositions;
	int tentative;
	
	public Modele() throws UnsupportedLookAndFeelException {
		ctrl =new Controleur(this);
		v= new Vue(this,ctrl);
		this.difficile=true;
		
		Random r = new Random();
		Color[] c = new Color[DIFFICULTE];
		for(int i=0;i<DIFFICULTE;i++) {
			c[i]=(Couleurs[r.nextInt(8)]);
		}
		this.etat=Etat.EN_COURS;
		this.combinaison= new Rangee(this,c);
		propositions= new ArrayList<Rangee>();
		propositions.add(new Rangee(this));
		tentative=0;
	}
	public void rejouer() {
		Random r = new Random();
		Color[] c = new Color[DIFFICULTE];
		for(int i=0;i<DIFFICULTE;i++) {
			c[i]=(Couleurs[r.nextInt(8)]);
		}
		this.combinaison= new Rangee(this,c);
		this.etat=Etat.EN_COURS;
		propositions= new ArrayList<Rangee>();
		propositions.add(new Rangee(this));
		tentative=0;
		this.v.nord.removeAll();
		this.v.nord.setLayout(new BorderLayout());
		this.v.nord.add(this.v.nvlle,BorderLayout.WEST);
		this.v.Clavier.boutons();
		this.v.frame.pack();
		this.v.frame.setVisible(true);
	}
	public void actualiser() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		Modele m = new Modele();
		
		
	}

	
	
	

}
