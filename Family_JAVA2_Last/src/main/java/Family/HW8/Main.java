package Family.HW8;

import Family.HW8.modal.Dog;
import Family.HW8.dao.CollectionFamilyDao;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;
import Family.HW8.modal.Pet;

public class Main {
    public static void main(String[] args) {
        CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

        FamilyService service = new FamilyService(collectionFamilyDao);
        FamilyController controller = new FamilyController(service);

        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();
        Human human4 = new Human();
        Human human5 = new Human();
        Human human6 = new Human();
        Human human7 = new Human("Human8", "Humanovich", 1968);
        Human human8 = new Human("Human7", "Humanovich", 1965);
        Human child1 = new Human();
        Human adoptChild = new Human("ADOPT", "ADOPTOVICH", 1998);
        Pet taksa = new Dog("Baget");

        System.out.println("======== createNewFamily");
        controller.createNewFamily(human1, human2);
        controller.createNewFamily(human3, human4);
        controller.createNewFamily(human5, human6);
        System.out.println("========displayAllFamilies");
        controller.displayAllFamilies();
        int members = controller.count();
        System.out.println(members);
        System.out.printf("======== count - %d \n", members);
        System.out.println("======== bornChild");
        Family updateFamily = controller.bornChild(controller.getFamilyByIndex(0), "Petr", "Maria");
        System.out.println(updateFamily.toString());
        System.out.println("======== getFamilyByIndex 0");
        Family familyAt0 = controller.getFamilyByIndex(0);
        System.out.println(familyAt0);
        System.out.println("========= deleteFamilyByFamily which at index 0");
        controller.deleteFamilyByFamily(controller.getFamilyByIndex(0));
        System.out.println("======== adoptChild ");
        Family weAdoptChild = controller.adoptChild(controller.getFamilyByIndex(0), adoptChild);
        System.out.println(weAdoptChild);
        System.out.println("========check getFamiliesBiggerThan 2");
        controller.getFamiliesBiggerThan(2);
        System.out.println("======== addPet to family at index 0");
        controller.addPet(0, taksa);
        System.out.println(controller.getFamilyByIndex(0));
        System.out.println("======== getPets index 0");
        System.out.println(controller.getPets(0));
        System.out.println("======== countFamiliesWithMemberNumber 2 ");
        System.out.println(controller.countFamiliesWithMemberNumber(2));
        controller.displayAllFamilies();
        System.out.println("======== deleteAllChildrenOlderThen 5 ");
        controller.displayAllFamilies();
        controller.deleteAllChildrenOlderThen(5);
        controller.displayAllFamilies();
        System.out.println("======== getFamiliesLessThan 2");
        Family weAdoptChild2 = controller.adoptChild(controller.getFamilyByIndex(0), adoptChild);
        controller.getFamiliesLessThan(3);
        controller.createNewFamily(human5, human6);
        System.out.println("========check displayAllFamilies");
        controller.displayAllFamilies();
        System.out.println("======== getFamiliesBiggerThan 2");
        controller.getFamiliesBiggerThan(2);
        System.out.println("======== saveFamily ");
        controller.saveFamily(new Family(human7, human8));
        controller.displayAllFamilies();
    }
}
