package sixstringcal.efficientchord;

// this is the class for types and is a subclass of chord.
public class Type extends Chord{

    // this method will display options for the type.
    public void display(){}

    // this method decides if it is major or minor and sets the relations between notes.  It currently only checks major and minor.
    public void findNotes(){

        // This checks if it is major.
        if (super.getType() == "major"){

            // this sets the relationship to that of a major.
            super.setTypeRel(new int[]{0, 4, 7});

        }

        // this checks if it is minor.
        else if(super.getType() == "minor"){

            //this sets the relationship to that of a minor.
            super.setTypeRel(new int[]{0, 3, 7});
        }
    }
}
