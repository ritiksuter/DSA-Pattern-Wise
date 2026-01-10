public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        char ch = 'A';
        char lower = (char) (ch | 32);
        System.out.println(lower);
    }
}