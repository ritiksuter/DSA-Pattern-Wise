public class SetTheIthBit {
    public static void main(String[] args) {
        int n = 10;
        int i = 1;
        int result = n | (1 << i);

        System.out.println(result);
    }
}
