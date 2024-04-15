import java.awt.*;
import java.awt.event.*;

public class PanelMouse extends Panel
{
	private Label lblMessage;

	private String message;

	public PanelMouse()
	{
		Panel panelGrille, panelGrilleZone1, panelGrilleZone2,panelGrilleZone3 ;
		

		this.setLayout ( new BorderLayout() );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		/* ----------------------- */
		/* Création des composants */
		/* ----------------------- */
		panelGrille = new Panel ( new  GridLayout(3,0) );

		panelGrilleZone1 = new Panel();
		panelGrilleZone2 = new Panel();
		panelGrilleZone3 = new Panel();

		panelGrilleZone1.setBackground(new Color(255, 160, 160));
		panelGrilleZone2.setBackground(new Color(160, 255, 160));
		panelGrilleZone3.setBackground(new Color(160, 160, 255));

		this.lblMessage  = new Label();
		this.lblMessage.setBackground(Color.white);


		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */
		this.add( panelGrille,     BorderLayout.CENTER );
		this.add( this.lblMessage, BorderLayout.SOUTH  );

		panelGrille.add( panelGrilleZone1 );
		panelGrille.add( panelGrilleZone2 );
		panelGrille.add( panelGrilleZone3 );


		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */
		panelGrilleZone1.addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e)
			{
				PanelMouse.this.lblMessage.setText(String.format("%6s (%3d:%3d)", " orangé", e.getX(), e.getY() ));
			}
		});

		panelGrilleZone2.addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e)
			{
				PanelMouse.this.lblMessage.setText( String.format("%6s (%3d:%3d)", " vert", e.getX(), e.getY() ));
			}
		});

		panelGrilleZone3.addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e)
			{
				PanelMouse.this.lblMessage.setText( String.format("%6s (%3d:%3d)", " mauve", e.getX(), e.getY() ));
			}
		});

	}

}