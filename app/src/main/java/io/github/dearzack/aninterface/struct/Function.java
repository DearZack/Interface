package io.github.dearzack.aninterface.struct;


/**
 * 子类命名规则
 * N -> no
 * P -> param
 * W -> with
 * R -> result
 * NPWR代表没有参数有返回值
 */
public abstract class Function {

    private String name;

    public Function(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
