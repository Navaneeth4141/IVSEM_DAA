import java.util.*;
class KCenters{
    static int maxindex(int[] dist,int n){
        int max=0;
        for(int i=1;i<n;i++)
            if(dist[i]>dist[max])
                max=i;
        return max;
    }
    static void selectKcities(int n,int weights[][],int k){
        boolean[] selected=new boolean[n];
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int first=0;
        selected[first]=true;
        for(int i=0;i<n;i++)
            dist[i]=weights[first][i];
        for(int count=1;count<k;count++){
            int next=maxindex(dist,n);
            selected[next]=true;
            for(int i=0;i<n;i++)
                dist[i]=Math.min(dist[i],weights[next][i]);
        }
        int max=0;
        for(int i=0;i<n;i++)
            if(!selected[i])
                max=Math.max(max,dist[i]);
        System.out.println("Maximum distance to nearest centre: "+max);
        System.out.print("Selected centres: ");
        for(int i=0;i<n;i++)
            if(selected[i])
                System.out.print(i+" ");
    }
    public static void main(String[] args){
        int n=4;
        int[][] weights={{0,4,8,5},{4,0,10,7},{8,10,0,9},{5,7,9,0}};
        int k=2;
        selectKcities(n,weights,k);
    }
}