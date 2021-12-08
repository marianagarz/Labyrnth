import java.util.ArrayList;
public class solveMaze{
	
	//need some help with how big everything should be 
	int rowNum, collNum;
	boolean[][] tested= new boolean[rowNum][collNum]; 
	
	ArrayList<Integer> moves= new ArrayList<Integer>(); 
	
	
	public int[] solve (Labrynth l)
	{
		findSafeMove(x,y,l);//SOS what shoud my x and ys b? seems like they cant b zero ciz wouldnt that get messed up?
		int[] solutions= new int[moves.size()];
		for (n=0, n<moves.size(),n--) //am i chopping stuff off or about to run into a huge problem here?
			solutions[n]=moves.get(n); //correct syntax??
		return solutions; 
		
	}
	
	public static boolean findSafeMove(int x, int y, Labrynth l)
	{
		//base case. QUESTION: how to know when you are at the end
		if ((x==rowNum-1)&&(y==collNum-1))
			return true;
		for (n=4;n>0;n--){
			//checking square up-- QUESTION: is this nessesary? feels to me like you  wouldn't need to check up when solving a maze...
			if  (isSafe(x,y-1,l)
			{
				moves.add(0); 
				tested[x][y-1]=true; 
				//ik you need to test the next one--> do you need to  check everysingle next one- in all directions? or no
				if (findSafeMove(x,y-1,l)
					return true; 
				else 
					goBack(x,y-1); 
			}
			
			//checking square down 
			if  (isSafe(x,y+1,l)
			{
				moves.add(1); 
				tested[x][y+1]=true; 
				if (findSafeMove(x,y+1,l)
					return true; 
				else 
					goBack(x,y+1); 
			}
			
			//checking square to the left
			if  (isSafe(x-1,y,l)
			{
				moves.add(2); 
				tested[x-1][y]=true; 
				if (findSafeMove(x-1,y,l)
					return true; 
				else 
					goBack(x-1,y); 
			}
			//checking square to the right
			if  (isSafe(x-1,y,l)
			{
				moves.add(3); 
				tested[x+1][y]=true; 
				if (findSafeMove(x+1,y,l)
					return true; 
				else 
					goBack(x+1,y); 
			}
		}
	}
	
	public static void goBack(int x,int y)
	{
		moves.remove(moves.size());
		tested[x][y]= false; 
	}
	
	
	public boolean isSafe(int x, int y, Labrynth l) 
	{
		if ((l.isValid(x,y)&&l.isStone(x,y))&&(!hasBeentested(x,y)))
			return true; 
	} 
	
	public boolean hasBeentested(int x, int y) 
	{
		return tested[x][y]; 
	}
}