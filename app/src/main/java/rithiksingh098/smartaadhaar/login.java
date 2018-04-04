package rithiksingh098.smartaadhaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button login;
    EditText id1,id2,id3,pass;
    RelativeLayout signup;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id1=findViewById(R.id.id1);
        id2=findViewById(R.id.id2);
        id3=findViewById(R.id.id3);
        pass=findViewById(R.id.pass);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        login =findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=id1.getText().toString()+id2.getText().toString()+id3.getText().toString();
                String password=pass.getText().toString();
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
                if(password.equals(storedPassword))
                {
                    Intent intent=new Intent(login.this,MainActivity.class);
                    intent.putExtra("aadhaar",id1.getText().toString()+" - "+id2.getText().toString()+" - "+id3.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup =findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,loginsignup.class);
                startActivity(intent);
            }
        });
    }
}
