import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        solve(arr, new boolean[arr.length], new ArrayList<>());
    }

    public static void solve(int[] arr, boolean[] used, List<Integer> list) {
        if (list.size() == arr.length) {
            System.out.println(list);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            used[i] = true;              // MAKE
            list.add(arr[i]);

            solve(arr, used, list);      // EXPLORE

            list.remove(list.size() - 1); // UNDO
            used[i] = false;
        }
    }
}