import java.io.*;

import java.util.*;

import java.net.*;

import java.security.*;

import javax.crypto.*;


public class Server{



  public static void main(String args[]){

      try{

		ServerSocket ss = new ServerSocket(12345,3);

		  while (true){

            System.out.println("Waitng for first client");
			

			Socket s1 = ss.accept();
			System.out.println("Connected");

			System.out.println("Waitng for second client");
			Socket s2 = ss.accept();
			System.out.println("Connected");
			
			System.out.println("Waitng for third client");
			Socket s3 = ss.accept();
			System.out.println("Connected");

            new Thread(new ServerThread(s1, s2, s3)).start();

        }
      }catch(Exception e){

        System.out.println(e);

      }

  }

}
class ServerThread extends Thread{
		Socket s1;
		Socket s2;
		Socket s3;


    public ServerThread(Socket s1, Socket s2, Socket s3){

        this.s1 = s1;

        this.s2 = s2;
	 	
		this.s3 = s3;

    }



    public void run(){

      try{
		Item i1 = new Item(1,"Java book",1000);
		Item i2 = new Item(2,"C++ book",1000);
		Item i3 = new Item(3,"Data structure and algorithems",2000);
		
		ObjectOutputStream oos1 = new ObjectOutputStream(s1.getOutputStream());
		ObjectOutputStream oos2 = new ObjectOutputStream(s2.getOutputStream());
		ObjectOutputStream oos3 = new ObjectOutputStream(s3.getOutputStream());
//		oos1.writeObject(i1);
//		oos1.writeObject(i2);
//		oos1.writeObject(i3);
//		oos2.writeObject(i1);
//		oos2.writeObject(i2);
//		oos2.writeObject(i3);
//		oos3.writeObject(i1);
//		oos3.writeObject(i2);
//		oos3.writeObject(i3);
		System.out.println(i1.toString());
		System.out.println(i2.toString());
		System.out.println(i3.toString());
		Scanner sc1= new Scanner(s1.getInputStream());
		Scanner sc2= new Scanner(s2.getInputStream());
		Scanner sc3= new Scanner(s3.getInputStream());
		ObjectInputStream ois1 = new ObjectInputStream(s1.getInputStream());
		
		
		ObjectInputStream ois2 = new ObjectInputStream(s2.getInputStream());
		ObjectInputStream ois3 = new ObjectInputStream(s3.getInputStream());

//		Chain h2 = (Chain)ois2.readObject();
//		ObjectOutputStream oos1 = new ObjectOutputStream(s1.getOutputStream());
//		oos1.writeObject(h2);
//		ObjectOutputStream oos2 = new ObjectOutputStream(s2.getOutputStream());
//		oos2.writeObject(h1);
//		byte [] salt = new byte [16];
//		SecureRandom rand=new SecureRandom();
//		rand.nextBytes(salt); // store together with hash in DB 
//		KeySpec spec = new PBEKeySpec(
//		"password".toCharArray(), salt, 65536, 128); SecretKeyFactory f =
//		SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//		byte[] hash = f.generateSecret(spec).getEncoded(); 
//		Base64.Encoder enc = Base64.getEncoder();
//		System.out.printf("salt:␣%s%n", enc.encodeToString(salt));
//		System.out.printf("hash:␣%s%n",enc.encodeToString(hash));
		while(true){
			if(sc1.hasNext()){
				String line = sc1.nextLine();
				System.out.println(line);
				
				Chain h1 = (Chain)ois1.readObject();
//				int l = Integer.parseInt(line);
//				switch (l) {
//					case 1:
//						h1.setMessage("Bought 'Java book', it cost 1000.")
//						break;
//					case 2:
//						h1.setMessage("Bought 'C++ book', it cost 1000.")
//						break;
//					case 3:
//						h1.setMessage("Bought 'Data structure and algorithems', it cost 2000.")
//						break;
//					default:
//						h1.setMessage("invalid sentence")
//						break;
//				}
				
				oos1.writeObject(h1);
				oos2.writeObject(h1);
				oos3.writeObject(h1);

			}
			if(sc2.hasNext()){
				String line = sc2.nextLine();
				System.out.println(line);
				Chain h2 = (Chain)ois2.readObject();
//				int l = Integer.parseInt(line);
//				System.out.println(l);
//				switch (l) {
//					case 1:
//						h2.setMessage("Bought 'Java book', it cost 1000.")
//						break;
//					case 2:
//						h2.setMessage("Bought 'C++ book', it cost 1000.");
//						break;
//					case 3:
//						h2.setMessage("Bought 'Data structure and algorithems', it cost 2000.");
//						break;
//					default:
//						h2.setMessage("invalid sentence");
//						break;
//				}
				oos1.writeObject(h2);
				oos2.writeObject(h2);
				oos3.writeObject(h2);

			}
			if(sc3.hasNext()){
				String line = sc3.nextLine();
				System.out.println(line);
				Chain h3 = (Chain)ois3.readObject();
//				int l = Integer.parseInt(line);
//				switch (l) {
//					case 1:
//						h3.setMessage("Bought 'Java book', it cost 1000.");
//						break;
//					case 2:
//						h3.setMessage("Bought 'C++ book', it cost 1000.");
//						break;
//					case 3:
//						h3.setMessage("Bought 'Data structure and algorithems', it cost 2000.");
//						break;
//					default:
//						h3.setMessage("invalid sentence");
//						break;
//				}
				oos1.writeObject(h3);
				oos2.writeObject(h3);
				oos3.writeObject(h3);

			}
				
		}
	  }catch(Exception e){

        System.out.println(e);

      }
	}
}
