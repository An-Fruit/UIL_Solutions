import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Moose{
    char[][] mat;
    boolean[][] shadow;
    int cnt;
    public void go(int r, int c){
        if(r < mat.length && r >= 0 && c <mat[r].length && c >= 0 && mat[r][c] == 'M'){
            mat[r][c] = '.';
            cnt++;
            go(r + 1, c);
            go(r - 1, c);
            go(r, c + 1);
            go(r, c - 1);
        }

    }

    public void run() throws Exception{
        //Scanner f = new Scanner(in);
        Scanner f = new Scanner(new File("data/moose.dat"));
        int cases = f.nextInt();

        while(cases-- > 0){
            mat = new char[10][10];
            ArrayList<Integer> size = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                mat[i] = f.next().toCharArray();
            }
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    if(mat[i][j] == 'M'){
                        cnt = 0;
                        go(i,j);
                        size.add(cnt);
                    }
                }
            }
            Collections.sort(size);
            Collections.reverse(size);
            System.out.println(size.get(0));
        }


        f.close();
    }
    public static void main(String[] args) throws Exception{
        new Moose().run();
    }
}



