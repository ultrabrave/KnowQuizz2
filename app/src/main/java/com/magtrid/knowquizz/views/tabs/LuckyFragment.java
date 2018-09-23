package com.magtrid.knowquizz.views.tabs;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.magtrid.knowquizz.R;
import com.magtrid.knowquizz.data.LuckyResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class LuckyFragment extends Fragment {


    public LuckyFragment() {
        // Required empty public constructor
    }

    public static LuckyFragment newIntance()
    {
        return new LuckyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lucky, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CheckBox checkBoxSmiley  = (CheckBox) view.findViewById(R.id.smileyCb);
        final CheckBox checkBoxHappy = (CheckBox) view.findViewById(R.id.happyCb);
        Button button = (Button) view.findViewById(R.id.luckyBtn);

        checkBoxHappy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    checkBoxSmiley.setChecked(b);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog(checkBoxSmiley.isChecked());
            }
        });


    }

    private void alertDialog(boolean resultado)
    {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(getActivity());
        alerDialog.setTitle("Tu mensaje");
        alerDialog.setMessage(new LuckyResult(resultado).result());
        alerDialog.setPositiveButton(":)", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alerDialog.setCancelable(false);
        alerDialog.show();
    }
}
