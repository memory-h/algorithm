package implementation;
import java.io.*;
public class _28295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int find = 90;

        for(int i = 1; i <= 10; i++) {
            int num = Integer.parseInt(br.readLine());

            switch(find) {
                case 0:
                    if(num == 1) find = 270;
                    if(num == 2) find = 180;
                    if(num == 3) find = 90;
                    break;

                case 90:
                    if(num == 1) find = 0;
                    if(num == 2) find = 270;
                    if(num == 3) find = 180;
                    break;

                case 180:
                    if(num == 1) find = 90;
                    if(num == 2) find = 0;
                    if(num == 3) find = 270;
                    break;

                case 270:
                    if(num == 1) find = 180;
                    if(num == 2) find = 90;
                    if(num == 3) find = 0;
                    break;
            }
        }
        if(find == 0) bw.write("E");
        if(find == 90) bw.write("N");
        if(find == 180) bw.write("W");
        if(find == 270) bw.write("S");

        bw.flush();
        bw.close();
    }
}