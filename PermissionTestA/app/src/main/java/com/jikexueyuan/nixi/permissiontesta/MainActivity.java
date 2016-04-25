package com.jikexueyuan.nixi.permissiontesta;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mStartActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartActivity = (Button) findViewById(R.id.button);
        mStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                boolean permission = (PackageManager.PERMISSION_GRANTED ==
                packageManager.checkPermission("nixi.permission.OPEN","com.jikexueyuan.nixi.permissiontesta"));
                if(permission){
                ComponentName componentName = new ComponentName("com.jikexueyuan.nixi.permissiontestb",
                        "com.jikexueyuan.nixi.permissiontestb.MainActivity");

                Intent intent = new Intent();
                intent.setComponent(componentName);
                startActivity(intent);}
                else {
                    Toast.makeText(getApplicationContext(),"你没有相应的权限",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
