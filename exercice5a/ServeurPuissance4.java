import java.io.*;
import java.net.*;

public class ServeurPuissance4 {
	public static void main(String[] args) {
		final int PORT = 5000;

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Le serveur est en attente de connexions...");

			while (true) 
			{
				Socket joueur1Socket = serverSocket.accept();
				System.out.println("Joueur 1 connecté : " + joueur1Socket);

				Socket joueur2Socket = serverSocket.accept();
				System.out.println("Joueur 2 connecté : " + joueur2Socket);

				ObjectOutputStream joueur1Out = new ObjectOutputStream(joueur1Socket.getOutputStream());
				ObjectInputStream joueur1In = new ObjectInputStream(joueur1Socket.getInputStream());

				ObjectOutputStream joueur2Out = new ObjectOutputStream(joueur2Socket.getOutputStream());
				ObjectInputStream joueur2In = new ObjectInputStream(joueur2Socket.getInputStream());

				Controleur ctrl = new Controleur();

				while (!ctrl.aGagner()) 
				{
					int coupJoueur1 = joueur1In.readInt();
					ctrl.placerJeton(coupJoueur1);
					joueur1Out.writeObject(ctrl.getGrille());

					if (!ctrl.aGagner()) 
					{
						int coupJoueur2 = joueur2In.readInt();
						ctrl.placerJeton(coupJoueur2);
						joueur2Out.writeObject(ctrl.getGrille());
					}
				}
				joueur1Socket.close();
				joueur2Socket.close();
			}
		} catch (IOException e) { e.printStackTrace();}
	}
}
