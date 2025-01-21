package org.example;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] items;
    private int size;

    public IntegerListImpl(int i) {
        this.items = new Integer[10];
        this.size = 0;
    }

    @Override

    public Integer add(int item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size] = item;
        size++;
        return item;
    }

  @Override
  public Integer add(int index, int item) {
      if (index < 0 || index > size) {
          throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
      }
      if (size == items.length) {
          items = Arrays.copyOf(items, items.length * 2);
      }
      System.arraycopy(items, index, items, index + 1, size - index);
      items[index] = item;
      size++;
      return item;
  }

  @Override
  public Integer set(int index, int item) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
      }
      items[index] = item;
      return item;
  }

  @Override
  public Integer remove(int item) {
      int index = -1;
      for (int i = 0; i < size; i++) {
          if (items[i].equals(item)) {
              index = i;
              break;
          }
      }
      if (index == -1) {
          throw new IllegalArgumentException("Item не найден " + item);
      }
      int removerItem = items[index];
      System.arraycopy(items, index + 1, items, index, size - index - 1);
      items[--size] = null;
      return removerItem;
  }

//  @Override
//  public String remove(int index) {
//      {
//          if (index < 0 || index > size) {


//              throw new IllegalArgumentException("Такого индекса массива не существует");
//          }
//          String removerItem = items[index];
//          System.arraycopy(items, index + 1, items, index, size - index - 1);
//          items[--size] = null;


//          return removerItem;
//      }
//  }


//  @Override
//  public boolean contains(String item) {
//      for (int i = 0; i < size; i++) {
//          if (items[i].equals(item)) {
//              return true;
//          }
//      }
//      return false;
//  }

//  @Override
//  public int indexOf(String item) {
//      for (int i = 0; i < size; i++) {
//          if (items[i].equals(item)) {
//              return i;
//          }

//      }
//      return -1;
//  }

//  @Override
//  public int lastIndexOf(String item) {
//      for (int i = 0; i < size; i++) {
//          if (items[i].equals(item)) {
//              return i;
//          }

//      }
//      return -1;
//  }

//  @Override
//  public String get(int index) {
//      if (index < 0 || index >= size) {
//          throw new IllegalArgumentException("Такого индекса не существует");
//      }
//      return items[index];
//  }

//  @Override
//  public boolean equals(IntegerList otherList) {
//      return Arrays.equals(this.toArray(), otherList.toArray());
//  }


//  @Override
//  public int size() {

//      return size;
//  }

//  @Override
//  public boolean isEmpty() {

//      return size == 0;
//  }

//  @Override
//  public void clear() {
//      size = 0;

//  }

//  @Override
//  public String[] toArray() {
//      String[] result = new String[size];
//      System.arraycopy(items, 0, result, 0, size);
//      return result;
//  }

  public Integer[] getItems() {
      return Arrays.copyOf(items, size);
  }

//  public int getSize() {
//      return size;
//  }


//  @Override
//  public int hashCode() {
//      int result = Objects.hash(size);
//      result = 31 * result + Arrays.hashCode(items);
//      return result;
//  }
//
}

