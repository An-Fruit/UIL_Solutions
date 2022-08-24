import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class DiagSum{
    static int[][] mat = new int[][] {
        {5, 7, 3, 16},
        {6, 10, 21, 12},
        {8, 4, 20, 15},
        {2, 9, 11, 14}
    };

    public int sum(int n){
        int sum = n;
        int xloc = -1;
        int yloc = -1;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == n){
                    xloc = i;
                    yloc = j;
                    break;
                }
            }
        }
        int templocx = xloc;
        int templocy = yloc;
        //down to the right
        while(templocx + 1 < 4 && templocy + 1 < 4){
            sum += mat[templocx + 1][templocy + 1];
            //System.out.print(mat[templocx + 1][templocy + 1] + " ");
            templocx++;
            templocy++;
        }
        templocx = xloc;
        templocy = yloc;
        //down to the left
        while(templocx + 1 < 4 && templocy - 1 >= 0){
            sum += mat[templocx + 1][templocy - 1];
            //System.out.print(mat[templocx + 1][templocy - 1] + " ");
            templocx++;
            templocy--;
        }
        templocx = xloc;
        templocy = yloc;
        //up & right
        while(templocx - 1 >= 0 && templocy + 1 < 4){
            sum += mat[templocx - 1][templocy + 1];
            //System.out.print(mat[templocx - 1][templocy + 1] + " ");
            templocx--;
            templocy++;
        }
        templocx = xloc;
        templocy = yloc;
        //up & left
        while(templocx - 1 >= 0 && templocy - 1 >= 0){
            sum += mat[templocx - 1][templocy - 1];
            //System.out.print(mat[templocx - 1][templocy - 1] + " ");
            templocx--;
            templocy--;
        }
        return sum;
    }

	public void run() throws Exception{

	    //Scanner f = new Scanner(new File("DiagSum.dat"));
	    Scanner f = new Scanner(System.in);

        while(f.hasNext()){
            int n = f.nextInt();
            if(n == 0) break;
            System.out.println("DIAGONAL SUM = " + sum(n));
        }

        f.close();

	}
	public static void main(String[] args) throws Exception{

	    new DiagSum().run();

	}
}
