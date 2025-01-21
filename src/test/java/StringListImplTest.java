import org.example.IntegerListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringListImplTest {
    private IntegerListImpl integerListImpl;
    private IntegerListImpl integerListImpl1;

    @BeforeEach
    public void setUp() {
        integerListImpl = new IntegerListImpl(5);
        integerListImpl1 = new IntegerListImpl(5);
    }

    @Test
    public void add() {

        int item1 = 1;
        int item2 = 2;
        int item3 = 3;

        integerListImpl.add(item1);
        integerListImpl.add(item2);
        int result = integerListImpl.add(item3);

        // Проверяем, что возвращенный элемент равен добавленному
        assertEquals(item3, result);

        //Проверяем, что все элементы действительно добавлены в массив
        Integer[] items = integerListImpl.getItems();

        assertEquals(3, items.length);
        assertEquals(item1, items[0]);
        assertEquals(item2, items[1]);
        assertEquals(item3, items[2]);
    }

   @Test
   public void addForIndex() {

       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       int item = 15;
       int result = integerListImpl.add(1, item);

       assertEquals(item, result);

       Integer[] items = integerListImpl.getItems();
       assertEquals(3, items.length);
       assertEquals(1, items[0]);
       assertEquals(item, items[1]);
       assertEquals(2, items[2]);
       assertThrows(IndexOutOfBoundsException.class, () -> {
           integerListImpl.add(15, 5);
       });

   }

   @Test
   public void set() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       int item = 15;
       int result = integerListImpl.set(0, item);
       assertEquals(item, result);

       Integer[] items = integerListImpl.getItems();
       assertEquals(2, items.length);
       assertEquals(item, items[0]);
       assertEquals(2, items[1]);
       assertThrows(IndexOutOfBoundsException.class, () -> {
           integerListImpl.set(2, 15);
       });
   }

   @Test
   public void remove() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       int result = integerListImpl.remove(2);
       assertEquals(2, result);

       Integer[] items = integerListImpl.getItems();
       assertEquals(1, items[0]);
       assertEquals(3, items[1]);

       assertThrows(IllegalArgumentException.class, () -> {
           integerListImpl.remove(4);
       });
   }

   @Test
   public void removeForIndex() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       int result = integerListImpl.remove(1);
       assertEquals(2, result);

       Integer[] items = integerListImpl.getItems();
       assertEquals(1, items[0]);
       assertEquals(3, items[1]);

       assertThrows(IllegalArgumentException.class, () -> {
           integerListImpl.remove(3);
       });
   }

   @Test
   public void contains() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       assertTrue(integerListImpl.contains(1));
       assertTrue(integerListImpl.contains(2));
       assertTrue(integerListImpl.contains(3));
       assertFalse(integerListImpl.contains(4));

   }

   @Test
   public void indexOf() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       assertEquals(0, integerListImpl.indexOf(1));
       assertEquals(1, integerListImpl.indexOf(2));
       assertEquals(2, integerListImpl.indexOf(3));
       assertEquals(-1, integerListImpl.indexOf(4));
   }

   @Test
   public void lastIndexOf() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       assertEquals(2, integerListImpl.lastIndexOf(3));
       assertEquals(1, integerListImpl.lastIndexOf(2));
       assertEquals(0, integerListImpl.lastIndexOf(1));
       assertEquals(-1, integerListImpl.lastIndexOf(4));

   }

   @Test
   public void get() {
       integerListImpl.add(0, 1);
       integerListImpl.add(1, 2);
       integerListImpl.add(2, 3);

       assertEquals(1, integerListImpl.get(0));
       assertEquals(2, integerListImpl.get(1));
       assertEquals(3, integerListImpl.get(2));
       assertThrows(IllegalArgumentException.class, () -> {
           integerListImpl.get(-1);
       });
       assertThrows(IllegalArgumentException.class, () -> {
           integerListImpl.get(-3);

       });
   }

//   @Test
//   public void equals() {
//       stringListImpl.add(0, "Item1");
//       stringListImpl.add(1, "Item2");
//       stringListImpl.add(2, "Item3");

//       stringListImpl1.add(0, "Item1");
//       stringListImpl1.add(1, "Item2");
//       stringListImpl1.add(2, "Item3");

//       assertTrue(stringListImpl.equals(stringListImpl1));
//       assertTrue(stringListImpl1.equals(stringListImpl));

//   }

//   @Test

//   public void size() {
//       assertEquals(0, stringListImpl.size());

//       stringListImpl.add(0, "Item1");
//       stringListImpl.add(1, "Item2");
//       stringListImpl.add(2, "Item3");

//       assertEquals(3, stringListImpl.size());

//   }

//   @Test
//   public void isEmpty() {
//       assertTrue(stringListImpl.isEmpty());

//       stringListImpl.add(0, "Item1");
//       assertFalse(stringListImpl.isEmpty());

//   }

//   @Test
//   public void clear() {
//       stringListImpl.add(0, "Item1");
//       stringListImpl.add(1, "Item2");
//       stringListImpl.add(2, "Item3");

//       stringListImpl.clear();

//       assertEquals(0, stringListImpl.size());
//   }

//   @Test
//   public void toArray() {
//       assertEquals(0, stringListImpl.size());
//       stringListImpl.add("Hello ");
//       assertArrayEquals(new String[] {"Hello "}, stringListImpl.toArray());
//       stringListImpl.add("World ");
//       assertArrayEquals(new String[]{"Hello ", "World "}, stringListImpl.toArray());
//       stringListImpl.add("!");
//       assertArrayEquals(new String[]{"Hello ", "World ", "!"}, stringListImpl.toArray());

//   }
}