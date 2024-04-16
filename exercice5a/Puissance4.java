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
		
		if(aGagner())
		{
			System.out.println("le joueur "+ dJoueur.getCoul() + " a fait un puissance 4");
			return true;
		}

		if(dJoueur.equals(j1))
			dJoueur = j2;
		else 
			dJoueur = j1;
	
		return false;
	}

	public boolean aGagner() {
		// Vérification des lignes horizontales
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j <= plateau[i].length - 4; j++) {
				if (plateau[i][j] != ' '
						&& plateau[i][j] == plateau[i][j + 1]
						&& plateau[i][j] == plateau[i][j + 2]
						&& plateau[i][j] == plateau[i][j + 3]) {
					return true;
				}
			}
		}
	
		// Vérification des lignes verticales
		for (int j = 0; j < plateau[0].length; j++) {
			for (int i = 0; i <= plateau.length - 4; i++) {
				if (plateau[i][j] != ' '
						&& plateau[i][j] == plateau[i + 1][j]
						&& plateau[i][j] == plateau[i + 2][j]
						&& plateau[i][j] == plateau[i + 3][j]) {
					return true;
				}
			}
		}
	
		// Vérification des diagonales (vers le bas et vers la droite)
		for (int i = 0; i <= plateau.length - 4; i++) {
			for (int j = 0; j <= plateau[i].length - 4; j++) {
				if (plateau[i][j] != ' '
						&& plateau[i][j] == plateau[i + 1][j + 1]
						&& plateau[i][j] == plateau[i + 2][j + 2]
						&& plateau[i][j] == plateau[i + 3][j + 3]) {
					return true;
				}
			}
		}
	
		// Vérification des diagonales (vers le haut et vers la droite)
		for (int i = plateau.length - 1; i >= 3; i--) {
			for (int j = 0; j <= plateau[i].length - 4; j++) {
				if (plateau[i][j] != ' '
						&& plateau[i][j] == plateau[i - 1][j + 1]
						&& plateau[i][j] == plateau[i - 2][j + 2]
						&& plateau[i][j] == plateau[i - 3][j + 3]) {
					return true;
				}
			}
		}
	
		return false; // Aucun joueur n'a gagné
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