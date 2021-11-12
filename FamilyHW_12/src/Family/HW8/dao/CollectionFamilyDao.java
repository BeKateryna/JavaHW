package Family.HW8.dao;

import Family.HW8.modal.Pet;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
    private static final List<Family> allFamilies = new ArrayList<>();
    Date date = new Date();
    long timeMilli = date.getTime();


    @Override
    public List<Family> getAllFamilies() {
        return allFamilies;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return index >= allFamilies.size() ? null : allFamilies.get(index);
    }

    @Override
    public Family deleteFamilyByIndex(int index) {
        if (index >= 0 && index < allFamilies.size()) {
            return this.allFamilies.remove(index);
        } else {
            return null;
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
    public Family saveFamily(Family family) {
        int index = allFamilies.indexOf(family);
        if (allFamilies.contains(family)) {
            allFamilies.set(index, family);

        } else {
            allFamilies.add(family);
        }
        try (FileOutputStream fos = new FileOutputStream("family.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(allFamilies);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return family;
    }


    @Override
    public void displayAllFamilies() {
        System.out.println(allFamilies);
    }

    @Override
    public void getFamiliesBiggerThan(int people) {
        List<Family> result = this.getAllFamilies().stream().filter((family) -> family.countFamily() > people).collect(Collectors.toList());
        result.forEach(System.out::println);

        if (result.isEmpty()) {
            System.out.println("=============There are no families with this amount========== ");
        }
    }

    @Override
    public void getFamiliesLessThan(int people) {
        List<Family> result = this.getAllFamilies().stream().filter((family) -> family.countFamily() < people).collect(Collectors.toList());
        result.forEach(System.out::println);
        if (result.isEmpty()) {
            System.out.println("=============There are no families with this amount========== ");
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
        boolean newBornChild = (Math.random() * 3) == 2;
        Human child = new Human();
        child.setName(newBornChild ? boy : girl);
        selectedFamily.addChild(child);
        allFamilies.set(index, selectedFamily);
        return selectedFamily;
    }

    @Override
    public Family adoptChild(Family family, Human human) {
        int selectedFamilyIndex = allFamilies.indexOf(family);
        Family selectedFamily = allFamilies.get(selectedFamilyIndex);
        selectedFamily.addChild(human);
        allFamilies.set(selectedFamilyIndex, selectedFamily);
        return selectedFamily;
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {
        List<Family> familiesWithChildren = allFamilies.stream().filter((family) -> family.getChildren().size() > 0).collect(Collectors.toList());
        familiesWithChildren.forEach(family -> family.getChildren().forEach(child -> {
            if (timeMilli - child.getBirthDate() > ((long) age * 1000 * 60 * 60 * 24 * 365)) {
                int indexChild = family.getChildren().indexOf(child);
                family.deleteChild(indexChild);
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

@Override
public List<Family> loadData() throws IOException {
    List<Family> families = new ArrayList<>();
    try(FileInputStream fis = new FileInputStream("family.txt");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
        families = (List<Family>) ois.readObject();
        System.out.println("Data from FILE:");
        for (int i = 0; i < families.size(); i++) {
            System.out.println(i + 1 + "." + " " + families.get(i).prettyFormat());
        }

    } catch (FileNotFoundException | ClassNotFoundException e) {
        e.printStackTrace(System.out);
    }
    return families;
}
}
