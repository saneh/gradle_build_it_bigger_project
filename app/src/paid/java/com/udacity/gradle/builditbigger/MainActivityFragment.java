package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.MainActivity;

import java.lang.Override;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Toast.makeText(getActivity(),getActivity().getString(R.string.paid_ver_message), Toast.LENGTH_SHORT).show();
        root.findViewById(R.id.joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make the spinner visible
                MainActivity.getSpinner().setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(getActivity()).execute();

            }
        });
        return root;
    }
}
