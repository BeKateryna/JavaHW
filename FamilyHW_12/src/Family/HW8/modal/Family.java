package Family.HW8.modal;

import java.io.Serializable;
import java.util.*;


public class Family implements Serializable {
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

    // methods
    public void addChild(Human child) {
        children.add(child);
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

    public String prettyFormat() {
        return String.format("Family of %s: \nmother: %s\nfather:%s\nchildren:%s\npets:%s\n", this.father.getSurname(),
                this.mother.prettyFormat(),
                this.father.prettyFormat(), this.children, this.describeAllPets());
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public String describeAllPets() {
        for (Pet p : getPets()) {
            p.prettyFormat();
        }
        return Arrays.toString(this.pets.toArray());
    }


    @Override
    public String toString() {
        return "\nThis is the family of " + father.getSurname() + "\nMother: " + mother.toString() + " " +
                "\nFather: "
                + father.toString()
                + " \nChildren: "
                + (children.size() == 0 ? "No children in this Family" : children)
                + " \nPets: "
                + (pets == null ? "No pets in this Family" : pets);
    }
    @Override
    public int hashCode() {
        int mother = this.mother.hashCode();
        int father = this.father.hashCode();
        return mother + father;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Family myFamily))
            return false;
        return (mother.hashCode() == myFamily.getMother().hashCode());
    }



    protected void finalize() {
        System.out.println("Removed");
    }

}


