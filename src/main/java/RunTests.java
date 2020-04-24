import org.junit.jupiter.api.Test;
import solutions.SolutionsInterface;
import solutions.SolutionsInterfaceImpl;

class RunTests {
    private static SolutionsInterface solver = new SolutionsInterfaceImpl();
    @Test
    void test0() {
        int[] people = {1, 2, 3, 4};
        int minToBeRich = 3;
        System.out.println(solver.maxRichPeople(people, minToBeRich));
    }
    @Test
    void test1() {
        int[] people = {1, 2, 3, 4};
        int minToBeRich = 10;
        System.out.println(solver.maxRichPeople(people, minToBeRich));
    }
    @Test
    void test2() {
        
    }
}
