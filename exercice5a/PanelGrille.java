import java.awt.GridLayout;

import javax.swing.*;


import java.awt.event.*;

public class PanelGrille extends JPanel implements ActionListener 
{
	Controleur ctrl;

	JLabel[][] tabLblCase;
	JButton[]  tabButton;


	public PanelGrille(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new GridLayout ( 7, 7) );
		String[][] modele = getModele();

		/*------------------------------*/
		/* Création des composants      */
		/*------------------------------*/

		// Création des Labels
		this.tabLblCase  = new JLabel [ this.ctrl.getNbLigne() ] [ this.ctrl.getNbColonne() ];


		for (int lig=0;lig<tabLblCase.length; lig++ )
			for (int col=0;col<tabLblCase[lig].length; col++ )
			{
				this.tabLblCase[lig][col] = new JLabel(new ImageIcon(this.ctrl.getIcon(lig, col)));
			}
		


		// Création des Boutons
		
		this.tabButton = new JButton[ this.ctrl.getNbLigne()+1];

		for (int col=0 ; col < modele[0].length ; col++ )
			if ( modele[0][col] != null && modele[0][col].startsWith ("fl_" ) )
			{
				this.tabButton[col] =new JButton(new ImageIcon("./fl_bas.gif"));
			}
			

		/*------------------------------*/
		/* Postionnement des composants */
		/*------------------------------*/
		int cas;

		for (int lig = 0; lig < modele.length; lig++)
			for (int col = 0; col < modele[lig].length; col++)
			{
				if (modele[lig][col] == null)
					cas = 0;
				else if (modele[lig][col].startsWith("fl_"))
					cas = 1;
				else
					cas = 2;

				switch (cas)
				{
				case 0 -> this.add(new JLabel());
				case 1 -> this.add(tabButton[col]);
				case 2 -> this.add(tabLblCase[lig - 1][col]);
				}
			}
		


		/*------------------------------*/
		/* Activation des composants    */
		/*------------------------------*/
		for (int cpt = 0; cpt < this.tabButton.length; cpt++)
			this.tabButton[cpt].addActionListener(this);
	}


	public void majIHM()
	{
		for ( int lig=0; lig< this.tabLblCase.length; lig++)
			for ( int col=0; col< this.tabLblCase[lig].length; col++)
			{
				this.tabLblCase[lig][col].setIcon(new ImageIcon(this.ctrl.getIcon(lig, col)));
			}

	}

	public void actionPerformed(ActionEvent e)
	{
		/*
			* Appel de la méthode permuter de Controleur avec les bons
			* paramètres
			*/

		// fleches du haut
		for (int i = 0; i < this.ctrl.getNbColonne(); i++)
			if (e.getSource() == tabButton[i])
				if(this.ctrl.placerJeton(i))
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
