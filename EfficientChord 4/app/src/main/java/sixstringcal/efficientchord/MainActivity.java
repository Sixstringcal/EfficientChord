package sixstringcal.efficientchord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textElement = (TextView) findViewById(R.id.textView2);
        Type firstType = new Type();

        firstType.setType("minor");

        firstType.findNotes();

        Accidentals firstAccidentals;
        firstAccidentals = new Accidentals();

        firstAccidentals.findRelations(5);
        String a;
        a = Arrays.toString(firstAccidentals.getNotes());
        textElement.setText(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
