import java.util.Scanner;

public class UserApplication {
	private static Scanner sc = new Scanner(System.in);
	User user = new User(); //User class not available yet
	
	public static void main() {
		
		System.out.println("Please enter your details below");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Age: ");
		String age = sc.next();
		int choice = 0;
		
		while (choice != 8) {
			System.out.println("1. Search movie");
			System.out.println("2. List movie");
			System.out.println("3. View movie details");
			System.out.println("4. Check seat availability");
			System.out.println("5. Book and purchase ticket");
			System.out.println("6. View booking history");
			System.out.println("7. List the Top 5 movies");
			System.out.println("8. Quit");
			System.out.println("Please select one of the choices above: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: //search movie
				break;
				
			case 2: //list movie
				break;
				
			case 3: //select movie, list the details
				break;
				
			case 4: //choose cineplex; choose movie; choose time; show: array list of seats
				break;
				
			case 5: //choose cineplex; choose movie; choose time; choose seat; show: tickets, seats, amount to be paid; approve?
				break;
				
			case 6: //list all movies booked, show: transaction id, movie, cinema, cineplex, date/time, tickets, seats, total amount
				break;
				
			case 7: 
				System.out.println("Sort by ticket sales or ratings? 1 for ticket sales, 2 for ratings");
				int inputTop5 = sc.nextInt();
				if (inputTop5!=1 || inputTop5!=2)
					System.out.println("Not a valid input! Please enter another input: ");
				else if (inputTop5 == 1){
					//list the top 5 movie by ticket sales
				}
				else if (inputTop5 == 2){
					//list the top 5 movie by ratings
				}	
				break;
			
			case 8:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Invalid input. Please enter another input: ");
				break;
			}
		}
		
		sc.close();
	}

}
