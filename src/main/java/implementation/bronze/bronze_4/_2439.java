package implementation.bronze.bronze_4;
import java.util.Scanner;
public class _2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        for(int i = 1; i <= N; i++) {
            for(int k = 1; k <= N - i; k++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}