public class Problemone {
    public static void main(String[] args) {
        int x = 0;
        for (int i = 0;i < 1000; i++) {
            if (i%3 == 0 || i%5 == 0) {
                x = x + i;
            }
        }
        System.out.println(x);
    }
}
