package Family.HW8.dao;

import Family.HW8.modal.Pet;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface FamilyDao {
    public List<Family> getAllFamilies();

    public Family getFamilyByIndex(int index);

    public Family deleteFamilyByIndex(int index);

    public boolean deleteFamilyByFamily(Family family);

    public Family saveFamily(Family family);

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


    List<Family> loadData() throws IOException;

}
