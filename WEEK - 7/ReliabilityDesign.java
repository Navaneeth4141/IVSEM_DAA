public class ReliabilityDesign {
    static double series(double[] r) {
        double result = 1.0;
        for (double v : r)
            result *= v;
        return result;
    }

    static double parallel(double r, int copies) {
        return 1 - Math.pow(1 - r, copies);
    }

    public static void main(String[] args) {
        double[] seriesComponents = {0.99, 0.98, 0.97, 0.96, 0.95};
        double seriesReliability = series(seriesComponents);
        double parallelReliability = parallel(0.9, 3);
        System.out.println("Series System Reliability: " + seriesReliability);
        System.out.println("Parallel Reliability (3 copies, r=0.9): " + parallelReliability);
    }
}