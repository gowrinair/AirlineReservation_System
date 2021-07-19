package Week2_Programs;

import java.util.Scanner;

public class AirlineReservation {
	int persons;
	String name[];
	int age[];
	long phNo;
	int flightNo;
	double totalCost;
	char coupon;
	
	
	
	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getAge() {
		return age;
	}

	public void setAge(int[] age) {
		this.age = age;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public char getCoupon() {
		return coupon;
	}

	public void setCoupon(char coupon) {
		this.coupon = coupon;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	Scanner sc=new Scanner(System.in);
	
	void airline() {
		
		System.out.println("----Welcome to AirExpress------\n");
		char ch;
		do {
			System.out.println("Choose any option: \n\n 1.Top Flight Routes\n 2.Give your details\n 3.Calculate Ticket Cost\n 4.Know More About AirExpress\n 5.Baggage Information");
			int choice=sc.nextInt();
		
			switch(choice) {
			
				case 1: System.out.println("SpiceJet : DELHI (20:05) ----> MUMBAI (22:05)  [4655/- per person]");	
						System.out.println();
						System.out.println("VISTARA  : MUMBAI (20:55)----> BANGLORE (22:40) [9266/- per person] ");
						System.out.println();
						System.out.println("Air India: DELHI (20:50) ----> GOA (12:45) [9000/- per person]");
						System.out.println();
						System.out.println("(*) Promo Code: EASEFLY to get flat Rs.350 OFF on any flights");
						break;
			
						
				case 2: System.out.println("Give your details for flight booking!");
						detailsForBooking();//details like flightNumber,PhoneNumber,Name,Age
						break;
						
						
				case 3: CalcTicketCost();// Calculating the ticket cost after getting details
						ticketGeneration(); //printing of ticket
						break;
				
						
				case 4: System.out.println("\r\n"
						+ "AirExpress is the flag carrier airline of India.\nHeadquartered at New Delhi.\nIt is owned by AirExpress Limited.\nA government-owned enterprise.");
						break;
						
				case 5: System.out.println("15 Kgs per passenger Check-in Baggage included for your selected flight ");
				        break;
				        
				default:System.out.println("Invalid Choice!");
						break;
		
			}System.out.println();
			System.out.println("Do you want to continue? : Y or N");
			 ch = sc.next().charAt(0); 
		} 
		while(ch=='Y'||ch=='y');
		System.out.println("THANK YOU FOR CHOOSING US!!");
	}
	
 void detailsForBooking() {
	System.out.println("Choose your flight: ");
	System.out.println("101. SpiceJet : DELHI (20:05) ----> MUMBAI (22:05)  [4655/- per person]");	
	System.out.println();
	System.out.println("201. VISTARA  : MUMBAI (20:55)----> BANGLORE (22:40) [9266/- per person]");
	System.out.println();
	System.out.println("301 .Air India: DELHI (20:50) ----> GOA (12:45) [9000/- per person]");
	int flightNo=sc.nextInt();
	setFlightNo(flightNo);
	
	if(flightNo==101||flightNo==201||flightNo==301)
	{
		System.out.println("Enter a phone number for booking: ");
		phNo=sc.nextLong();
		
		System.out.println("Enter the no.of passengers: ");
		persons=sc.nextInt();
		
		String name[]=new String[persons];
		int age[]=new int[persons];
		setPersons(persons);
		
		for(int i=0;i<persons;i++) {
			System.out.println("Enter the name of "+(i+1)+" passenger: ");
			name[i]=sc.next();
			setName(name);
			System.out.println("Enter the age: ");
			age[i]=sc.nextInt();
			setAge(age);
		
		}
		System.out.println("Dou want to avail coupon code? Y or N");
		coupon=sc.next().charAt(0);
	
 	}else 
 		System.out.println("Enter valid flight number");
	
 }
 


double CalcTicketCost() {
	switch(flightNo) {
	case 101: if(coupon=='Y'||coupon=='y')
				  totalCost=persons*(4655-350);
	 		  else
	 			  totalCost=persons*4655; 
	          break;
	case 201: if(coupon=='Y'||coupon=='y')
				  totalCost=persons*(9266-350);
	 		  else
	 			  totalCost=persons*9266;
			  break;
	case 301: if(coupon=='Y'||coupon=='y')
				  totalCost=persons*(9000-350);
			  else
				  totalCost=persons*9000; 
			  break; 
	
	}
	return totalCost;
	
}

void ticketGeneration() {
	System.out.println("Download your flight tickets now!");
	System.out.println();
	System.out.println("Contact Number: "+phNo);
	System.out.println("No.of Passengers: "+persons);
	for(int j=0;j<persons;j++) {
		System.out.print("Name of "+(j+1)+" person: "+name[j]);
		System.out.println("  Age: "+age[j]);
	}
	if(flightNo==101) {
		System.out.println("Departure: DELHI at 20:05\nArrival: MUMBAI at 22:05");
		System.out.println("Total Cost for your flight: "+totalCost);}
	
	if(flightNo==201) {
		System.out.println("Departure: MUMBAI at 20:55\tArrival: BANGLORE at 22:40");
		System.out.println("Total Cost for your flight: "+totalCost);}
	
	if(flightNo==301) {
		System.out.println("Departure: DELHI at 20:50\nArrival: GOA at 12:45");
		System.out.println("Total Cost for your flight: "+totalCost);}
}

}
