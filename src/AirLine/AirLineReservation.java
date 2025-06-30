package AirLine;
import java.util.*;

class Flight{
	int flight_number;
	String origin,destination;
	int totalseats,availableseats;
	public Flight(int flight_number,String origin,String destination,int totalseats) {
		this.flight_number=flight_number;
		this.origin=origin;
		this.destination=destination;
		this.totalseats=totalseats;
		this.availableseats=totalseats;
	}
}

class User{
	String username;
	String password;
	boolean isAdmin;
	public User(String username,String password,boolean isAdmin) {
		this.username=username;
		this.password=password;
		this.isAdmin=isAdmin;
	}
}

class Ticket{
	static int counter=1000;
	int ticketId;
	String username;
	Flight flight;
	public Ticket(String username,Flight flight){
		this.ticketId=counter++;
		this.username=username;
		this.flight=flight;
	}
}

public class AirLineReservation {
	static Scanner sc=new Scanner(System.in);
	static List<Flight> flights=new ArrayList<>();
	static Map<String,User> users=new HashMap<>();
	static Map<Integer,Ticket> tickets=new HashMap<>();
	public static void main(String[] args) {
		System.out.println("*********************AirLine Reservation System********************");
		System.out.println("1.Login\n2.Register\n3.Exit");
		initializeFlights();
		initializeAdmin();
		while(true) {
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1 -> login();
				case 2 -> register();
				case 3 -> {
					System.out.println("Exiting Console"); System.exit(0);
				}
			}
		}
	}
	
	static void initializeFlights() {
		flights.add(new Flight(1,"Coimbatore","Madurai",10));
		flights.add(new Flight(2,"Chennai","Bangalore",5));
	}
	
	static void initializeAdmin() {
		users.put("admin", new User("admin","1234",true));
	}
	
	static void login(){
		System.out.println("Enter the User Name:");
		String username=sc.nextLine();
		User user=users.get(username);
		System.out.println("Enter your Password:");
		String password=sc.nextLine();
		if(user!=null&&user.password.equals(password)) {
			System.out.println("Login Successfull");
		}
		else System.out.println("Invalid Credentials");
	}
	
	static void register() {
		System.out.println("Enter the UserName:");
		String username=sc.nextLine();
		if(users.containsKey(username)) {
			System.out.println("Username Already Exists");
			return;
		}
		System.out.println("Enter the Password");
		String password=sc.nextLine();
		users.put(username, new User(username,password,false));
		System.out.println("Registration Successfull");
	}
	
}
