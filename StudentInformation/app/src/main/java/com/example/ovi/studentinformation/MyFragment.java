package com.example.ovi.studentinformation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ovi on 2/12/2017.
 */

public class MyFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup contain, Bundle saveInsatances){
        return inflater.inflate(R.layout.fragment_layout,contain,false);
    }

}
