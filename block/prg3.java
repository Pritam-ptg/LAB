import java.security.MessageDigest;
import java.util.Date;
class Block {
public String data;
public long timeStamp;
public String hash;
public Block(String data) {
this.data = data;
this.timeStamp = new Date().getTime();
this.hash = calculateHash();
}
public String calculateHash() {
try {
String input = data + timeStamp;
MessageDigest md = MessageDigest.getInstance("SHA-256");
byte[] hashBytes = md.digest(input.getBytes());
StringBuilder hexString = new StringBuilder();
for (byte b : hashBytes) {
String hex = Integer.toHexString(0xff & b);
if (hex.length() == 1) {
hexString.append('0');
}
hexString.append(hex);
}
return hexString.toString();
}
catch (Exception e) {
throw new RuntimeException(e);
}
}
}
public class Main {
public static void main(String[] args) {
Block block = new Block("Transaction: A pays B 100");
System.out.println("Block Data: " + block.data);
System.out.println("Timestamp: " + block.timeStamp);
System.out.println("Generated Hash: " + block.hash);
}
}