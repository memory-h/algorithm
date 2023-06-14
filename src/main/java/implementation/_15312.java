package implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _15312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String name = br.readLine();
        String her = br.readLine();
        Integer[] arr = new Integer[name.length() * 2];

        for(int i = 0; i < name.length(); i++){
            char c1 = name.charAt(i);
            char c2 = her.charAt(i);

            arr[i * 2] = alphabet[c1 - 65];
            arr[(i * 2) + 1] = alphabet[c2 - 65];
        }
        List<Integer> list = Arrays.asList(arr);

        while(list.size() > 2) {
            List<Integer> list2 = new ArrayList<>();

            for(int i = 0; i < list.size() - 1; i++){
                list2.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = list2;
        }
        list.forEach(e -> System.out.print(e));
    }
}