import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class ThirteenJewels{
    char[][] mat;
    int[][] shadow;
    int cnt, xloc, yloc;

    public void find(int r, int c, int steps){
        if(r < mat.length && r >= 0 && c < mat[r].length && c > 0 && mat[r][c] != '#' && mat[r][c] != 'E' && steps < shadow[r][c]){
            char temp = mat[r][c];
            shadow[r][c] = steps;
            mat[r][c] = '#';
            if(temp == '*'){
                temp = '.';
                cnt++;
            }
            if(cnt >= 13){
                xloc =r;
                yloc = c;
                mat[r][c] = temp;
                return;
            }


            find(r + 1, c, steps + 1);
            find(r - 1, c, steps + 1);
            find(r, c + 1, steps + 1);
            find(r, c - 1, steps + 1);
            mat[r][c] = temp;

        }
    }
    public void gotoend(int r, int c, int steps){
        if(r < mat.length && r >= 0 && c < mat[r].length && c >= 0 && mat[r][c] != '#' && steps < shadow[r][c]){
            char temp = mat[r][c];
            mat[r][c] = '#';
            shadow[r][c] = steps;
            if(temp == 'E'){
                mat[r][c] = temp;
                return;
            }


            gotoend(r + 1, c, steps + 1);
            gotoend(r - 1, c, steps + 1);
            gotoend(r, c + 1, steps + 1);
            gotoend(r, c - 1, steps + 1);
        }
    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/thirteen.dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            mat = new char[10][10];
            shadow = new int[10][10];
            xloc = 0;
            yloc = 0;
            for(int[] n : shadow) Arrays.fill(n, Integer.MAX_VALUE);
            for(int i = 0; i < 10; i++){
                mat[i] = f.next().toCharArray();
            }
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 'S') find(i,j,0);
                }
            }
            int findtime = shadow[xloc][yloc];
            System.out.println(findtime);
            for(int [] n : shadow){
                System.out.println(Arrays.toString(n));
            }
            gotoend(xloc, yloc, 0);
            for(int i = 0; i< mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 'E'){
                        System.out.println(findtime + shadow[i][j]);
                        break;
                    }
                }
            }

        }

        f.close();
    }
    public static void main(String[] args) throws Exception{
        new ThirteenJewels().run();
    }
}



