public class Dijkstra_Algorithm {
	public static void main(String[] args)
	{
		Dijkstra_Algorithm();
	}
	
	static int node = 7;
	static int[][] cost = new int[node][node];
	static final int max = Integer.MAX_VALUE;
	
	static void Dijkstra_Algorithm()
	{
		set('A','B',5);
		set('A','C',6);
		set('A','D',4);
		set('B','D',4);
		set('B','F',4);
		set('C','E',3);
		set('C','G',7);
		set('D','E',5);
		set('D','G',5);
		set('E','G',4);
		set('F','G',2);
		
		for(char ch = 'A'; ch<='G'; ch++)
			process(ch);
	}
	
	static void process(char ch)
	{
		int start = (int)(ch-65);
		int[] distance = new int[node];
		boolean[] find = new boolean[node];
	
		distance[start] = 0;
		find[start] = true;
		
		for(int i = 0; i<node; i++)
			distance[i] = max;
		
		for(int i = 0; i<node;i++)
		{
			if(find[i] == false && cost[start][i] != 0)
				distance[i] = cost[start][i];
		}

		for(int i = 0; i<node-2; i++)
		{
			int minpos = choose(distance,start,find);
			find[minpos] = true;
			
			for(int j = 0; j<node; j++)
			{
				if(find[j] == false && cost[minpos][j] != 0)
				{
					if(distance[j] > distance[minpos] + cost[minpos][j])
						distance[j] = distance[minpos] + cost[minpos][j];
				}
			}
		}
		
		print(start, distance);	
	}
	
	static int choose(int[] distance, int start, boolean[] find)
	{
		int min = max;
		int minpos = -1;
		
		for(int j = 0; j<node;j++)
		{
			if(find[j] == false && distance[j] != max)
			{
				if(distance[j] < min)
				{
					min = distance[j];
					minpos = j;
				}
			}
		}
		
		return minpos;
	}
	
	static void set(char first, char second, int distance)
	{
		int firch = (int)first - 65;
		int secch = (int)second - 65;
		cost[firch][secch] = distance;
		cost[secch][firch] = distance;
	}
	
	static void print(int start, int distance[])
	{
		System.out.println("시작 노드 : "+(char)(start+65));
		for(int i = 0; i<node; i++)
		{
			if(start != i)
				System.out.println((char)(i+65)+" : "+distance[i]);
		}
		System.out.println("=====================");
	}
}