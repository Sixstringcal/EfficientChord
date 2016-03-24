package sixstringcal.efficientchord;

/**
 * This is the superclass of the application.
 * This is where all of the gets and sets are for all the other subclasses as well as some others.
 */
public class Chord{

    /*
    *     Creates the variables needed.
    */
    private String type, interval;

    //keeps track of length.
    private int length = 0;

    /**
     * This sets the length to the variable aL that is passed in.
     * @param aL is used to set the length to it.
     */
    public void setLength(int aL){

        //sets length.
        length=aL;
    }

    /**
     * This returns the length.  It is mainly used for the logic of the application.
     * @return length is used for computations for the chord and the application as a whole.
     */
    public int getLength(){

        // gets length
        return length;
    }

    // stores the root.
    private int root;

    /*
    *    This tells the relations between notes for type.
    */
    private int[] typeRel = new int[999];

    /*
    *     Creates an integer array called notes that has space for 6 integers.
    *     There is only space for 6 integers because there are only 6 strings on a standard guitar and this application only works for a 6 string guitar.
    *     It is an integer because the note can be read as an integer.
    */
    private int[] notes = new int[6];

    /*
    *     This creates a string array with 999 spots.
    *     There are 999 spots because the user might want lots and at that point, the user can decide what accidentals they care about because that's a personal decision.
    *     The array holds accidentals so things like sharp 13 and flat 4 notes that affect the chord.
    *     The array is a string because it needs to have information on if it is sharp or flat.
    */
    private int[] accidental = new int[4];

    /**
     * This is used to return the type to help with the logic and for the type of chord to be displayed to the user.
     * @return type to the user and also to help with the logic of the application.
     */
    public String getType(){

       // This returns the value of type.
        return type;
    }

    /**
     * This sets the chord type to the tempType passed in.
     * @param tempType is what the type of the chord is set to.
     */
    public void setType(String tempType){

       // This sets the type by the value passed in.
        type= tempType;
    }


    /**
     * This gets the interval for the chord and returns it.
     * @return interval to be shown to the user and for some logic in the application.
     */
    public String getInterval(){

       // This returns the value of interval.
        return interval;
    }


    /**
     * This sets the interval of the chord to the value of aInterval
     * @param aInterval is what the interval is set to.
     */
    public void setInterval(String aInterval){

       // This sets the interval to the value passed in.
        interval = aInterval;
    }




    /**
     * This sets the accidentals for the chord to tempAccidentals.
     * This also converts the accidentals into integer notation which is easier to use in an application.
     * This also will lead to nicer chord names in case the user put it in not nicely, example: B# = C.
     * @param tempAccidentals is what accidentals is set to.
     */
    public void setAccidentals(String[][] tempAccidentals){
        for(int i = 0; i<4; i++){
            switch(tempAccidentals[1][i]){
                case "A":
                    accidental[i] = 0;
                    break;
                case "B":
                    accidental[i] = 2;
                    break;
                case "C":
                    accidental[i] = 3;
                    break;
                case "D":
                    accidental[i] = 5;
                    break;
                case "E":
                    accidental[i] = 7;
                    break;
                case "F":
                    accidental[i] = 8;
                    break;
                case "G":
                    accidental[i] = 10;
                    break;
            }
            if(tempAccidentals[0][i] == "#"){
                accidental[i] = accidental[i] + 1;
            }
            else if(tempAccidentals[0][i] == "b" && accidental[i] > 0){
                accidental[i] = accidental[i] - 1;
            }
            else if(tempAccidentals[0][i] == "b" && accidental[i] == 0){
                accidental[i] = 11;
            }
        }
    }



    /**
     * This returns the value of the accidentals.
     * @return accidental will be returned.
     */
    public int[] getAccidentals(){

       // This returns the accidental of the chord given the number passed in.
        return accidental;
    }



    /**
     * This will make the chord based on what information has been passed in by the user about the chord.
     */
    public void makeCord(){

    }



    /**
     * This will read the chords from a stored and saved file from the device.
     */
    public void readChord(){

    }



    /**
     * this will return the notes so the logic of the application can happen.
     * @return notes so the program will work.
     */
    public int[] getNotes(){

        return notes;
    }



    /**
     * This returns the relationship of the chord in integer notation.
     * @return typeRel for the logic of the application.
     */
    public int[] getTypeRel(){

        return typeRel;
    }



    /**
     * This sets the typeRel to aTypeRel for logic purposes of the application.
     * @param aTypeRel is used to set the type relationship.
     */
    public void setTypeRel(int[] aTypeRel){

       // sets the type relationship.
        typeRel = aTypeRel;
    }
}
