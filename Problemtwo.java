public class Problemtwo {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = x + y;
        int sum = 2;
        while(z <= 4000000) {
            if (z%2 == 0) {
                sum += z;
            }
            x = y;
            y = z;
            z = x + y;
        }
        System.out.println(sum);
    }
}
