import java.awt.GridLayout;

import javax.swing.*;


import java.awt.event.*;

public class PanelGrille extends JPanel implements ActionListener 
{
	Controleur ctrl;

	JButton[][] tabLblCase;
	JButton[]  tabButton;


	public PanelGrille(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new GridLayout ( this.ctrl.getNbLigne(), this.ctrl.getNbColonne()) );
		String[][] modele = getModele();

		/*------------------------------*/
		/* Création des composants      */
		/*------------------------------*/

		// Création des Labels
		this.tabLblCase  = new JButton [ this.ctrl.getNbLigne() ] [ this.ctrl.getNbColonne() ];


		for (int lig=0;lig<tabLblCase.length; lig++ )
			for (int col=0;col<tabLblCase[lig].length; col++ )
			{
				this.tabLblCase[lig][col] = new JButton(new ImageIcon(this.ctrl.getIcon(lig, col)));
			}
		


		// Création des Boutons
		/*
		this.tabButton = new JButton[ this.ctrl.getNbLigne()+1];

		for (int col=0 ; col < modele[0].length ; col++ )
			if ( modele[0][col] != null && modele[0][col].startsWith ("fl_" ) )
			{
				this.tabButton[col] =new JButton(new ImageIcon("./fl_bas.gif"));
			}
			*/

		/*------------------------------*/
		/* Postionnement des composants */
		/*------------------------------*/
		for (int lig = 0; lig < tabLblCase.length; lig++)
			for (int col = 0; col < tabLblCase[0].length; col++)
				this.add(tabLblCase[lig][col]);
		


		/*------------------------------*/
		/* Activation des composants    */
		/*------------------------------*/
		for (int lig = 0; lig < tabLblCase.length; lig++)
			for (int col = 0; col < tabLblCase[0].length; col++)
				this.tabLblCase[lig][col].addActionListener(this);
	}


	public void majIHM()
	{
		for ( int lig=0; lig< this.tabLblCase.length; lig++)
			for ( int col=0; col< this.tabLblCase[lig].length; col++)
				this.tabLblCase[lig][col].setIcon(new ImageIcon(this.ctrl.getIcon(lig, col)));
	}

	public void actionPerformed(ActionEvent e)
	{
		/*
			* Appel de la méthode permuter de Controleur avec les bons
			* paramètres
			*/

		// fleches du haut
		for (int lig = 0; lig < this.tabLblCase.length; lig++)
			for (int col = 0; col < this.tabLblCase[lig].length; col++)
				if (e.getSource() == tabLblCase[lig][col])
					if (this.ctrl.placerJeton(col))
						System.exit(0);
		
		this.majIHM();
	}

	private String[][] getModele()
	{
		/* Voici un exemple de Modele généré pour une grille de 6 x 6

		{ {null,        "fl_haut", "fl_haut", "fl_haut", "fl_haut", "fl_haut", "fl_haut", null        },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		{null,        "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",   null       }  };
		*/


		// Construction du Modele correspondant à la taille de notre Grille.
		String[][] tabModele = new String[ctrl.getNbLigne()+1][ctrl.getNbColonne()];

		for (int col = 0; col < tabModele[0].length; col++ )
			tabModele[0]                     [col] = "fl_bas";

		for (int lig=1; lig < tabModele.length; lig++ )
			for (int col = 0; col < tabModele[0].length; col++ )
				tabModele[lig][col] = "val";

		return tabModele;
	}
}
