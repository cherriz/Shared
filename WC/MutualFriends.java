import java.util.*;

public class MutualFriends {
	
	public static class Pair
	{
		int x, y;
		public Pair(int _x, int _y)
		{
			x = _x; y = _y;
		}
	}

	private static ArrayList<ArrayList<Pair>> answers =  new ArrayList<ArrayList<Pair>>();
	private static boolean done = false;
	private static int N = 3;
	private static int[][] numMutualFriends;
	private static boolean[][] friendship;
	
	private static boolean matchCondition()
	{
		for (int i = 0; i <N; i++)
		{
			for (int j = 0; j < i; j++)
			{
				int numFriends = 0;
				for (int k = 0; k < N; k++)
				{
					if (k != i && k != j && friendship[i][k] && friendship[j][k])
						numFriends++;
				}
				if (numFriends != numMutualFriends[i][j])
					return false;
			}
		}
		return true;
	}
	
	private static void solve(int x, int y) {
		
		if (done) return;
		
		if (y >= x)
		{
			solve(x+1, 0);
			return;
		}
		if (x > N-1)
		{
			if (!matchCondition()) return;
			
			ArrayList<Pair> ans = new ArrayList<>();
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < i; j++) 
					if (friendship[i][j]) 
						ans.add(new Pair(i, j));
			answers.add(ans);			
			done = true;
			return;
		}
		
		friendship[x][y] = friendship[y][x] = true;
		solve(x,y+1);
		friendship[x][y] = friendship[y][x] = false;
		solve(x,y+1);
	}
	
	public static void main(String[] args) {
		numMutualFriends = new int[][] {
			{0,1,1},
			{1,0,1},
			{1,1,0}
		};
		/*numMutualFriends = new int[][] {
			// 0,1  1,4  4,2  2,0  1,3
			{0,0,0,1,2},
			{0,0,2,0,0},
			{0,2,0,0,0},
			{1,0,0,0,1},
			{2,0,0,1,0}
		};*/
		friendship = new boolean[N][N];
		solve(0,0);
		
		System.out.println("Total ways: " + answers.size());
		for (int i = 0; i < answers.size(); i++) 
		{
			System.out.println(answers.get(i).size());
			for (int j = 0; j < answers.get(i).size(); j++)
			{
				Pair p = answers.get(i).get(j);
				System.out.print("("+p.x + "," + p.y+ ")");
			}
		}					
	}
}
