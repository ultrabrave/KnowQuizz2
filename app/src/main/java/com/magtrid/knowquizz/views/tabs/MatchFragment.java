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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.magtrid.knowquizz.R;
import com.magtrid.knowquizz.data.MatchResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {


    public MatchFragment() {
        // Required empty public constructor
    }

    public static MatchFragment newInstance(){
        return new MatchFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView tvedad = (TextView) view.findViewById(R.id.userTv);
        final TextView tvedadamor = (TextView) view.findViewById(R.id.loverTv);
        final SeekBar sbedad = (SeekBar) view.findViewById(R.id.userSb);
        final SeekBar sblover = (SeekBar) view.findViewById(R.id.loverSb);
        Button btnenviar = (Button) view.findViewById(R.id.btnEnviarFragmentMatch);

        sbedad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvedad.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Start seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Stop seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        sblover.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvedadamor.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Start seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Stop seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int edad = sbedad.getProgress();
                int amor = sblover.getProgress();
                alertDialog(String.valueOf(new MatchResult(edad,amor).getResult()));

            }
        });
    }

    private void alertDialog(String resultado)
    {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(getActivity());
        alerDialog.setTitle("Compatibilidad");
        alerDialog.setMessage(resultado);
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
