package sixstringcal.efficientchord;

/**
 * This is a subclass of chord and decides the Type of chord and the relationships.
 */
public class Type extends Chord{


    /**
     * This decides what notes based on the type of chord to be used using interval notation.
     * 0 is not a necessary chord.
     */
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
        else if(super.getType() == "diminished"){
            super.setTypeRel(new int[]{0,3,6});
        }
        else if(super.getType() == "augmented"){
            super.setTypeRel(new int[]{0,4,8});
        }
    }
}
