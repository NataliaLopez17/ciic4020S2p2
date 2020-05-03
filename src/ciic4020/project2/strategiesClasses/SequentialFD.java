package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class corresponds to the Sequential strategy to count frequencies in an
 * array list.
 * 
 * @author pedroirivera-vega
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SequentialFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public SequentialFD() {
		super("Sequential");
	}

	/**
	 * 
	 * For every element e in dataset we look towards results to see if we have
	 * already seen the element before. If we find it we increase the frequency. If
	 * we don't find it we add e to results with a frequency of 1.
	 * 
	 *
	 * @param dataset arraylist to use and count the frequencies of the elements
	 * @return results list of resulting entries
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {

		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();

		for (E e : dataSet) {
			boolean entryFound = false;
			for (int i = 0; i < results.size() && !entryFound; i++) {
				Map.Entry<E, Integer> entry = results.get(i);

				/**
				 * if the entry key is equal to the object in data set, we found the object and
				 * the value must be increased by 1.
				 */
				if (entry.getKey().equals(e)) {
					entry.setValue(entry.getValue() + 1);
					entryFound = true;
				}
			}
			/**
			 * if the entry is not found then we add a new entry to results for the first
			 * instance found of e
			 */
			if (!entryFound) {
				Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(e, 1);
				results.add(entry);
			}
		}

		return results;
	}

}
