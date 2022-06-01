package sg.edu.rp.c346.id21012050.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.dbs);
        OCBC = findViewById(R.id.ocbc);
        UOB = findViewById(R.id.uob);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18001111111"));
                startActivity(intentCall);

            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18003633333"));
                startActivity(intentCall);

            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18002222121"));
                startActivity(intentCall);

            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
        } else if (id == R.id.chineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
        } else {
            DBS.setText("Error translation");
            OCBC.setText("Error translation");
            UOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

}