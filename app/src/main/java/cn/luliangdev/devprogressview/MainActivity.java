package cn.luliangdev.devprogressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ProgressView progressview1;
    private ProgressView progressview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_start=findViewById(R.id.btn_start);



        progressview1 = findViewById(R.id.progressview1);
        progressview1.setColor(getResources().getColor(R.color.colorAccent));
        progressview1.setRadius(6);
        progressview1.setProgress(500);

        progressview2 = findViewById(R.id.progressview2);
        progressview2.setColor(getResources().getColor(R.color.colorPrimary));
        progressview2.setProgress(600);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressview1.startAnim();
                progressview2.startAnim();
            }
        });

    }
}
