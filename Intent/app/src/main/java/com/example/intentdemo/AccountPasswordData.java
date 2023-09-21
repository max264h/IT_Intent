package com.example.intentdemo;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountPasswordData {
    private ArrayList<HashMap<String,String>> data = new ArrayList<>();
    public void setActPwdData(String account,String password){
        HashMap hashMap = new HashMap();
        hashMap.put("Account",account);
        hashMap.put("Password",password);
        this.data.add(hashMap);
    }

    public ArrayList<HashMap<String,String>> getActPwdData(){
        return data;
    }
}
