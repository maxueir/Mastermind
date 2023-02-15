import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;




public class Vue extends JFrame implements Observer,WindowListener{
	static Dimension dimension=new Dimension(600,500);
	static int diametreproposition=20;
	static int diametreresultat=10;
	Modele m;
	Graphics g;
	int largeur;
	int hauteur;
	JFrame frame;
	JPanel nord;
	JPanel scores;
	VueClavier Clavier;
	ActionListener l;
	JButton nvlle;

	VuePropositions vueprop;


	public Vue(Modele m, ActionListener l) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		m.addObserver(this);
		this.l=l;
		this.m=m;

		this.nvlle=new JButton("Nouvelle Partie");
		this.nvlle.setName("nvlle");
		this.nvlle.addActionListener(l);
		this.nord=new JPanel();
		this.scores= new JPanel();
		this.actualisernord();




		frame= new JFrame();
		Clavier=new VueClavier(this,l);
		Clavier.boutons();

		int largeur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5+m.DIFFICULTE*10+(m.DIFFICULTE-1)*5+5;
		int hauteur= 5+m.DIFFICULTE*20+(m.DIFFICULTE-1)*10+5;
		vueprop=new VuePropositions(this);
		vueprop.addMouseListener((MouseListener) l);


		frame.setTitle("MASTERMIND");
		frame.setLayout(new BorderLayout());
		frame.setLocation(400,50);
		frame.setSize(dimension);
		frame.add(Clavier,BorderLayout.SOUTH);
		frame.add(vueprop,BorderLayout.CENTER);
		frame.add(nord,BorderLayout.NORTH);

		frame.pack();
		frame.addWindowListener(this);
		frame.setVisible(true);


	}

	public void gagne() {
		this.m.t.stop();
		if(this.m.scores.containsKey(this.m.p)) {
			if(this.m.tentative<this.m.scores.get(this.m.p).score) {

				this.m.scores.replace(this.m.p, new Score(this.m.tentative,this.m.scores.get(this.m.p).temps));
			}
			if(this.m.temps<this.m.scores.get(this.m.p).temps) {

				this.m.scores.replace(this.m.p, new Score(this.m.scores.get(this.m.p).score,this.m.temps));
			}

		}
		else {
			this.m.scores.put(this.m.p, new Score(this.m.tentative,Modele.temps));
		}
		System.out.println(this.m.scores);
		this.actualisernord();
		this.nord.add(new JLabel("PARTIE GAGNE"),BorderLayout.CENTER);
		this.Clavier.fin(l);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	public void perdu() {
		this.m.t.stop();
		this.nord.add(new JLabel("PARTIE PERDUE"),BorderLayout.CENTER);
		this.Clavier.fin(l);
		this.frame.pack();
		this.frame.setVisible(true);
	}

	public void actualisernord() {
		this.nord.removeAll();
		this.scores.removeAll();
		this.scores.setLayout(new BoxLayout(this.scores,BoxLayout.Y_AXIS));
		this.nord.setLayout(new BorderLayout());
		this.nord.add(nvlle,BorderLayout.WEST);
			if(this.m.scores.containsKey(this.m.p)) {
				Score scaure= this.m.scores.get(this.m.p);
				String a ="Meilleur score: "+scaure.score;
				this.scores.add(new JLabel(a));
				String b;
				if(scaure.temps<60) {
					b="Meilleur temps: "+scaure.temps+"s";
				}
				else if(scaure.temps%60==0) {
					b="Meilleur temps: "+scaure.temps/60+"m";
				}
				else {
					b="Meilleur temps: "+(scaure.temps-scaure.temps%60)+"m"+scaure.temps%60+"s";
				}
				
				this.scores.add(new JLabel(b));

			}
		
		this.nord.add(scores,BorderLayout.EAST);

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
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println(this.m.scores);
		this.m.t.stop();
		this.frame.dispose();
		XMLEncoder encoder=null;
		try {
			FileOutputStream fos = new FileOutputStream("scores.xml");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);

			encoder.writeObject(this.m.scores);
			encoder.flush();
			//encoder.writeObject(Modele.temps);
			//encoder.flush();
			System.out.println("ok");
		}catch(final IOException ex) {
			throw new RuntimeException("Impossible d'ecrire les donnees");
		}finally {
			if(encoder!=null)encoder.close();
		}
	}
	@Override
	public void windowClosed(WindowEvent e) {



	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}


}
