package io.github.dearzack.aninterface.struct;

import android.text.TextUtils;

import java.util.HashMap;

public class FunctionsManager {

    private static FunctionsManager instance;

    private FunctionsManager() {
        functionNPNR = new HashMap<>();
        functionNPWR = new HashMap<>();
        functionWPNR = new HashMap<>();
        functionWPWR = new HashMap<>();
    }

    public static FunctionsManager getInstance() {
        if (instance == null) {
            instance = new FunctionsManager();
        }
        return instance;
    }

    private HashMap<String, FunctionNPNR> functionNPNR;
    private HashMap<String, FunctionNPWR> functionNPWR;
    private HashMap<String, FunctionWPNR> functionWPNR;
    private HashMap<String, FunctionWPWR> functionWPWR;

    public FunctionsManager add(FunctionNPNR function) {
        functionNPNR.put(function.getName(), function);
        return this;
    }

    public void invoke(String name) throws FunctionException {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        if (functionNPNR != null) {
            FunctionNPNR f = functionNPNR.get(name);
            if (f != null) {
                f.function();
                return;
            }
        }
        throw new FunctionException("Has no this function " + name);
    }

    public FunctionsManager add(FunctionNPWR function) {
        functionNPWR.put(function.getName(), function);
        return this;
    }

    public <Result> Result invoke(String name, Class<Result> result) throws FunctionException {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        if (functionNPWR != null) {
            FunctionNPWR f = functionNPWR.get(name);
            if (f != null) {
                if (result != null) {
                    return result.cast(f.function());
                } else {
                    return (Result) f.function();
                }
            }
        }
        throw new FunctionException("Has no this function " + name);
    }

    public FunctionsManager add(FunctionWPNR function) {
        functionWPNR.put(function.getName(), function);
        return this;
    }

    public <Param> void invoke(String name, Param param) throws FunctionException {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        if (functionWPNR != null) {
            FunctionWPNR f = functionWPNR.get(name);
            if (f != null) {
                f.function(param);
                return;
            }
        }
        throw new FunctionException("Has no this function " + name);
    }

    public FunctionsManager add(FunctionWPWR function) {
        functionWPWR.put(function.getName(), function);
        return this;
    }

    public <Result, Param> Result invoke(String name, Param param, Class<Result> result) throws FunctionException {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        if (functionWPWR != null) {
            FunctionWPWR f = functionWPWR.get(name);
            if (f != null) {
                if (result != null) {
                    return result.cast(f.function(param));
                } else {
                    return (Result) f.function(param);
                }
            }
        }
        throw new FunctionException("Has no this function " + name);
    }
}
