package com.lab1;

import com.lab1.controlManage.consoleManage;

public class Main {

    static public void main(String[] args){
        System.out.println("Добрый день");
        consoleManage manage = new consoleManage();
        manage.inputOrCreateTable();
        while (true) {
            manage.mainController();
        }
    }

}
