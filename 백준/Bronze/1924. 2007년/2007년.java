import java.util.Scanner;

public class Main {
    
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] DAY_OF_THE_WEEKS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.close();
        
        int totalDays = getTotalDays(month, day);
        
        System.out.println(getDayOfTheWeek(totalDays));
    }
    
    private static int getTotalDays(int month, int day) {
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += DAYS_IN_MONTH[i];
        }
        return totalDays;
    }
    
    private static String getDayOfTheWeek(int totalDays) {
        int dayIndex = totalDays % 7;
        return DAY_OF_THE_WEEKS[dayIndex];
    }
}
