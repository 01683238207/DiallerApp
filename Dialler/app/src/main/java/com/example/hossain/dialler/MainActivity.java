package com.example.hossain.dialler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12,clear;
    ImageButton bt13,buttonContact;
    TextView tv1;
    static final int REQUEST_CODE_FOR_CONTACT=1011; //this code will be used to identify for which request we are receiving the response.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        setListener();
        initView();
    }

    private void setListener() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);
        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt13.setOnClickListener(this);
        clear.setOnClickListener(this);
        buttonContact.setOnClickListener(this);
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tev_1);
    }

    private void initButton() {
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        bt3 = (Button) findViewById(R.id.bt_3);
        bt4 = (Button) findViewById(R.id.bt_4);
        bt5 = (Button) findViewById(R.id.bt_5);
        bt6 = (Button) findViewById(R.id.bt_6);
        bt7 = (Button) findViewById(R.id.bt_7);
        bt8 = (Button) findViewById(R.id.bt_8);
        bt9 = (Button) findViewById(R.id.bt_9);
        bt10 = (Button) findViewById(R.id.bt_10);
        bt11 = (Button) findViewById(R.id.bt_11);
        bt12 = (Button) findViewById(R.id.bt_12);
        bt13 = (ImageButton) findViewById(R.id.bt_13);
        clear=(Button)findViewById(R.id.myButton);
        buttonContact= (ImageButton) findViewById(R.id.contactButton);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contactButton:
                Intent intent=new Intent(Intent.ACTION_PICK); //Type of operation that is picking contact
                intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI); //Setting uri data to indicate what we are willing to get
                startActivityForResult(intent,REQUEST_CODE_FOR_CONTACT);
                break;
            case R.id.bt_1:
                String s1 = tv1.getText().toString().concat("1");
                tv1.setText(s1);
                break;
            case R.id.bt_2:
                String s2 = tv1.getText().toString().concat("2");
                tv1.setText(s2);
                break;
            case R.id.bt_3:
                String s3 = tv1.getText().toString().concat("3");
                tv1.setText(s3);
                break;
            case R.id.bt_4:
                String s4 = tv1.getText().toString().concat("4");
                tv1.setText(s4);
                break;
            case R.id.bt_5:
                String s5 = tv1.getText().toString().concat("5");
                tv1.setText(s5);
                break;
            case R.id.bt_6:
                String s6 = tv1.getText().toString().concat("6");
                tv1.setText(s6);
                break;
            case R.id.bt_7:
                String s7 = tv1.getText().toString().concat("7");
                tv1.setText(s7);
                break;
            case R.id.bt_8:
                String s8 = tv1.getText().toString().concat("8");
                tv1.setText(s8);
                break;
            case R.id.bt_9:
                String s9 = tv1.getText().toString().concat("9");
                tv1.setText(s9);
                break;
            case R.id.bt_10:
                String s10 = tv1.getText().toString().concat("*");
                tv1.setText(s10);
                break;
            case R.id.bt_11:
                String s11 = tv1.getText().toString().concat("0");
                tv1.setText(s11);
                break;
            case R.id.bt_12:
                String s12 = tv1.getText().toString().concat("#");
                tv1.setText(s12);
                break;
            case R.id.bt_13:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                String s = "tel:" + tv1.getText().toString();
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse(s));
                startActivity(call);
                break;
            case R.id.myButton:
                if(v==clear){
                    tv1.setText("");
                    break;
                }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {//to indicate the user hase selected any desired item
            if(requestCode==REQUEST_CODE_FOR_CONTACT) {//to identify if the response is for the contact pick request
                Uri dataUri=data.getData();
                Cursor cursor=getContentResolver().query(dataUri,null,null,null,null);
                if(cursor.moveToFirst()){ //Moves the cursor to the first row first column
                    int index=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);//Get the Column number of the the Number containing column
                    String string=cursor.getString(index); //gets the phone number if any
                    tv1.setText(string);
                }
            }
        }
    }
}
