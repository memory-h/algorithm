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

        int min = Math.min(b, Math.min(c, d));
        int totalPrice = 0;
        int discountPrice = 0;
        int price = 0;

        Integer[] burger = new Integer[b];
        Integer[] sideMenu = new Integer[c];
        Integer[] beverage = new Integer[d];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            totalPrice += burger[i];
        }
        Arrays.sort(burger, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            sideMenu[i] = Integer.parseInt(st.nextToken());
            totalPrice += sideMenu[i];
        }
        Arrays.sort(sideMenu, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            beverage[i] = Integer.parseInt(st.nextToken());
            totalPrice += beverage[i];
        }
        Arrays.sort(beverage, Collections.reverseOrder());

        for (int i = 0; i < min; i++)
            discountPrice += (int) ((burger[i] + sideMenu[i] + beverage[i]) * 0.9);

        for (int i = min; i < b; i++) price += burger[i];
        for (int i = min; i < c; i++) price += sideMenu[i];
        for (int i = min; i < d; i++) price += beverage[i];

        bw.write(totalPrice + "\n" + (discountPrice + price));
        bw.flush();
        bw.close();
    }
}