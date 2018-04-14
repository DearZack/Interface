package io.github.dearzack.aninterface;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.dearzack.aninterface.fragment.BaseFragment;
import io.github.dearzack.aninterface.fragment.FirstFragment;
import io.github.dearzack.aninterface.fragment.FourthFragment;
import io.github.dearzack.aninterface.fragment.SecondFragment;
import io.github.dearzack.aninterface.fragment.ThirdFragment;
import io.github.dearzack.aninterface.struct.FunctionNPNR;
import io.github.dearzack.aninterface.struct.FunctionNPWR;
import io.github.dearzack.aninterface.struct.FunctionWPNR;
import io.github.dearzack.aninterface.struct.FunctionWPWR;
import io.github.dearzack.aninterface.struct.FunctionsManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mThis;
    private Button first, second, third, fourth;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThis = this;
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fm = getSupportFragmentManager();
    }

    public void setFunction(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionsManager functionsManager = FunctionsManager.getInstance();
        fragment.setFunctionsManager(functionsManager.add(new FunctionNPNR(FirstFragment.INTERFACE) {
            @Override
            public void function() {
                Toast.makeText(mThis, "调用NPNR接口", Toast.LENGTH_SHORT).show();
            }
        }).add(new FunctionNPWR<String>(SecondFragment.INTERFACE) {
            @Override
            public String function() {
                return "调用NPWR接口";
            }
        }).add(new FunctionWPNR<String>(ThirdFragment.INTERFACE) {
            @Override
            public void function(String param) {
                Toast.makeText(mThis, "调用WPNR接口,传入：" + param , Toast.LENGTH_SHORT).show();
            }
        }).add(new FunctionWPWR<String, Integer>(FourthFragment.INTERFACE) {
            @Override
            public String function(Integer integer) {
                return "调用WPWR接口,传入：" + integer;
            }
        }));
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.first:
                ft.replace(R.id.container, new FirstFragment(), FirstFragment.class.getName());
                ft.commit();
                break;
            case R.id.second:
                ft.replace(R.id.container, new SecondFragment(), SecondFragment.class.getName());
                ft.commit();
                break;
            case R.id.third:
                ft.replace(R.id.container, new ThirdFragment(), ThirdFragment.class.getName());
                ft.commit();
                break;
            case R.id.fourth:
                ft.replace(R.id.container, new FourthFragment(), FourthFragment.class.getName());
                ft.commit();
                break;
        }
    }
}
