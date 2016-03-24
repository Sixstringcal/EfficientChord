package sixstringcal.efficientchord;

/**
 * This is a subclass of Chord that inherits from the Chord class.
 * This class does the logic with the accidentals.
 */
public class Accidentals extends Chord {
           private int[] tempStore = new int[4];
       // This integer array of played notes is for calculating the notes played and is at 999 just in case.
    private int[] playedNotes = new int[999];

    /**
     * This is the method to get the played notes from the superclass.
     * @return playedNotes to be seen by a user or used for the program's logic.
     */
    public int[] getPlayedNotes(){

       // This returns the played notes.
        return playedNotes;
    }

    /**
     * The relationship of the accidentals are discovered to the chord.
     * @param flatsAndSharps is used to determine the relationships between the notes in integer notation.
     */
    public void findRelations(int flatsAndSharps){
        tempStore = getNotes();
        tempStore[getLength()] = flatsAndSharps;
        setLength(getLength()+1);
    }

}
