public class ConvertLowercaseToUppercase {
    public static void main(String[] args) {
        char ch = 'a';
        char upper = (char) (ch & ~32);
        System.out.println(upper);
    }
}