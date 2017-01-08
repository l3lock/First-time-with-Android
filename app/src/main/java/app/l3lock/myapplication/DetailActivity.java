package app.l3lock.myapplication;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    // Explicit
    private ImageView img;
    private TextView title, detail;
    private Button back_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Bind Widget
        img = (ImageView) findViewById(R.id.Img);
        title = (TextView) findViewById(R.id.Title);
        detail = (TextView) findViewById(R.id.Detail);
        back_Button = (Button) findViewById(R.id.Back_button);

        // Controller Button
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Show View
        int index = getIntent().getIntExtra("index", 0);

        int img_view = getIntent().getIntExtra("img", R.drawable.assassin_logo);
        img.setImageResource(img_view);

        String str_title = getIntent().getStringExtra("title");
        title.setText(str_title);

//        String[] str_detail = getResources().getStringArray(R.array.long_detail);
//        detail.setText(str_detail[index]);
    }
}

