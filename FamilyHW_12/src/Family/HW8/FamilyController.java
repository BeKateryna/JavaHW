package Family.HW8;

import Family.HW8.modal.Family;
import Family.HW8.modal.Human;
import Family.HW8.modal.Pet;

import java.io.IOException;
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

    public Family deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
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


    public void bornChild(Family family, String boy, String girl) {
        try {
            if (familyService.count() > 4) {
                throw new FamilyOverflowException("Sorry, but you cannot do this. Maybe next time)");
            }
        } catch (FamilyOverflowException foe) {
            System.out.println("Sorry, but you cannot do this. Maybe next time)");
        }

        familyService.bornChild(family, boy, girl);
    }

    public void adoptChild(Family family, Human child) {
        try {
            if (familyService.count() > 4) {
                throw new FamilyOverflowException("Sorry, but you cannot do this. Maybe next time)");
            }
        } catch (FamilyOverflowException foe) {
            System.out.println("Sorry, but you cannot do this. Maybe next time)");
        }

        familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public List<Family> loadData() throws IOException {
        return familyService.loadData();
    }

}
