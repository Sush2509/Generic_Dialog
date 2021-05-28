package com.example.genericdialogue;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.util.Map;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class DialogManager {

    private static DialogManager single_instance = null;

    private DialogManager(){

    }

    public static synchronized DialogManager getInstance(){
        if(single_instance == null){
            single_instance = new DialogManager();
        }
        return  single_instance;
    }

    public void showDialog(FragmentActivity fragmentActivity, DialogType dialogType,DialogData dialogData){

        DialogueBaseFragment dialogueBaseFragment = new DialogueBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DialogType",dialogType.name());
        bundle.putSerializable("DialogData",dialogData);
        dialogueBaseFragment.setArguments(bundle);

        FragmentManager fm = fragmentActivity.getSupportFragmentManager();


        dialogueBaseFragment.show(fm,"CautionDialogue");
    }

    public void dismiss(FragmentActivity fragmentActivity){

        Fragment prev = fragmentActivity.getSupportFragmentManager().findFragmentByTag("CautionDialogue");
        if (prev != null) {
            DialogFragment df = (DialogFragment) prev;
            df.dismiss();
        }
    }
}
