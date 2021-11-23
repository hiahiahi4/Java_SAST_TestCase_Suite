package com.hiahiahia.cases.generics.case2.service;

import java.io.IOException;

public class UserService extends BaseService {
    /*
     * java绫荤户鎵跨壒鎬э細瀛愮被閲嶅啓鐖剁被鏂规硶鏃讹紝閫氳繃super鍘昏皟鐢ㄧ埗绫荤殑鍚屽悕鏂规硶
     */
    public void run(String cmd) {
        super.execute(cmd);
    }
    public void execute(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);   // safe
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
