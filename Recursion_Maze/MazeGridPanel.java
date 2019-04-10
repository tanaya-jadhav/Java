import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JPanel;

public class MazeGridPanel extends JPanel{
	private int rows;
	private int cols;
	private Cell[][] maze;



	// extra credit
	public void genDFSMaze() {
		boolean[][] visited;
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		stack.push(start);
	}

	//homework
	public void solveMaze() {
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		start.setBackground(Color.GREEN);
		Cell finish = maze[rows-1][cols-1];
		finish.setBackground(Color.RED);
		stack.push(start);

		while(stack.peek() != finish && stack.isEmpty() == false) {
			Cell current = stack.peek();
//			String cur_pos = Integer.toString(current.row) + Integer.toString(current.col);
//			System.out.println(cur_pos);
//			System.out.println(current.row);
//			System.out.println(current.col);
			current.setBackground(Color.GREEN);
			int cur_row = current.row;
			int cur_col = current.col;
//			System.out.println(current.northWall);
//			System.out.println(current.southWall);
//			System.out.println(current.eastWall);
//			System.out.println(current.westWall);
			if (cur_row != 0 && current.northWall == false && visited(cur_row-1, cur_col)==false){
				Cell north = maze[cur_row-1][cur_col];
//				System.out.println("in if statement");
//				stack.push(north);
//				north.setBackground(Color.GREEN);
			}
//			System.out.println(visited(cur_row+1, cur_col));
			else if (current.southWall == false && visited(cur_row+1, cur_col) == false){
//				System.out.println("in else if");
				Cell south = maze[cur_row+1][cur_col];
				stack.push(south);
				south.setBackground(Color.GREEN);
//				System.out.println(stack.peek().row);
//				System.out.println(stack.peek().col);
			}
			else if (current.eastWall == false && visited(cur_row, cur_col+1) == false){
//				System.out.println("in east else if");
				Cell east = maze[cur_row][cur_col+1];
				stack.push(east);
				east.setBackground(Color.GREEN);
//				System.out.println(stack.peek().row);
//				System.out.println(stack.peek().col);
			}
//			else if (cur_col != 0 && current.westWall == false && visited(cur_row, cur_col-1) == false){
//				System.out.println("in west else if");
//				Cell west = maze[cur_row][cur_col-1];
//				stack.push(west)
//			}
			else {
				current = stack.pop();
//				System.out.println("popping");
			}
//			else break;
//
//			maze[current.row ][current.col]
		}

	}


	

	


	public boolean visited(int row, int col) {
		Cell c = maze[row][col];
		Color status = c.getBackground();
		if(status.equals(Color.WHITE)  || status.equals(Color.RED)  ) {
			return false;
		}


		return true;


	}


	public void genNWMaze() {
		
		for(int row = 0; row  < rows; row++) {
			for(int col = 0; col < cols; col++) {

				if(row == 0 && col ==0) {
					continue;
				}

				else if(row ==0) {
					maze[row][col].westWall = false;
					maze[row][col-1].eastWall = false;
				} else if(col == 0) {
					maze[row][col].northWall = false;
					maze[row-1][col].southWall = false;
				}else {
					boolean north = Math.random()  < 0.5;
					if(north ) {
						maze[row][col].northWall = false;
						maze[row-1][col].southWall = false;
					} else {  // remove west
						maze[row][col].westWall = false;
						maze[row][col-1].eastWall = false;
					}
					maze[row][col].repaint();
				}
			}
		}
		this.repaint();
		
	}

	public MazeGridPanel(int rows, int cols) {
		this.setPreferredSize(new Dimension(800,800));
		this.rows = rows;
		this.cols = cols;
		this.setLayout(new GridLayout(rows,cols));
		this.maze =  new Cell[rows][cols];
		for(int row = 0 ; row  < rows ; row++) {
			for(int col = 0; col < cols; col++) {

				maze[row][col] = new Cell(row,col);

				this.add(maze[row][col]);
			}

		}


		this.genNWMaze();
		this.solveMaze();
		
	}




}
