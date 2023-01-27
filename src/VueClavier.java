import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueClavier extends JPanel{
	JButton jaune;
	JButton vert;
	JButton bleu;
	JButton magenta;
	JButton rouge;
	JButton orange;
	JButton blanc;
	JButton noir;
	JButton rejouer;
	JButton quitter;
	Vue v;
	ActionListener l;
	
	public VueClavier(Vue v, ActionListener l) {
		this.v=v;
		this.l=l;
	}

	public void boutons() {
		this.removeAll();
		this.setLayout(new FlowLayout());

		jaune= new JButton();
		jaune.setName("jaune");
		jaune.setBackground(Color.YELLOW);
		jaune.setSize(20,20);
		this.add(jaune);

		vert= new JButton();
		vert.setName("vert");
		vert.setBackground(Color.GREEN);
		vert.setSize(20,20);
		this.add(vert);

		bleu= new JButton();
		bleu.setName("bleu");
		bleu.setBackground(Color.BLUE);
		bleu.setSize(20,20);
		this.add(bleu);

		magenta= new JButton();
		magenta.setName("magenta");
		magenta.setBackground(Color.MAGENTA);
		magenta.setSize(20,20);
		this.add(magenta);

		rouge= new JButton();
		rouge.setName("rouge");
		rouge.setBackground(Color.RED);
		rouge.setSize(20,20);
		this.add(rouge);

		orange= new JButton();
		orange.setName("orange");
		orange.setBackground(Color.ORANGE);
		orange.setSize(20,20);
		this.add(orange);

		blanc= new JButton();
		blanc.setName("blanc");
		blanc.setBackground(Color.WHITE);
		blanc.setSize(20,20);
		this.add(blanc);

		noir= new JButton();
		noir.setName("noir");
		noir.setBackground(Color.BLACK);
		noir.setSize(20,20);
		this.add(noir);

		jaune.addActionListener(l);
		vert.addActionListener(l);
		bleu.addActionListener(l);
		magenta.addActionListener(l);
		rouge.addActionListener(l);
		orange.addActionListener(l);
		blanc.addActionListener(l);
		noir.addActionListener(l);
	}
	public void fin(ActionListener l) {
		this.rejouer=new JButton("REJOUER");
		this.rejouer.setName("rejouer");
		this.rejouer.addActionListener(l);
		this.quitter=new JButton("QUITTER");
		this.quitter.setName("quitter");
		this.quitter.addActionListener(l);
		this.removeAll();
		this.setLayout(new FlowLayout());
		this.add(this.rejouer);
		this.add(this.quitter);


	}
}
