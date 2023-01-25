import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Controleur implements ActionListener{
	
	Modele m;
	
	public Controleur(Modele m) {
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String couleur=e.toString().split(" ")[e.toString().split(" ").length -1];
		if(couleur.equals("jaune")) {
			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.YELLOW};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.YELLOW);
			}
		}
		else if(couleur.equals("vert")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.GREEN};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.GREEN);
			}
		}
		else if(couleur.equals("bleu")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.BLUE};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.BLUE);
			}
		}
		else if(couleur.equals("magenta")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.MAGENTA};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.MAGENTA);
			}
		}
		else if(couleur.equals("rouge")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.RED};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.RED);
			}
		}
		else if(couleur.equals("orange")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.ORANGE};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.ORANGE);
			}
		}
		else if(couleur.equals("blanc")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.WHITE};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.WHITE);
			}
		}
		else if(couleur.equals("noir")) {

			if(this.m.propositions.get(this.m.propositions.size()-1).complete) {
				Color[] co= {Color.BLACK};
				this.m.propositions.add(new Rangee(m,co));
			}
			else {
				this.m.propositions.get(this.m.propositions.size()-1).ajouter(Color.BLACK);
			}
		}
		this.m.actualiser();
	}


}
