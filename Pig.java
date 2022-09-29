import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Pig{
    char[][] mat;

    int[][] shadow;
    boolean found;
    public void go(int r, int c, int steps){
        if(r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != 'R'  && steps < shadow[r][c]){
            char temp = mat[r][c];
            shadow[r][c] = steps;
            if(mat[r][c] == 'H'){
                found = true;
                return;
            }
            mat[r][c] = 'R';
            shadow[r][c] = steps;
            go(r + 1, c, steps + 1);
            go(r - 1, c, steps + 1);
            go(r, c + 1, steps + 1);
            go(r, c - 1, steps + 1);
            mat[r][c] = temp;
        }
    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/pig.dat"));
        int cases = f.nextInt();
        while(cases-- > 0){
            int r = f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            found = false;
            for(int i = 0; i<mat.length; i++){
                mat[i] = f.next().toCharArray();
            }
            for(int[] n : shadow){
                Arrays.fill(n, Integer.MAX_VALUE);
            }
            boolean got = false;
            for(int i = 0; i < mat.length; i++){
                if(got) break;
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 'D'){
                        go(i,j,0);
                        got = true;
                        break;
                    }
                }
            }
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    if (mat[i][j] == 'H') {

                        if(shadow[i][j] > 7) found = false;
                    }
                }
            }
            if(found) System.out.println("BACON");
            else System.out.println("PIG ON THE RUN");

        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Pig().run();
    }
}



