package Family.HW3;

import java.util.Scanner;

public class TaskPlanner {
    public static String checkMyScedule(String[][] a, String enteredDay) {
        Scanner sc = new Scanner(System.in);
        String checkMyTask = "Sorry, I don't understand you, please try again.";

        if (enteredDay.equals("exit")) {
            return enteredDay;
        }
            for (int i = 0; i < a.length; i++) {
                if (a[i][0].equals(enteredDay)) {
                    checkMyTask = "Your task for" + enteredDay + "is " + a[i][1];
                }
            }
            return checkMyTask;
    }

    public static void main(String[] args) {

        String[][] scedule = {
                {"monday", "do homework",},
                {"tuesday", "go to gym"},
                {"wednesday", "go to courses"},
                {"thursday", "read a book"},
                {"friday", "meet a friends"},
                {"saturday", "visit a parents"},
                {"sunday", "go to spa"},
        };

        Scanner sc = new Scanner(System.in);

        for (; ; ) {
            System.out.println("\n Please, input the day of the week:  ");
            String dayOfWeek = sc.next().toLowerCase().trim();
            String checkMyTask = checkMyScedule(scedule, dayOfWeek);
            if (checkMyTask .equals("exit")) break;
            System.out.println(checkMyTask);
        }
    }
}
