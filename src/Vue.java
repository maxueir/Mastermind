import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Vue extends JFrame implements Observer{
	static Dimension dimension=new Dimension(600,500);
	static int diametreproposition=20;
	static int diametreresultat=10;
	Modele m;
	Graphics g;
	int largeur;
	int hauteur;
	JFrame frame;
	JPanel VueClavier;
	JButton jaune;
	JButton vert;
	JButton bleu;
	JButton magenta;
	JButton rouge;
	JButton orange;
	JButton blanc;
	JButton noir;
	VuePropositions vueprop;
	
	
	public Vue(Modele m, ActionListener l) {
		m.addObserver(this);
		
		this.m=m;
		VueClavier= new JPanel();
		VueClavier.setLayout(new FlowLayout());
		
		jaune= new JButton();
		jaune.setName("jaune");
		jaune.setBackground(Color.YELLOW);
		jaune.setSize(20,20);
		VueClavier.add(jaune);
		
		vert= new JButton();
		vert.setName("vert");
		vert.setBackground(Color.GREEN);
		vert.setSize(20,20);
		VueClavier.add(vert);
		
		bleu= new JButton();
		bleu.setName("bleu");
		bleu.setBackground(Color.BLUE);
		bleu.setSize(20,20);
		VueClavier.add(bleu);
		
		magenta= new JButton();
		magenta.setName("magenta");
		magenta.setBackground(Color.MAGENTA);
		magenta.setSize(20,20);
		VueClavier.add(magenta);
		
		rouge= new JButton();
		rouge.setName("rouge");
		rouge.setBackground(Color.RED);
		rouge.setSize(20,20);
		VueClavier.add(rouge);
		
		orange= new JButton();
		orange.setName("orange");
		orange.setBackground(Color.ORANGE);
		orange.setSize(20,20);
		VueClavier.add(orange);
		
		blanc= new JButton();
		blanc.setName("blanc");
		blanc.setBackground(Color.WHITE);
		blanc.setSize(20,20);
		VueClavier.add(blanc);
		
		noir= new JButton();
		noir.setName("noir");
		noir.setBackground(Color.BLACK);
		noir.setSize(20,20);
		VueClavier.add(noir);
		
		jaune.addActionListener(l);
		vert.addActionListener(l);
		bleu.addActionListener(l);
		magenta.addActionListener(l);
		rouge.addActionListener(l);
		orange.addActionListener(l);
		blanc.addActionListener(l);
		noir.addActionListener(l);
		
		
		int largeur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5+m.DIFFICULTE*10+(m.DIFFICULTE-1)*5+5;
		int hauteur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5;
		vueprop=new VuePropositions(this);
		
		frame= new JFrame();
		frame.setTitle("MASTERMIND");
		frame.setLayout(new BorderLayout());
		frame.setLocation(400,50);
		frame.setSize(dimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(VueClavier,BorderLayout.SOUTH);
		frame.add(vueprop,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	public void gagne() {
		VueClavier.removeAll();
		VueClavier.setLayout(new FlowLayout());
		VueClavier.add(new JLabel("GAGNE"));
		frame.setVisible(true);
	}
	public void perdu() {
		VueClavier.removeAll();
		VueClavier.setLayout(new FlowLayout());
		VueClavier.add(new JLabel("PERDU"));
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.m.etat==Modele.Etat.GAGNE) {
			this.gagne();
		}
		else if(this.m.etat==Modele.Etat.PERDU) {
			this.perdu();
		}
		this.vueprop.repaint();
		frame.repaint();
		
		
	}


}
