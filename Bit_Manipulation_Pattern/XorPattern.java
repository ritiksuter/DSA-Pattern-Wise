public class XorPattern {
    public static void main(String[] args) {
        // int[] arr = {4,1,2,1,2};
        // int xor = 0;

        // for (int i = 0; i < arr.length; i++) {
        //     xor = xor ^ arr[i];
        // }
        // System.out.println(xor);

        // Swap Two Numbers
        // int a = 10;
        // int b = 20;
        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
        // System.out.println("a : " + a);
        // System.out.println("b : " + b);

        // Find missing number (1.....n) -->
        // int[] nums = {1,2,3,4};
        // int xor1 = 0;
        // for (int i = 1; i <= nums.length + 1; i++) xor1 ^= i;
        // int xor2 = 0;
        // for (int x : nums) xor2 ^= x;
        // int missing = xor1 ^ xor2;
        // System.out.println(missing);

        // Two non-repeating numbers
        int[] nums = {1,2,3,2,1,4};

        int xor = 0;
        for (int x : nums) xor ^= x;   // 3 ^ 4

        int mask = xor & (-xor);

        int a = 0;
        int b = 0;

        for (int x : nums) {
            if((x & mask) != 0) {
                a ^= x;
            }
            else {
                b ^= x;
            }
        }
        System.out.println(a + " " + b);
    }
}