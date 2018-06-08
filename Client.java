import java.util.*;
import java.io.*;
import java.net.*;
import java.security.*;

class Client
{
	
		public static void main(String[] args)
				throws Exception
		{
			Person p = new Person();
			Scanner scan = new Scanner(System.in);
			System.out.println("What is your name?");
			String name = scan.next();
			p.setName(name);
			p.toString();
			Socket s = new Socket("localhost", 12345);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			int index = 0;
//			oos.writeObject(h);
//			Chain h = new Chain();
			Scanner sc = new Scanner(s.getInputStream());

			Thread t1 = new ClientToSrvThread(p,pw,oos);
			Thread t2 = new SrvToClientThread(p,ois);

				t1.start();
				t2.start();

				t1.join();
				t2.join();
			
		}
	}

	class ClientToSrvThread extends Thread
	{
		Person p;
		PrintWriter pw;
		ObjectOutputStream oos;
		Chain c = new Chain();

		ClientToSrvThread(Person p,PrintWriter pw,ObjectOutputStream oos)
		{
			this.p = p;
			this.pw = pw;
			this.oos = oos;
		}

		public void run()
		{
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				try{
					if(p.getLastChain()==null){
//						SecureRandom random = new SecureRandom();
//						byte[] bytes = new byte[16];
//						random.nextBytes(bytes);
							String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
							StringBuilder salt = new StringBuilder();
							Random rnd = new Random();
							while (salt.length() < 18) { // length of the random string.
								int index = (int) (rnd.nextFloat() * SALTCHARS.length());
								salt.append(SALTCHARS.charAt(index));
							}
							String saltStr = salt.toString();
						c = new Chain(p.getName(),saltStr, line);
						System.out.println(c);
				}else{
					c = new Chain(p.getName(),p.getLastChain().getHash(), line);
				}
//				System.out.println(c);
					pw.println(c.getMessage());
					pw.flush();
					oos.writeObject(c);
				
				}catch(Exception e){

					System.out.println(e);

				}

			}
		}
	}

	class SrvToClientThread extends Thread
	{
		ObjectInputStream ois;
		Chain i= new Chain();
		Person p;

		SrvToClientThread(Person p,ObjectInputStream ois)
		{
			this.p = p;
			this.ois = ois;
		}

		public void run()
		{
			while (true)
			try{
				i = (Chain)ois.readObject();
				i.addIndex();
//				index = i.getIndex();
				p.addChain(i);
				p.toString();
				System.out.println(i);
				System.out.flush();
			}catch(Exception e){

				System.out.println(e);

			}
			//System.out.println("dead!");
		}			

		
}