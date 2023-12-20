public class ObjectList {

    public FractionCounter [] fractionList = new FractionCounter[1000];
    private int numElements = 0;

    public int numOfElements(){ // returns the number of elements in fractionList to be able to 
        return numElements;     //loop through it in the main functio
    }

    public FractionCounter getElementByIndex(int index){ //index of each element in fractionList
        return fractionList[index];
    }

    public void add(FractionCounter fracCounter){ // adds fractionCounter objects in the fractionList array
        fractionList[numElements] = fracCounter;
        numElements++;
    }

    @Override
    public String toString() { // returns the string of all the elements in fractionList array
        String retVal = "";
        for(int i = 0; i < numElements; i++){
             retVal += fractionList[i];
             //System.out.println(data[i]);
             //System.out.println(retVal.indexOf(i));
        }

        return retVal;
    }



    
    




}
