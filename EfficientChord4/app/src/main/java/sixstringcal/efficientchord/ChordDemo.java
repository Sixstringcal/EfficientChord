package sixstringcal.efficientchord;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ChordDemo extends AppCompatActivity {



    @Override
    /**
     *  Loads the frame for displaying the chords and instatiates necessary variables and objects
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Main22Activity setChordsClass = new Main22Activity();
        TextView[] labelChords = new TextView[setChordsClass.currentChordNumber+1];
        for(int i = 0; i < setChordsClass.currentChordNumber; i++){
            labelChords[i] = (TextView) findViewById(R.id.textView9);
            labelChords[i].setText(setChordsClass.chords[2][i]+""+setChordsClass.chords[1][i]+setChordsClass.chords[0][i]);
        }
    }

}
