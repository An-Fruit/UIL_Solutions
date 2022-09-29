import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Testing{

    public void run() throws Exception{
        Scanner f = new Scanner(in);
        //Scanner f = new Scanner(new File("Testing.dat"));

        char[][] c = new char[4][4];
        char[] cats = new char[]{'C', 'A', 'T', 'S'};
        for(int i = 0; i < c.length; i++){
            c[0][i] = cats[i];
        }
        for(int i = 0; i < 4; i++){
            c[i][0] = cats[i];
        }
        for(char[] cs : c){
            System.out.println(Arrays.toString(cs));
        }
        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Testing().run();
    }
}



