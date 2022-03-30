package com.oat.hap;

import ilog.cplex.IloCplex;

/**
 * @author: liYuan
 * @Title: Test01
 * @ProjectName: java-springboot-vue
 * @Description:
 * @date: 2022/3/29 17:37
 */
public class Test01 {
    public static void main(String[] args) {
        IloCplex.IntParam variableSelect = IloCplex.Param.MIP.Strategy.VariableSelect;
        IloCplex.DoubleParam mipGap = IloCplex.Param.MIP.Tolerances.MIPGap;

        System.out.println("ssssssssssssss");
        System.out.println("test01Branch");
        System.out.println("aaaaaaaaaaaaaaaa");
        System.out.println("\"test01\"test01\"test01\"test01\"test01\"test01\"test01\"test01");
    }
}
