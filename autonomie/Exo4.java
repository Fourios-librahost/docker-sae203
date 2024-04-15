import java.awt.*;
import java.awt.event.*;



public class Exo4 extends Frame implements ActionListener
{
	private Button btn1;
	private Button btn2;
	private Label  lblCompteur;

	private List   lstChoix;

	private int    cpt1;
	private int    cpt2;

	public Exo4()
	{
		this.setTitle("2 Boutons et 1 liste");
		this.setLocation(50,50);
		this.setLayout  ( new GridLayout(4,1,5,5) );

		this.cpt1 = 0;
		this.cpt2 = 0;

		// CrÃ©ation des Controles
		this.btn1        = new Button( " Appliquer " );
		this.btn2        = new Button( " Annuler " );

		this.lblCompteur = new Label();
		this.lblCompteur.setText( "Appliquer : " + this.cpt1 + "    Annuler : " + this.cpt2 );

		this.lstChoix = new List();
		this.lstChoix.setMultipleMode(true);

		this.lstChoix.add("premier"  );
		this.lstChoix.add("second"   );
		this.lstChoix.add("troisieme");
		this.lstChoix.add("quatrieme");
		this.lstChoix.add("cinquieme");
		this.lstChoix.add("sixieme"  );
		this.lstChoix.add("septieme" );


		// Activation des ContrÃ´les
		this.btn1.addActionListener    (this);
		this.btn2.addActionListener    (this);
		this.lstChoix.addActionListener(this);


		// Positionnement des ContrÃ´les
		this.add( this.btn1        );
		this.add( this.btn2        );
		this.add( this.lblCompteur );
		this.add( this.lstChoix    );


		this.pack();
		this.setVisible(true);
	}

    private void modifierCompteur(int num)
    {
		if ( num == 1 ) this.cpt1++;
		if ( num == 2 ) this.cpt2++;

		this.lblCompteur.setText( "Appliquer : " + this.cpt1 + "    Annuler : " + this.cpt2 );
	}


	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btn1)
		{
			this.modifierCompteur(1);
			for ( String s:this.lstChoix.getSelectedItems() )
				System.out.println ( s );

			System.out.println ( " (" + this.lstChoix.getSelectedIndexes().length + "/" + this.lstChoix.getItemCount() +")" );
		}

		if (e.getSource() == this.btn2 )
			this.modifierCompteur(2);

		if (e.getSource() == this.lstChoix)
			System.out.println ( "L'utilisateur a double-cliquÃ© sur un item de la liste" );
	}

	public static void main(String [] args) { new Exo4(); }
}