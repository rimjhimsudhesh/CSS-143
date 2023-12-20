import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Rimjhim Sudhesh
 Fractions V1 Assignment
 the purpose of this class is it reads a file "fractions.txt"
 counts the number of fractions then puts the num and den into
 two seperate arrays. then check if the ratios of the fractions 
 are equal. if so then add it to the count and reports the count 
 that each fraction was found in the txt file

 Questions:
 1. I don't think you can solve this without arrays. the least
 number of variables you can use is 4. One for to count the 
 fraction, counter for the times it was found, and two variables
 for numerator and denominator. 

 2. Yes, you can use one array to solve this. The datatype would 
 be a string. 

 3. Nested Class. Composition is used for code reusability. It's done 
 by using an instance variable and instance should be created before
 it is used. 

 4. In my code I used the ratio of a fraction. if multiple fractions are the
 same ratio then you know the fractions are equal
 */

class Solution{
    public static void main(String[]args){
        findRatio();    //calling the function to check for equal ratios
      
    }

    public static void findRatio(){
        int fractionCounter = 0;
        /* 
         * this code is in the try method so that it can catch the file not 
         * found error. first the file is being read then the number of fractions
         * are counter. then arrays of the fraction size are initialized
         */
        try{
            File read = new File("fractions.txt"); 
            Scanner reader = new Scanner(read);
            while (reader.hasNextLine()) {
                fractionCounter++;
                String data = reader.nextLine();
            }
    
            int [] num = new int[fractionCounter]; 
            int [] den = new int[fractionCounter];
            int [] counter = new int[fractionCounter];
            String [] divide = new String[fractionCounter];
            boolean [] ratio = new boolean[fractionCounter];
            int count = 0;
        
            /*
             * File is read again to split fraction into array num
             * and den. 
             */

            File read1 = new File("fractions.txt");
            Scanner reader1 = new Scanner(read1);
            int index = 0;
            while(reader1.hasNextLine()){
                String tempfraction = reader1.nextLine();
                String [] parts = tempfraction.split("/");
                int tempNum = Integer.parseInt(parts[0]);
                int tempDen = Integer.parseInt(parts[1]);
                num[index] = tempNum;
                den[index] = tempDen;
                index++;
                
                //tempNum = 1;
                //tempDen = tempDen/tempNum;
                
            }
            /*
             * num[i]/den[j] fraction is compared to other fracs
             * in the arrays. 
             */
            for(int i = 0; i < fractionCounter;i++){
                if(ratio[i]==true){ //if ratio is true then it can be skipped since it's already been counted for
                    continue;
                }
                
                divide[count] = num[i] + "/" + den[i];
                counter[count] = 1; //count always starts out as 1
                for(int j = i+1; j<fractionCounter;j++){
                    if(num[i]*den[j] == num[j]*den[i]){ //since "/" rounds down (x/y)=(a/b) is also x*b = a*y
                        ratio[j] = true; // if true then ratio array index is true so will be skipped when i index comes to this
                        counter[count]++; // counter is increased

                    }
                }
                count++;



                
            }

            for(int i = 0;i < divide.length;i++){ // printing "[insert fraction] has count of [count]"
                if(divide[i] != null){
                    System.out.println(divide[i] + " has a count of " + counter[i]);
                }
            }


            
            
        
        reader.close();
        } 
        
        catch(FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
            
    
        
    }

    


   
}