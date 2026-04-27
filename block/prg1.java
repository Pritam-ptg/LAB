import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class Main{
    public static String genHash(String data) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(data.getBytes());
        StringBuilder hexStr = new StringBuilder();
        for(byte b: hashBytes){
            String hex = Integer.toHexString(0xff&b);
            if(hex.length()==1)
                hexStr.append('0');
                hexStr.append(hex);
        }
        return hexStr.toString();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter data: ");
        String data = sc.nextLine();
        try{
            String hash = genHash(data);
            System.out.println("SHA-256 hash: "+hash);
        }
        catch(NoSuchAlgorithmException e){
            System.out.println("hashing algorithm not found");
        }
        sc.close();
    }
}