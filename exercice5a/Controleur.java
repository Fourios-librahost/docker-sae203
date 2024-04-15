public class Controleur
{
	private FrameGrille ihm;
	private Puissance4  metier;

	public Controleur()
	{
		this.metier = new Puissance4(new Joueur("M",'J'), new Joueur("ou", 'R'));
		this.ihm    = new FrameGrille ( this );
	}

	public String getIcon(int lig, int col)
	{
		switch ( metier.getVal(lig, col) )
		{
			case 'R' : return "r.png";
			case 'J' : return "j.png";
			case ' ' : return "v.png";
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
