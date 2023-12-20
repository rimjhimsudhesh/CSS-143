/*
 * Queues extends LinkedList
 */
public class Queues extends List{
    /*
     * inserts @param Object next 
     * in list
     */
    public void enqueue(Object next){
        super.append(next);
    }

    /*
     * @returns object that has been removed
     */
    public Object dequeue(){
        return super.remove(0);
    }

    public void delete(int index){
        super.remove(index);
    }

    public Object remove(int index){
        return super.remove(index);
    }

    public void insert(Object next, int index){
        push(next);
    }

    public void append(Object next){
        push(next);
    }

    public String toString(){
        return super.toString();
    }

    public int size(){
        return super.size();
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

    public int indexOf(Object target){
        // Throw an LinkedListException if the method is called
        throw new LinkedListException();
    }

    public static void main(String [] args){
        Queues myList = new Queues();
        myList.enqueue(9);
        myList.enqueue("i");
        myList.enqueue("r");
        //myList.dequeue();
        System.out.println(myList.toString());
        System.out.println("size is: " + myList.size()); 
        //myList.dequeue();
    }
}
