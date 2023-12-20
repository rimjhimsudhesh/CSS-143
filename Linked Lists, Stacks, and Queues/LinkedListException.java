public class LinkedListException extends RuntimeException{
    public LinkedListException(){ 
        super("Out of bounds");
    }
    public LinkedListException(String msg){
        super(msg);
        //System.out.println("inside exception..");
    }
}