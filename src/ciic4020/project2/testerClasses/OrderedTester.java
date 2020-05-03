package ciic4020.project2.testerClasses;

import java.io.File;
import java.io.FileNotFoundException;

import ciic4020.project2.strategiesClasses.OrderedFD;

public class OrderedTester {

	public static void main(String[] args) throws FileNotFoundException {
	    GenericFDTester<Integer> tester = 
	    		new GenericFDTester<>(new OrderedFD<Integer>());
	    tester.run(new IntegerDataReader(new File("inputData", "integerData.txt")));

	    GenericFDTester<String> stester = 
	    		new GenericFDTester<>(new OrderedFD<String>());
	    stester.run(new StringDataReader(new File("inputData", "stringData.txt")));
	}

}