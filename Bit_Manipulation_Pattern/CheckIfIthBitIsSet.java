public class CheckIfIthBitIsSet {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;

        if((n & (1 << i)) != 0) {
            System.out.println("Bit is set");
        }
        else {
            System.out.println("Bit is NOT set");
        }
    }
}