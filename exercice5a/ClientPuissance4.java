import java.io.*;
import java.net.*;

public class ClientPuissance4 {
	private static final String SERVER_ADDRESS = "localhost";
	private static final int PORT = 5000;

	public static void main(String[] args) {
		try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

			System.out.println("Connecté au serveur Puissance4.");

			while (true) 
			{
				try
				{ 
					Object serverResponse = in.readObject();

					if (serverResponse instanceof char[][]) 
					{
						char[][] grille = (char[][]) serverResponse;
						afficherGrille(grille);
					} else 
					{
						System.out.println((String) serverResponse);
					}
				}catch(IOException | ClassNotFoundException e) { 
					System.out.println("Jeu Terminé"); break;}
			}
		} catch (IOException e) { e.printStackTrace();}
	}

	private static void afficherGrille(char[][] grille) {
		for (char[] row : grille) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
