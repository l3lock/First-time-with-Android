package app.l3lock.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private ListView main_ListView;
    private Button start_Button;

    private static String URL = "https://google.com";
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
        int[] img = new int[] {
            R.drawable.assassin_logo,
            R.drawable.assassin_logo,
            R.drawable.assassin_logo
        };

        // Set up Array By XML.
        String[] title = getResources().getStringArray(R.array.title);
        String[] detail = getResources().getStringArray(R.array.detail);

        MyAdapter adapter = new MyAdapter(this,img,title,detail);
        main_ListView.setAdapter(adapter);
    }
}
