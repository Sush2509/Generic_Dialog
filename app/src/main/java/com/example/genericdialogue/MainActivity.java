package com.example.genericdialogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button clickMeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMeBtn = findViewById(R.id.click_me_btn);

        clickMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogData dialogData = new DialogData();

                dialogData.setImage(R.drawable.saved_icon);
                dialogData.setMsg(getResources().getString(R.string.saved_msg));
                dialogData.setTitle(getResources().getString(R.string.saved_successfully));
                dialogData.setIconBg(R.drawable.saved_dialogue_imageview_bg);

                DialogManager.getInstance().showDialog(MainActivity.this,DialogType.SAVED,dialogData);
            }
        });
    }


}