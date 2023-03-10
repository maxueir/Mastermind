import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class VuePropositions extends Canvas{
	Vue v;

	public VuePropositions(Vue v) {
		this.v=v;
		this.setSize(10+(this.v.diametreproposition+this.v.diametreproposition/2+this.v.diametreresultat+this.v.diametreresultat/2)*this.v.m.DIFFICULTE,10+(this.v.diametreproposition+this.v.diametreproposition/2)*(this.v.m.nb_tentatives+1));
		this.setVisible(true);
	}
	public void actualiser() {
		this.setSize(10+(this.v.diametreproposition+this.v.diametreproposition/2+this.v.diametreresultat+this.v.diametreresultat/2)*this.v.m.DIFFICULTE,10+(this.v.diametreproposition+this.v.diametreproposition/2)*(this.v.m.nb_tentatives+1));

	}
	public VuePropositions() {
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		for(int i=0;i<this.v.m.propositions.size();i++) {
			for (int j=0;j<this.v.m.propositions.get(i).jetons.size();j++) {
					g.setColor(this.v.m.propositions.get(i).jetons.get(j));
					g.fillOval(5+j*30, 5+i*30, 20, 20);
				

			}
		}
		for(int i=0;i<this.v.m.propositions.size();i++) {
			if(this.v.m.propositions.get(i).complete) {
				for (int j=0;j<this.v.m.propositions.get(i).resultat.size();j++) {
					if(this.v.m.propositions.get(i).resultat.get(j)!=null) {
						g.setColor(this.v.m.propositions.get(i).resultat.get(j));
						g.fillOval(5+this.v.m.DIFFICULTE*(this.v.diametreproposition+this.v.diametreproposition/2)+j*15, 5+i*30, 10, 10);

					}
					else {
						g.setColor(Color.BLACK);
						g.drawOval(5+this.v.m.DIFFICULTE*(this.v.diametreproposition+this.v.diametreproposition/2)+j*15, 5+i*30, 10, 10);
					}
				}
			}

		}
		 if(this.v.m.etat!=Modele.Etat.EN_COURS) {
			 for(int i=0;i<this.v.m.combinaison.jetons.size();i++) {
				 g.setColor(this.v.m.combinaison.jetons.get(i));
				 g.fillOval((this.v.frame.getWidth()-(this.v.diametreproposition+this.v.diametreproposition/2)*this.v.m.DIFFICULTE)/2 +i*(this.v.diametreproposition+this.v.diametreproposition/2), 5+this.v.m.nb_tentatives*30 , 20, 20);
				 
			 }
		 }
	}

}
