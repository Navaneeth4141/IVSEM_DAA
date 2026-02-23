import java.util.*;
public class SummingPieces {
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i]=sc.nextLong();
        long[] pow2 = new long[n+1];
        pow2[0]=1;
        for(int i=1;i<=n;i++) pow2[i]=(pow2[i-1]*2)%MOD;
        long res=0;
        for(int i=0;i<n;i++){
            long left=i;
            long right=n-i-1;
            long contrib=(pow2[(int)left]*(pow2[(int)right]-1+MOD)%MOD 
                        + pow2[(int)right]*(pow2[(int)left]-1+MOD)%MOD 
                        + pow2[(int)(left+right)])%MOD;
            res=(res + a[i]*contrib%MOD)%MOD;
        }
        System.out.println(res);
        sc.close();
    }
}