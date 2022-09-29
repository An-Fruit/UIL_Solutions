import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Fatimah{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/fatimah.dat"));
        int cases = f.nextInt();
        for(int i = 1; i <= cases; i++){
            int m = f.nextInt();
            int n = f.nextInt();
            for(int j = 0; j < m; j++){
                f.next();
            }
            for(int j = 0; j < n; j++){
                f.next();
                f.next();
            }
            System.out.printf("Case #%1$d: %2$d%n", i, m - n);
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Fatimah().run();
    }
}



