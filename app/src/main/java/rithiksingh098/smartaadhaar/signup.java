package rithiksingh098.smartaadhaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText aid1,aid2,aid3,pass,repass;
    Button cr_done;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        aid1=findViewById(R.id.aid1);
        aid2=findViewById(R.id.aid2);
        aid3=findViewById(R.id.aid3);
        pass=findViewById(R.id.pass);
        repass=findViewById(R.id.repass);

        cr_done=findViewById(R.id.cr_done);
        cr_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=aid1.getText().toString()+aid2.getText().toString()+aid3.getText().toString();
                String password=pass.getText().toString();
                String confirmPassword=repass.getText().toString();
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                }
                else if(!password.equals(confirmPassword))
                {Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();}
                else
                {
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
