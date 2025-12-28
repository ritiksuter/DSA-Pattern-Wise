public class StringBuilderPattern {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            sb.append(i);
        }
        String result = sb.toString();

        String s = "java";
        String reversed = new StringBuilder(s).reverse().toString();
    }
}