/*
 * Implements Queue methods using ArrayList
 * object. 
 */

 public class Queue {
    ArrayList queueList = new ArrayList();
    int numElement = 0;

    /*
     * adds element from the to.
     * used arraylist add method
     */
    void enqueue(Object elem){
        queueList.add(elem, queueList.getNumElements());
    }

    /*
     * removes elements from the bottom
     * [0, 1, 2, 4]
     * dequeue()
     * [1, 2, 4] 
     * used arraylist remove method
     */
    public void dequeue(){
        //bject result = 'l';
        queueList.remove(0);

    }

    /*
     * returns size of queueList
     * uses arraylist size method 
     */
    int size(){
        return queueList.size();
    }

    /*
     * returns array in form of string
     * bottom to top
     * same as arraylist toString methof
     */
    public String toString(){
        return queueList.toString();
    }
    
     /*
     * checks if array is empty.
     * if array has length of 0 then
     * will return true.
     * if not then will return false
     */
    boolean isEmpty(){
        return queueList.isEmpty();
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
        if(!(other instanceof Queue)){
            return false;
        }

        Queue thisQueue = (Queue) other;
        return(thisQueue.queueList.equals(queueList));
    }

    
}
