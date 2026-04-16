import java.security.MessageDigest;
public class Main {
public static String sha256(String data) throws Exception {
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(data.getBytes());
StringBuilder hexString = new StringBuilder();
for (byte b : hash) {
String hex = Integer.toHexString(0xff & b);
if (hex.length() == 1) {
hexString.append('0');
}
hexString.append(hex);
}
return hexString.toString();
}
public static void main(String[] args) throws Exception {
String data = "Hello";
int nonce = 0;
int difficulty = 4;
String target = new String(new char[difficulty]).replace('\0', '0');
String hash = "";
while (true) {
String input = data + nonce;
hash = sha256(input);
if (hash.substring(0, difficulty).equals(target)) {
break;
}
nonce++;
}
System.out.println("Data: " + data);
System.out.println("Nonce: " + nonce);
System.out.println("Hash: " + hash);
System.out.println("Difficulty: " + difficulty);
}
}