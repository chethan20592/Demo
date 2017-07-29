package com.billbox.demo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.*;
import android.widget.Toast;
import android.util.Log;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
    public String Readfilename;
    public String Readfilenamefull;


    //tokengeneration//
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
        createTemp();
        //getfilename();
        onTokenRefresh();
        Addlisteneronbutton();
    }

    public void Addlisteneronbutton()
    {
        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {

            private static final String TAG = "MyFirebaseIIDService";

            @Override
            public void onClick(View v) {

                //writing file
               /* FileOutputStream fos = null;
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
            }*/

                getfilename();
            }

});
    }
//create  folders initially
public void createTemp()
{
    String filename[] = {"temp","Shopping","Travel","Utilities","Others"};
    File myDirectory = getFilesDir();
    int i =0;
    for( i=0;i<=filename.length-1;i++)
    {
    File dir = new File(myDirectory , filename[i]);

    try{
        if(!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Directory is not created");
            }
        }else
        {
            System.out.println("Directory already created");
        }
    }catch(Exception e){
        e.printStackTrace();
    }}
}

    //Get file from temp folder
    public void getfilename()
    {
        String filename = "temp";
        File myDirect = getFilesDir();
        File dir = new File(myDirect,filename);
        File[] files = dir.listFiles();
        int count = 0;
        for(int i =1; i<=files.length; i++)
        {
            System.out.println(files[count].getName());
            String Readfilenamefull = files[count].getName();
            String Readfilename = FilenameUtils.getBaseName(Readfilenamefull);
            splitname(Readfilename,Readfilenamefull);
            count++;
        }

    }

    //Splitting file name and copying file to specific folder
    public boolean splitname(String Name, String Fullfilename)
    {
        String Split[] = Name.split("_");
        String Type =  Split[0];
        String Section = Split[1];
        System.out.println(Type);
        System.out.println(Section);

        //Saving files
        if(Type.equals("Shopping"))
        {
            File myDirectory = getFilesDir();
            System.out.println(myDirectory);
            File dir1 = new File( myDirectory, Type);
            System.out.println(dir1);
            File dir = new File( dir1, Section);
            try{
                if(!dir.exists()) {
                    if (dir.mkdirs()) {
                        System.out.println("Directory created");
                        //copy file to this folder
                    } else {
                        System.out.println("Directory is not created");
                    }
                }else
                {
                    System.out.println("Directory already created");
                    //copy file to this folder
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }

}

