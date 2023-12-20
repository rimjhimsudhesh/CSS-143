/**
 * The ItemNotFoundException class throws an error if called
 * It is called when a given word cannot be found
 * This exception extends the RuntimeException class and
 * can be thrown at runtime
 * 
 * @author Rimjhim Sudhesh
*/


public class ItemNotFoundException extends RuntimeException {
    /**
    * Constructs an ItemNotFoundException with the default message "Cannot be found".
    */
    public ItemNotFoundException(){
        super(" Cannot be found");
    }

    /**
     * Constructs an ItemNotFoundException with a specified message.
     * @param message the detail message
     */
    public ItemNotFoundException(String message){
        super(message);
    }
}
