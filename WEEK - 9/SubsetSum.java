import java.util.*;

public class SubsetSum {
    static boolean flag=false;

    static void printSubsetSum(int i,int n,int[] set,int target,List<Integer> subset){
        if(target==0){
            System.out.println(subset);
            flag=true;
            return;
        }
        if(i==n||target<0) return;

        subset.add(set[i]);
        printSubsetSum(i+1,n,set,target-set[i],subset);
        subset.remove(subset.size()-1);

        printSubsetSum(i+1,n,set,target,subset);
    }

    public static void main(String[] args){
        int[] set1={1,2,1};
        int sum1=3;
        System.out.println("Output 1:");
        printSubsetSum(0,set1.length,set1,sum1,new ArrayList<>());
        System.out.println();
        flag=false;

        int[] set2={3,34,4,12,5,2};
        int sum2=30;
        System.out.println("Output 2:");
        printSubsetSum(0,set2.length,set2,sum2,new ArrayList<>());
        if(!flag) System.out.println("There is no such subset");
    }
}