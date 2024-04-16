import java.io.*;
import java.net.*;

public class ClientPuissance4 {
	private static final int PORT = 5000;

	public static void main(String[] args) {
		final String SERVER_ADDRESS = args[0];
		try {
			InetAddress hostName = InetAddress.getByName(SERVER_ADDRESS);
			Socket socket = new Socket(hostName, PORT);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Connecté au serveur Puissance 4.");
			//in.readLine();
			Controleur ctrl= new Controleur();
			while (true)
			{
				try{
					if (in.readLine().equals("j1"))
					{
						System.out.println("j1");
						while(!ctrl.aGagner())
						{
							int ss = ctrl.getInt();
							int sv = ctrl.getInt();
							while (ss == sv) { sv = ctrl.getInt(); 
								try
								{
									Thread.sleep(50);
								} catch (InterruptedException e)
								{
									System.out.println(e);
								}}
							out.println(sv);
							ctrl.setEnabled(false);
							int coupAutre = Integer.parseInt(in.readLine());
							ctrl.setEnabled(true);
							ctrl.placerJeton(coupAutre);
							ctrl.majIHM();
							}
					}
					else
					{
						System.out.println("j2");
						while (!ctrl.aGagner())
						{
							ctrl.setEnabled(false);
							int coupAutre = Integer.parseInt(in.readLine());
							ctrl.setEnabled(true);
							ctrl.placerJeton(coupAutre);
							ctrl.majIHM();
							int ss = ctrl.getInt();
							int sv = ctrl.getInt();
							while (ss == sv)
							{
								sv = ctrl.getInt();
								try
								{
									Thread.sleep(500);
								} catch (InterruptedException e)
								{
									System.out.println(e);
								}
							}
							out.println(sv);
						}
					}
				} catch(IOException e) { 
					System.out.println("Jeu Terminé"); break;}
			}
/*
			while (true) 
			{
				try
				{ 
					JFrame serverResponse = (JFrame) in.readObject();
				}catch(IOException | ClassNotFoundException e) { 
					System.out.println("Jeu Terminé"); break;}
			}*/
		} catch (IOException e) { e.printStackTrace();}
	}

}
