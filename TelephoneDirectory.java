//?
import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class TelephoneDirectory {

	private ArrayDictionary <Name, String> dictionary;
	
	public TelephoneDirectory() {
		dictionary =new ArrayDictionary<>();
	}
	
	public void readFile(Scanner data) {
		while(data.hasNext()) {
			Name name = new Name(data.next(), data.next());
			dictionary.add(name,  data.next());
		}
		data.close();
	}
	
	public void display() {
		Iterator<Name> nameIterator = dictionary.getKeyIterator();
		Iterator<String> phoneIterator = dictionary.getValueIterator();
		
		while(nameIterator.hasNext()) {
			System.out.println(nameIterator.next() + " " + phoneIterator.next());
		}
	}
	
	public String getPhoneNumber(String fullName) {
		return fullName;
	}
	
}
