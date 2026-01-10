public class ToggleIthBit {
    public static void main(String[] args) {
        int n = 10;
        int i = 2;

        int result = n ^ (1 << i);

        System.out.println(result);
    }
}