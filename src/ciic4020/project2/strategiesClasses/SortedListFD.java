package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import ciic4020.project2.sortedlist.SortedArrayList;
import ciic4020.project2.sortedlist.SortedList;

/**
 * This class implements the SortedList strategy to count frequencies in an
 * ArrayList.
 * 
 * @author YOUR NAME HERE
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable. However,
	 * Map.Entry and AbstractMap.SimpleEntry are not Comparable, so we extend
	 * AbstractMap.SimpleEntry and create a Comparable version that we can use with
	 * our SortedList. Note: The K (key) of this class will be the E of
	 * SortedListFD, so it will be Comparable.
	 * 
	 * @author Juan O. Lopez
	 *
	 * @param <K> The type of the key of each entry
	 * @param <V> The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V> extends AbstractMap.SimpleEntry<K, V>
			implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}

	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {

		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		SortedList<ComparableEntry<E, Integer>> sortedlist = new SortedArrayList<ComparableEntry<E, Integer>>(1000);

		for (E val : dataSet) {
			boolean entryFound = false;
			int k = 0;
			for (k = 0; k < sortedlist.size() && !entryFound && sortedlist.get(k).getKey().compareTo(val) < 0; k++) {

			}
			/**
			 * We check to see if i < size first because it might gives us an out of bounds,
			 * if the loop finishes and we enter the if again.
			 * 
			 * If the entry key is equal to the object in data set, we found the object and
			 * the value must be increased by 1.
			 */
			if (k < sortedlist.size() && sortedlist.get(k).getKey().compareTo(val) == 0) {
				sortedlist.get(k).setValue(sortedlist.get(k).getValue() + 1);

			}

			/**
			 * if the entry is not found then we add a new entry to sortedlist.
			 */
			else {
				ComparableEntry<E, Integer> e = new ComparableEntry<E, Integer>(val, 1);
				sortedlist.add(e);
			}
		}
		/**
		 * copies all the elements from sortedlist to results
		 */
		for (int i = 0; i < sortedlist.size(); i++) {
			results.add(new AbstractMap.SimpleEntry<>(sortedlist.get(i).getKey(), sortedlist.get(i).getValue()));
		}
		return results;
	}

}