//Classe client du projet

package ServeurClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Client {

	private Socket com;
	private String cliAdresse;
	
	public Client(String adr, int port) throws IOException{
		cliAdresse=adr;
		com = new Socket(cliAdresse, port);

	}
	
	public void envoiInfo(String mes) throws IOException{
		mes+=" Test \n";
		DataOutputStream output = new DataOutputStream(com.getOutputStream());
		output.writeBytes(mes);
	}
	
	public String litInfo() throws IOException{
		String chaineRecu;
		//Message du client
		BufferedReader in = new BufferedReader(new InputStreamReader(com.getInputStream()));
		if(in.ready()){
			chaineRecu=in.readLine();
			return(chaineRecu);
		}
		else {return "";}
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
				// TEST \\
		/*try{
			
			Point p = new Point();
			System.out.println("POINT ENTRE : "+p.toString());
			Client cli1 = new Client("127.0.0.1", 10666);
			Client cli2 = new Client("127.0.0.2", 10667);
			cli1.envoiInfo(p.toString());
			System.out.println("CLIENT 1 A ENVOYE SON MESSAGE (YEAH)");
			String s ;
			while (1>0) {
				s = cli2.litInfo() ;
				if (!s.equals("")) {
					System.out.println("CLIENT 2 A RECUE SON MESSAGE (YEAH)");
					System.out.println("MESSAGE RECU DANS CLIENT 2 : "+s);

					p = new Point(s) ;
					System.out.println("POINT SORTIE : " + p.toString()) ;
				}
			}
			
			//Client cli2 = new Client(10666);
		}
		catch(Exception e){System.out.println("main client"+e);}*/
	}

}