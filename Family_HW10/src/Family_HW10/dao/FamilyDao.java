package Family_HW10.dao;

import Family_HW10.modal.Family;
import Family_HW10.modal.Human;
import Family_HW10.modal.Pet;

import java.util.List;
import java.util.Set;

 public interface FamilyDao {
    public List<Family> getAllFamilies();

    public Family getFamilyByIndex(int index);

    public boolean deleteFamilyByIndex(int index);

    public boolean deleteFamilyByFamily(Family family);

    public void saveFamily(Family family);

    public void displayAllFamilies();

    public void getFamiliesBiggerThan(int people);

    public void getFamiliesLessThan(int people);

    public int countFamiliesWithMemberNumber(int number);

    public void createNewFamily(Human firstPerson, Human secondPerson);

    public Family bornChild(Family family, String fatherName, String motherName);

    public Family adoptChild(Family family, Human adoptPerson);

    public void deleteAllChildrenOlderThen(int age);

    public int count();

    public Set<Pet> getPets(int index);

    public void addPet(int index, Pet pet);

}
