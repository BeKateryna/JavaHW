package Family.HW7;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Set;

public class FamilyTest  {

    Human mom = new Human();
    Human mom1 = new Human();
    Human papa = new Human();
    Human papa2 = new Human();
    Human child1 = new Human();
    Human child3 = new Human();
    Human child5 = new Human();

    Family bigFamily = new Family(mom, papa);
    Family bigFamily2 = new Family(mom1, papa2);

    @Test
    public void should_Add_Child() {
        bigFamily2.addChild(child3);
        Assertions.assertEquals(1, bigFamily2.getChildren().size());
    }
    @Test
    public void should_Delete_Child_By_Pass_Object() {
        bigFamily.addChild(child1);
        boolean result = bigFamily.deleteChild(child1);
        Assertions.assertEquals(0, bigFamily.getChildren().size());
        Assertions.assertTrue(result);
    }

 @Test
 public void should_delete_chilid_by_pass_index () {
     bigFamily.addChild(child5);
     boolean result = bigFamily.deleteChild(0);
     Assertions.assertEquals(0, bigFamily.getChildren().size());
     Assertions.assertTrue(result);
 }

    @Test
    public void should_return_correct_count_after__add__child(){
        bigFamily.addChild(child1);
        int result = bigFamily.countFamily();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void should_return_correct__number_of_pets(){
        Set<Pet> allpets = bigFamily.getPets();
        int result = allpets.size();
        Assertions.assertNotEquals(1, result);
    }
}
