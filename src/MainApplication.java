import java.util.Scanner;


public class MainApplication {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(){
		
		System.out.println("Are you a user or a staff? (1 for user, 2 for staff)");
		int value;
		while (true){
			value = sc.nextInt();
			if (value!=1 || value!=2)
				System.out.println("Not a valid input! Please enter another input: ");
			else
				break;
		}
		
		if (value==1)
			//call user application
			System.out.println();
		
		else
			//call staff application
			System.out.println();
			
		sc.close();
	}
}
