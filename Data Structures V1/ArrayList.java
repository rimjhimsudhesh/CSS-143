/*Class that implements the methods of
ArrayLists using an Array
*/

import java.util.Arrays;

public class ArrayList{

    private Object [] arrayList = new Object[100];
    private int numElements = 0;


    /*
     * Sets the number of elements:
     * since arrays cannot be dynamic
     * I set the array to be a large number
     * and only count the length where there
     * are elements presents. Essentially 
     * not null. 
     */

    public void setNumElements(){
        numElements = 0;
        for(int i = 0; i < arrayList.length; i++){
            if(arrayList[i] == null){
                continue;
            }
            
            else{
                numElements++;
            }
        }
    }

    /*
     * returns the number of elements
     * in the array that aren't empty.
     * !null 
     */
    public int getNumElements(){
        return numElements;
    }

    /* 
     * this method adds the object Elem at the given
     * index then shifts every element after it to the right
     * 
     * Example:
     * Array before add: ['c', 'v', 'r', 'g', '7']
     * add('t', 1)
     * Array after add: ['c', 't', 'v', 'r', 'g', '7']
     */
    void add(Object elem, int index){
        for(int i = arrayList.length-1; i > index; i--){
            arrayList[i] = arrayList[i - 1];
        }


        insert(elem, index);
    }
    

    /*
     * inserts an object at the given elem
     * but overrides the element that is already there
     * Example:
     * Array before insert: ['c', 'v', 'r', 'g', '7']
     * insert('b', 3)
     * Array after insert: ['c', 'v', 'r', 'b', '7'] --> 'g' is replaced with 'b'
     */
    void insert(Object elem, int index){
        arrayList[index] = elem;
        numElements++;
    } 

    /*
     * removes the element at given index
     * Example:
     * Array before remove: ['c', 'v', 'r', 'g', '7']
     * remove(2)
     * Array after remove: ['c', 'v', 'g', '7'] --> 'r' is gone
     */
    void remove(int index){
        arrayList[index] = null;
        for(int i = index; i < arrayList.length-1; i++){
            arrayList[i] = arrayList[i+1];
            
        } 
        numElements--;

    }

    /*
     * returns the length of the array
     * 
     */
    int size(){
        return getNumElements();
    }

    /*
     * returns the array in 
     * string form.
     * [a, y, u, p, u]
     * toString()
     * a y u p u
     */
    public String toString(){
        String retVal = "";
        for(int i = 0; i < getNumElements(); i++){
            retVal += arrayList[i] + " ";
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
        if(getNumElements() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * returns the index of given element.
     * if user wanted to know index of '1'
     * and the array is [1, 7, 6, 9]
     * then it will return 0 
     */
    int indexOf(Object elem){
        for(int i = 0; i < getNumElements(); i++){
            if(arrayList[i] == elem){
                return i;
            }

            
        
        }

        return -1;
    }

    /* checks if two arrays are equal by comparing size 
     * and elements. if an array is [1, 0, 6, 7]
     * and second array is [1, 6, 7, 0] this will return
     * false. But if they were in the same order they will
     * return true
     */
    public boolean equals(Object other){
        if(this == other){
            return true;
        }

        if(!(other instanceof ArrayList)){
            return false;
        }

        ArrayList that = (ArrayList) other;

        for(int i = 0; i < getNumElements(); i++){
            Object arrayList1 = get(i);
            Object arrayList2 = that.get(i);

            if(!arrayList1.equals(arrayList2)){
                return false;
            }
        }

        return true;

    }  

    /*
     * returns the element that is at given index
     * if user wanted index 0 of array [1,6,7,8]
     * this method will return 1. 
     */
    Object get(int index){
        Object result = 'o';
        for(int i = 0; i < arrayList.length; i++){
            if(arrayList[index] == arrayList[i]){
                result = arrayList[i];
            }
        }
        return result;
    }



    
    


}