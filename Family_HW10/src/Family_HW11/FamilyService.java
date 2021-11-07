package Family_HW11;

import Family_HW11.dao.FamilyDao;
import Family_HW11.modal.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamilyByIndex(index);
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

    public void adoptChild(Family family, Human adopt) {
        familyDao.adoptChild(family, adopt);
        familyDao.saveFamily(family);
    }


    public void bornChild(Family family, String boy, String girl) {
        familyDao.bornChild(family, boy, girl);
        familyDao.saveFamily(family);
    }


    public void deleteAllChildrenOlderThen(int age) {
        this.getAllFamilies().stream().peek(family -> {
            family.getChildren()
                    .removeIf(child -> (LocalDate.now().getYear() - Instant.ofEpochMilli(child.getBirthDate())
                            .atZone(ZoneId.systemDefault()).toLocalDate().getYear()) > age);
        }).forEach(familyDao::saveFamily);
    }


//    public void deleteAllChildrenOlderThen(int age) {
//        familyDao.deleteAllChildrenOlderThen(age);
//    }

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
