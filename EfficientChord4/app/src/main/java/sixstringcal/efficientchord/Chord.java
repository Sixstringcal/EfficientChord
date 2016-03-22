package sixstringcal.efficientchord;

//Superclass
public class Chord{

    /*
    *     Creates the variables needed.
    *     They are strings because it works easier for identification.
    *     Type decides the type of the chord such as major or minor.
    *     Interval decides things like 7 chords and 13 chords.
    *     I cannot find a way to implement an interface, it just doesn't seem like it makes sense in this situation.
    */
    private String type, interval;

    //keeps track of length.
    private int length = 0;

    // sets length.
    public void setLength(int aL){

        //sets length.
        length=aL;
    }

    //gets the length.
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

       // This method gets the type of chord and returns it.
    public String getType(){

       // This returns the value of type.
        return type;
    }

       // This sets the type of the chord to the value passed in.
    public void setType(String tempType){

       // This sets the type by the value passed in.
        type= tempType;
    }

       // This gets the interval for the chord and returns it.
    public String getInterval(){

       // This returns the value of interval.
        return interval;
    }

       // This sets the interval of the chord to the value passed in.
    public void setInterval(String aInterval){

       // This sets the interval to the value passed in.
        interval = aInterval;
    }

       // This sets the accidentals for the chord to the values passed in
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

       // This gets the accidentals for the chord and returns it by the accidental passed in.
    public int[] getAccidentals(){

       // This returns the accidental of the chord given the number passed in.
        return accidental;
    }

       // This method will make the chord given the information given about the chord and the information the app has created.
    public void makeCord(){

       //  Currently empty because I haven't made this part yet.
    }

       //  This reads the chord from the files that will be used that I have not implemented yet.
    public void readChord(){
       // This will get the notes from the file and is not done yet.
    }

       // This will display the chord.
    public void displayChord(){
       // This is not done.
    }

       // This will send the notes.
    public int[] getNotes(){

       // This returns the notes.
        return notes;
    }

       // This just gets the type relationships.
    public int[] getTypeRel(){

       // This returns the type relationship.
        return typeRel;
    }

       // This sets the type relationships.
    public void setTypeRel(int[] aTypeRel){

       // sets the type relationship.
        typeRel = aTypeRel;
    }
}
