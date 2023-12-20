public class List{
    Node head = null; // start of the linked list 

    static public class Node{  
    Node next;
    Object data;
    

        Node(Object d, Node node){ // Node constructor 
            data = d;
            next = node;
        }
    }

    // inserts object into list while shifting it down
    /* 10, 20, 30
     * insert(50, 1)
     * 10, 50, 20, 30
     * @param data object being added at int index
     */ 
    public void insert(Object data, int index){
        if(head == null){ // if head is null then new node is created as head
            head = new Node(data, null);
        }
        else if(head.next == null){ // if list is of size 1 then new node is added
            head.next = new Node(data, null);
        }
        else if(index > size()){ // if index is greater in size then exception should be thrown 
            throw new LinkedListException("error");
        }
        else if(index == 0){ // index = 0 should reassign the head 
            Node newNode = new Node(data, this.head);
            head = newNode;
        }
        else{ // if linked list is greater than 2 then object should be added with while loop while creating new node 
            int counter = 0;
            Node pointer = this.head;
            while(counter != index - 1){
                counter++;
                pointer = pointer.next;
                   
            }
            Node newNode = new Node(data,pointer.next);
            pointer.next = newNode;
        
        }
    }

    /*
     * adding node to the end of the array 
     * @param Object next is the one being added to the 
     * end of list
     */
    public void append(Object next){ 
        //Node node = new Node(next,null);

        if(head == null){
            head = new Node(next, null);
            return;
        }

        Node n =  head;
        while(n.next != null){
                n = n.next;
        }
        n.next = new Node(next, null);
        }
    

    /**
     * removing element from list
     * 10, 20, 30
     * remove(1)
     * 10, 30
     * @param index of the element that needs to be removed
     */
    public Object remove(int index) { 
        Object result = null;
        if(this.head == null){
            throw new LinkedListException("Error");
        }
        else if(this.head.next == null){
            this.head = null;
        }
        else if(index > this.size()){
            throw new LinkedListException("Error");
        }
        else if(index == 0){
            this.head.next = this.head.next.next;
        }
        else if(index == 1){
            this.head.next = head.next.next;
        }
        else if(size() >= 2){ // same logic as insert but reversed 
            int count = 0;
            Node point = this.head;
            while(count != index - 1){
                count++;
                point = point.next;
            }
            if (point.next.next == null){
                point.next = null;
                //throw new LinkedListException("Error");
            }
            else{
                point.next = point.next.next;
            }
        }
        return result;

    } 

    /*
     * @returns the string version of the linked list
     */
    public String toString(){
        String retVal = ""; 
        Node node = head; 

        while(node != null){
            retVal += node.data + " ";
            node = node.next;
        }

        return retVal + " ";
    }

    /*
     * @returns the size of the linked list
     */
    public int size(){
        int length = 0;
        Node pointer = this.head;
        while(pointer != null){
            length++;
            pointer = pointer.next;
        }
        return length; 
    }

    /*
     * removes element but doesnt return the removed value
     * @param index that needs to be deleted
     */
    public void delete(int index){
        remove(index);

    }

    /* 
     * checks if list is empty. 
     * @returns true if yes false if not
     */
    public boolean isEmpty(){
        return this.size() == 0;
    }

    /* 
     * @returns the index an object is at
     */
    public int indexOf(Object target){
        Node pointer = head;
        int count = 0;
        if(!(target instanceof Node)){
            return -1;
        }
        else{
            while(head != null){
                if(pointer == target){
                    return count;
                }
                pointer = head.next;
                count++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();
        List test = new List();
        
        one.append(5); 
        //one.append(6);
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);
        //test.delete(0); // throws linked list exception "error"
    
        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);	
    
        one.delete(0);
        multiple.delete(1);
        System.out.println("One (upon delete):"+one);
        System.out.println("Multiple (upon delete):"+ multiple);
    
        one.insert(600, 1);
        multiple.insert(400, 2);
        System.out.println("One (on insert):"+one);
        System.out.println("Multiple(on insert):"+ multiple);
    }


}