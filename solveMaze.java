import java.util.ArrayList;
public class solveMaze{
	
	
	public static int rowNum, colNum;
	public static ArrayList<Integer> moves= new ArrayList<Integer>(); 
	public static boolean[][] tested;
	public static int[] solutions;
	
	public static int[] solve (Labyrinth l)
	{
		rowNum= l.rows(); 
		colNum=l.cols();
		
		tested= new boolean[rowNum][colNum]; 
		
		findSafeMove(0,0,l);
		solutions= new int[moves.size()];
		for (int n=0; n<moves.size();n++) 
			solutions[n]=moves.get(n); 
		return solutions; 
		
	}
	
	public static boolean findSafeMove(int row, int col, Labyrinth l)
	{
		//base case, returns true if the maze has been solved
		if ((row==rowNum-1)&&(col==colNum-1))
			return true;
		for (int n=0;n<4;n++){
			//checks up 
			if  (isSafe(row-1,col,l))
			{
				moves.add(0); 
				tested[row-1][col]=true; 
				if (findSafeMove(row-1,col,l)) 
					return true; 
				else 
					goBack(row-1,col); 
			}
			
			//checking square down 
			if  (isSafe(row+1,col,l))
			{
				moves.add(1); 
				tested[row+1][col]=true; 
				if (findSafeMove(row+1,col,l))
					return true; 
				else 
					goBack(row+1,col); 
			}
			
			//checking square to the left
			if  (isSafe(row,col-1,l))
			{
				moves.add(2); 
				tested[row][col-1]=true; 
				if (findSafeMove(row,col-1,l))
					return true; 
				else 
					goBack(row,col-1); 
			}
			//checking square to the right
			if  (isSafe(row,col+1,l))
			{
				moves.add(3); 
				tested[row][col+1]=true; 
				if (findSafeMove(row,col+1,l))
					return true; 
				else 
					goBack(row,col+1); 
			}
		}
		return false;
	}
	
	public static void goBack(int x,int y)
	{
		moves.remove(moves.size()-1);
		tested[x][y]= false; 
	}
	
	
	public static boolean isSafe(int x, int y, Labyrinth l) 
	{
		if ((l.isValid(x,y)&&l.isStone(x,y))&&(!hasBeentested(x,y))) 
			return true; 
		return false;
	} 
	
	public static boolean hasBeentested(int x, int y) 
	{
		return tested[x][y]; 
	}
	
	public static void main (String[] args){
		int myRows, myCols; 
		myRows=5; 
		myCols=5;
		Labyrinth l= new Labyrinth(myRows,myCols); 
		for (int n=0;n<myRows;n++)
		{
			for(int x=0;x<myCols;x++)
				System.out.print(" "+l.isStone(n,x)+" ");
			System.out.println();
		}
		solve(l);
		System.out.println(solutions[0]);
		System.out.println(l.solves(solutions)); 
	}
}