/*
 *  Driver class for ArrayList, Queue, and Stack
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		queueTests();
		arrayListTests();
        stackTests();
	}

	// drives the arrayList class 
	private static void arrayListTests() {
		//todo: make more tests here
		ArrayList a = new ArrayList();

		
		//a.add('c',7);
		
		a.insert('B', 0);
		a.insert('a',0);
		a.insert('t',1);
		a.add('c',1);
		a.add('r',1);
		a.remove(2);
		a.insert('m',1);
		a.add('h',0);
		a.insert('u',0);
		a.remove(0);


		System.out.println(a.get(0));
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		System.out.println(a.indexOf('c'));	 	
		a.setNumElements();
		System.out.println(a.toString());
		System.out.println(a.equals(a));
		
		while(a.isEmpty() == false) {
			a.remove(0);
			//System.out.println(a.toString());
		}   
		
	}

	// drives the queue class
	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();
		
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		a.dequeue();
		a.dequeue();
		System.out.println(a.equals(a));
		System.out.println(a.toString());
		System.out.println(a.size());
		
		while(a.isEmpty() == false) {
			a.dequeue();
		} 

	}

	// drives the stack class
	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();
		
		a.push('B');
		a.push('a');
		a.push('t');
		a.pop();
		//a.pop();
		
		System.out.println(a.size());
		System.out.println(a.equals(a));
		System.out.println(a.toString());
		System.out.println(a.isEmpty());
		
		while(a.isEmpty() == false) {
			a.pop();
		}  
	}
	

}
