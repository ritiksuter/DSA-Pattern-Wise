import java.util.List;

public class RecursionWithChoice {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(count(arr, 0));
    }

    public static void solve(int[] arr, int index, String ans) {
        if(index == arr.length) {
            System.out.println(ans);
            return ;
        }
        // Take
        solve(arr, index+1, ans+arr[index] + " ");

        // Not-Take
        solve(arr, index+1, ans);
    }

    public static int count(int[] arr, int index) {
        if (index == arr.length) return 1;

        int take = count(arr, index + 1);
        int notTake = count(arr, index + 1);

        return take + notTake;
    }

    public static void subsetSum(int[] arr, int index, int sum, List<Integer> list) {
        if(index == arr.length) {
            System.out.println(list + " => " + sum);
            return ;
        }
        // Take
        list.add(arr[index]);
        subsetSum(arr, index+1, sum+arr[index], list);

        // Backtrack
        list.remove(list.size() - 1);

        // Not Take
        subsetSum(arr, index+1, sum, list);
    }
}