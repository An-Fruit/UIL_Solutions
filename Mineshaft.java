import java.util.*;
import java.io.*;

public class Mineshaft {
	char[][][] mat;
	
	public void go(int z, int x, int y) {
		if(z > 0 && z < mat.length && x > 0 && x < mat[z].length && y > 0 && y < mat[z][x].length && mat[z][x][y] != '#') {
			
		}
	}
	
	public void run() throws Exception{
		Scanner f = new Scanner(System.in);
		int t = f.nextInt();
		while(t-- > 0) {
			int floor = f.nextInt();
			int r = f.nextInt();
			int c = f.nextInt();
			int durability = f.nextInt();
			mat = new char[floor][r][c];
			for(int i = 0; i < mat.length; i++) {
				for(int j = 0; j < mat[i].length; j++) {
					mat[i][j] = f.next().toCharArray();
				}
			}
			
			int[] startloc = new int[3];
			for(int i = 0; i < mat.length; i++) {
				for(int j = 0; j < mat[i].length; j++) {
					for(int k = 0; k < mat[i][j].length; k++) {
						if(mat[i][j][k] == 'S') {
							startloc[0] = i;
							startloc[1] = j;
							startloc[2] = k;
							break;
						}
					}
				}
			}
			f.close();
			
		}
	}
	public static void main(String[] args) throws Exception{
		new Mineshaft().run();
	}
}
