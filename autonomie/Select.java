import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.*;

public class FrameCouleur extends JFrame
{
	private JPanel             panelCouleur;

	private PanelSelectCouleur panelRouge;
	private PanelSelectCouleur panelVert;
	private PanelSelectCouleur panelBleu;

	private boolean            bFini;

	public FrameCouleur ()
	{
		this.setTitle    ( " Selection couleur " );
		this.setSize     ( 400, 400 );
		this.setLocation ( 200, 200 );

		this.setLayout   ( new GridLayout ( 4, 1 ) );

		this.bFini = false;


		this.panelCouleur = new JPanel();

		this.panelRouge   = new PanelSelectCouleur( this, 'R' );
		this.panelVert    = new PanelSelectCouleur( this, 'V' );
		this.panelBleu    = new PanelSelectCouleur( this, 'B' );

		this.add ( this.panelCouleur );
		this.add ( this.panelRouge   );
		this.add ( this.panelVert    );
		this.add ( this.panelBleu    );

		this.bFini = true;

		this.majCouleur ();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setVisible ( true );
	}

	public void majCouleur()
	{
		if ( this.bFini )
		{
			int r, v, b;

			r = this.panelRouge.getValeur();
			v = this.panelVert .getValeur();
			b = this.panelBleu .getValeur();

			this.panelCouleur.setBackground ( new Color ( r, v, b ) );
		}
	}

	public static void main(String[] a)
	{
		new FrameCouleur();
	}

}


