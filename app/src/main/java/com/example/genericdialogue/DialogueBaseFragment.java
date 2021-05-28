package com.example.genericdialogue;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class DialogueBaseFragment extends DialogFragment {

    private ImageView dialogIconImgView;
    private TextView titleTextView,msgtextView;
    private DialogData dialogData;
    private String dialogType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogue, container);

        dialogIconImgView = view.findViewById(R.id.dialogue_imageView);
        titleTextView = view.findViewById(R.id.title_textview);
        msgtextView = view.findViewById(R.id.msg_textview);

        dialogIconImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogManager.getInstance().dismiss(getActivity());
            }
        });

        Bundle bundle = getArguments();

        if(bundle != null){
             dialogType = bundle.getString("DialogType");
             dialogData = (DialogData) bundle.getSerializable("DialogData");
        }

        if(DialogType.CAUTION.name().equals(dialogType)){
            dialogIconImgView.setImageResource(dialogData.getImage());
            titleTextView.setText(dialogData.getTitle());
            msgtextView.setText(dialogData.getMsg());
            titleTextView.setTextColor(getActivity().getResources().getColor(R.color.caution_txt_color));
            msgtextView.setTextColor(getActivity().getResources().getColor(R.color.caution_txt_color));
            dialogIconImgView.setBackgroundResource(dialogData.getIconBg());
        }
        else if(DialogType.SAVED.name().equals(dialogType)){
            dialogIconImgView.setImageResource(dialogData.getImage());
            titleTextView.setText(dialogData.getTitle());
            msgtextView.setText(dialogData.getMsg());
            titleTextView.setTextColor(getActivity().getResources().getColor(R.color.saved_txt_color));
            msgtextView.setTextColor(getActivity().getResources().getColor(R.color.saved_txt_color));
            dialogIconImgView.setBackgroundResource(dialogData.getIconBg());
        }
        else if(DialogType.LOADING.name().equals(dialogType)){
            dialogIconImgView.setImageResource(dialogData.getImage());
            titleTextView.setText(dialogData.getTitle());
            msgtextView.setText(dialogData.getMsg());
            titleTextView.setTextColor(getActivity().getResources().getColor(R.color.loading_txt_color));
            msgtextView.setTextColor(getActivity().getResources().getColor(R.color.loading_txt_color));
            dialogIconImgView.setBackgroundResource(dialogData.getIconBg());
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


    }

}
