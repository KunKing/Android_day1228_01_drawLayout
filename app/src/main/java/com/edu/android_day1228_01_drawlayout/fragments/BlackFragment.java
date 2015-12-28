package com.edu.android_day1228_01_drawlayout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.android_day1228_01_drawlayout.R;

/**
 * 能在编辑时候产生的
 */

public class BlackFragment extends Fragment {
    private static final String ARG_PARAM = "text";

    public BlackFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static BlackFragment newInstance(String param) {
        BlackFragment fragment = new BlackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // 这边初始化布局文件
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_black, container, false);
    }


    //
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.fragText);
        String s = getArguments().getString(ARG_PARAM);
        textView.setText(s);
    }
}
