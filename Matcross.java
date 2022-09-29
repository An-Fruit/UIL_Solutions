import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Matcross{

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/matcross.dat"));
        int cases = f.nextInt();
        char[][] mat;
        while(cases-- > 0){
            int r = f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            for(char[] cs : mat){
                Arrays.fill(cs, '#');
            }
            for(int i = 0; i < mat.length; i++){
                if(i != 0 && i != mat.length - 1){
                    for(int j = 0; j < mat[i].length; j++){
                        if(j != 0 && j != mat[i].length - 1){
                            if(i % 2 == 1){
                                if(j % 2 == 0) mat[i][j] = ' ';
                            }
                            else{
                                if(j % 2 == 1) mat[i][j] = ' ';
                            }
                        }

                    }
                }
            }

            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat.length; j++){
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Matcross().run();
    }
}



