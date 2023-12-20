public class FractionCounter{

    Fraction fraction;
    int counter = 0;

    public FractionCounter(){

    }

    //set 
    FractionCounter (Fraction theFraction){ 
        fraction = theFraction;
        counter = 1;
    }

    boolean compareAndIncrement(Fraction newFraction){
        if((newFraction.getNumerator() == fraction.getNumerator()) && (newFraction.getDenominator() == fraction.getDenominator())){
            //System.out.println("here");
            counter++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        //System.out.println(fraction);
        return fraction + " has a count of " + counter + "\n";
    } 
}