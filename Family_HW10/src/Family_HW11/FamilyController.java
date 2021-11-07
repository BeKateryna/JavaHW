package Family_HW11;

import Family_HW11.Exeptions.FamilyOverflowException;
import Family_HW11.modal.Family;
import Family_HW11.modal.Human;
import Family_HW11.modal.Pet;
import java.util.List;
import java.util.Set;



public class FamilyController {
    FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public boolean deleteFamilyByFamily(Family family) {
        return familyService.deleteFamilyByFamily(family);
    }

    public void saveFamily(Family family) {
        familyService.saveFamily(family);
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int people) {
        familyService.getFamiliesBiggerThan(people);
    }

    public void getFamiliesLessThan(int people) {
        familyService.getFamiliesLessThan(people);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human human1, Human human2) {
        familyService.createNewFamily(human1, human2);
    }

//    public void bornChild(Family family, String boy, String girl) {
////        try {
////            if (familyService.count() > 4) {
////                throw new FamilyOverflowException("You cannot born a child");
////            }
////        } catch (FamilyOverflowException foe) {
////            System.out.println("You cannot born a child");
////        }
//
//        familyService.bornChild(family, boy, girl);
//
//    }
//
//    public Family adoptChild(Family family, Human adopt) {
//        try {
//            if (familyService.count() > 4) {
//                throw new FamilyOverflowException("You cannot adopt child");
//            }
//        } catch (FamilyOverflowException foe) {
//            System.out.println("You cannot adopt child");
//        }
//
//        return familyService.adoptChild(family, adopt);
//    }
//
//    public void deleteAllChildrenOlderThen(int age) {
//        familyService.deleteAllChildrenOlderThen(age);
//    }
public int count() {
    return familyService.count();
}

    public void bornChild(Family family, String boy, String girl) {
        try {
            if (familyService.count() > 4) {
                throw new FamilyOverflowException("You cannot born a child");
            }
        } catch (FamilyOverflowException foe) {
            System.out.println("You cannot born a child");
        }

        familyService.bornChild(family, boy, girl);
    }

    public void adoptChild(Family family, Human child) {
        try {
            if (familyService.count() > 4) {
                throw new FamilyOverflowException("You cannot adopt child");
            }
        } catch (FamilyOverflowException foe) {
            System.out.println("You cannot adopt child");
        }

        familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }



    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}
