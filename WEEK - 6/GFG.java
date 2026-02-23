import java.util.*;
public class GFG{
    public int assignHole(ArrayList<Integer> mice, ArrayList<Integer> holes){
        if(mice.size()!=holes.size()) return -1;
        Collections.sort(mice);
        Collections.sort(holes);
        int max=0;
        for(int i=0;i<mice.size();i++)
            max=Math.max(max,Math.abs(mice.get(i)-holes.get(i)));
        return max;
    }
    public static void main(String[] args){
        GFG gfg=new GFG();
        ArrayList<Integer> mice=new ArrayList<>(Arrays.asList(4,-4,2));
        ArrayList<Integer> holes=new ArrayList<>(Arrays.asList(4,0,5));
        System.out.println("The last mouse gets into the hole in time: "+gfg.assignHole(mice,holes));
    }
}