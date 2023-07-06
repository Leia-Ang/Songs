package sg.edu.rp.c346.id22011199.songs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView tvSongTitle;

    EditText etSongTitle;

    TextView tvSinger;
    EditText etSinger;

    TextView tvYear;
    EditText etYear;

    TextView tvStars;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;
    RadioButton RB4;
    RadioButton RB5;

    Button btnInsert;
    Button btnShow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSongTitle = findViewById(R.id.tvSongTitle);
        etSongTitle = findViewById(R.id.etSongTitle);
        tvSinger = findViewById(R.id.tvSinger);
        etSinger = findViewById(R.id.etSinger);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvStars = findViewById(R.id.tvStars);
        RB1 = findViewById(R.id.RB1);
        RB2 = findViewById(R.id.RB2);
        RB3 = findViewById(R.id.RB3);
        RB4 = findViewById(R.id.RB4);
        RB5 = findViewById(R.id.RB5);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertSong(etSongTitle.getText().toString(), etSinger.getText().toString(), Integer.parseInt(etYear.getText().toString());
                db.close();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Songs> data = db.getSongsContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Songs ", i +". "+Songs.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvSongTitle.setText(txt);


            }
        });



    }
}