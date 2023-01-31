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
	public void evaluerfacile() {
		if(indiceJeton==modele.DIFFICULTE) {
			this.complete=true;
			this.modele.tentative++;
			if(this.modele.tentative==modele.nb_tentatives) {
				this.modele.etat=Modele.Etat.PERDU;
			}

			ArrayList<Boolean> val=new ArrayList<Boolean>();
			for(int i=0;i<modele.DIFFICULTE;i++) {
				val.add(true);//tableau de la solution
				this.resultat.add(null);
			}

			for(int i=0;i<this.modele.DIFFICULTE;i++) {
				if(jetons.get(i).equals(modele.combinaison.obtenir(i))) {
					this.resultat.set(i,Color.BLACK);
					
					val.set(i, false);
					System.out.println(i);
				}
			}
			System.out.println(this.resultat);

			for(int i=0;i<this.modele.DIFFICULTE;i++) {//boucle pour la proposition



				int j=0;
				Boolean b=true;
				while (j<this.modele.DIFFICULTE && b) {
					if(i==3) {
						System.out.println(jetons.get(i).equals(modele.combinaison.obtenir(j)));
						System.out.println(j);
						System.out.println(val.get(j));
						System.out.println(val);
					}
					if(this.resultat.get(i)==null && jetons.get(i).equals(modele.combinaison.obtenir(j)) && val.get(j)) {
						b=false;
						val.set(j, false);
						this.resultat.set(i,Color.WHITE);
						System.out.println("i:"+i+"j:"+j);
					}
					j++;
				}


			}
			Boolean gagne=true;
			for(int i=0;i<resultat.size();i++) {
				if(resultat.get(i)!=Color.BLACK) {
					gagne=false;
				}
			}
			if(gagne && resultat.size()==modele.combinaison.jetons.size()) {
				this.modele.etat=Modele.Etat.GAGNE;
			}

		}


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

			for(int i=0;i<modele.DIFFICULTE;i++) {//iterateur de la proposition
				if(!jetons.get(i).equals(modele.combinaison.obtenir(i))) {
					int j=0;
					boolean b=true;
					while(j<modele.DIFFICULTE && b) {//iterateur de la solution
						if(j!=i) {
							if(jetons.get(i).equals(modele.combinaison.obtenir(j)) && val.get(j)==true) {
								val.set(j, false);
								this.resultat.add(Color.WHITE);

								b=false;
							}
						}
						j++;
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
		if(this.modele.difficile) {
			this.evaluer();
		}
		else {
			this.evaluerfacile();
		}
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
