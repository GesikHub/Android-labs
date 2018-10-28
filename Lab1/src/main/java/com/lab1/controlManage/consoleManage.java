package com.lab1.controlManage;

public class consoleManage {

    private ConsoleReader cr = new ConsoleReader();
    private String[] inputOrCreateTableList = new String[] {"Открыть базу данных"};
    private String[] mainControllerList = new String[] {"Вывести список всех таблиц", "Вывести список столбцов",
    "Добавить значение", "Вывести значение", "Удалить значение", "Обновить значение"};

    public String[] inputOrCreateTableFunctionList = new String[] {"openDatabase"};
    public String[] mainControllerFunctionList = new String[] {"showTable", "showColumns", "addToColumns",
            "showColumnValue", "deleteColumn", "updateColumns"};


    public void inputOrCreateTable() {
        for(int i = 0; i < inputOrCreateTableList.length; i++) {
            System.out.println((i + 1) + " - " + inputOrCreateTableList[i]);
        }
        cr.reader("inputOrCreateTable", inputOrCreateTableList.length, this);
    }

    public void mainController() {
        for(int i = 0; i < mainControllerList.length; i++) {
            System.out.println((i + 1) + " - " + mainControllerList[i]);
        }
        cr.reader("mainController", mainControllerList.length, this);
    }
}
