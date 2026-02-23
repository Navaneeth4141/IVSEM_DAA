import java.util.*;
class Squares{
    static int minimumCostOfBreaking(Integer X[], Integer Y[], int m, int n){
        Arrays.sort(X, Collections.reverseOrder());
        Arrays.sort(Y, Collections.reverseOrder());
        int hzntl=1, vert=1, i=0, j=0, res=0;
        while(i<m && j<n){
            if(X[i]>Y[j]){
                res+=X[i]*vert;
                hzntl++;
                i++;
            }else{
                res+=Y[j]*hzntl;
                vert++;
                j++;
            }
        }
        while(i<m){
            res+=X[i]*vert;
            hzntl++;
            i++;
        }
        while(j <n){
            res+=Y[j]*hzntl;
            vert++;
            j++;
        }
        return res;
    }
    public static void main(String arg[]){
        int m=6,n=4;
        Integer X[]={2,1,3,1,4};
        Integer Y[]={4,1,2};
        System.out.print(minimumCostOfBreaking(X,Y,m-1,n-1));
    }
}