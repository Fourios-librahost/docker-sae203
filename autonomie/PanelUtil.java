import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.*;

import javax.swing.*;

public class PanelUtil extends JPanel implements ActionListener, AdjustmentListener
{

	private FrameCouleur frame;

	private JScrollBar    sbCouleur;
	private JTextField    txtDecimal;
	private JTextField    txtHexaDecimal;


	public PanelUtil()
	{
		Color couleur=null;

		JPanel panelHaut;
		JPanel panelBas;

		JLabel lblInf, lblSup;

		this.setLayout ( new BorderLayout () );

		/* -------------------------------------*/
		/* CrÃ©ation des Composants              */
		/* -------------------------------------*/
		panelHaut = new JPanel();
		panelBas  = new JPanel();

		panelHaut.setOpaque ( false  );
		panelBas .setOpaque ( false  );

		panelHaut.setLayout ( new BorderLayout ( 5, 5 ) );


		this.sbCouleur       = new JScrollBar ( JScrollBar.HORIZONTAL, 0, 10, 0, 265 );
		this.txtDecimal      = new JTextField ( "000" );
		this.txtHexaDecimal  = new JTextField ( "00"  );

		lblInf = new JLabel ( " 00 ");
		lblInf.setOpaque ( true );   
		lblInf.setBackground ( Color.WHITE );   

		lblSup = new JLabel ( " FF ");
		lblSup.setOpaque ( true );
		lblSup.setBackground ( Color.WHITE );

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