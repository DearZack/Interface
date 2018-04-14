package io.github.dearzack.aninterface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.github.dearzack.aninterface.R;
import io.github.dearzack.aninterface.struct.FunctionException;

public class FirstFragment extends BaseFragment {

    public static final String INTERFACE = FirstFragment.class.getName() + "_NPNR";

    private Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    manager.invoke(INTERFACE);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }
}
