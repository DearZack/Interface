package io.github.dearzack.aninterface.struct;

public abstract class FunctionWPWR<Result, Param> extends Function {
    public FunctionWPWR(String name) {
        super(name);
    }

    public abstract Result function(Param param);
}
