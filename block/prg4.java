import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
public class Main{
public static String sha256(String input){
try {
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
catch (Exception e){
throw new RuntimeException(e);
}
}
public static String getMerkleRoot(List<String> transactions) {
List<String> currentLevel = new ArrayList<>();
for (String tx : transactions)
currentLevel.add(sha256(tx));
while (currentLevel.size() > 1){
List<String> nextLevel = new ArrayList<>();
for (int i = 0; i < currentLevel.size(); i += 2) {
String left = currentLevel.get(i);
String right;
if (i + 1 < currentLevel.size())
right = currentLevel.get(i + 1);
else
right = left;
nextLevel.add(sha256(left + right));
}
currentLevel = nextLevel;
}
return currentLevel.get(0);
}
public static void main(String[] args) {
List<String> transactions = new ArrayList<>();
transactions.add("Transaction1");
transactions.add("Transaction2");
transactions.add("Transaction3");
transactions.add("Transaction4");
String merkleRoot = getMerkleRoot(transactions);
System.out.println("Merkle Root: " + merkleRoot);
}
}