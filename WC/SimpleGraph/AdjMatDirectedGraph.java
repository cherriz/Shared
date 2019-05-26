import java.util.Iterator;

public class AdjMatDirectedGraph 
{
    private int V;
    private int E;
    private double[][] adj;
    
    public AdjMatDirectedGraph(int V) 
    {
        this.V = V;
        this.E = 0;
        this.adj = new double[V][V];
    }

    public int V() { return this.V; }
    public int E() { return this.E; }


    public void AddEdge(int u, int v, double w) 
    {
        if (adj[u][v] != 0) 
        	E++;
        adj[u][v] = w;
    }

    public Iterable<Integer> Adjacent(int v) 
    {
        return new VIterator(v);
    }

    private class VIterator implements Iterator<Integer>, Iterable<Integer> 
    {
        private int v;
        private int u = 0;

        public VIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (u < V) 
            {
                if (adj[v][u] != 0) 
                	return true;
                u++;
            }
            return false;
        }

        public Integer next() {
            if (hasNext()) 
            	return u++;
            else           
            	return null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V; v++) 
        {
            sb.append(v + ": ");
            for (int u : Adjacent(v)) 
            {
                sb.append(u);
                sb.append("(" + adj[v][u] + ")");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

	public static void main(String[] args) 
	{
		
		AdjMatDirectedGraph graph = new AdjMatDirectedGraph(2);
		graph.AddEdge(0,1,0.5);
		System.out.println(graph.toString());

	}

}
