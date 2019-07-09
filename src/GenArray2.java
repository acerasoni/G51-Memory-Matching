
import java.util.Iterator;

public class GenArray2<T> implements Iterable<T> {

	protected Object[] myArray;

	public GenArray2(int size) {
		myArray = new Object[size];
	}

	public void set(int index, T value) {
		myArray[index] = value;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) myArray[index];
	}

	class MyIterator implements Iterator<T> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < myArray.length;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) myArray[index++];
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	public static void main(String[] args) {

		GenArray2<String> array2 = new GenArray2<String>(5);

		for (int i = 0; i < 5; i++)
			array2.set(i, "Hello" + i);

		// Don�t care what type of iterator it is�
		Iterator<String> it = array2.iterator();
		while (it.hasNext())
			System.out.println("" + it.next());
		for (String str : array2)
			System.out.println("" + str);
	}

}