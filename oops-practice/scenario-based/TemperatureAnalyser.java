
public class TemperatureAnalyser {

    public static void main(String[] args) {

        float temperatures[][] = new float[7][24];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = (float) (Math.random() * 31) + 20;
            }
        }

        findHottestAndColdestDay(temperatures);
        averageDayTemperature(temperatures);

    }

    public static void findHottestAndColdestDay(float temperatures[][]) {

        int hottest = Integer.MIN_VALUE;
        int coldest = Integer.MAX_VALUE;

        float dayTemp = Float.MIN_VALUE;
        float dayTemp2 = Float.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            float sum = 0;
            float average = 0;
            for (int j = 0; j < 24; j++) {
                sum += temperatures[i][j];
            }
            average = sum / 24;
            if (average > dayTemp) {
                dayTemp = average;
                hottest = i + 1;
            }
            if (average < dayTemp2) {
                dayTemp2 = average;
                coldest = i + 1;
            }

        }

        System.out.println("Hottest Day: " + hottest);
        System.out.println("Coldest Day: " + coldest);
    }

    public static void averageDayTemperature(float temperatures[][]) {
        for (int i = 0; i < 7; i++) {
            float sum = 0;
            float average = 0;
            for (int j = 0; j < 24; j++) {
                sum += temperatures[i][j];
            }
            average = sum / 24;
            System.out.println("Average " + (i + 1) + " Day " + average);

        }
    }

}