import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class BestDayofSales{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/BestDayofSales.dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            int[] week = new int[7];
            int max = Integer.MIN_VALUE;
            int ind = 0;
            for(int i = 0; i < 7; i++){
                int temp = f.nextInt();
                if(temp > max){
                    max = temp;
                    ind = i;
                }

            }
            String[] days = "SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY".split(" ");
            System.out.println(days[ind]);
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new BestDayofSales().run();
    }
}



