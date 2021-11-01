package Family.HW9.main;

import Family.HW9.main.modal.Family;
import Family.HW9.main.modal.Human;
import Family.HW9.main.modal.Pet;

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

    public boolean deleteFamilyByIndex(int index) {
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

    public Family bornChild(Family family, String boy, String girl) {
        return familyService.bornChild(family, boy, girl);
    }

    public Family adoptChild(Family family, Human adopt) {
        return familyService.adoptChild(family, adopt);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Set<Pet> getPets(int index) { return familyService.getPets(index);}

    public void addPet(int index, Pet pet) {familyService.addPet(index, pet);}
}
