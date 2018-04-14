package io.github.dearzack.aninterface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import io.github.dearzack.aninterface.R;
import io.github.dearzack.aninterface.struct.FunctionException;

public class FourthFragment extends BaseFragment {

    public static final String INTERFACE = FourthFragment.class.getName() + "_WPWR";

    private Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getActivity(), manager.invoke(INTERFACE, 123, String.class), Toast.LENGTH_SHORT).show();
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }
}
