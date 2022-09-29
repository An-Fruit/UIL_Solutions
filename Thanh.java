import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Thanh{
    char[][] mat;
    int[][] shadow;
    boolean found;

        public void go(int r, int c, int steps){
            if(r < mat.length && r >= 0 && c < mat[r].length && c > 0 && mat[r][c] != '#' && steps < shadow[r][c]){

            }
        }
        public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("thanh.dat"));
        int t = f.nextInt();
        while(t-- > 0) {
            int i = f.nextInt();
            int j = f.nextInt();
            mat = new char[i][j];
            shadow = new int[i][j];
            for(int[] n : shadow){
                Arrays.fill(n,Integer.MAX_VALUE);
            }
            for(int k = 0; k < i; k++){
                mat[k] = f.next().toCharArray();
            }
            for(int k = 0; k < mat.length; k++){
                for(int l = 0; l < mat[k].length; l++){
                    if(mat[k][l] == 'T'){
                        go(k,l,0);
                    }
                }
            }
        }
        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Thanh().run();
    }
}



