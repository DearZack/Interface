package io.github.dearzack.aninterface.struct;

public abstract class FunctionWPNR<Param> extends Function {
    public FunctionWPNR(String name) {
        super(name);
    }

    public abstract void function(Param param);
}
