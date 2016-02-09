package testsuites0802maven.features;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import testsuites0802maven.categories.Smoke;

import static testsuites0802maven.pages.ToDoMVC.*;

@Category(Smoke.class)
public class TodosE2ETest extends BaseTest {

    @Test
    public void testTasksCommonFlow() {

        givenAtAll();
        add("a");
        assertVisibleTasks("a");
        toggleAll();

        filterActive();
        assertEmptyVisibleTasks();

        add("b");
        toggle("b");
        assertEmptyVisibleTasks();

        filterCompleted();
        assertVisibleTasks("a", "b");

        //activate task
        toggle("a");
        assertVisibleTasks("b");

        сlearCompleted();
        assertEmptyVisibleTasks();
        assertItemsLeft(1);

        filterAll();
        delete("a");
        assertEmptyTasks();
    }
}
