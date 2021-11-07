package Family_HW11.dao;

import Family_HW11.modal.Family;
import Family_HW11.modal.Human;
import Family_HW11.modal.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao{
    private static final List<Family> allFamilies = new ArrayList<>();
    private static final int YEAR_NOW = 2021;

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
//    public void displayAllFamilies() {
//        System.out.println(allFamilies);
//    }
    public void displayAllFamilies() {
        for (int i = 0; i < this.getAllFamilies().size(); i++) {
            System.out.println(i + 1 + "." + " " + getAllFamilies().get(i).prettyFormat());
        }
    }


    @Override
    public void getFamiliesBiggerThan(int people) {
        List<Family> result = allFamilies.stream().filter((family) -> family.countFamily() > people).collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Override
    public void getFamiliesLessThan(int people) {
        List<Family> result = allFamilies.stream().filter((family) -> family.countFamily() < people).collect(Collectors.toList());
        result.forEach(System.out::println);
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
//        int index = allFamilies.indexOf(family);
//        Family selectedFamily = allFamilies.get(index);
//        boolean newBornChild =  (Math.random() * 3) == 2;
//        Human child = new Human();
//        child.setName(newBornChild ? boy : girl);
//        selectedFamily.addChild(child);
//        allFamilies.set(index, selectedFamily);
//        return selectedFamily;
        int index = allFamilies.indexOf(family);
        Family searchedFamily = allFamilies.get(index);
        boolean isBoy = Math.random() < 0.5;
        Human child = new Human();
        child.setName(isBoy ? boy : girl);
        searchedFamily.addChild(child);
        allFamilies.set(index, searchedFamily);
        return searchedFamily;

    }

    @Override
    public Family adoptChild(Family family, Human human) {
//        int selectedFamilyIndex = allFamilies.indexOf(family);
//        Family selectedFamily= allFamilies.get(selectedFamilyIndex);
//        selectedFamily.addChild(human);
//        allFamilies.set(selectedFamilyIndex, selectedFamily);
//        return selectedFamily;
        int index = allFamilies.indexOf(family);
        Family searchedFamily = allFamilies.get(index);
        searchedFamily.addChild(human);
        allFamilies.set(index, searchedFamily);
        return searchedFamily;
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {
        List<Family> familiesWhichHasChildren= allFamilies.stream().filter((f) -> f.getChildren().size() > 0).collect(Collectors.toList());
        familiesWhichHasChildren.forEach(f -> f.getChildren().forEach(child -> {
            if (YEAR_NOW - child.getBirthDate()  > age) {
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
