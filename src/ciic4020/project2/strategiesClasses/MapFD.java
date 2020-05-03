package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}

	/**
	 * Sorts the dataset and examines all objects in the list, to determinethe
	 * frequency of each object. Store the entries to the result list.
	 *
	 * @param dataset arraylist to use and count the frequencies of the elements
	 * @return results list of resulting entries
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		// TODO Auto-generated method stub
		ArrayList<Entry<E, Integer>> result = new ArrayList<Map.Entry<E, Integer>>();
		Map<E, Integer> table = new Hashtable<E, Integer>();

		for (E val : dataSet) {

			/**
			 * if the object is found then we modify the entry by increasing the value by 1
			 */
			if (table.containsKey(val)) {
				table.put(val, table.get(val) + 1);
			}
			/**
			 * if the object is not found then a new entry is added
			 */
			else {
				table.put(val, 1);
			}
		}

		/**
		 * for loop that loops through all the entries in the hashtable and added to the
		 * final list of entries (result).
		 */
		for (Entry<E, Integer> e2 : table.entrySet()) {
			result.add(e2);
		}
		return result;
	}
}
