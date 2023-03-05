import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int TOTAL_DWARFS = 9;
    private static final int TARGET_HEIGHT_SUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfHeights = new int[TOTAL_DWARFS];
        int heightSum = 0;

        for (int i = 0; i < TOTAL_DWARFS; i++) {
            dwarfHeights[i] = Integer.parseInt(br.readLine());
            heightSum += dwarfHeights[i];
        }

        for (int i = 0; i < TOTAL_DWARFS - 1; i++) {
            for (int j = i + 1; j < TOTAL_DWARFS; j++) {
                if (heightSum - dwarfHeights[i] - dwarfHeights[j] == TARGET_HEIGHT_SUM) {
                    dwarfHeights[i] = 0;
                    dwarfHeights[j] = 0;

                    Arrays.sort(dwarfHeights);
                    for (int k = 2; k < TOTAL_DWARFS; k++) {
                        System.out.println(dwarfHeights[k]);
                    }
                    return;
                }
            }
        }
    }
}
