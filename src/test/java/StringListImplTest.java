import org.example.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringListImplTest {
    private StringListImpl stringListImpl;
    private StringListImpl stringListImpl1;

    @BeforeEach
    public void setUp() {
        stringListImpl = new StringListImpl(5);
        stringListImpl1 = new StringListImpl(5);
    }

    @Test
    public void add() {

        String item1 = "Item1";
        String item2 = "Item2";
        String item3 = "Item3";

        stringListImpl.add(item1);
        stringListImpl.add(item2);
        String result = stringListImpl.add(item3);

        // Проверяем, что возвращенный элемент равен добавленному
        assertEquals(item3, result);

        //Проверяем, что все элементы действительно добавлены в массив
        String[] items = stringListImpl.getItems();

        assertEquals(3, items.length);
        assertEquals(item1, items[0]);
        assertEquals(item2, items[1]);
        assertEquals(item3, items[2]);
    }

    @Test
    public void addForIndex() {

        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        String item = "TestItem";
        String result = stringListImpl.add(1, item);

        assertEquals(item, result);

        String[] items = stringListImpl.getItems();
        assertEquals(3, items.length);
        assertEquals("Item1", items[0]);
        assertEquals(item, items[1]);
        assertEquals("Item2", items[2]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringListImpl.add(15, "TestItem");
        });

    }

    @Test
    public void set() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        String item = "TestItem";
        String result = stringListImpl.set(0, item);
        assertEquals(item, result);

        String[] items = stringListImpl.getItems();
        assertEquals(2, items.length);
        assertEquals(item, items[0]);
        assertEquals("Item2", items[1]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringListImpl.set(2, "TestItem");
        });
    }

    @Test
    public void remove() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        String result = stringListImpl.remove("Item2");
        assertEquals("Item2", result);

        String[] items = stringListImpl.getItems();
        assertEquals("Item1", items[0]);
        assertEquals("Item3", items[1]);

        assertThrows(IllegalArgumentException.class, () -> {
            stringListImpl.remove("Item4");
        });
    }

    @Test
    public void removeForIndex() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        String result = stringListImpl.remove(1);
        assertEquals("Item2", result);

        String[] items = stringListImpl.getItems();
        assertEquals("Item1", items[0]);
        assertEquals("Item3", items[1]);

        assertThrows(IllegalArgumentException.class, () -> {
            stringListImpl.remove(3);
        });
    }

    @Test
    public void contains() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        assertTrue(stringListImpl.contains("Item1"));
        assertTrue(stringListImpl.contains("Item2"));
        assertTrue(stringListImpl.contains("Item3"));
        assertFalse(stringListImpl.contains("Item4"));

    }

    @Test
    public void indexOf() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        assertEquals(0, stringListImpl.indexOf("Item1"));
        assertEquals(1, stringListImpl.indexOf("Item2"));
        assertEquals(2, stringListImpl.indexOf("Item3"));
        assertEquals(-1, stringListImpl.indexOf("Item4"));
    }

    @Test
    public void lastIndexOf() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        assertEquals(2, stringListImpl.lastIndexOf("Item3"));
        assertEquals(1, stringListImpl.lastIndexOf("Item2"));
        assertEquals(0, stringListImpl.lastIndexOf("Item1"));
        assertEquals(-1, stringListImpl.lastIndexOf("Item4"));

    }

    @Test
    public void get() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        assertEquals("Item1", stringListImpl.get(0));
        assertEquals("Item2", stringListImpl.get(1));
        assertEquals("Item3", stringListImpl.get(2));
        assertThrows(IllegalArgumentException.class, () -> {
            stringListImpl.get(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringListImpl.get(-3);

        });
    }

    @Test
    public void equals() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        stringListImpl1.add(0, "Item1");
        stringListImpl1.add(1, "Item2");
        stringListImpl1.add(2, "Item3");

        assertTrue(stringListImpl.equals(stringListImpl1));
        assertTrue(stringListImpl1.equals(stringListImpl));

    }

    @Test

    public void size() {
        assertEquals(0, stringListImpl.size());

        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        assertEquals(3, stringListImpl.size());

    }

    @Test
    public void isEmpty() {
        assertTrue(stringListImpl.isEmpty());

        stringListImpl.add(0, "Item1");
        assertFalse(stringListImpl.isEmpty());

    }

    @Test
    public void clear() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        stringListImpl.add(2, "Item3");

        stringListImpl.clear();

        assertEquals(0, stringListImpl.size());
    }

    @Test
    public void toArray() {
        assertEquals(0, stringListImpl.size());
        stringListImpl.add("Hello ");
        assertArrayEquals(new String[] {"Hello "}, stringListImpl.toArray());
        stringListImpl.add("World ");
        assertArrayEquals(new String[]{"Hello ", "World "}, stringListImpl.toArray());
        stringListImpl.add("!");
        assertArrayEquals(new String[]{"Hello ", "World ", "!"}, stringListImpl.toArray());

    }
}