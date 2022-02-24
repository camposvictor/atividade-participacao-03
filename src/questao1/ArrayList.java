package questao1;

import java.util.Iterator;

public class ArrayList<T extends Object>
    implements Iterable<T> {
  private T[] array;
  private int elementCount;

  public ArrayList() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public ArrayList(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Tamanho deve ser maior que zero");
    }
    array = (T[]) new Object[size];
    elementCount = 0;
  }

  private boolean isFull() {
    return elementCount == array.length;
  }

  public boolean isEmpty() {
    return elementCount == 0;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    T[] newArray = (T[]) new Object[array.length * 2];
    System.arraycopy(array, 0, newArray, 0, array.length);
    array = newArray;
  }

  public void add(T element) {
    if (isFull())
      resize();

    array[elementCount++] = element;
  }

  public T get(int index) {
    if (index < 0 || index >= elementCount) {
      throw new IndexOutOfBoundsException();
    }

    T element = null;

    try {
      element = this.array[index];
    } catch (IndexOutOfBoundsException e) {
      System.out.println("The index that you specified is not within bounds.");
      System.exit(-1);
    }

    return element;
  }

  public int size() {
    return elementCount;
  }

  public void clear() {
    for (int i = 0; i < elementCount; i++)
      array[i] = null;

    elementCount = 0;
  }

  public Iterator<T> iterator() {
    return new ArrayListIterator();
  }

  private class ArrayListIterator implements Iterator<T> {
    private int currentIndex;

    public ArrayListIterator() {
      currentIndex = 0;
    }

    public boolean hasNext() {
      return currentIndex < elementCount;
    }

    public T next() {
      if (!hasNext())
        throw new IndexOutOfBoundsException();

      return array[currentIndex++];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
