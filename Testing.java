import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		
		TelephoneDirectory td = new TelephoneDirectory();
		
		Scanner sc = new Scanner(newFile("filename here"));

		td.readFile(sc);
		td.display();
		
		//prompt 
		Scanner input = new Scanner(System.in);
		String fullName = input.nextLine();
		System.out.println("The phone is " + td.getPhoneNumber(fullName));
		
		/*
		Name name = new Name(fullName);
		return dictionary.getValue();
		*/
	}

}
