public abstract class CheckIfNumberIsOddOrEven {
    public static void main(String[] args) {
        int n = 13;

        if((n & 1) == 1) {
            System.out.println("ODD");
        }
        
        else {
            System.out.println("Even");
        }
    }
}
