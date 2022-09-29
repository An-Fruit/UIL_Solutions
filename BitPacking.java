import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class BitPacking{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/bitpacking.dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            String num = Integer.toString(f.nextInt(), 2);
            String fin = "";
            for(int i = num.length(); i < 32; i++){
                fin += "0";
            }
            fin+=num;
            //System.out.println(fin);
            int temp1 = Integer.parseInt(fin.substring(9,14),2);
            //System.out.println(temp1);
            char type = (char)(temp1 + 64);
            int sub = Integer.parseInt(fin.substring(14,20),2);
            //System.out.println(sub);
            char subtype;
            if(sub < 27) subtype = (char) (64 + sub);
            else if(sub < 51) subtype = (char) (96 + sub % 26);
            else subtype = (char)(47 + sub %50);
            int inv = Integer.parseInt(fin.substring(20,32),2);

            System.out.printf("Type: %c | Sub Type: %c | Inventory: %d%n",type, subtype, inv);
        }

        f.close();
    }
    public static void main(String[] args) throws Exception{
        new BitPacking().run();
    }
}



