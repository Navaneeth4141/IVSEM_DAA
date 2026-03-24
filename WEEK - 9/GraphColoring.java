public class GraphColoring {
    final int V = 4;

    boolean isSafe(int v,int[][] graph,int[] color,int c){
        for(int i=0;i<V;i++)
            if(graph[v][i]==1 && color[i]==c) return false;
        return true;
    }

    boolean solve(int[][] graph,int m,int[] color,int v){
        if(v==V) return true;

        for(int c=1;c<=m;c++){
            if(isSafe(v,graph,color,c)){
                color[v]=c;
                if(solve(graph,m,color,v+1)) return true;
                color[v]=0;
            }
        }
        return false;
    }

    void print(int[] color){
        for(int i=0;i<V;i++)
            System.out.print(color[i]+" ");
    }

    void graphColoring(int[][] graph,int m){
        int[] color=new int[V];
        if(!solve(graph,m,color,0)) System.out.println("No solution");
        else print(color);
    }

    public static void main(String[] args){
        GraphColoring g=new GraphColoring();
        int[][] graph={
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };
        int m=3;
        g.graphColoring(graph,m);
    }
}