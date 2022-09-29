import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Eagles{
    char[][] mat;
    int[][] shadow;
    int xloc;
    int yloc;
    boolean found;
    public void go(int r, int c, int steps){
        if(r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != 'B'
                && mat[r][c] != 'M' && steps < shadow[r][c]){
            shadow[r][c] = steps;
            char temp = mat[r][c];
            if(temp == 'E'){
                return;
            }
            mat[r][c] = 'M';
            //down & right
            go(r + 1, c + 1, steps + 1);
            //down
            go(r + 1, c, steps + 1);
            //down & left
            go(r + 1, c - 1, steps + 1);
            //right
            go(r, c + 1, steps + 1);
            //left
            go(r, c - 1, steps + 1);
            //up & right
            go(r - 1, c + 1, steps + 1);
            //up
            go(r - 1, c, steps + 1);
            //up & left
            go(r - 1, c - 1, steps + 1);
            mat[r][c] = temp;
        }
    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/eagles.dat"));
        int t = f.nextInt();
        while(t-- > 0){
            int startx = f.nextInt() - 1;
            int starty = f.nextInt() - 1;
            mat = new char[10][10];
            shadow = new int[10][10];
            for(int[] i : shadow){
                Arrays.fill(i, Integer.MAX_VALUE);
            }
            for(int i = 0; i < mat.length; i++){
                mat[i] = f.next().toCharArray();
            }
            go(startx, starty, 0);
            ArrayList<Integer> es = new ArrayList<>();
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 'E') es.add(shadow[i][j]);
                }
            }
            Collections.sort(es);
            System.out.println(es.get(0));

        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Eagles().run();
    }
}

