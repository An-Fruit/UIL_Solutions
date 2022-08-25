import java.util.*;
import java.io.*;

public class Rats {

	char[][] mat;
	int[][] shadow;
	boolean found;
	public void go(int r, int c, int steps) {
		if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c] != '#' && steps < shadow[r][c]) {
			if(mat[r][c] == 'C') {
				found = true;
				return;
			}
			mat[r][c] = '#';
			shadow[r][c] = steps;
			
			go(r + 1, c, steps + 1);
			go(r - 1, c, steps + 1);
			go(r, c + 1, steps + 1);
			go(r, c - 1, steps + 1);
			
			mat[r][c] = '.';
		}
	}
	
	public void run() throws Exception{
		Scanner f = new Scanner(System.in);
		
		int t = f.nextInt();
		f.nextLine();
		while(t-- > 0) {
			int size = f.nextInt();
			mat = new char[size][size];
			for(int i = 0; i < mat.length; i++) {
				for(int j = 0; j < mat[i].length; j++) {
					mat[i][j] = f.next().charAt(0);
				}
			}
		}
		
		f.close();
	}
	public static void main(String[] args) throws Exception{
		new Rats().run();
	}
	
}
