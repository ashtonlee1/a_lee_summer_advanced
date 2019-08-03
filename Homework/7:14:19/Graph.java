import java.io.*;
import java.util.*;

class Graph
{
  private LinkedList<Integer> adj[];
	private int V;

	Graph(int n)
	{
		V = n;
		adj = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			adj[i] = new LinkedList();
    }
	}

	void link(int i, int n)
	{
		adj[i].add(n);
	}

	void DFSHelper(boolean visited[], int x)
	{
		visited[x] = true;
		System.out.print(x+" ");
		Iterator<Integer> i = adj[x].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSHelper(visited,n);
		}
	}


	void DFS(int x)
	{
		boolean visited[] = new boolean[V];
		DFSHelper(visited,x);
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
    g.link(0, 1);
		g.link(0, 2);
		g.link(1, 2);
    g.link(2, 3);
		g.link(2, 0);
    g.link(3, 4);
		g.DFS(3);
	}
}
