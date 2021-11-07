package Family.HW8;

import Family.HW8.dao.FamilyDao;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;
import Family.HW8.modal.Pet;

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

    public void createNewFamily(Human firstPerson, Human secondPerson) {familyDao.createNewFamily(firstPerson, secondPerson);}

    public void bornChild(Family family, String boy, String girl) {
        familyDao.bornChild(family, boy, girl);
    }

    public void adoptChild(Family family, Human adopt) {
        familyDao.adoptChild(family, adopt);
    }

    public void deleteAllChildrenOlderThen(int age) {familyDao.deleteAllChildrenOlderThen(age);}

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
