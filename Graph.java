// A Java program to implement graph coloring
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This class represents an undirected graph using adjacency list
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    
    //Constructor
    Graph(int v)
    {
        V = v;
       
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
            
          
    }
    
    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected
    }
    public int getV()
    {
    	return V;
    }
    public void printGraph(int graph[][])
    {
       for(int i=0;i<12;i++){
                for(int j = 0; j < 12;j++){
                    System.out.print(graph[i][j]);
                }
                 System.out.print("\n");
            }
    }
    public LinkedList<Integer> getListAdj(int u)
    {
    	return adj[u];
    }
    public int[][] readGraph(String input_name)
    {
		BufferedReader reader;
	int[][]	result = new int[12][12];
		try {
			reader = new BufferedReader(new FileReader(input_name));
			Scanner scanner =new Scanner(reader);
			for(int i=0;i<12;i++){
				for(int j = 0; j < 12;j++){
                    result[i][j]=scanner.nextInt();
                }
			}
			reader.close();
			return result;
		} catch (IOException e) {
			int temp[][] = new int[0][0];
            return temp;
              
		}
         // return true;
    }
    
}
// This code is contributed by Anh Vo 
