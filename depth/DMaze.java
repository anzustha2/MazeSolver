//Anju Shrestha
//cs304
//package projects.depth;
import java.io.*;         
import java.util.Scanner;

//This is your STACK!
//import collections.list.generics.Stack;


public class DMaze
{
   Display display;
   Scanner kbd = new Scanner(System.in);
   
   Stack<Cell> stack = new Stack<>();

	protected final char SPACE = ' ';
	protected final char WALL = '#';
	protected final char FOOTPRINT = '+';
	protected final char START = 'S';
	protected final char END = 'E';
	
	protected int numRows;        
	protected int numCols;        

	protected int startRow;
	protected int startCol;
	protected int endRow;
	protected int endCol;

	protected int numSolutions;
		    
	protected PrintWriter output;
	protected BufferedReader input;

	protected Cell [][] grid;  
   
   public void setDisplay(Display d)
   {
      display = d;
   }
	public DMaze(String inputFileName) throws IOException
	{
      FileReader f = new FileReader(inputFileName);
      input = new BufferedReader(f);      
	}

	public boolean getMaze() throws IOException
	{
		int i, j;
      grid = FileInput.getNextGrid(input);
		
      numRows = grid.length;
		
		if (numRows == 0)
			return false;
		else
		{
			numCols = grid[0].length;
			return true;
		}
	}

//***************************************************************************	
	public String toString()
	{
		String mazeString = "\n";

      for( int i=0; i<grid.length; i++ )
      {
         for( int j=0; j<grid[i].length; j++ )
         {
            if( grid[i][j].visited != true || grid[i][j].type == START )
            {
               System.out.print( grid[i][j].type );
            }
            else
               System.out.print( FOOTPRINT );
         }   
         System.out.println();
      
      }
		return mazeString;
	}
//***************************************************************************	
   public int solveMaze(boolean recurse)
	{
		int i, j = 0;
		numSolutions = 0;
			
		// Get start and end coordinates and set visited array to false.
		for (i = 0; i < numRows; i++)
      {
			for (j = 0; j < numCols; j++)
			{
				grid[i][j].visited = false;
				if (grid[i][j].type == START)
				{
					startRow = i;
					startCol = j;
				}
				else if (grid[i][j].type == END)
				{
					endRow = i;
					endCol = j;
				}
			}
      }
      /* solve maze */
      if( recurse )
      {
   		visitCell(startRow, startCol);
      }
      else
      {
         stack.push(grid[startRow][startCol]);
      
         while( !stack.isEmpty() )
         {
            Cell cell = stack.pop();
   		   if (cell.y == endRow && cell.x == endCol)
      		{
      			System.out.print("\nSolution found!\n");
               numSolutions++;
      			System.out.println(this);
      			System.out.print("Hit \"Enter\" to continue...");
      			kbd.nextLine();
      		}
            else if( cell.visited != true && cell.type != WALL )
      		{
               sleep(100);
               cell.visited = true;
               stack.push(grid[cell.y-1][cell.x]);
               stack.push(grid[cell.y][cell.y+1]);
               stack.push(grid[cell.y+1][cell.x]);
               stack.push(grid[cell.y][cell.x-1]);
               //cell.visited = false;
               //put your code here
               // add the four neighbors to the stack
               // neighbors of cell are in our grid.
               sleep(100); //sleep a bit more
      		}
         }
      }
		return numSolutions;
	}	

   // making our solution sleep every loop allows the graphics thread to update
   public void sleep(int t)
   {
         try
         {
            Thread.sleep(t);
         }
         catch(InterruptedException ie)
         {
            System.out.println(ie);
         }
   }
//***************************************************************************	
   /* this is our recursive solution */	
   private void visitCell(int i, int j)
	{
		if (i == endRow && j == endCol)
		{
         System.out.print("\nSolution found!\n");
          numSolutions++;
          System.out.println(this);
      	 System.out.print("Hit \"Enter\" to continue...");
      	 kbd.nextLine();
          return;
         
		}
      else if( grid[i][j].visited == true ) 
      {
         return;
      }
      else if( grid[i][j].type == WALL ) 
      {
         return;
      }
		else
		{
         grid[i][j].visited = true;
         sleep(100);
         visitCell(i-1, j); //up
         visitCell(i, j+1); //right
          visitCell(i+1, j); //down
          visitCell(i, j-1); //left
          grid[i][j].visited = false;


         //visited = true;
         //sleep a bit
         //visit neighbors
         //
		}
	}	// 	private void visitCell(int i, int j)
}