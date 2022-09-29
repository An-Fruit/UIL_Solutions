import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class AbsoluteDifference{
    int n;
    public int absdif(int a, int b, int c, int d){
        if(a == b && b == c && c == d){
            n = a;
            return 0;
        }
        else{
            return 1 + absdif((int)(Math.abs(b - a)), (int)(Math.abs(c - b)), (int)(Math.abs(d - c)), (int)(Math.abs(a - d)));
        }
    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/absolute.dat"));
        int t = f.nextInt();
        while(t-- > 0){
            n = 0;
            int a = f.nextInt();
            int b = f.nextInt();
            int c = f.nextInt();
            int d = f.nextInt();
            System.out.println(absdif(a,b,c,d) + " " + n);
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new AbsoluteDifference().run();
    }
}



