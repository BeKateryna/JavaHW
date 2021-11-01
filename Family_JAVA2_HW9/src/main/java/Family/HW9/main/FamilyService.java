package Family.HW9.main;

import Family.HW9.main.dao.FamilyDao;
import Family.HW9.main.modal.Family;
import Family.HW9.main.modal.Human;
import Family.HW9.main.modal.Pet;

import java.util.List;
import java.util.Set;

public class FamilyService {
    FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public boolean deleteFamilyByFamily(Family family) {
        return familyDao.deleteFamilyByFamily(family);
    }

    public void saveFamily(Family family) {
        familyDao.saveFamily(family);
    }

    public void displayAllFamilies() {
        familyDao.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int people) {
        familyDao.getFamiliesBiggerThan(people);
    }

    public void getFamiliesLessThan(int people) {
        familyDao.getFamiliesLessThan(people);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return familyDao.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human firstPerson, Human secondPerson) {
        familyDao.createNewFamily(firstPerson, secondPerson);
    }

    public Family bornChild(Family family, String boy, String girl) {
        return familyDao.bornChild(family, boy, girl);
    }

    public Family adoptChild(Family family, Human adopt) {
        return familyDao.adoptChild(family, adopt);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyDao.count();
    }

    public Set<Pet> getPets(int index) {
        Family family = familyDao.getFamilyByIndex(index);
        return family.getPets();
    }

    public void addPet(int index, Pet pet) {
        Family family = familyDao.getFamilyByIndex(index);
        family.getPets().add(pet);
        familyDao.saveFamily(family);
    }
}
