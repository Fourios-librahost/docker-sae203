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

				PrintWriter joueur1Out = new PrintWriter(joueur1Socket.getOutputStream(), true);
				//ObjectOutputStream joueur1Out = new ObjectOutputStream(joueur1Socket.getOutputStream());
				BufferedReader joueur1In = new BufferedReader(new InputStreamReader(joueur1Socket.getInputStream()));

				PrintWriter joueur2Out = new PrintWriter(joueur2Socket.getOutputStream(), true);
				//ObjectOutputStream joueur2Out = new ObjectOutputStream(joueur2Socket.getOutputStream());
				BufferedReader joueur2In = new BufferedReader(new InputStreamReader(joueur2Socket.getInputStream()));
				joueur1Out.println("j1");
				joueur2Out.println("j2");
				try
				{
					while (true)
					{
						int coupJoueur1 = Integer.parseInt(joueur1In.readLine());
						joueur2Out.println(coupJoueur1);

						int coupJoueur2 = Integer.parseInt(joueur2In.readLine());
						if (coupJoueur1 == 66) {break;}
						joueur1Out.println(coupJoueur2);
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				joueur1Socket.close();
				joueur2Socket.close();
			}
		} catch (IOException e) { e.printStackTrace();}
	}
}
