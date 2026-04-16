import java.util.Scanner;
import java.util.Date;
class Block{
public String data;
public String prevBlock;
public Date timeStamp;
public Block(String data, String prevBlock){
this.data = data;
this.prevBlock = prevBlock;
this.timeStamp = new Date();
}
public void display(){
System.out.println("block data: "+data);
System.out.println("previous block: "+prevBlock);
System.out.println("time stamp: "+timeStamp);
}
}
public class Main{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
System.out.print("enter data: ");
String data = sc.nextLine();
Block b = new Block(data, "None");
System.out.println("\nblock created\n");
b.display();
sc.close();
}
}