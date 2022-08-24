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

public class RomanNumerals{

	static int[] vals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	static String[] roman = "M CM D CD C XC L XL X IX V IV I".split(" ");

    public String convert(int n){
		String ret = "";
		for(int i = 0; i < vals.length; i++){
			while(n >= vals[i]){
				n -= vals[i];
				ret += roman[i];
			}
		}
		return ret;
    }

    public void run() throws Exception{

	    //Scanner f = new Scanner(new File("RomanNumerals.dat"));
	    Scanner f = new Scanner(System.in);

		while(f.hasNext()){
			int n = f.nextInt();
			if(n == 0) break;
			System.out.println(convert(n));
		}

        f.close();

	}
	public static void main(String[] args) throws Exception{

		new RomanNumerals().run();

	}
}

