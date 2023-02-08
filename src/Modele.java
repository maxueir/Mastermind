import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.UnsupportedLookAndFeelException;

//avis:
	//jeu fonctionnel avec qq petits beugs (point turquoise)
	//33je remercie quand meme le developpeur que j'aime de tous mon coeurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr<3'
	
public class Modele extends Observable implements Serializable{
	static Color[] Couleurs = {Color.BLUE,Color.YELLOW,Color.GREEN,Color.MAGENTA,Color.RED,Color.ORANGE,Color.WHITE,Color.BLACK};
	int nb_tentatives=10;
	int DIFFICULTE=4;
	Boolean difficile;
	static enum Etat {EN_COURS,GAGNE,PERDU};
	Vue v;
	Controleur ctrl;
	Etat etat;
	Rangee combinaison;
	ArrayList<Rangee> propositions;
	int tentative;
	Map<Partie,Score> scores;
	File fichier;
	Partie p;
	
	public Modele() throws UnsupportedLookAndFeelException {
		this.difficile=false;
		p=new Partie(difficile,DIFFICULTE);
		XMLDecoder decoder=null;
		fichier = new File("scores.xml");
		try {
			FileInputStream fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			
			this.scores= (Map<Partie,Score>) decoder.readObject();
		} catch(Exception e) {
			System.out.println("hey");
			scores= new HashMap<Partie,Score>();
			//System.out.println("Erreur lors de la lecture des donnees");
			//throw new RuntimeException("Erreur lors de la lecture des donnees");
		}finally {
			if(decoder != null)decoder.close();
		}
		System.out.println(scores);
		
		
		
		Random r = new Random();
		Color[] c = new Color[DIFFICULTE];
		for(int i=0;i<DIFFICULTE;i++) {
			//c[i]=(Couleurs[(i%2) +2]);
			c[i]=(Couleurs[r.nextInt(8)]);
		}
		/*c[0]=Color.ORANGE;
		c[1]=Color.GREEN;
		c[2]=Color.BLUE;
		c[3]=Color.YELLOW;*/
		this.etat=Etat.EN_COURS;
		this.combinaison= new Rangee(this,c);
		propositions= new ArrayList<Rangee>();
		propositions.add(new Rangee(this));
		tentative=0;
	}
	public void rejouer() {
		p=new Partie(difficile,DIFFICULTE);
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
		this.v.actualisernord();
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
		m.ctrl =new Controleur(m);
		m.v= new Vue(m,m.ctrl);
		
		
	}
	public static Color[] getCouleurs() {
		return Couleurs;
	}
	public static void setCouleurs(Color[] couleurs) {
		Couleurs = couleurs;
	}
	public int getNb_tentatives() {
		return nb_tentatives;
	}
	public void setNb_tentatives(int nb_tentatives) {
		this.nb_tentatives = nb_tentatives;
	}
	public int getDIFFICULTE() {
		return DIFFICULTE;
	}
	public void setDIFFICULTE(int dIFFICULTE) {
		DIFFICULTE = dIFFICULTE;
	}
	public Boolean getDifficile() {
		return difficile;
	}
	public void setDifficile(Boolean difficile) {
		this.difficile = difficile;
	}
	public Vue getV() {
		return v;
	}
	public void setV(Vue v) {
		this.v = v;
	}
	public Controleur getCtrl() {
		return ctrl;
	}
	public void setCtrl(Controleur ctrl) {
		this.ctrl = ctrl;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Rangee getCombinaison() {
		return combinaison;
	}
	public void setCombinaison(Rangee combinaison) {
		this.combinaison = combinaison;
	}
	public ArrayList<Rangee> getPropositions() {
		return propositions;
	}
	public void setPropositions(ArrayList<Rangee> propositions) {
		this.propositions = propositions;
	}
	public int getTentative() {
		return tentative;
	}
	public void setTentative(int tentative) {
		this.tentative = tentative;
	}
	public Map<Partie, Score> getMeilleurs() {
		return scores;
	}
	public void setMeilleurs(Map<Partie, Score> meilleurs) {
		this.scores = meilleurs;
	}
	public Map<Partie, Score> getScores() {
		return scores;
	}
	public void setScores(Map<Partie, Score> scores) {
		this.scores = scores;
	}
	public File getFichier() {
		return fichier;
	}
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	public Partie getP() {
		return p;
	}
	public void setP(Partie p) {
		this.p = p;
	}

	
	
	

}
