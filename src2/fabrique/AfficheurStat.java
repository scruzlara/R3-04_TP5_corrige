package fabrique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class AfficheurStat extends JPanel{

	/**
	 * les stats à afficher
	 */
	Map <String, Integer> stats;
	/**
	 * la taille du panel
	 */
	int taille;
	
	/**
	 * constructeur 
	 * @param res les stats générés
	 * @param taille la taille du Panel
	 */
	public AfficheurStat(Map<String, Integer> res,int taille) {
		this.stats=res;
		this.taille=taille;
		setPreferredSize(new Dimension(taille,taille));
	}
	
	/**
	 * surcharge de l'affichage
	 * affiche des rectangles de tailles variables en fonction des stats 
	 */
	public void paintComponent(Graphics g)
	{
		//point de depart du prochain rectangle à dessiner
		// evolue au fur et à mesure du dessin
		int departX=0;
		//on parcours keyset
		for (String s:stats.keySet())
		{
			int tailleMorceau=(stats.get(s)*taille)/100;
			g.setColor(getColor(s));
			g.fillRect(departX, 0, departX+tailleMorceau, taille);
			//on decale le point de depatr du rectangle suivant
			departX=departX+tailleMorceau;
		}
	}

	
	/**
	 * methode privée qui retourne la couleur associée aux différents types
	 * @param s le type
	 * @return la couleur associée
	 */
	private Color getColor(String s) {
		switch(s)
		{
		case "voiture":
			return (Color.BLACK);
		case "bicyclette":
			return (Color.RED);
		case "bus":
			return (Color.GREEN);
		case "pieton":
			return (Color.BLUE);			
			
		}
		//ne devrait jamais arriver
		return(null);

	}

	/**
	 * construit et affiche la JFrame contenant le JPanel 
	 */
	public void display() {
		JFrame f=new JFrame();
		f.setContentPane(this);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
