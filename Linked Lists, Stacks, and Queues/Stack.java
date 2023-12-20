/*
 * Stack extends Linked List
 */

public class Stack extends List{
    /*
     * inserts @param Object next 
     * in list
     */
    public void push(Object next){
        super.append(next);
    }

    /*
     * @returns object that has been removed
     */
    public Object pop(){
        return super.remove(0);
    }

    /*
     * deletes elements 
     * @param at index that has been passed
     */
    public void delete(int index){
          super.remove(index);
    }

    /*
     * @returns remove last element in 
     * list
     */
    public Object remove(){
        return pop();
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
        throw new LinkedListException();
    }

    
    public static void main(String [] args){
        Stack myList = new Stack();
        //myList.pop(); // throws exception and prints "Error"
        myList.push('9'); 
        myList.push('i');
        //myList.pop();
        //myList.pop();
        System.out.println(myList);
        //myList.push(10);
        myList.push(9);
        myList.push(8);
        myList.push(7);
        System.out.println(myList);// should be 7,8,9, 9, i
        myList.pop();
        System.out.println("size is: " + myList.size()); 
    }



}