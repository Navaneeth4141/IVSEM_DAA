import java.util.*;

public class FlowshopScheduling {
    static class Job {
        int id, m1, m2;
        Job(int id, int m1, int m2) {
            this.id = id;
            this.m1 = m1;
            this.m2 = m2;
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 3, 2),
            new Job(2, 2, 1),
            new Job(3, 4, 3)
        };

        List<Job> left = new ArrayList<>(), right = new ArrayList<>();
        for (Job j : jobs) {
            if (j.m1 < j.m2) left.add(j);
            else right.add(j);
        }

        left.sort(Comparator.comparingInt(j -> j.m1));
        right.sort((a, b) -> b.m2 - a.m2);

        List<Job> sequence = new ArrayList<>();
        sequence.addAll(left);
        sequence.addAll(right);

        int time1 = 0, time2 = 0;
        for (Job j : sequence) {
            time1 += j.m1;
            time2 = Math.max(time1, time2) + j.m2;
        }

        System.out.print("Optimal Job Sequence: ");
        for (Job j : sequence)
            System.out.print("J" + j.id + " ");
        System.out.println();
        System.out.println("Minimum makespan: " + time2);
    }
}