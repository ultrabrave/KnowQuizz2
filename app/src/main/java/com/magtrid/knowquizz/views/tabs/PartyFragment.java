package com.magtrid.knowquizz.views.tabs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.magtrid.knowquizz.R;
import com.magtrid.knowquizz.data.PartyResult;


public class PartyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static PartyFragment newInstance()
    {
        PartyFragment pf = new PartyFragment();
        return new PartyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_party, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.partyRg);
        Button button = (Button) view.findViewById(R.id.partyBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Valor checkeado", String.valueOf(radioGroup.getCheckedRadioButtonId()));
                int id = radioGroup.getCheckedRadioButtonId();
                if (id != -1)
                {
                    RadioButton radioButton = radioGroup.findViewById(id);
                    String answer = radioButton.getText().toString();
                    PartyResult partyResult = new PartyResult(answer);
                    alertDialog(partyResult.getResult());
                   // Toast.makeText(getContext(), partyResult.getResult(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(), "Seleccione una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void alertDialog(String answer)
    {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(getActivity());
        alerDialog.setTitle("Tu nivel de fiesta");
        alerDialog.setMessage(answer);
        alerDialog.setPositiveButton("Yeah!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alerDialog.setCancelable(false);
        alerDialog.show();
    }
}
