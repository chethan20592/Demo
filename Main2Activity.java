package com.billbox.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String filename = "Shopping";
        File myDirect = getFilesDir();
        File Specificdir = new File(myDirect,filename);
        System.out.println(Specificdir);

        File[] files = Specificdir.listFiles();
        System.out.println(files);
        String[] Sfiles = new String[files.length];
        System.out.println(Sfiles);
        for (int i = 0; i < files.length; i++) {
            Sfiles[i] = files[i].getName();
            System.out.println(Sfiles[i]);
        }
        System.out.println(Sfiles);
        String[] Sfiles1 = {"yes","yes"};
        String[] Sfiles2 = {"No files Present"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.activity_listview, R.id.label, Sfiles);

            ListView listView = (ListView) findViewById(R.id.Specificdir);
            listView.setAdapter(adapter);
        }
    //third activity
    /*public void Addlistenerontextview() {

        t1 = (TextView) findViewById(R.id.label);
    }*/

}
