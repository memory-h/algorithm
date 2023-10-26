package greedy.gold.gold_5;

import java.io.*;
import java.util.*;

public class _1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /** 크레인 */
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crane.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());

        /** 박스 */
        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(box, Collections.reverseOrder());

        // 박스 무게의 최대값이 크레인 무게의 최대값보다 크면 모든 박스를 배로 옮길 수 없으므로 -1을 출력한다.
        if (crane.get(0) < box.get(0)) bw.write("-1");
        else {
            int count = 0;

            while (!box.isEmpty()) {
                int craneIndex = 0;
                int boxIndex = 0;

                while (craneIndex < crane.size() && boxIndex < box.size()) {
                    // 크레인 무게가 박스 무게 보다 크거나 같으면 박스를 제거하고, 다음 크레인으로 박스를 처할 수 있는지 확인한다.
                    if (crane.get(craneIndex) >= box.get(boxIndex)) {
                        box.remove(boxIndex);
                        craneIndex++;
                    }
                    // 크레인이 박스를 처리하지 못하면 다음 박스로 넘어간다.
                    else boxIndex++;
                }
                count++;
            }
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
    }
}