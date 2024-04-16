import java.awt.GridLayout;

import javax.swing.*;


import java.awt.event.*;

public class PanelGrille extends JPanel implements ActionListener 
{
	Controleur ctrl;

	JButton[][] tabLblCase;

	public PanelGrille(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new GridLayout ( this.ctrl.getNbLigne(), this.ctrl.getNbColonne()) );

		/*------------------------------*/
		/* Création des composants      */
		/*------------------------------*/

		// Création des Boutons
		this.tabLblCase  = new JButton [ this.ctrl.getNbLigne() ] [ this.ctrl.getNbColonne() ];


		for (int lig=0;lig<tabLblCase.length; lig++ )
			for (int col=0;col<tabLblCase[lig].length; col++ )
			{
				this.tabLblCase[lig][col] = new JButton(new ImageIcon(this.ctrl.getIcon(lig, col)));
			}
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

	public void enabled(boolean inf)
	{
			for (int i=0; i<this.tabLblCase.length; i++)
				for (int j=0; j<this.tabLblCase[0].length; j++)
					{
						tabLblCase[i][j].setEnabled(inf);
					}
	}

	public void actionPerformed(ActionEvent e)
	{
		for (int lig = 0; lig < this.tabLblCase.length; lig++)
			for (int col = 0; col < this.tabLblCase[lig].length; col++)
				if (e.getSource() == tabLblCase[lig][col])
				{
					this.ctrl.setInt(col);
					this.ctrl.setAChange(true);
					if (this.ctrl.placerJeton(col))
						System.exit(0);
				}
		this.majIHM();
	}
}
