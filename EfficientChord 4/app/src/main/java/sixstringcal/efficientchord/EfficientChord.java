package sixstringcal.efficientchord;

import java.util.Arrays;

// this is the class with the main method.
public class EfficientChord {

    // this is the main method.
    public static void main (String[] args){

        // creates the new chord object.
        Type firstType = new Type();

        firstType.setType("minor");

        firstType.findNotes();

        Accidentals firstAccidentals = new Accidentals();

        firstAccidentals.findRelations(5);
        String a;
        a = Arrays.toString(firstAccidentals.getNotes());

    }
}
