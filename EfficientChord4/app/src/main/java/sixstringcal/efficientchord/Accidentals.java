package sixstringcal.efficientchord;

       //This is the class for accidentals which is a subclass of chord.
public class Accidentals extends Chord {
           private int[] tempStore = new int[999];
       // This integer array of played notes is for calculating the notes played and is at 999 just in case.
    private int[] playedNotes = new int[999];

       // This method gets the played notes from the accidentals.
    public int[] getPlayedNotes(){

       // This returns the played notes.
        return playedNotes;
    }
       // This decides the relations.
    public void findRelations(int flatsAndSharps){
        tempStore = getNotes();
        tempStore[getLength()] = flatsAndSharps;
        setLength(getLength()+1);
    }

       // This displays options for the accidentals.
    public void display(){

    }
}
