import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Ana{

    public void run() throws Exception{
        Scanner f = new Scanner(in);
        //Scanner f = new Scanner(new File("Ana.dat"));
        for(int i = 1; i <= 12; i++){
            System.out.println(i + "*" + i + "=" + (i*i));
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Ana().run();
    }
}



