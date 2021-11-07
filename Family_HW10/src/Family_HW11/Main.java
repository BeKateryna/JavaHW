package Family_HW11;

import Family_HW11.Exeptions.FamilyOverflowException;
import Family_HW11.dao.CollectionFamilyDao;
import Family_HW11.modal.Family;
import Family_HW11.modal.Human;
import Family_HW11.modal.Man;
import Family_HW11.modal.Woman;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();
    public static FamilyService service = new FamilyService(collectionFamilyDao);
    public static FamilyController controller = new FamilyController(service);


    public static void main(String[] args) {
        System.out.println(("Welcome to Family Generator Game").toUpperCase());
        selectMenuItem();
    }


    public static void selectMenuItem() {
        boolean exit = false;
        do {
            menu();
            System.out.print("Введите пункт меню или введите exit: ");
            String optionUser = input.nextLine().toLowerCase();

            switch (optionUser) {
                case "1" -> firstOption(4);
                case "2" -> secondOption();
                case "3" -> thirdOption();
                case "4" -> fourthOption();
                case "5" -> fifthOption();
                case "6" -> sixthOption();
                case "7" -> seventhOption();
                case "8" -> eighthOption();
                case "9" -> ninthOption();
                case "exit" -> exit = true;
            }

        } while (!exit);

    }

    public static void firstOption(int count) {
        ArrayList<String> womanNames = new ArrayList<>(List.of("Olena", "Oksana", "Marina", "Irina", "Margo"));
        ArrayList<String> manNames = new ArrayList<>(List.of("Maksim", "Oleg", "Vadim", "Alex", "Sergey"));
        ArrayList<String> surnames = new ArrayList<>(List.of("Lobachevskiy", "Egorov", "Ivanov", "Petrov", "Sechenov"));
        ArrayList<Integer> iq = new ArrayList<>(List.of(80, 100, 120, 90, 95));


        for (int i = 1; i <= count; i++) {
            int indexManName = (int) (Math.random() * manNames.size());
            int indexWomanName = (int) (Math.random() * manNames.size());
            int indexSurname = (int) (Math.random() * surnames.size());
            int indexIq = (int) (Math.random() * iq.size());

            LocalDate from = LocalDate.of(1980, 1, 1);
            LocalDate to = LocalDate.of(2001, 1, 1);

            long days = from.until(to, ChronoUnit.DAYS);
            long randomDays = ThreadLocalRandom.current().nextLong(days + i);

            LocalDate randomDate = from.plusDays(randomDays);
            String birthDate = randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            LocalDate fromChild = LocalDate.of(2006, 1, 1);
            LocalDate toChild = LocalDate.of(2020, 1, 1);

            long daysChild = fromChild.until(toChild, ChronoUnit.DAYS);
            long randomDaysChild = ThreadLocalRandom.current().nextLong(daysChild + i);

            LocalDate randomDateChild = fromChild.plusDays(randomDaysChild);
            String birthDateChild = randomDateChild.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Human father = new Man(manNames.get(indexManName), surnames.get(indexSurname), birthDate,
                    iq.get(indexIq));
            Human mother = new Woman(womanNames.get(indexWomanName), surnames.get(indexSurname), birthDate,
                    iq.get(indexIq));
//            Human child = new Woman(womanNames.get(indexWomanName), surnames.get(indexSurname), birthDateChild,
//                    iq.get(indexIq));
//            List<Human> children = List.of(child);
            controller.createNewFamily(father, mother);
        }
    }

    public static void secondOption() {
        if (controller.getAllFamilies().size() == 0) {
            System.out.println("No families in Database");
        }
        controller.displayAllFamilies();
    }

    public static void thirdOption() {
        System.out.println("Введите число");
        int number = input.nextInt();
        if (number > 5) {
            throw new FamilyOverflowException("Invalid number");
        }
        controller.getFamiliesBiggerThan(number);
    }


    public static void fourthOption() {
        System.out.println("Введите число");
        try {
            String inStr = input.nextLine();
            int number = Integer.parseInt(inStr);
            if (number <= 2) {
                System.out.println("Please enter number greater than 2");
                fourthOption();
            } else {
                controller.getFamiliesLessThan(number);
            }
        } catch (NumberFormatException ime) {
            System.out.println("Invalid number");
            fourthOption();
        }
    }

    public static void fifthOption() {
        System.out.println("Введите число");

        try {
            String inStr = input.nextLine();
            int number = Integer.parseInt(inStr);
            if (number > 0) {
                System.out.println(controller.countFamiliesWithMemberNumber(number));
            } else {
                System.out.println("Enter number, greater than ZERO");
                fifthOption();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("You entered the wrong number, please try again");
            fifthOption();
        }
    }

    public static void sixthOption() {
        System.out.println("Enter mother's name");
        String motherName = input.next();
        System.out.println("Enter mother's surname");
        String motherSurname = input.next();
        System.out.println("Enter mother's year of birth");
        String motherBirthYear = input.next();
        System.out.println("Enter mother's months of birth");
        String motherBirthMonth = input.next();
        System.out.println("Enter mother's day of birth");
        String motherBirthDay = input.next();
        System.out.println("Enter mother's IQ");
        int motherIq = input.nextInt();
        if (motherName.equals("") || motherSurname.equals("") || motherBirthDay.equals("") || motherBirthYear.equals("") || motherBirthMonth.equals(""))
            throw new IllegalArgumentException();


        Woman mother = new Woman(motherName, motherSurname, String.format("%s/%s/%S", motherBirthDay, motherBirthMonth,
                motherBirthYear), motherIq);


        System.out.println("Enter father's name");
        String fatherName = input.next();
        System.out.println("Enter father's surname");
        String fatherSurname = input.next();
        System.out.println("Enter father's year of birth");
        String fatherBirthYear = input.next();
        System.out.println("Enter father's months of birth");
        String fatherBirthMonth = input.next();
        System.out.println("Enter father's day of birth");
        String fatherBirthDay = input.next();
        System.out.println("Enter father's IQ");
        int fatherIq = input.nextInt();
        if (fatherName.equals("") || fatherSurname.equals("") || fatherBirthDay.equals("") || fatherBirthYear.equals("") || fatherBirthMonth.equals(""))
            throw new IllegalArgumentException();
        Man father = new Man(fatherName, fatherSurname, String.format("%s/%s/%S", fatherBirthDay, fatherBirthMonth,
                fatherBirthYear), fatherIq);
        controller.createNewFamily(mother, father);
    }

    public static void seventhOption() {
        System.out.println("Enter family ID");
        try {
            String inStr = input.nextLine();
            int familyId = Integer.parseInt(inStr);
            if (familyId > controller.getAllFamilies().size()) {
                System.out.println("No family with such index");
                seventhOption();
            }
            controller.deleteFamilyByIndex(familyId - 1);
        } catch (NumberFormatException nfe) {
            System.out.println("You entered the wrong number, please try again");
            seventhOption();
        }

    }

    public static void eighthOption() {
        System.out.println("""
                Выберите пункт из Подменю:\s
                1. Родить ребенка\s
                2. Усыновить ребенка
                3. Вернуться в главное меню""");

        System.out.print("Введите пункт подменю: ");
        try {
            String optionUser = input.nextLine().toLowerCase();
            int number = Integer.parseInt(optionUser);
            if (number <= 0 || number > 3) {
                System.out.println("Enter Correct Menu Number");
                eighthOption();
            } else {
                switch (optionUser) {
                    case "1" -> bornChild();
                    case "2" -> adoptChild();
                    case "3" -> selectMenuItem();
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("You entered the wrong number, please try again");
            eighthOption();
        }

    }

    public static void ninthOption() {
        System.out.println("Enter child age");
        try {
            String optionUser = input.nextLine().toLowerCase();
            int childAge = Integer.parseInt(optionUser);
            if (childAge < 0) {
                System.out.println("Enter correct age");
                ninthOption();
            }
            controller.deleteAllChildrenOlderThen(childAge);
        } catch (NumberFormatException nfe) {
            System.out.println("You entered the wrong number, please try again");
            ninthOption();
        }
    }

    public static void bornChild() {
        System.out.println("Enter family ID");
        int familyId = input.nextInt();
        int index = familyId - 1;
        Family family = controller.getFamilyByIndex(index);
        System.out.println(family.toString());
        System.out.println("Enter boy's name");
        String boyName = input.next();
        System.out.println("Enter girls's name");
        String girlName = input.next();
        controller.bornChild(controller.getFamilyByIndex(index), boyName, girlName);
    }

    public static void adoptChild() {
        System.out.println("Enter family ID");
        int familyId = input.nextInt();
        Family family = controller.getFamilyByIndex(familyId - 1);
        System.out.println("Enter child's sex: boy or girl");
        String childSex = input.next();
        System.out.println("Enter child's name");
        String childName = input.next();
        System.out.println("Enter child's year of birth");
        String childBirthYear = input.next();
        System.out.println("Enter child's months of birth");
        String childBirthMonth = input.next();
        System.out.println("Enter child's day of birth");
        String childBirthDay = input.next();
        System.out.println("Enter child's IQ");
        int childIq = input.nextInt();

        if (childSex.equals("boy")) {
            Human boy = new Man(childName, family.getFather().getSurname(), String.format("%s/%s/%S", childBirthDay, childBirthMonth,
                    childBirthYear), childIq);
            controller.adoptChild(family, boy);
        } else {
            Human girl = new Woman(childName, family.getFather().getSurname(), String.format("%s/%s/%S", childBirthDay, childBirthMonth,
                    childBirthYear), childIq);
            controller.adoptChild(family, girl);
        }
    }

    public static void menu() {
        System.out.println("""
                Выберите пункт из Меню:\s
                1. Заполнить тестовыми данными\s
                2. Отобразить весь список семей
                3. Отобразить список семей, где количество людей больше заданного\s
                4. Отобразить список семей, где количество людей меньше заданного\s
                5. Подсчитать количество семей, где количество членов равно\s
                6. Создать новую семью\s
                7. Удалить семью по индексу семьи в общем списке\s
                8. Редактировать семью по индексу семьи в общем списке\s
                \t1. Родить ребенка\s
                \t2. Усыновить ребенка\s
                \t3. Вернуться в главное меню\s
                9. Удалить всех детей старше возраста""");
    }
}
