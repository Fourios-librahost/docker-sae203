import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.*;

import javax.swing.*;

public class PanelSelect extends JPanel implements ActionListener, AdjustmentListener
{

	private Select frame;

	private JScrollBar    sbCouleur;
	private JTextField    txtDecimal;
	private JTextField    txtHexaDecimal;


	public PanelSelect(  Select frame, char coul )
	{
		Color couleur=null;

		int    val = -1;

		JPanel panelHaut;
		JPanel panelBas;

		JLabel lblInf, lblSup;

		this.frame = frame;

		this.setLayout ( new BorderLayout () );

		/* -------------------------------------*/
		/* CrÃ©ation des Composants              */
		/* -------------------------------------*/
		panelHaut = new JPanel();
		panelBas  = new JPanel();

		panelHaut.setOpaque ( false  );    // contrairement Ã  AWT les Panel sont Opaques
		panelBas .setOpaque ( false  );    // je les mets en Transparent pour voir la couleur du Panel
		                                   // (this) d'ariÃ¨re-plan

		panelHaut.setLayout ( new BorderLayout ( 5, 5 ) );

		this.sbCouleur       = new JScrollBar ( JScrollBar.HORIZONTAL, 0, 10, 0, 265 );
		this.txtDecimal      = new JTextField ( "000" );
		this.txtHexaDecimal  = new JTextField ( "00"  );

		lblInf = new JLabel ( " 00 ");
		lblInf.setOpaque ( true );               // contrairement Ã  swing les JLabel sont transparents
		lblInf.setBackground ( Color.WHITE );    // je les mets en opaque pour voir la couleur.

		lblSup = new JLabel ( " FF ");
		lblSup.setOpaque ( true );
		lblSup.setBackground ( Color.WHITE );


		// initialisation gÃ©nÃ©rale
		switch ( coul )
		{
			case 'R' ->{ couleur = new Color ( 211, 110, 132 ); val = 255; }
			case 'V' ->{ couleur = new Color ( 130, 213, 130 ); val = 128; }
			case 'B' ->{ couleur = new Color ( 128, 202, 235 ); val = 128; }
		}

		this.setBackground ( couleur );

		this.majTout( val );


		/* -------------------------------------*/
		/* Positionnement des composants        */
		/* -------------------------------------*/
		this.add ( panelHaut, BorderLayout.CENTER );
		this.add ( panelBas , BorderLayout.SOUTH  );

		panelHaut.add ( lblInf         , BorderLayout.WEST   );
		panelHaut.add ( this.sbCouleur , BorderLayout.CENTER );
		panelHaut.add ( lblSup         , BorderLayout.EAST   );

		panelBas .add ( new JLabel ( "Dec : " ) );
		panelBas .add ( this.txtDecimal         );
		panelBas .add ( new JLabel ( "Hex : " ) );
		panelBas .add ( this.txtHexaDecimal     );


		/* -------------------------------------*/
		/* Activation des composants            */
		/* -------------------------------------*/
		this.txtDecimal       .addActionListener    ( this );
		this.txtHexaDecimal   .addActionListener    ( this );
		this.sbCouleur        .addAdjustmentListener( this );

	}

	public int  getValeur()
	{
		return this.sbCouleur.getValue();
	}

	public void actionPerformed ( ActionEvent e )
	{
		int valeur = 0;

		// Je mets mes deux instructions de conversions dans un try ainsi une saisie
		// invalide (exemple TOTO ) provoquera une levÃ©e d'excpetion
		// exception que j'intercÃ¨pte pour affecter 0 Ã  la valeur.
		try
		{
			if ( e.getSource() == this.txtDecimal )
				valeur = Integer.parseInt ( this.txtDecimal.getText() );

			if ( e.getSource() == this.txtHexaDecimal )
				valeur = Integer.parseInt ( this.txtHexaDecimal.getText(), 16 );
		}
		catch ( Exception ex )
		{
			valeur = 0;
		}

		this.majTout( valeur );
	}

	public void adjustmentValueChanged ( AdjustmentEvent e )
	{
		if ( e.getSource() == this.sbCouleur )
			this.majTout ( this.sbCouleur.getValue() );
	}

	private void majTout ( int val )
	{
		this.sbCouleur.setValue ( val );
		val = this.sbCouleur.getValue();

		this.txtDecimal    .setText ( " " + String.format ( "%03d", val ) + " " );
		this.txtHexaDecimal.setText ( " " + String.format ( "%02X", val ) + " " );

		this.frame.majCouleur();

	}

}