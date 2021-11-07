package Family.HW8;

import Family.HW8.modal.*;
import Family.HW8.dao.CollectionFamilyDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class  Main {
    public static Scanner input = new Scanner(System.in);
    public static CollectionFamilyDao familyDao = new CollectionFamilyDao();
    public static FamilyService familyService = new FamilyService(familyDao);
    public static FamilyController familyController = new FamilyController(familyService);


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
                case "1" -> firstStep(3);
                case "2" -> secondStep();
                case "3" -> thirdStep();
                case "4" -> fourthStep();
                case "5" -> fifthStep();
                case "6" -> sixthStep();
                case "7" -> seventhStep();
                case "8" -> eighthStep();
                case "9" -> ninthStep();
                case "exit" -> exit = true;
            }

        } while (!exit);

    }

    public static void firstStep(int count) {
        ArrayList<String> woman = new ArrayList<>(List.of("Masha", "Sveta", "Kate", "Lera"));
        ArrayList<String> man = new ArrayList<>(List.of("Vova", "Misha", "Vasya", "Oleg"));
        ArrayList<String> surnames = new ArrayList<>(List.of("Vovovish", "Seregovich", "Mushketerovish", "Finch"));
        ArrayList<Integer> iq = new ArrayList<>(List.of(50, 100, 200, 10, 105));

        for (int i = 1; i <= count; i++) {
            int mansInx = (int) (Math.random() * man.size());
            int womensInx = (int) (Math.random() * woman.size());
            int surnamesInx = (int) (Math.random() * surnames.size());
            int iqs = (int) (Math.random() * iq.size());
            LocalDate from = LocalDate.of(1970, 12, 1);
            LocalDate to = LocalDate.of(2002, 12, 1);
            long days = from.until(to, ChronoUnit.DAYS);
            long randomDays = ThreadLocalRandom.current().nextLong(days + i);
            LocalDate random = from.plusDays(randomDays);
            String birthDate = random.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate fromForChildren = LocalDate.of(2010, 1, 1);
            LocalDate toForChildren = LocalDate.of(2020, 1, 1);
            long daysForChild = fromForChildren.until(toForChildren, ChronoUnit.DAYS);
            long randomDaysForChild = ThreadLocalRandom.current().nextLong(daysForChild + i);
            LocalDate randomDateChild = fromForChildren.plusDays(randomDaysForChild);
            String birthDateChild = randomDateChild.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Man father = new Man(man.get(mansInx), surnames.get(surnamesInx), birthDate,
                    iq.get(iqs));
            Woman mother = new Woman(woman.get(womensInx), surnames.get(surnamesInx), birthDate,
                    iq.get(iqs));
            Human child = new Woman(woman.get(womensInx), surnames.get(surnamesInx), birthDateChild,
                    iq.get(iqs));
            Family fam = new Family(mother, father);
            fam.addChild(child);
            familyDao.saveFamily(fam);
        }
        System.out.println("============== Init Database created ==============");

    }

    public static void secondStep() {
        if (familyController.getAllFamilies().size() == 0) {
            System.out.println("There are no families in Database");
        }
        familyController.displayAllFamilies();
    }

    public static void thirdStep() {
        System.out.println("Введите число");
        int num= input.nextInt();
        if (num > 5) {
            throw new FamilyOverflowException("Invalid number");
        }
        familyController.getFamiliesBiggerThan(num);
    }

    public static void fourthStep() {
        System.out.println("Введите число");
        try {
            String inStr = input.nextLine();
            int num= Integer.parseInt(inStr);
            if (num <= 2) {
                System.out.println("Please enter number greater than 2");
                fourthStep();
            } else {
                familyController.getFamiliesLessThan(num);
            }
        } catch (NumberFormatException ime) {
            System.out.println("Invalid number");
            fourthStep();
        }
    }

    public static void fifthStep() {
        System.out.println("Введите число");

        try {
            String inStr = input.nextLine();
            int num = Integer.parseInt(inStr);
            if (num > 0) {
                System.out.println(familyController.countFamiliesWithMemberNumber(num));
            } else {
                System.out.println("Enter number, greater than 0");
                fifthStep();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong number, please try again");
            fifthStep();
        }
    }

    public static void sixthStep() {
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
        int motherIqs = input.nextInt();
        if (motherName.equals("") || motherSurname.equals("") || motherBirthDay.equals("") || motherBirthYear.equals("") || motherBirthMonth.equals(""))
            throw new IllegalArgumentException();
        Human mother = new Human(motherName, motherSurname, String.format("%s/%s/%S", motherBirthDay, motherBirthMonth,
                motherBirthYear), motherIqs);

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
        Human father = new Human(fatherName, fatherSurname, String.format("%s/%s/%S", fatherBirthDay, fatherBirthMonth,
                fatherBirthYear), fatherIq);
        familyController.createNewFamily(mother, father);
    }

    public static void seventhStep() {
        System.out.println("Enter family ID");
        try {
            String str = input.nextLine();
            int familyId = Integer.parseInt(str);
            if (familyId > familyController.getAllFamilies().size()) {
                System.out.println("No family with this index");
                seventhStep();
            }
            familyController.deleteFamilyByIndex(familyId - 1);
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong number, please try again");
            seventhStep();
        }

    }

    public static void eighthStep() {
        System.out.println("""
            Выберите пункт из Подменю:\s
            1. Родить ребенка\s
            2. Усыновить ребенка
            3. Вернуться в главное меню""");

        System.out.print("Введите пункт подменю: ");
        try {
            String optionUser = input.nextLine().toLowerCase();
            int num = Integer.parseInt(optionUser);
            if (num <= 0 || num > 3) {
                System.out.println("Enter Correct Menu Number");
                eighthStep();
            } else {
                switch (optionUser) {
                    case "1" -> bornChild();
                    case "2" -> adoptChild();
                    case "3" -> selectMenuItem();
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong number, please try again");
            eighthStep();
        }
    }

    public static void ninthStep() {
        System.out.println("Enter child age");
        try {
            String optionUser = input.nextLine();
            int childAge = Integer.parseInt(optionUser);
            if (childAge < 0) {
                System.out.println("Enter correct age");
                ninthStep();
            }
            familyController.deleteAllChildrenOlderThen(childAge);
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong number, please try again");
            ninthStep();
        }
    }

    public static void bornChild() {
        System.out.println("Enter family ID");
        int familyId = input.nextInt();
        Family family = familyController.getFamilyByIndex(familyId - 1);
        System.out.println("Enter boy's name");
        String boyName = input.next();
        System.out.println("Enter girls's name");
        String girlName = input.next();
        familyController.bornChild(family, boyName, girlName);
    }

    public static void adoptChild() {
        System.out.println("Enter family ID");
        int familyId = input.nextInt();
        Family family = familyController.getFamilyByIndex(familyId - 1);
        System.out.println("Enter child's sex: boy or girl");
        String childSex = input.next();
        System.out.println("Enter child's name");
        String childName = input.next();
        System.out.println("Enter child's surname");
        String childSurname = input.next();
        System.out.println("Enter child's year of birth");
        String childBirthYear = input.next();
        System.out.println("Enter child's months of birth");
        String childBirthMonth = input.next();
        System.out.println("Enter child's day of birth");
        String childBirthDay = input.next();
        System.out.println("Enter child's IQ");
        int childIqs = input.nextInt();

        if (childSex.equals("boy")) {
            Human boy = new Human(childName, childSurname, String.format("%s/%s/%S", childBirthDay, childBirthMonth,
                    childBirthYear), childIqs);
            familyController.adoptChild(family, boy);
        } else {
            String birthdate = String.format("%s/%s/%S", childBirthDay, childBirthMonth,
                    childBirthYear);
            Human girl = new Human(childName, childSurname, birthdate, childIqs);
            familyController.adoptChild(family, girl);
        }
    }
}
