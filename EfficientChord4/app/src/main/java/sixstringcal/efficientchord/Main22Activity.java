package sixstringcal.efficientchord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import static sixstringcal.efficientchord.R.layout.activity_main22;
import static sixstringcal.efficientchord.R.layout.activity_set_chord;

/**
 * This is the class to create the frame/activity for the chord creator page/frame.
 */
public class Main22Activity extends AppCompatActivity implements View.OnClickListener {
    Button addAccidentals;
    Button addInterval;
    Button addChord;
    int number = 4;
    Button viewChords;
    RadioButton naturalBttn;
    RadioButton sharpBttn;
    RadioButton flatBttn;
    RadioButton minorBttn;
    RadioButton majorBttn;
    RadioButton diminishedBttn;
    Button viewChordsButton;
    String accidentalState;
    String[][] storedAccidentals = new String[2][4];
    RadioGroup typeGroup;
    Switch sharpSwitch;
    RadioButton augmentedBttn;
    RadioGroup rootGroup;
    int maxNumberOfChords = 999999;
    int[][][] chords = new int[3][maxNumberOfChords+1][];
    int currentChordNumber;
    String typeOfChord = "major";
    int[] typeInt = {0};

    @Override
    /**
     * This just creates the frame/activity/window.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_set_chord);
        addAccidentals = (Button) findViewById(R.id.button4);
        addAccidentals.setOnClickListener(this);
        currentChordNumber = 0;
        sharpSwitch = (Switch) findViewById(R.id.switch1);
        sharpSwitch.bringToFront();
        accidentalState = "♮";
        augmentedBttn = (RadioButton) findViewById(R.id.radioButton11);
        augmentedBttn.setOnClickListener(this);
        diminishedBttn = (RadioButton) findViewById(R.id.radioButton10);
        diminishedBttn.setOnClickListener(this);
        majorBttn = (RadioButton) findViewById(R.id.radioButton8);
        majorBttn.setOnClickListener(this);
        minorBttn = (RadioButton) findViewById(R.id.radioButton9);
        minorBttn.setOnClickListener(this);
        viewChordsButton = (Button) findViewById(R.id.button2);
        viewChordsButton.bringToFront();
        typeGroup = (RadioGroup) findViewById(R.id.radioGroups);
        typeGroup.bringToFront();
        rootGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rootGroup.bringToFront();
        addInterval = (Button) findViewById(R.id.button3);
        addInterval.setOnClickListener(this);
        addChord = (Button) findViewById(R.id.button);
        addChord.setOnClickListener(this);
        viewChords = (Button) findViewById(R.id.button2);
        viewChords.setOnClickListener(this);
        naturalBttn = (RadioButton) findViewById(R.id.radioButton3);
        naturalBttn.setOnClickListener(this);
        sharpBttn = (RadioButton) findViewById(R.id.radioButton);
        sharpBttn.setOnClickListener(this);
        flatBttn = (RadioButton) findViewById(R.id.radioButton2);
        flatBttn.setOnClickListener(this);
    }

    TextView accidentalView;



    /**
     * This stores the type of accidental in the array to decide later on if it is sharp or flat (+/-1 in integer notation).
     * @param type is stored in the storedAccidentals array.
     */
    public void setCurrentAccidental(String type){
        accidentalState = type;
        storedAccidentals[0][number-4] = type;
    }


    /**
     * This creates the text for the currently invisible textViews so they can be seen with the current amount of accidentals.
     * Once four accidentals have been passed in, it alerts the user that there cannot be any more accidentals passed in.
     * It also updates the storedAccidentals variable and puts the new accidentals in there.
     */
    private void addAccidentalsClicked(){
        switch (number){
            case 4:
                accidentalView = (TextView) findViewById(R.id.textView4);
                break;
            case 5:
                accidentalView = (TextView) findViewById(R.id.textView5);
                break;
            case 6:
                accidentalView = (TextView) findViewById(R.id.textView6);
                break;
            case 7:
                accidentalView = (TextView) findViewById(R.id.textView7);
                TextView accidentalWarning = (TextView) findViewById(R.id.textView8);
                accidentalWarning.setText("Max Accidentals Hit");

                break;
        }
        EditText addABttn;
        addABttn = (EditText) findViewById(R.id.editText);
        accidentalView.setText(accidentalState+(addABttn).getText().toString());
        storedAccidentals[1][number-4] = (addABttn).getText().toString();
        if(number<7){
            number++;
        }


    }


    /**
     * This will make it so the current interval is applied
     */
    private void addIntervalClicked(){

    }


    /**
     * This just makes it so that once the Add Chord button is clicked that the information will be created for the chords.
     */
    private void addChordClicked(){
        if(currentChordNumber < maxNumberOfChords+1) {
            Type firstType = new Type();


            firstType.setType(typeOfChord);

            firstType.findNotes();

            Accidentals firstAccidentals = new Accidentals();
            firstAccidentals.setAccidentals(storedAccidentals);
            firstAccidentals.findRelations(5);
            if(typeOfChord == "major"){
                typeInt[0] = 0;
            }
            else if(typeOfChord == "minor"){
                typeInt[0] = 1;
            }
            else if(typeOfChord == "diminished"){
                typeInt[0] = 2;
            }
            else if(typeOfChord == "augmented"){
                typeInt[0] = 3;
            }
            chords[0][currentChordNumber] = firstAccidentals.getAccidentals();
            chords[1][currentChordNumber] = typeInt;
        }
    }


    /**
     * This lets the user look at what chords they have created so far and starts the activity to view them.
     */
    private void viewChordsClicked(){
        startActivity(new Intent("sixstringcal.efficientchord.ChordDemo"));
    }

    @Override
    /**
     * This just handles what happens on each button/radioButton/etc.
     * Basically just a bunch of checks to decide what to do.
     */
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                addAccidentalsClicked();
                break;
            case R.id.button3:
                addIntervalClicked();
                break;
            case R.id.button:
                addChordClicked();
                break;
            case R.id.button2:
                viewChordsClicked();
                break;
            case R.id.radioButton3:
                setCurrentAccidental("♮");
                break;
            case R.id.radioButton:
                setCurrentAccidental("#");
                break;
            case R.id.radioButton2:
                setCurrentAccidental("b");
                break;
            case R.id.radioButton9:
                typeOfChord = "minor";
                break;
            case R.id.radioButton8:
                typeOfChord = "major";
                break;
            case R.id.radioButton10:
                typeOfChord = "diminished";
                break;
            case R.id.radioButton11:
                typeOfChord = "augmented";
                break;
        }
    }
}
