import java.awt.Color;
public class Controleur
{
	private FrameGrille ihm;
	private Puissance4  metier;

	public Controleur()
	{
		this.metier = new Puissance4(new Joueur("M",'J'), new Joueur("ou", 'R'));
		this.ihm    = new FrameGrille ( this );
	}

	// Pour Version 1
	public Color getCouleur(int lig, int col)
	{
		switch ( metier.getVal(lig, col) )
		{
			case 'R' : return new Color ( 237,  27,  35 );
			case 'J' : return new Color ( 254, 242,   0 );
			case ' ' : return new Color(0,255,255);
		}

		return null;
	}

	public String getIcon(int lig, int col)
	{
		switch ( metier.getVal(lig, col) )
		{
			case 'R' : return "R.png";
			case 'J' : return "J.png";
			case ' ' : return "V.png";
		}

		return null;
	}

	public int getNbLigne  () { return this.metier.getNbLig (); }
	public int getNbColonne() { return this.metier.getNbCol(); }

	public boolean placerJeton(int lig) {return this.metier.placerJeton(lig);}

	public static void main(String[] a)
	{
		new Controleur();
	}
}
