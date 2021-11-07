package Family.HW8.dao;

import Family.HW8.modal.Pet;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao{
    private static final List<Family> allFamilies = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return allFamilies;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return index >= allFamilies.size() ? null : allFamilies.get(index);
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        if (index >= allFamilies.size()) {
            return false;
        } else {
            allFamilies.remove(index);
            return true;
        }

    }

    @Override
    public boolean deleteFamilyByFamily(Family family) {
        if (allFamilies.contains(family)) {
            allFamilies.remove(family);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void saveFamily(Family family) {
        int index = allFamilies.indexOf(family);
        if (allFamilies.contains(family)) {
            allFamilies.set(index, family);
        } else {
            allFamilies.add(family);
        }
    }

    @Override
    public void displayAllFamilies() {
        System.out.println(allFamilies);
    }

    @Override
    public void getFamiliesBiggerThan(int number) {
        for (Family family : allFamilies) {
            if (family.countFamily() > number) {
                System.out.println("Families have more members than: " + number + " - \n" + family);
            }
        }

    }

    @Override
    public void getFamiliesLessThan(int number) {
        for (Family family : allFamilies) {
            if (family.countFamily() < number) {
                System.out.println("Families have less members than: " + number + " - \n" + family);
            }

        }

    }

    @Override
    public int countFamiliesWithMemberNumber(int number) {
        List<Family> filteredFamilies = allFamilies.stream().filter(f -> f.countFamily() == number).collect(Collectors.toList());
        return filteredFamilies.size();
    }

    @Override
    public void createNewFamily(Human human1, Human human2) {
        Family family = new Family(human1, human2);
        allFamilies.add(family);
    }

    @Override
    public Family bornChild(Family family, String boy, String girl) {
        int index = allFamilies.indexOf(family);
        Family selectedFamily = allFamilies.get(index);
        boolean newBornChild =  (Math.random() * 3) == 2;
        Human child = new Human();
        child.setName(newBornChild ? boy : girl);
        selectedFamily.addChild(child);
        allFamilies.set(index, selectedFamily);
        return selectedFamily;
    }

    @Override
    public Family adoptChild(Family family, Human human) {
        int selectedFamilyIndex = allFamilies.indexOf(family);
        Family selectedFamily= allFamilies.get(selectedFamilyIndex);
        selectedFamily.addChild(human);
        allFamilies.set(selectedFamilyIndex, selectedFamily);
        return selectedFamily;
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {
        List<Family> familiesWhichHasChildren= allFamilies.stream().filter((f) -> f.getChildren().size() > 0).collect(Collectors.toList());
        familiesWhichHasChildren.forEach(f -> f.getChildren().forEach(child -> {
            if (LocalDate.now().getYear() - child.getYear() > age) {
                int indexChild = f.getChildren().indexOf(child);
                f.deleteChild(indexChild);
            }
        }));
    }

    @Override
    public int count() {
        return allFamilies.size();
    }

    @Override
    public Set<Pet> getPets(int index) {
        Family family = allFamilies.get(index);
     return family.getPets();
    }

    @Override
    public void addPet(int index, Pet pet) {
        Family family = allFamilies.get(index);
        family.getPets().add(pet);
    }
}
