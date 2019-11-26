import java.lang.Exception;
import java.util.List;
import java.io.*;
import java.util.LinkedList; 

public class  GraphImplementation implements Graph
{

        int vertices; 
        int[][]array;  
        public GraphImplementation(int vertices) 
        { 
            this.vertices= vertices; 
              
            // define the size of array as  
            // number of vertices 
            this.array = new int[vertices][vertices]; 
              
            // Create a new list for each vertex 
            // such that adjacent nodes can be stored 
            for(int i = 0; i < vertices ; i++)
            { 
                for(int y= 0;y<vertices;y++)
                {
                	array[i][y]=0;
                } 
            } 
        } 
    /**
    *adds edge to directed graph
    */
	public void addEdge(int v1, int v2) throws Exception
	{
		if(v1<0||v1>array.length||v2<0||v2>array.length)
		{
			throw new Exception();
		}
		if(array[v1][v2]==0)
		{
			array[v1][v2]=1;
		}
	}
	public List<Integer> neighbors(int vertex) throws Exception
	{
       LinkedList<Integer> adjListArray=new LinkedList<Integer>();
        for(int i = 0; i < array.length; i++)
        {
        	if(array[vertex][i]>0)
        	{
        		adjListArray.add(i);
        	}
        }
        return adjListArray; 
    } 
    public int findzero(int[] sum)
    {
    	for(int x=0;x<array.length;x++)
    	{
    		if(sum[x]==0)
    		{
    			return x;
    		}
    	}
    	return -1;
    }
    public void print_sum(int[] sum)
    {
    	for(int x=0;x<sum.length;x++)
    	{
    		System.out.print(sum[x]+" ");
    	}
    	System.out.println();
    }
	public List<Integer> topologicalSort()
	{

		LinkedList<Integer> schedule=new LinkedList<Integer>();
		int sum[]=new int [vertices];
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				sum[i]+=array[j][i];
			}
		}
		for(int count=0;count<vertices;count++)
		{
			//print_sum(sum);
			int n=findzero(sum);
/*			for(int i=0;i<schedule.size();i++)
			{
				//System.out.println(schedule.get(i));
			}*/
			if (n<0)
			{
				for(int i=0;i<schedule.size();i++)
				{
					System.out.println(schedule.get(i)+"test");
				}
				return schedule;
			}
			//System.out.println(n);
			schedule.add(n);
			//System.out.println(schedule.size()+"mid");
			sum[n]=-1;
			for(int i=0;i<vertices;i++)
			{
				//System.out.println(sum[i]);
				sum[i]-=array[n][i];
			}
			//System.out.println(schedule.size()+"end");
		}
		//System.out.println(schedule.size());
/*		for(int i=0;i<schedule.size();i++)
		{
			System.out.println(schedule.get(i));
		}*/
		return schedule;
	}

}