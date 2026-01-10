public class CheckIfANumberIsAPowerOf2 {
    public static void main(String[] args) {
        int n = 16;

        if(n > 0 && (n & (n - 1)) == 0) {
            System.out.println("Power of Two");
        }
        else {
            System.out.println("Not Power of Two");
        }
    }
}