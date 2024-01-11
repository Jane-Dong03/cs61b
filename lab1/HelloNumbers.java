public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int ans = 0;
        while (x < 9) {
            System.out.print(ans + " ");
            x = x + 1;
            ans += x;
        }
        System.out.println(ans);
        System.out.println(5 + "10");
        System.out.println(5 + 10);
    }
}