import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Bryan{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/bryan.dat"));
        int cases = f.nextInt();
        for(int i = 0; i < cases; i++){
            int t = f.nextInt();
            int sum = 0;
            for(int j = 0; j < t; j++){
                f.next();
                sum += f.nextInt();
            }
            System.out.print("Case #" + (i + 1) + ": ");
            if(sum == 0) System.out.println("Phew, broke even!");
            if(sum > 0) System.out.println("Wow, Bryan saved $" + sum);
            if(sum < 0) System.out.println("Oh no! Bryan had to borrow $" + (-1 * sum));

        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Bryan().run();
    }
}



