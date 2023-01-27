import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		else if(couleur.equals("rejouer")) {
			this.m.rejouer();
		}
		else if(couleur.equals("quitter")) {
			this.m.v.frame.dispose();
		}
		else if(couleur.equals("nvlle")) {
			JTextField tailleprop = new JTextField();
			JTextField nbtent = new JTextField();
			CheckboxGroup cg =new CheckboxGroup(); 
			Checkbox facile =new Checkbox("facile", false, cg);
			Checkbox difficile =new Checkbox("difficile", false, cg);
			//JCheckBox difficulte = new JCheckBox();

			Object[] entrees = {"Difficulte de la partie:" +"\n"+"(facile attribu a chaque jeton son evaluation)", facile,difficile,
					"Taille de la combinaison a deviner:", tailleprop,
					"Nombre de tentatives:", nbtent};

			int option = JOptionPane.showConfirmDialog(this.m.v, entrees, "Nouvelle Partie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				try {
					int a =Integer.valueOf(tailleprop.getText());
					int b=Integer.valueOf(nbtent.getText());
					if(facile.getState() || difficile.getState()) {
						this.m.difficile=difficile.getState();
						this.m.DIFFICULTE=a;
						this.m.nb_tentatives=b;
						this.m.v.vueprop.actualiser();
						this.m.rejouer();
					}
					
				}
				catch(Exception i) {
					
				}
			}
			
		}

		if(!couleur.equals("quitter")){
			this.m.actualiser();
		}


	}


}
