package Family.HW4;


import java.util.Arrays;
import java.util.Objects;

 class Family {
    Human mother;
    Human father;
    Human[] children;
    Pet pet;


    //Getters
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    public Pet getPet() {
        return pet;
    }


    // Setters
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }


    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Family() {

    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        mother.setFamily(this);
        father.setFamily(this);

    }

    // methods
    public void addChild(Human human) {
        Human[] newChild = new Human[this.children.length + 1];
        for (int i = 0; i < this.children.length; ++i) {
            newChild[i] = this.children[i];
        }
        human.setFamily(this);
        newChild[newChild.length - 1] = human;
        this.children = newChild;
    }

    public boolean deleteChildInx(int index) {
        if (index <= this.children.length - 1 && index >= 0) {
            Human[] newChildArray = new Human[this.children.length - 1];
            for (int i = 0, k = 0; i < this.children.length; i++) {
                if (i == index) {
                    continue;
                }
                newChildArray[k++] = this.children[i];
            }
            this.children = newChildArray;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteChildObj(Human child) {
        boolean wasDeleted = false;
        for (int i = 0, k = 0; i < this.children.length; i++) {
            Human[] newChildArray = new Human[this.children.length - 1];
            if (this.children[i].equals(child)) {
                continue;
            }
            if (!this.children[i].equals(child)) {
                break;
            }
            newChildArray[k++] = this.children[i];
            this.children = newChildArray;
            return wasDeleted = true;
        }
        return wasDeleted;
    }

    public int countFamily() {
        return this.children != null ? 2 + this.children.length : 2;
    }


    @Override
    public String toString() {
        return "Family{" + "\n" +
                "mother=" + mother + "\n" +
                ", father=" + father + "\n" +
                ", children=" + Arrays.toString(children) + "\n" +
                ", pet=" + pet + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + " was deleted");
    }

}


