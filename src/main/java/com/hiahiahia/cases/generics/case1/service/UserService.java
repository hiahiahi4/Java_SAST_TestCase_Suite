package com.hiahiahia.cases.generics.case1.service;

public class UserService extends BaseService {
    /*
     * java类继承特性：子类会继承父类的方法
     */
    public void run(String cmd) {
        execute(cmd);
    }
}
