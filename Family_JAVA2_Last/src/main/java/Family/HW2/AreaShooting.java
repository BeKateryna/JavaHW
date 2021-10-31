package Family.HW2;
import java.util.Random;
import java.util.Scanner;

public class AreaShooting {

    static int randomNumber () {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(5) + 1;
        return rndNum;
    }

    public static void print(String s){
        System.out.print(s);
    }


    static void buildStartTable(String[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                print("\t" + array[i][j] + "\t");
            }
            System.out.println();
        };
    }

    static void gameTable (String s, String[][] array,int row,int column){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[row][column] = s;
                print("\t" + array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        int currentRow = randomNumber();
        int currentColumn = randomNumber();

        Scanner in = new Scanner(System.in);
        print(" \n All set. Get ready to rumble! \n");

        String [][]  field = {
                {"0","1","2","3","4","5"},
                {"1","-","-","-","-","-"},
                {"2","-","-","-","-","-"},
                {"3","-","-","-","-","-"},
                {"4","-","-","-","-","-"},
                {"5","-","-","-","-","-"},
        };

        buildStartTable(field);

        for (; ;) {
            print("\n Choose column number for your shot: ");
            int userColumn = in.nextInt();

            print("\n Choose row number for your shot: ");
            int userRow = in.nextInt();

            if( userColumn > field.length - 1) {
                print("\n Your number is out of column range. Please try again.");
            }
            if (userRow > field.length - 1) {
               print("\n Your number is out of row range. Please try again.");
            }
            if( userRow <= field.length -1 && userColumn <= field.length - 1 ){
                print("\n");
               gameTable("*", field, userRow, userColumn);
            }
            if (currentRow == userRow && currentColumn == userColumn){
                print(" -----------You win!----------- \n");
               gameTable("X", field, userRow, userColumn);
                break;
            }
        }
    }
}
