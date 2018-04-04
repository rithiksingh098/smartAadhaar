package rithiksingh098.smartaadhaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aadhaar_display,faqq;
    Button edit_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aadhaar_display=findViewById(R.id.aadhaar_display);
        aadhaar_display.setText(getIntent().getStringExtra("aadhaar"));

        edit_profile=findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,edit_profile.class));
            }
        });

        faqq=findViewById(R.id.faq);
        faqq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FAQ.class));
            }
        });
    }
}
