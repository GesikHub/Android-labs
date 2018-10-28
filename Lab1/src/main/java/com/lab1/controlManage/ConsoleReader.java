package com.lab1.controlManage;

import com.lab1.DataBaceController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;


public class ConsoleReader {
    private Scanner scn = new Scanner(System.in);
    private DataBaceController dbc = new DataBaceController();

    public void reader(String nameFunction, int lenght, consoleManage cn) {
        try {
            int len = scn.nextInt();
            if(len > lenght) {
                System.out.println("Упс, вы ввели неправильное значение");
                Method method = cn.getClass().getDeclaredMethod(nameFunction);
                method.invoke(cn);
                return;
            }
            Field field= cn.getClass().getField(nameFunction + "FunctionList");
            String[] functionList = (String[]) field.get(cn);
            Method method = dbc.getClass().getDeclaredMethod(functionList[len - 1]);
            method.invoke(dbc);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
