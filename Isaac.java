import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Isaac{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("isaac.dat"));
        int t = f.nextInt();
        while(t-- > 0){
            ArrayList<String> list = new ArrayList<>();
            int n  = f.nextInt();
            while(n-- > 0) list.add(f.next());
            int max = 0;
            for(int i =0 ; i < list.size(); i++){
                if(list.get(0).length() > max) max = list.get(0).length();
            }
            int columns = 60/max;

        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Isaac().run();
    }
}



