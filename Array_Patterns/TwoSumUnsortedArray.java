import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 4, 2};
        int target = 10;
        int[] ans = twoSum(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
}
