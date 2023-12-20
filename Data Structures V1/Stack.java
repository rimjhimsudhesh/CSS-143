/*
 * Implements Stack methods using ArrayList
 * object. 
 */

public class Stack {

    ArrayList stackObj = new ArrayList();

    /*
     * adds element at the end of the array
     * same as arrayList add method
     */
    public void push(Object elem){
        stackObj.add(elem, stackObj.getNumElements());
       
        
    }

    /*
     * removes elements from end of the array
     * used arraylist remove method
     */
    public void pop(){
        stackObj.remove(stackObj.getNumElements()-1);
    } 

    /*
     * returns size of the array
     * used arraylist size method 
     */
    int size(){
        return stackObj.size();
    }

    /*
     * returns array in string form
     * top to bottom
     * used arraylist to string method
     */
    public String toString(){
        String retVal = "";
        for(int i = stackObj.getNumElements()-1; i >= 0; i--){
            retVal += stackObj.get(i) + " ";
            //System.out.println(stackObj.get(i));
        }

        return retVal;
    }

    /*
     * checks if array is empty.
     * if array has length of 0 then
     * will return true.
     * if not then will return false
     */
    boolean isEmpty(){
        return stackObj.isEmpty();
    }

    /* checks if two arrays are equal by comparing size 
     * and elements. if an array is [1, 0, 6, 7]
     * and second array is [1, 6, 7, 0] this will return
     * false. But if they were in the same order they will
     * return true
     * 
     * same as arraylist equals method
     */
    public boolean equals(Object other){
        if(!(other instanceof Stack)){
            return false;
        }

        Stack thisStack = (Stack) other;
        return(thisStack.stackObj.equals(stackObj));
    }
    
}
