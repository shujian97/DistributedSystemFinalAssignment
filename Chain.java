import java.io.*;
import java.util.Date;
import java.util.*;

public class Chain implements Serializable{
	private static int index=0;
	private String name;
	private String previous_hash;
	private String hash;
	private String message;
	private long timeStamp;
//	private static final Random RANDOM = new SecureRandom();

	public Chain(){

	}

	// My constructor with all arguments
	public Chain(String name,String previous_hash, String message ) {
		this.name = name;
		this.index = index;
		this.previous_hash = previous_hash;
		this.hash = getSaltString(previous_hash);
		this.message = message;
		this.timeStamp = new Date().getTime();
	}
	public String getSaltString(String saltchars) {
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 18) { // length of the random string.
				int index = rnd.nextInt(16);
				salt.append(saltchars.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;

		}
//	public static bytes getNextSalt() {
//			byte[] salt = new byte[16];
//			RANDOM.nextBytes(salt);
//			return salt;
//		}
//		 public static String hash(char[] password, byte[] salt) {
//				PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
//				Arrays.fill(password, Character.MIN_VALUE);
//				try {
//					SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//					return new String(skf.generateSecret(spec).getEncoded());
//				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//					throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
//				} finally {
//					spec.clearPassword();
//				}
//			}
  // Getters and Setters
	public static int getIndex() {
		return index;
	}

	public void addIndex(){
		index++;
	}

	public void setPrevious_hash(String previous_hash) {
		this.previous_hash = previous_hash;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPrevious_hash(){
			return this.previous_hash;
	}
	public String getHash(){
		return this.hash;
	}

	public String getMessage(){
			return this.message;
	}
	@Override
	public String toString(){
		return "index: "+index+" timeStamp: "+timeStamp+"  name: "+name+" previous_hash: "+previous_hash+" message: "+message;
	}

}