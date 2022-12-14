import java.util.*;
import java.io.*;

public class Mineshaft {
	char[][][] mat;
	int[][][] shadow;
	boolean found, used;
	int durability, seconds;
	public void go(int z, int x, int y, int steps) {
		boolean used = false;
		int time = 0;
		if(z >= 0 && z < mat.length && x >= 0 && x < mat[z].length && y >= 0 && y < mat[z][x].length &&
				(mat[z][x][y] != '#' || (mat[z][x][y] == '%' && durability == 0)) && steps < shadow[z][x][y]) {
			shadow[z][x][y] = steps;
			if(mat[z][x][y] == 'E') {
				found = true;
				seconds = shadow[z][x][y];
				return;
			}
			if(mat[z][x][y] == '%') {
				used = true;
				time += 3;
				durability--;
			}
			mat[z][x][y] = '#';

			//down a floor
			go(z + 1, x, y, steps + 2 + time);
			//up a floor
			go(z - 1, x, y, steps + 3 + time);
			//four cardinal directions
			go(z, x + 1, y, steps + 1 + time);
			go(z, x - 1, y, steps + 1 + time);
			go(z, x, y + 1, steps + 1 + time);
			go(z, x, y - 1, steps + 1 + time);
			if(used) durability++;
			mat[z][x][y] = '.';
		}
	}
	
	public void run() throws Exception{
		Scanner f = new Scanner(new File("mineshaft.dat"));
		//Scanner f = new Scanner(System.in);
		int t = f.nextInt();
		while(t-- > 0) {
			found = false;
			int floor = f.nextInt();
			int r = f.nextInt();
			int c = f.nextInt();
			durability = f.nextInt();
			seconds = 0;
			mat = new char[floor][r][c];
			shadow = new int[floor][r][c];
			for(int i = 0; i < mat.length; i++) {
				for(int j = 0; j < mat[i].length; j++) {
					mat[i][j] = f.next().toCharArray();
				}
			}
			
			
			
			for(int i = 0; i < shadow.length; i++) {
				for(int j = 0; j < shadow[i].length; j++) {
					for(int[] k : shadow[i]){
						Arrays.fill(k, Integer.MAX_VALUE);
					}
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
			go(startloc[0], startloc[1], startloc[2], 0);
			if(found) System.out.println(seconds + " SECONDS");
			else System.out.println("DEAD");
			
		}
		
		f.close();
	}
	public static void main(String[] args) throws Exception{
		new Mineshaft().run();
	}
}
