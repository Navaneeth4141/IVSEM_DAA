import java.util.*;
class GFG{
    static int MAX_CHAR=256;
    static int nextChar(int freq[],int dist[]){
        int max=-1;
        for(int i=0;i<MAX_CHAR;i++)
            if(freq[i]>0 && dist[i]<=0 && (max==-1 || freq[i]>freq[max]))
                max=i;
        return max;
    }
    static int rearrange(char str[],char out[],int d){
        int n=str.length;
        int freq[]=new int[MAX_CHAR];
        int dist[]=new int[MAX_CHAR];
        for(int i=0;i<n;i++) freq[str[i]]++;
        for(int i=0;i<n;i++){
            int ch=nextChar(freq,dist);
            if(ch==-1) return 0;
            out[i]=(char)ch;
            freq[ch]--;
            dist[ch]=d;
            for(int j=0;j<MAX_CHAR;j++)
                if(dist[j]>0) dist[j]--;
        }
        return 1;
    }
    public static void main(String[] args){
        char str[]="aaaabbbcc".toCharArray();
        int n=str.length;
        char out[]=new char[n];
        if(rearrange(str,out,2)==1)
            System.out.println(String.valueOf(out));
        else
            System.out.println("Cannot be rearranged");
    }
}