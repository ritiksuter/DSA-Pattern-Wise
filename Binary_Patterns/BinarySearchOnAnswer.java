public class BinarySearchOnAnswer {
    public static int binarySearchOnAnswer(int low, int high, int[] piles, int h) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int speed, int[] piles, int h) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // ceil division
        }
        return hours <= h;
    }
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int low = 1;
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int result = binarySearchOnAnswer(low, high, piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
