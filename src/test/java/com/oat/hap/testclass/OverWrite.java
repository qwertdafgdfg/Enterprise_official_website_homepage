package com.oat.hap.testclass;

/**
 * @author: liYuan
 * @Title: OverWrite
 * @ProjectName: java-springboot-vue
 * @Description:
 * @date: 2022/3/29 7:01
 */
public class OverWrite {
    public OverWrite() {
        super();
    }

    @Override
    public int hashCode() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        String s = new String();
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
