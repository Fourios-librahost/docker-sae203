public class Puissance4 
{

	private char[][] plateau = {
									{' ', ' ', ' ', ' ', ' ', ' ', ' '},
									{' ', ' ', ' ', ' ', ' ', ' ', ' '},
									{' ', ' ', ' ', ' ', ' ', ' ', ' '},
									{' ', ' ', ' ', ' ', ' ', ' ', ' '},
									{' ', ' ', ' ', ' ', ' ', ' ', ' '},
									{' ', ' ', ' ', ' ', ' ', ' ', ' '}
								};

	private Joueur j1, j2;
	private Joueur dJoueur;

	public Puissance4(Joueur j1, Joueur j2)
	{
		this.j1 = j1;
		this.j2 = j2;
		this.dJoueur = j1;
	}

	public boolean placerJeton(int lig)
	{
		int cpt = 0;

		int indX = 0;
		int indY = 0;
		
		if(this.plateau[cpt][lig] != ' ')
			return false;

		for(int i = 0; i < plateau.length; i++)
		{
			if(plateau[i][lig] == ' ')
			{
				if(i == plateau.length-1)
				{
					this.plateau[i][lig] = dJoueur.getCoul();
					indY = i;
					break;
				}
			}
			else
			{
				this.plateau[--i][lig] = dJoueur.getCoul();
				break;
			}
			
			indX = lig;
			indY = i;
		}
		
		if(aGagner(indX, indY))
		{
			System.out.println("gg "+ dJoueur.getCoul());
		}

		if(dJoueur.equals(j1))
			dJoueur = j2;
		else 
			dJoueur = j1;
	
		return true;
	}

	public boolean aGagner(int x, int y)
	{   
		//System.out.println(x + " " + y);
		
		//System.out.println(dJoueur.getCoul());
		try
		{

			//System.out.println(x + " " + y + "A");
			//BAS
			if(this.plateau[y][x] == dJoueur.getCoul() && this.plateau[y+1][x] == dJoueur.getCoul() && this.plateau[y+2][x] == dJoueur.getCoul() && this.plateau[y+3][x] == dJoueur.getCoul())
			{
				System.out.println("oui BAS");
				return true;
			}

			//GAUCHE
			if(this.plateau[y][x] == dJoueur.getCoul() && this.plateau[y][x-1] == dJoueur.getCoul() && this.plateau[y][x-2] == dJoueur.getCoul() && this.plateau[y][x-3] == dJoueur.getCoul())
			{
				return true;
			}

			//DROITE
			if(this.plateau[y][x] == dJoueur.getCoul() && this.plateau[y][x+1] == dJoueur.getCoul() && this.plateau[y][x+2] == dJoueur.getCoul() && this.plateau[y][x+3] == dJoueur.getCoul())
			{
				System.out.println("oui DROITE");
				return true;
			}

		}
		catch(Exception e){}
		return false;
	}

	public String toString()
	{
		String sRet = "";

		for(int i = 0; i < this.plateau.length; i++)
		{
			sRet += "|";
			for(int j = 0; j < this.plateau[i].length; j++)
			{
				sRet += String.format("%3s", this.plateau[i][j]) + "|";
			}

			sRet += "\n" + "_____________________________" + "\n";
		}
		return sRet;
	}

	public char[][] getGrille()
	{
		char[][] SChar = new char[this.plateau.length][this.plateau[0].length];
		for (int i=0; i < this.plateau.length; i++)
			for (int j=0; j < this.plateau[0].length; j++)
				SChar[i][j] = this.plateau[i][j];
		return SChar;
	}

	public char getVal(int lig, int col)
	{
		return this.plateau[lig][col];
	}

	public int getNbLig() { return this.plateau.length;}
	public int getNbCol() { return this.plateau[0].length;}
}