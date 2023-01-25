import java.awt.Color;
import java.util.ArrayList;

public class Rangee {
	ArrayList<Color> jetons;//combinaison en cours
	private int indiceJeton;// indice du jeton en cours de choix
	ArrayList<Color> resultat;// combinaison du resultat associe a la combinaison
	boolean complete;// booleen de etat de completion de la rangee
	private Modele modele;
	
	public Rangee(Modele m, Color[] c) {
		jetons = new ArrayList<Color>();
		for(int i=0;i<c.length;i++) {
			jetons.add(c[i]);
		}
		this.modele=m;
		indiceJeton=1 ;
		resultat= new ArrayList<Color>();
		complete=false;
	}
	
	public Rangee(Modele m) {
		jetons = new ArrayList<Color>();
		indiceJeton=0;
		resultat= new ArrayList<Color>();
		complete=false;
		this.modele=m;
		
	}
	
	public void evaluer() {
		
		
		if(indiceJeton==modele.DIFFICULTE) {
			ArrayList<Boolean> val=new ArrayList<Boolean>();
			for(int i=0;i<modele.DIFFICULTE;i++) {
				val.add(true);
			}
			
			this.complete=true;
			this.modele.tentative++;
			if(this.modele.tentative==modele.nb_tentatives) {
				this.modele.etat=Modele.Etat.PERDU;
			}
			
			for(int i=0;i<modele.DIFFICULTE;i++) {
				if(jetons.get(i).equals(modele.combinaison.obtenir(i))) {
					this.resultat.add(Color.BLACK);
					val.set(i, false);
				}
			}
			
			for(int i=0;i<modele.DIFFICULTE;i++) {
				if(!jetons.get(i).equals(modele.combinaison.obtenir(i))) {
					for(int j=0;j<modele.DIFFICULTE;j++) {
						if(j!=i) {
							if(jetons.get(i).equals(modele.combinaison.obtenir(j)) && val.get(j)==true) {
								val.set(j, false);
								this.resultat.add(Color.WHITE);
								
							}
						}
					}
				}
			}
			boolean b=true;
			for(int i=0;i<resultat.size();i++) {
				if(resultat.get(i).equals(Color.WHITE)) {
					b=false;
				}
			}
			if(b && resultat.size()==modele.DIFFICULTE) {
				modele.etat=Modele.Etat.GAGNE;
			}
		}
	}
	
	public void ajouter(Color c) {
		jetons.add(c);
		this.indiceJeton++;
		
		this.evaluer();
	}
	
	public Color obtenir(int i) {
		return jetons.get(i);
	}
	@Override
	public String toString() {
		String ret="";
		for(int i=0;i<jetons.size();i++) {
			ret=ret+jetons.get(i).toString();
		}
		return ret;
	}
}
