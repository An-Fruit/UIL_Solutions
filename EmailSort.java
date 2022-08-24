import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class EmailSort{


	public void run() throws Exception{

	    //Scanner f = new Scanner(new File("EmailSort.dat"));
	    Scanner f = new Scanner(System.in);
        ArrayList<Address> emails = new ArrayList<>();
        int t = f.nextInt();
        while(t-- > 0){
            String[] line = f.next().split("@");
            emails.add(new Address(line[0], line[1]));
        }
        f.close();

        Collections.sort(emails, (a, b) -> {
            if(a.svcprov.equals(b.svcprov)) return a.name.compareTo(b.name);
            return a.svcprov.compareTo(b.svcprov);
        });
        for(Address a : emails){
            System.out.println(a);
        }

	}

    class Address{
        String name, svcprov;
        public Address(String n, String s){
            name = n;
            svcprov = s;
        }
        public String toString(){
            return name + "@" + svcprov;
        }
    }
	public static void main(String[] args) throws Exception{

	new EmailSort().run();

	}
}
