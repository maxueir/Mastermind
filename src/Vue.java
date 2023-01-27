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
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;




public class Vue extends JFrame implements Observer{
	static Dimension dimension=new Dimension(600,500);
	static int diametreproposition=20;
	static int diametreresultat=10;
	Modele m;
	Graphics g;
	int largeur;
	int hauteur;
	JFrame frame;
	JPanel nord;
	VueClavier Clavier;
	ActionListener l;
	JButton nvlle;
	
	VuePropositions vueprop;
	
	
	public Vue(Modele m, ActionListener l) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		m.addObserver(this);
		this.l=l;
		
		this.nvlle=new JButton("Nouvelle Partie");
		this.nvlle.setName("nvlle");
		this.nvlle.addActionListener(l);
		this.nord=new JPanel();
		this.nord.setLayout(new BorderLayout());
		this.nord.add(nvlle,BorderLayout.WEST);
		
		
		this.m=m;
		frame= new JFrame();
		Clavier=new VueClavier(this,l);
		Clavier.boutons();
		
		int largeur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5+m.DIFFICULTE*10+(m.DIFFICULTE-1)*5+5;
		int hauteur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5;
		vueprop=new VuePropositions(this);
		
		
		frame.setTitle("MASTERMIND");
		frame.setLayout(new BorderLayout());
		frame.setLocation(400,50);
		frame.setSize(dimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(Clavier,BorderLayout.SOUTH);
		frame.add(vueprop,BorderLayout.CENTER);
		frame.add(nord,BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	public void gagne() {
		this.nord.add(new JLabel("PARTIE GAGNE"),BorderLayout.CENTER);
		this.Clavier.fin(l);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	public void perdu() {
		this.nord.add(new JLabel("PARTIE PERDUE"),BorderLayout.CENTER);
		this.Clavier.fin(l);
		this.frame.pack();
		this.frame.setVisible(true);
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
