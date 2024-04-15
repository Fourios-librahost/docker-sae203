import javax.swing.*;
import java.awt.Dimension;


public class FrameGrille extends JFrame
{

	private PanelGrille panelGrille;

	public FrameGrille(Controleur ctrl)
	{
		int hauteurEcran, largeurEcran;
		Dimension dimEcran;

		dimEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		hauteurEcran = (int) dimEcran.getHeight();
		largeurEcran = (int) dimEcran.getWidth();

		this.panelGrille = new PanelGrille ( ctrl );

		this.setTitle   ( "Connect 4" );
		this.setLocation( (largeurEcran/2) - 200, (hauteurEcran/2) - 100 );
		this.setSize    ( 500, 500 );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add ( this.panelGrille );

		this.setVisible ( true );
	}

	public void majIHM()
	{
		this.panelGrille.majIHM();
	}
}