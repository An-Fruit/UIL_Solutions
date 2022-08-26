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

public class AlphabetSpiral{
    int size;
    char[][] mat;
    static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public void generateMatrix(int n){
        int top = 0;
        int left = 0;
        int right = size - 1;
        int bottom = size - 1;
        int loc = 0;
        boolean run = true;

        while(run){

            if (left > right || loc >= n || loc >= 26)
                break;

            // go left to right
            for (int j = left; j <= right; j++){
                if(loc >= n || loc >= 26){
                    run = false;
                    break;
                }
                mat[bottom][j] = alphabet[loc++];
            }

            bottom--;

            if (top > bottom || loc >= n || loc >= 26)
                break;

            // go up
            for (int j = bottom; j >= top; j--){
                if(loc >= n || loc >= 26){
                    run = false;
                    break;
                }
                mat[j][right] = alphabet[loc++];
            }

            right--;

            if (left > right || loc >= n || loc >= 26)
                break;

            // go right to left
            for (int j = right; j >= left; j--) {
                if(loc >= n || loc >= 26){
                    run = false;
                    break;
                }
                mat[top][j] = alphabet[loc++];
            }
            top++;

            if (top > bottom || loc >= n || loc >= 26)
                break;

            // go down
            for (int j = top; j <= bottom; j++) {
                if(loc >= n || loc >= 26){
                    run = false;
                    break;
                }
                mat[j][left] = alphabet[loc++];
            }
            left++;

        }
    }

	public void run() throws Exception{

	    //Scanner f = new Scanner(new File("AlphabetSpiral.dat"));
	    Scanner f = new Scanner(System.in);

        while(f.hasNext()){

            int temp = f.nextInt();
            if(temp == 0) break;
            size = 0;
            if(temp <= 4){
                size = 2;
            }
            else if(temp <= 9){
                size = 3;
            }
            else if(temp <= 16){
                size = 4;
            }
            else if(temp <= 25){
                size = 5;
            }
            else if(temp <= 36){
                size = 6;
            }
            mat = new char[size][size];
            for(char[] c : mat){
                Arrays.fill(c, '*');
            }

            generateMatrix(temp);
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

        f.close();

	}
	public static void main(String[] args) throws Exception{

	new AlphabetSpiral().run();

	}
}
