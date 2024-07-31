package Bank;
import java.util.Scanner;
 class Customer
{
	String Name;
	int accountnumber;
	Scanner sc=new Scanner(System.in);
	public void getAccountNumber(){
		System.out.println("Enter Account Number");
		int accountnumber=sc.nextInt();
		
		
	}
	public void getname() {
		System.out.println("Enter Your Name");
		String name=sc.nextLine();
	}
}
 
 
 class Account extends Customer{

}
public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
