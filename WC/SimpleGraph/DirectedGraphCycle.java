import java.util.Stack;

public class DirectedGraphCycle 
{
    private boolean[] visited;        
    private int[] edgeTo;            
    private boolean[] isOnStack;       
    private Stack<Integer> cycle;    

    public DirectedGraphCycle(AdjMatDirectedGraph graph) 
    {
        for (int i = 0; i < graph.V(); i++)
        {
        	visited  = new boolean[graph.V()];
            isOnStack = new boolean[graph.V()];
            edgeTo  = new int[graph.V()];
            if (!visited[i] && cycle == null)
            	DFS(graph, i);
        }
    }

    public Stack<Integer> Cycle() { return cycle; }

    private void DFS(AdjMatDirectedGraph graph, int i) 
    {
        visited[i] = true;
        isOnStack[i] = true;
        
        for (int j : graph.Adjacent(i)) {

            if (cycle != null)
            {
            	return;
            }
            else if (!visited[j]) 
            {
                edgeTo[j] = i;
                DFS(graph, j);
            }
            else if (isOnStack[j]) 
            {
                cycle = new Stack<Integer>();
                for (int x = i; x != j; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(j);
                cycle.push(i);
            }
        }
        isOnStack[i] = false;
    }

    public static void main(String[] args) 
    {
		AdjMatDirectedGraph graph = new AdjMatDirectedGraph(5);	
		graph.AddEdge(0, 1, 1);
		graph.AddEdge(1, 2, 1);
		graph.AddEdge(2, 0, 1);
		graph.AddEdge(0, 3, 1);
		graph.AddEdge(3, 4, 1);
		graph.AddEdge(4, 0, 1);
		
		DirectedGraphCycle cycles = new DirectedGraphCycle(graph);
		Stack<Integer> cycle = cycles.Cycle();
		
    if (cycle != null) 
    {
      while (!cycle.isEmpty())
            System.out.print(cycle.pop()+ "->");
        System.out.println();
    }
    else 
    {
        System.out.println("No cycle");
    }

  }

}
