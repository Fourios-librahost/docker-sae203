public class Joueur 
	{
	private String nom;
	private char couleur;
	private int nbJeton = 15;

	public Joueur(String nom, char couleur)
	{
		this.nom = nom;
		this.couleur = couleur;
	}

	public boolean enleverJeton()
	{
		if(this.nbJeton != 0)
		{
			this.nbJeton--;
			return true;
		} 
		return false;
	}

	public char getCoul()
	{
		return this.couleur;
	}
	
	public String getNom() 
	{
		return nom;
	}

	public int getNbJeton() 
	{
		return nbJeton;
	}


}
