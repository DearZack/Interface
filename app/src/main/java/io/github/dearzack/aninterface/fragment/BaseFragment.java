package io.github.dearzack.aninterface.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import io.github.dearzack.aninterface.MainActivity;
import io.github.dearzack.aninterface.struct.FunctionsManager;

public class BaseFragment extends Fragment {

    protected FunctionsManager manager;
    protected MainActivity baseActivity;

    public void setFunctionsManager(FunctionsManager manager) {
        this.manager = manager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            baseActivity = (MainActivity) context;
            baseActivity.setFunction(getTag());
        }
    }
}
