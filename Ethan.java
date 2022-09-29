import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Ethan{
    int[][] mat;

    public double calcdistance(int r1, int c1, int r2, int c2){
        double xdist = Math.abs(r1 - r2);
        double ydist = Math.abs(c1 - c2);
        return Math.sqrt(Math.pow(xdist,2) + Math.pow(ydist, 2));
    }


    public double distancesum(int startx, int starty){
        int d = mat.length;
        double sum = 0;
        int[] prev = new int[]{startx, starty};
        for(int k = 2; k <= mat.length * mat.length; k++){
            boolean found = false;
            for(int i = 0; i < mat.length; i++){
                if(found) break;
                for(int j = 0; j < mat.length; j++){
                    if(mat[i][j] == k){
                        sum += calcdistance(prev[0], prev[1], i, j);
                        prev[0] = i;
                        prev[1] = j;
                        found = true;
                        break;
                    }
                }
            }
        }
        return sum;
    }
    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/ethan.dat"));
        int cases = f.nextInt();
        int[] startloc = new int[2];
        for(int i = 1; i <= cases; i++){
            int d = f.nextInt();
            mat = new int[d][d];
            for(int j = 0; j < mat.length; j++){
                for(int k = 0; k < mat[j].length; k++){
                   int temp = f.nextInt();
                    mat[j][k] = temp;
                    if(temp == 1){
                        startloc[0] = j;
                        startloc[1] = k;
                    }
                }
            }
            System.out.printf("Case #%1$d distance: %2$.4f%n", i, distancesum(startloc[0], startloc[1]));

        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Ethan().run();
    }
}



