package Family.HW1;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {

    public static int RandomNumber(int from, int to) {
        int random = (int) (Math.random() * (to - from + 1) + from);
        return random;
    }

    static int[] checkNumbers(int userNumber, int randomNumber, int[] userArrNumbers) {

        while (userNumber != randomNumber) {
            if (userNumber > randomNumber) {
                //  add number to userArray
                userArrNumbers = addNumberToUserArray(userArrNumbers, userNumber);
                // check user number
                userNumber = enteredUserNumber("Your number is too big. Please, try again");
            }
            if (userNumber < randomNumber) {
                userArrNumbers = addNumberToUserArray(userArrNumbers, userNumber);
                userNumber = enteredUserNumber("Your number is too small. Please, try again");
            }
        }
        userArrNumbers = addNumberToUserArray(userArrNumbers, userNumber);
        return userArrNumbers;
    }

    public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    static String enteredUserName(String string) {
        System.out.println(string);
        Scanner scanner = scanner();
        return scanner.nextLine();
    }

    static int enteredUserNumber(String string) {
        System.out.println(string);
        Scanner scanner = scanner();
        return scanner.nextInt();
    }


    static int[] addNumberToUserArray(int[] userArray, int newNumber) {
        // new arr + add space for new number
        int[] newArray = new int[userArray.length + 1];
        // copy array
        for (int i = 0; i < userArray.length; i++) {
            newArray[i] = userArray[i];
        }
        // add in new arr new number
        newArray[userArray.length] = newNumber;
        // return new array with new number
        return newArray;
    }


    static void showUserAllNumbers(int[] arr) {
        // for me
//        for (int i = arr.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }

        Arrays.sort(arr);
        System.out.print("Your numbers is: ");
        for (int num : arr) {
            System.out.print(num + ",");
        }
    }


    public static void main(String[] args) {
        System.out.print("Let the game begin! \n");
        while (true) {
            int randomNumber = RandomNumber(0, 100);
            String userName = enteredUserName("\n Enter your name");
            int userNumber = enteredUserNumber("Enter your number: ");

            // only for checking
            System.out.printf("The random number is: %d \n", randomNumber);

            int[] userAllNumbers = {};

            userAllNumbers = checkNumbers(userNumber, randomNumber, userAllNumbers);
            System.out.printf("Congratulations, %s! \n", userName);
            showUserAllNumbers(userAllNumbers);
        }
    }

}
