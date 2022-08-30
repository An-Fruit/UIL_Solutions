import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Grinch{
    char[][] mat;
    int[][] shadow;
    ArrayList<Integer> X;
    ArrayList<Integer> Y;
    int fndcnt, total;

    public void go(int r, int c, int steps){
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c] != '#' && steps < shadow[r][c]) {
            char temp = mat[r][c];
            mat[r][c]= '#';
            shadow[r][c] = steps;
            if (temp == 'T') {
                fndcnt++;
                mat[r][c] = '.';
                temp = '.';
            }
            go(r + 1, c, steps + 1);
            go(r - 1, c, steps + 1);
            go(r, c + 1, steps + 1);
            go(r, c - 1, steps + 1);

            mat[r][c] = temp;
        }
    }
    public void run() throws Exception{
        //Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("grinch.dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            int r = f.nextInt();
            int c = f.nextInt();
            fndcnt = 0;
            X = new ArrayList<>();
            Y = new ArrayList<>();
            int xloc = -1;
            int yloc = -1;
            total = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            for(int[] a : shadow){
                Arrays.fill(a, Integer.MAX_VALUE);
            }
            for(int i = 0; i < r; i++){
                mat[i] = f.next().toCharArray();
            }
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 'R'){
                        xloc = i;
                        yloc = j;
                    }
                    if (mat[i][j] == 'T') {
                        X.add(i);
                        Y.add(j);
                    }
                }
            }

            go(xloc, yloc,0);
            System.out.println("Delivered: " + fndcnt);
            if(fndcnt < total) System.out.println("Get Grinched!");
            else{
                int sum = 0;
                int maxdist = 0;
                ArrayList<Integer> times = new ArrayList<>();
                for(int i = 0; i < X.size(); i++){
                    times.add(shadow[X.get(i)][Y.get(i)]);
                }
                Collections.sort(times);
                maxdist = times.get(times.size() - 1);
                times.remove(times.size() - 1);
                for(int a : times) sum += 2 * a;
                sum += maxdist;

                System.out.println(sum);

            }



        }

        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Grinch().run();
    }
}




