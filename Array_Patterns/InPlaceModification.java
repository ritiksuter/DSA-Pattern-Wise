import java.util.Arrays;

public class InPlaceModification {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, 0, 9, 0, 2, 5 };
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for(int num : nums) {
            if(num != 0) nums[index++] = num;
        }

        while(index < nums.length) {
            nums[index++] = 0;
        }
    }
}
