public class HamiltonianCycle {
    final int V = 5;

    boolean isSafe(int v,int[][] graph,int[] path,int pos){
        if(graph[path[pos-1]][v]==0) return false;
        for(int i=0;i<pos;i++)
            if(path[i]==v) return false;
        return true;
    }

    boolean solve(int[][] graph,int[] path,int pos){
        if(pos==V){
            return graph[path[pos-1]][path[0]]==1;
        }

        for(int v=1;v<V;v++){
            if(isSafe(v,graph,path,pos)){
                path[pos]=v;
                if(solve(graph,path,pos+1)) return true;
                path[pos]=-1;
            }
        }
        return false;
    }

    void print(int[] path){
        for(int i=0;i<V;i++)
            System.out.print(path[i]+" ");
        System.out.println(path[0]);
    }

    void hamCycle(int[][] graph){
        int[] path=new int[V];
        for(int i=0;i<V;i++) path[i]=-1;
        path[0]=0;

        if(!solve(graph,path,1)) System.out.println("No solution");
        else print(path);
    }

    public static void main(String[] args){
        HamiltonianCycle h=new HamiltonianCycle();
        int[][] graph={
            {0,1,0,1,0},
            {1,0,1,1,1},
            {0,1,0,0,1},
            {1,1,0,0,1},
            {0,1,1,1,0}
        };
        h.hamCycle(graph);
    }
}