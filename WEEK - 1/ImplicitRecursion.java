import java.util.*;
class ImplicitRecursion {
    public static int findLargest(List<Integer> numbers) {
        if (numbers.size() == 1)
            return numbers.get(0);

        int last = numbers.remove(numbers.size() - 1);
        int max = findLargest(numbers);

        numbers.add(last); // restore list
        return Math.max(last, max);
    }
    public static int findSecondLargest(List<Integer> numbers) {
        int largest = findLargest(numbers);
        numbers.remove(Integer.valueOf(largest));
        return findLargest(numbers);
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int secondLargest = findSecondLargest(numbers);
        System.out.println(secondLargest);
    }
}
