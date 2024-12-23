package ticTacToe;
// this class creates the game board in a 2D array with rows and columns. 
//It contains the methods for checking a win or a draw 

import java.awt.*;


public class Board {
	// grid line width
	public static final int GRID_WIDTH = 8;
	// grid line half width
	public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;
	//2D array of ROWS-by-COLS Cell instances
	Cell [][] cells;
	
	// Constructor to create the game board 
	public Board() {
		
	 //to initialise the cells array using ROWS and COLS constants from GameMain
		cells = new Cell [GameMain.ROWS][GameMain.COLS];
		
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	
// IsDraw boolean method to check if the game is a draw. Check if any of the cells content are Player.Empty. If they are it is not a draw. Method returns false if not a draw, true if it is a draw.  it is not a draw and the method game continues.
	public boolean isDraw() {
		 for (int row = 0; row < GameMain.ROWS; row++) {
			 for (int col = 0; col < GameMain.COLS; col++) {
				 if  (cells [row][col].content==(Player.Empty)) {
					 return false;
				 }
			 }
		 }
		 return true;
	}
		
	
	// Has won method to find if a player has won a game with  3 in a row, 3 in a column or 3 in a diagonal. Return true if the current player "thePlayer" has won after making their move
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		
		// check if player has 3-in-that-row
		if(cells[playerRow][0].content == thePlayer && cells[playerRow][1].content == thePlayer && cells[playerRow][2].content == thePlayer )
			return true; 
		
		 // Check if the player has 3 in the first playerCol.
		if(cells[0][0].content == thePlayer && cells[1][0].content == thePlayer && cells[2][0].content == thePlayer )
			return true;
		
		 // Check if the player has 3 in the second playerCol.
		if(cells[0][1].content == thePlayer && cells[1][1].content == thePlayer && cells[2][1].content == thePlayer )
			return true;
		
		// Check if the player has 3 in the third playerCol.
		if(cells[0][2].content == thePlayer && cells[1][2].content == thePlayer && cells[2][2].content == thePlayer )
			return true;
			
		// check if player has 3-in-the-diagonal from top left to bottom right cell
		if( cells[0][0].content == thePlayer && cells[1][1].content == thePlayer && cells[2][2].content == thePlayer)
			return true;
		
		// Check if player has 3 in the diagonal from bottom left hand to top right hand cell
		if( cells[2][0].content == thePlayer && cells[1][1].content == thePlayer && cells[0][2].content == thePlayer)
			return true;
	
		//if there is no winner, keep playing
		return false;
	}
	
	
	 //Draws the grid (rows then columns) using constant sizes, then call on the
	// Cells to paint themselves into the grid
	 
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int row = 1; row < GameMain.ROWS; ++row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GRID_WIDTH_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int col = 1; col < GameMain.COLS; ++col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * col - GRID_WIDTH_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int row = 0; row < GameMain.ROWS; ++row) {          
			for (int col = 0; col < GameMain.COLS; ++col) {  
				cells[row][col].paint(g);
			}
		}
	}


	



}
