import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.*;

public class FrameUtil extends JFrame
{
	private JPanel panelRouge;
	private JPanel panelVert;
	private JPanel panelBleu;

	public FrameUtil ()
	{
		this.setTitle    ( " Selection couleur " );
		this.setSize     ( 400, 400 );
		this.setLocation ( 200, 200 );

		this.setLayout   ( new GridLayout ( 4, 1 ) )

		this.panelRouge   = new JPanel();
		this.panelVert    = new JPanel();
		this.panelBleu    = new JPanel();

		this.add ( this.panelRouge   );
		this.add ( this.panelVert    );
		this.add ( this.panelBleu    );


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setVisible ( true );
	}

	public static void main(String[] a)
	{
		new FrameUtil();
	}

}