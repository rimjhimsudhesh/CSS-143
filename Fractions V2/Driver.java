import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.InputMismatchException;

//main class to access all other classes
// this class calls compare and increment to check 
// if there are any of the same fractions
// if not then unique fraction counter object is added to 
// fractionCounter array. Prints out "fraction" + has a count
// of + "count"

public class Driver{


    public static void main(String [] args) {
        try{
            File read = new File("fractions.txt"); 
            Scanner reader = new Scanner(read);
            Fraction fraction = new Fraction();
            FractionCounter fracCtr = new FractionCounter(fraction);
            ObjectList list = new ObjectList();        
            while (reader.hasNextLine()) { // reads file
                fraction = new Fraction(reader.nextLine());
                if(!fraction.isValid()){
                    continue;
                } 
                boolean fracCount_exists = false; // set flag as false 
                for(int i = 0; i < list.numOfElements() ; i++){ // loops through FractionCounter array
                    fracCtr = list.getElementByIndex(i); // assigns fraction counter to the elements of list

                    if(fracCtr.compareAndIncrement(fraction)){                     
                        fracCount_exists = true;  // checks if they are the same if not then true
                        break;
                    } 
                }
                if(fracCount_exists != true){
                    fracCtr = new FractionCounter(fraction); // if unique then adds to the array
                    list.add(fracCtr);
                }
            
            }

            System.out.println("**done with the whole thing. Now printing final output");
            for(int i = 0; i < list.numOfElements() ; i++){
                System.out.println(list.getElementByIndex(i).toString());   // prints the count and fraction
            }


        }   

        

        catch(FileNotFoundException  | InputMismatchException | NumberFormatException  e) { // catches errors of unreasonable typos
            System.out.println("the file is corrupted");
            return;
        }
    
        
        
    }

   
    
}