package Family_HW11.modal;

import java.util.*;


public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets = new HashSet<>();

    // Getters Setters

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPets() {
        return pets;
    }


    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public Family(Human mother, Human father, List<Human> children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    // methods
    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (children == null || index < 0 || index >= children.size()) {
            return false;
        }
        List<Human> newArr = new ArrayList<>(children);
        newArr.remove(index);
        children = newArr;
        return true;
    }


    public int countFamily() {
        return children.size() + 2;
    }

    private int findChildIndex(Human child) {
        for (int i = 0; i < children.size(); i++) {
            if (child == children.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteChild(Human child) {
        int index = findChildIndex(child);
        return deleteChild(index);
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public String toString() {
        String var10000 = this.father.getSurname();
        return "This is the family of " + var10000 + "\nMother: " + this.mother.toString() + " \nFather: " + this.father.toString() + " \nChildren: " + (this.children.size() == 0 ? "No children in this Family" : this.children) + " \nPets: " + (this.pets == null ? "No pets in this Family" : this.pets);
    }
    public String describeAllPets() {
        for (Pet p : getPets()) {
            p.prettyFormat();
        }
        return Arrays.toString(this.pets.toArray());
    }

    public String prettyFormat() {
        return String.format("Family of %s: \nmother: %s\nfather:%s\nchildren:%s\npets:%s\n", this.father.getSurname(),
                this.mother.prettyFormat(),
                this.father.prettyFormat(), this.children, this.describeAllPets());
    }



//    @Override
//    public String toString() {
//        return "Family{" +
//                "mother=" + mother +
//                ", father=" + father +
//                ", children=" + children +
//                ", pets=" + pets +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) && father.equals(family.father) && children.equals(family.children) && pets.equals(family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    protected void finalize() {
        System.out.println("Removed");
    }

}


