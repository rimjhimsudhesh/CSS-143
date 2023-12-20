/**
 * The Exception class throws an error if called
 * It is called when an error has occured
 * This exception extends the RuntimeException class and
 * can be thrown at runtime
 * 
 * @author Rimjhim Sudhesh
*/

public class ExceptionClass extends RuntimeException {
    /**
    * Constructs an ItemNotFoundException with the default message "Cannot be found".
    */
    public ExceptionClass(){
        super(" Cannot be found");
    }

    /**
     * Constructs an ItemNotFoundException with a specified message.
     * @param message the detail message
     */
    public ExceptionClass(String message){
        super(message);
    }
}

