package io.github.dearzack.aninterface.struct;

public abstract class FunctionNPWR<Result> extends Function {
    public FunctionNPWR(String name) {
        super(name);
    }

    public abstract Result function();
}
