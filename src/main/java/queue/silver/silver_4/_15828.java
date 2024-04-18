package queue.silver.silver_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int buffSize = 0;

        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            int packet = Integer.parseInt(br.readLine());

            if (packet == -1) {
                break;
            }

            // 패킷 값이 들어왔을 때, 라우터 내부에 존재하는 버퍼의 크기보다 작은 경우
            if (packet > 0 && buffSize < n) {
                queue.add(packet);
                buffSize++;
            } else if (packet == 0) {
                // 패킷 값이 0일 때, 버퍼가 비어있는 경우
                if (!queue.isEmpty()) {
                    queue.poll();
                    buffSize--;
                }
            }
        }

        if (queue.isEmpty()) {
            sb.append("empty");
        } else {
            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}