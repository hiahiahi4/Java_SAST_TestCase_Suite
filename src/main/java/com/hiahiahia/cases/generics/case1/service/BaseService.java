package com.hiahiahia.cases.generics.case1.service;

import java.io.IOException;

public class BaseService {
    public void execute(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);     // unsafe
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
