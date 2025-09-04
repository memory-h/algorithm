package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _15720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Integer[] burger = readIntArray(br.readLine(), b);
        Integer[] sideMenu = readIntArray(br.readLine(), c);
        Integer[] beverage = readIntArray(br.readLine(), d);

        int totalPrice = sum(burger) + sum(sideMenu) + sum(beverage);

        sortDesc(burger);
        sortDesc(sideMenu);
        sortDesc(beverage);

        int discountPrice = 0;
        int burgerSetCount = Math.min(b, Math.min(c, d));

        for (int i = 0; i < burgerSetCount; i++) {
            int setSum = burger[i] + sideMenu[i] + beverage[i];
            discountPrice += (setSum * 9) / 10;
        }

        discountPrice += sumFrom(burger, burgerSetCount);
        discountPrice += sumFrom(sideMenu, burgerSetCount);
        discountPrice += sumFrom(beverage, burgerSetCount);

        bw.write(totalPrice + "\n" + discountPrice);
        bw.flush();
        bw.close();
    }

    private static Integer[] readIntArray(String line, int n) {
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    private static void sortDesc(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    private static int sum(Integer[] arr) {
        int s = 0;
        for (int v : arr) {
            s += v;
        }
        return s;
    }

    private static int sumFrom(Integer[] arr, int from) {
        int s = 0;
        for (int i = from; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

}