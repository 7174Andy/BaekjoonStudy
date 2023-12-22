import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String sValue = br.readLine();
        int value = Integer.parseInt(sValue);
        int compare;
        int addition = 0;
        int cnt = 1;
        if (value < 10) {
            compare = value * 10 + value;
            sValue = Integer.toString(compare);
        } else {
            int mlb = Character.getNumericValue(sValue.charAt(0));
            int msb = Character.getNumericValue(sValue.charAt(1));
            addition = mlb + msb;
            String additionS = Integer.toString(addition);
            int msbAddition = Character.getNumericValue(additionS.charAt(additionS.length() - 1));
            sValue = Integer.toString(msb) + Integer.toString(msbAddition);
            compare = Integer.parseInt(sValue);
        }
        while (compare != value) {
            cnt++;
            if (compare < 10) {
                compare = compare * 10 + compare;
                sValue = Integer.toString(compare);
            } else {
                int mlb = Character.getNumericValue(sValue.charAt(0));
                int msb = Character.getNumericValue(sValue.charAt(1));
                addition = mlb + msb;
                String additionS = Integer.toString(addition);
                int msbAddition = Character.getNumericValue(additionS.charAt(additionS.length() - 1));
                sValue = Integer.toString(msb) + Integer.toString(msbAddition);
                compare = Integer.parseInt(sValue);
            }
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
