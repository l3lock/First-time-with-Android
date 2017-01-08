package app.l3lock.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private ListView main_ListView;
    private Button start_Button;

    private static String URL = "https://github.com/l3lock/First-time-with-Android";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        main_ListView = (ListView) findViewById(R.id.main_ListView);
        start_Button = (Button) findViewById(R.id.start_button);

        // Controller of Button
        start_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sound Effect
                MediaPlayer btn_sound = MediaPlayer.create(
                        getBaseContext(), R.raw.button_21);
                btn_sound.start();

                // Intent Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(URL));
                startActivity(intent);
            }
        });

        // Create ListView
        // Set up Sample Array
        final int[] img = new int[] {
            R.drawable.assassin_logo,
            R.drawable.assassin_logo,
            R.drawable.assassin_logo
        };

        // Set up Array By XML.
        final String[] title = getResources().getStringArray(R.array.title);
        final String[] detail = getResources().getStringArray(R.array.detail);

        MyAdapter adapter = new MyAdapter(this,img,title,detail);
        main_ListView.setAdapter(adapter);

        // ListView Item Click
        main_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("index", i);
                intent.putExtra("img", img[i]);
                intent.putExtra("title", title[i]);
                startActivity(intent);
            }
        });
    }
}
