package hackerrank;

import java.util.Scanner;

public class Bomberman {

	private static final char BOMB = 'O';
	private static final char NO_BOMB = '.';

	private static char[][] grid = null;

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int iterations = scan.nextInt();

		grid = new char[rows][cols];
		scan.nextLine();
		for (int  i  = 0; i < rows; i++){
			fillGrid(i, scan.nextLine());
		}
		scan.close();
		//0Put bombs
		//1Do nothing
		//2fillBombs
		//3explode planted @ 0
		//4fillBombs 
		//5explode planted @ 2
		//6fillBombs 
		//7explode planted @ 4

		char[][] volatileGrid = copyGrid(grid);
		char[][] lessVolGrid = null;
		if (iterations == 1)iterations = 1;
		else if (iterations % 2 == 0)iterations  = 2;
		else if (iterations % 4 == 1)iterations  = 5;
		else iterations = 3;
		
		if (iterations > 1){
			for (int j = 2; j <= iterations; j++){ 
				if (j % 2 == 1){
					explodeGrid(volatileGrid);
					volatileGrid = lessVolGrid;
				}else { 
					volatileGrid = copyGrid(grid);
					lessVolGrid = fillBombs();
				}
				System.out.println("Iteration =======>"+j);
				printGrid();
			}
			
		}
	
		printGrid();
	}


	private static char[][] copyGrid(char[][] input){
		char[][] copy = new char[input.length][input[0].length];
		for (int i = 0 ;i < input.length; i++){
			System.arraycopy(input[i], 0, copy[i], 0, input[i].length);
		}
		return copy;
	}

	private static char[][] fillBombs(){

		char[][] newTickingGrid = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++){
			for (int k = 0; k < grid[i].length; k++){
				if (grid[i][k] == NO_BOMB){
					grid[i][k] = BOMB;
					newTickingGrid[i][k] = BOMB;
				}else {
					newTickingGrid[i][k] = NO_BOMB;
				}
			}
		}
		return newTickingGrid;
	}

	private static void explodeGrid(char[][] previousGrid){
		for (int i = 0; i < previousGrid.length; i++){
			for (int k = 0; k < previousGrid[i].length; k++){
				if (previousGrid[i][k] == BOMB){
					explodeCell(i,k);
				}
			}
		}

	}

	private static void explodeCell(int i, int j){
		grid[i][j] = NO_BOMB;
		if (i>0)grid[i-1][j] = NO_BOMB;
		if (i<grid.length-1)grid[i+1][j] = NO_BOMB;
		if (j>0)grid[i][j-1] = NO_BOMB;
		if (j<grid[i].length-1)grid[i][j+1] = NO_BOMB;

	}

	private static void printGrid(){
		StringBuilder row = new StringBuilder();
		for (int i = 0; i < grid.length; i++){
			row.setLength(0);
			for (int k = 0; k < grid[i].length; k++){
				row.append(grid[i][k]);
			}
			System.out.println(row.toString());   
		}
	}


	private static void fillGrid(int row, String input){
		for (int i = 0 ;i < input.length(); i++){
			grid[row][i] = input.charAt(i);
		}
	}
}