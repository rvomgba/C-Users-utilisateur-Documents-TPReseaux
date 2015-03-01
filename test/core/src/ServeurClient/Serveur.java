//Classe serveur du projet

package ServeurClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import java.net.*;
/*
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
*/

public class Serveur {

		private ServerSocket servSock1;
		private ServerSocket servSock2;
		private final int port1 = 10666;
		private final int port2 = 10667;
		private Socket sockCli1;
		private Socket sockCli2;
		
		public Serveur() throws IOException{
			servSock1 = new ServerSocket(port1);
			servSock2 = new ServerSocket(port2);
			System.out.println("Attente accept");
			sockCli1 = servSock1.accept();
			System.out.println("client 1 ok");
			sockCli2 = servSock2.accept();
			System.out.println("client 2 ok");
		}		

		public String litInfo1() throws IOException{
			String chaineRecu;
			//Message du client
			BufferedReader in = new BufferedReader(new InputStreamReader(sockCli1.getInputStream()));
			chaineRecu=in.readLine();
			return(chaineRecu);
		}
		
		public String litInfo2() throws IOException{
			String chaineRecu;
			//Message du client
			BufferedReader in = new BufferedReader(new InputStreamReader(sockCli2.getInputStream()));
			chaineRecu=in.readLine();
			return(chaineRecu);
		}

		public void envoiInfo1(String mes) throws IOException{
			mes+=" Test \n";
			//Le client envoie un message
			System.out.println("Client 1 : \n");
			//BufferedReader in = new BufferedReader(new InputStreamReader(comm.getInputStream()));
			DataOutputStream output = new DataOutputStream(sockCli1.getOutputStream());
			output.writeBytes(mes);
		}
		
		public void envoiInfo2(String mes) throws IOException{
			mes+=" Test \n";
			//Le client envoie un message
			System.out.println("Client 2 : \n");
			//BufferedReader in = new BufferedReader(new InputStreamReader(comm.getInputStream()));
			DataOutputStream output = new DataOutputStream(sockCli2.getOutputStream());
			output.writeBytes(mes);
		}
	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try{
			Serveur srv = new Serveur();
			String mes1 ;
			while (1>0) {
				//System.out.println("boucle");
				mes1 = srv.litInfo1() ;
				//System.out.println("info 1 lue");
				// On attend un message de Cli1 ou de Cli2
				if (!mes1.equals("")) {
					//System.out.println("message reçu du Client 1 : "+mes1);
					srv.envoiInfo2(mes1);
				}
			}
			//System.out.println(InetAddress.getLocalHost());
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
