package com.billbox.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.*;
import android.widget.Toast;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.String;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.content.Context;
import android.content.*;
import android.net.Uri;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    TextView tv;
    EditText ed1;
    private static final String TAG = "MyFirebaseIIDService";
    //tokengeneration
    public void onTokenRefresh() {
    // Get updated InstanceID token.
    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    Log.d(TAG, "Refreshed token: " + refreshedToken);
    System.out.println(refreshedToken);

    // If you want to send messages to this application instance or
    // manage this apps subscriptions on the server side, send the
    // Instance ID token to your app server.
    sendRegistrationToServer(refreshedToken);
}
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onTokenRefresh();
        Addlisteneronbutton();
    }

    public void Addlisteneronbutton()
    {



    /*
    //writing file
                FileOutputStream fos = null;
                String data = "hello billbox";
                String filename = "chethan";
                File myDir = getFilesDir();

                /*try {
                    File secondFile = new File(myDir + "/data/", filename);
                    fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    //default mode is PRIVATE, can be APPEND etc.
                    //fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(),filename + " saved" + myDir,
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}
*/


        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {

            private static final String TAG = "MyFirebaseIIDService";

            @Override
            public void onClick(View v) {
      /*          //tokengeneration

                //public void onTokenRefresh() {
                    // Get updated InstanceID token.
                    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                    Log.d(TAG, "Refreshed token: " + refreshedToken);
                    System.out.println(refreshedToken);

                    // If you want to send messages to this application instance or
                    // manage this apps subscriptions on the server side, send the
                    // Instance ID token to your app server.
                    sendRegistrationToServer(refreshedToken);
                }
                private void sendRegistrationToServer(String token) {
                    // TODO: Implement this method to send token to your app server.
                }*/

                //writing file
                FileOutputStream fos = null;
                String data = "hello billbox";
                //String filename = "chethan";
                //File myDir = getFilesDir();
                String filename1 = "PDF Reader.apk";
                File myDir = getFilesDir();
                File file = null;
                System.out.println("hi");

                file = new File(myDir , filename1);
                System.out.println(file);
                Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_LONG).show();
                if (file.exists()) {
                    Intent target = new Intent(Intent.ACTION_VIEW);
                    target.setDataAndType(Uri.fromFile(file), "application/*");
                    target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                    Intent intent = Intent.createChooser(target, "Open File");
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(),
                                "No Application Available to View PDF", Toast.LENGTH_SHORT).show();
                                // Instruct the user to install a PDF reader here, or something
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "File path is incorrect.", Toast.LENGTH_LONG).show();
            }
}

});
    }

}
