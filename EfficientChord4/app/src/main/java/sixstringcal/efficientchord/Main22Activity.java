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

public class Main22Activity extends AppCompatActivity implements View.OnClickListener {
    Button addAccidentals;
    Button addInterval;
    Button addChord;
    int number = 4;
    Button viewChords;
    RadioButton naturalBttn;
    RadioButton sharpBttn;
    RadioButton flatBttn;
    Button viewChordsButton;
    String accidentalState;
    String[][] storedAccidentals = new String[2][4];
    RadioGroup typeGroup;
    Switch sharpSwitch;
    RadioGroup rootGroup;
    int maxNumberOfChords = 999999;
    int[][][] chords = new int[3][maxNumberOfChords+1][];
    int currentChordNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_set_chord);
        addAccidentals = (Button) findViewById(R.id.button4);
        addAccidentals.setOnClickListener(this);
        currentChordNumber = 0;
        sharpSwitch = (Switch) findViewById(R.id.switch1);
        sharpSwitch.bringToFront();
        accidentalState = "♮";
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



    public void setCurrentAccidental(String type){
        accidentalState = type;
        storedAccidentals[0][number-4] = type;
    }

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

    private void addIntervalClicked(){

    }

    private void addChordClicked(){
        if(currentChordNumber < maxNumberOfChords+1) {
            Type firstType = new Type();

            firstType.setType("minor");

            firstType.findNotes();

            Accidentals firstAccidentals = new Accidentals();
            firstAccidentals.setAccidentals(storedAccidentals);
            firstAccidentals.findRelations(5);
            chords[0][currentChordNumber] = firstAccidentals.getAccidentals();
        }
    }

    private void viewChordsClicked(){
        startActivity(new Intent("sixstringcal.efficientchord.ChordDemo"));
    }

    @Override
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
        }
    }
}
