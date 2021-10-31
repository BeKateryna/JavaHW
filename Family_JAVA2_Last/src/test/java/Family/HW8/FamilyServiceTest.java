package Family.HW8;

import Family.HW8.dao.CollectionFamilyDao;
import Family.HW8.modal.Dog;
import Family.HW8.modal.Family;
import Family.HW8.modal.Human;
import Family.HW8.modal.Pet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class FamilyServiceTest {
    FamilyService service = new FamilyService(new CollectionFamilyDao());
    Human human1 = new Human();
    Human human2 = new Human();
    List<Family> familyList = new ArrayList();
    @Test
    public void should__be_not_empty_array_after__addFamily() {
        service.createNewFamily(human1, human2);
        Assert.assertNotEquals(familyList, service.getAllFamilies());
    }

    @Test
    public void should__display__all__families__when__call_getAllFamilies() {
        service.createNewFamily(human1, human2);
        familyList.add(new Family(human1, human2));
        Assert.assertEquals(familyList, service.getAllFamilies());
    }

    @Test
    public void should__show__correct__number__of__exist__familyes__when__call__count() {
        service.createNewFamily(human1, human2);
        Assert.assertEquals(1, service.count());
    }
    @Test
    public void should_getNull_when_call_getFamilyByIndex__and_this_listEmpty(){
        Assertions.assertNull(service.getFamilyByIndex(0));
    }
    @Test
    public void should_return__array__of__pets__when__call_getPets(){
        service.createNewFamily(human1, human2);
        Pet taksa = new Dog("Baget");
        service.addPet(0, taksa);
        Assert.assertArrayEquals(service.getFamilyByIndex(0).getPets().toArray(), service.getPets(0).toArray());
    }
    @Test
    public void should__add__pets__when__call_addPets(){
        service.createNewFamily(human1, human2);
        Pet taksa = new Dog("Baget");
        service.addPet(0, taksa);
        int needToBe = 1;
        Assert.assertEquals(needToBe, service.getFamilyByIndex(0).getPets().size());
    }
    @Test
    public void should__family__add__child__when__call_adoptChild(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.adoptChild(f, new Human("ADOPT", "ADOPTOVICH", 1988));
        int needToBe = 3;
        Assert.assertEquals(needToBe, service.getFamilyByIndex(0).countFamily());
    }
    @Test
    public void should__family__delete__child__when__call_deleteChild(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.adoptChild(f, new Human("ADOPT", "ADOPTOVICH", 1988));
        f.deleteChild(0);
        int needToBe = 2;
        Assert.assertEquals(needToBe, service.getFamilyByIndex(0).countFamily());
    }
    @Test
    public void should__family__delete__child__when__call_deleteAllChildrenOlderThen(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.adoptChild(f, new Human("ADOPT", "ADOPTOVICH", 1988));
        service.deleteAllChildrenOlderThen(2);
        int needToBe = 2;
        Assert.assertEquals(needToBe, service.getFamilyByIndex(0).countFamily());
    }
    @Test
    public void should__family__add__child__when__call_bornChild(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.bornChild(f, "mary", "serg");
        int needToBe = 3;
        Assert.assertEquals(needToBe, service.getFamilyByIndex(0).countFamily());
    }
    @Test
    public void shouldBe_notCorrect_number_of_families_which__have__lessThanMembers_after_countFamiliesWithMemberNumber(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.adoptChild(f, new Human("ADOPT", "ADOPTOVICH", 1988));
        Assert.assertNotEquals(0, service.countFamiliesWithMemberNumber(3));
    }
    @Test
    public void shouldBe_notCorrect_number_of_families_which__have__lessThanMembers_after_getFamiliesLessThan(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.getFamiliesLessThan(2);
        int getFamiliesLessThan =  service.count();
        Assert.assertNotEquals(0, getFamiliesLessThan);
    }
    @Test
    public void shouldBe_correct_number_of_families_which__have__lessThanMembers_after_getFamiliesBiggerThan(){
        service.createNewFamily(human1, human2);
        Family f = service.getFamilyByIndex(0);
        service.bornChild(f, "mary", "serg");
        service.getFamiliesBiggerThan(2);
        int getFamiliesBiggerThan =  service.count();
        Assert.assertEquals(1, getFamiliesBiggerThan);
    }

    @Test
    public void should__addNewFamily__after__call__saveFamily(){
        Family f = new Family(human1,human2);
        service.saveFamily(f);
        int getFamiliesBiggerThan =  service.count();
        Assert.assertEquals(1, getFamiliesBiggerThan);
    }
    @Test
    public void should__deleteFamily__after__call__deleteFamilyByFamily(){
        Family f = new Family(human1,human2);
        Family f2 = new Family(new Human("human1", "ADOPTOVICH", 1968),new Human("human2", "ADOPTOVICH", 1978));
        service.saveFamily(f);
        service.saveFamily(f2);
        service.deleteFamilyByFamily(f);
        Assert.assertEquals(f2, service.getFamilyByIndex(0));
    }
    @Test
    public void should__deleteFamily__after__call__deleteFamilyByIndex(){
        Family f = new Family(human1,human2);
        Family f2 = new Family(new Human("human1", "ADOPTOVICH", 1968),new Human("human2", "ADOPTOVICH", 1978));
        service.saveFamily(f);
        service.saveFamily(f2);
        service.deleteFamilyByIndex(0);
        Assert.assertEquals(f2, service.getFamilyByIndex(0));
    }
    @Test
    public void should__deleteFamily__after__call__getFamilyByIndex(){
        Family f = new Family(human1,human2);
        Family f2 = new Family(new Human("human1", "ADOPTOVICH", 1968),new Human("human2", "ADOPTOVICH", 1978));
        service.saveFamily(f);
        service.saveFamily(f2);
        Assert.assertEquals(f, service.getFamilyByIndex(0));
    }
}

