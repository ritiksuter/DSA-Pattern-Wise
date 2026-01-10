import java.util.ArrayList;
import java.util.List;

public class SubsetsUsingBitmask {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;   // 2^n

        List<List<Integer>> res = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            res.add(subset);
        }
        return res;
    }
}