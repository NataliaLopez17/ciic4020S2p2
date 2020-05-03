package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	@Override
	/**
	 * Sorts the dataset first and then examines all objects in the list, to
	 * determine the frequency of each object. Store the entries to the result list.
	 *
	 * @param dataset arraylist to use and count the frequencies of the elements
	 * @return results list of resulting entries
	 */
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {

		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();

		dataSet.sort(null);
		for (E e : dataSet) {
			boolean entryFound = false;
			int j = 0;
			for (j = 0; j < results.size() && !entryFound && results.get(j).getKey().compareTo(e) < 0; j++) {

			}
			/**
			 * 
			 * We check to see if j < size first because it might gives us an out of bounds,
			 * if the loop finishes and we enter the if again.
			 * 
			 * if the entry key is equal to the object in data set, we found the object and
			 * the value must be increased by 1.
			 */
			if (j < results.size() && results.get(j).getKey().compareTo(e) == 0) {
				results.get(j).setValue(results.get(j).getValue() + 1);

			}
			/**
			 * need to create a new entry for the first instance found of object e
			 */
			else {
				Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(e, 1);
				results.add(entry);
			}

		}

		return results;
	}
}
