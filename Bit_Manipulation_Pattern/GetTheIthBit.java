public class GetTheIthBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;

        int bit = (n & (1 << i)) != 0 ? 1 : 0;
        System.out.println(bit);
    }
}
