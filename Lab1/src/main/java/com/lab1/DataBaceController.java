package com.lab1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import dnl.utils.text.table.TextTable;

public class DataBaceController {
    Connection con = null;

    public void openDatabase() {
        Scanner scn = new Scanner(System.in);
        String dbName = scn.nextLine();
        try {
             this.con = DriverManager.getConnection("jdbc:sqlite:"+dbName);
             System.out.println("База Подключена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showTable() {
        try {
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("select * from sqlite_master where type = 'table'");
            while (resSet.next()) {
                System.out.println(resSet.getString("name"));
            }
            statm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showColumns() {
        try {
            Scanner src = new Scanner(System.in);
            String name = src.nextLine();
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("pragma table_info(" + name + ")");
            while (resSet.next()) {
                System.out.println(resSet.getString("name") + " - " + resSet.getString("type"));
            }
            statm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addToColumns() {
        try {
            System.out.println("Выбирите таблицу, в которую хотите добавить значение");
            ArrayList<String> tables = new ArrayList<String>();
            String sqlString = "INSERT INTO";
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("select * from sqlite_master where type = 'table'");
            int i = 0;
            while (resSet.next()) {
                tables.add(resSet.getString("name"));
                System.out.println((i + 1) + " - " + resSet.getString("name"));
                i++;
            }
            Scanner scn = new Scanner(System.in);
            int numTable = scn.nextInt();
            sqlString += "'" + tables.get(numTable - 1) + "' VALUES (";
            resSet = statm.executeQuery("pragma table_info(" + tables.get(numTable - 1) + ")");
            while (resSet.next()) {
                System.out.println("Введите значение " + resSet.getString("name") + " типа " +
                        resSet.getString("type"));
                String value = scn.next();
                sqlString += "'" + value + "',";
            }
            sqlString =  sqlString.substring(0, sqlString.length() - 1);
            sqlString += ");";
            statm.execute(sqlString);
            statm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showColumnValue() {
        System.out.println("Выбирите таблицу в которую хотите вывести");
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<String> columns = new ArrayList<String>();
        String sqlString = "SELECT * FROM ";
        try {
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("select * from sqlite_master where type = 'table'");
            int i = 0;
            while (resSet.next()) {
                tables.add(resSet.getString("name"));
                System.out.println((i + 1) + " - " + resSet.getString("name"));
                i++;
            }
            Scanner scn = new Scanner(System.in);
            int numTable = scn.nextInt();
            resSet = statm.executeQuery("pragma table_info(" + tables.get(numTable - 1) + ")");
            while (resSet.next()) {
                columns.add(resSet.getString("name"));
            }
            sqlString += tables.get(numTable - 1);
            System.out.println("1 - C фильтром");
            System.out.println("2 - Без фильтром");
            int check = scn.nextInt();
            if(check == 2) {
                sqlString += ";";
            }
            if(check == 1) {

                for (int j = 0; j < columns.size(); j++) {
                    System.out.println( j + 1 + " - " + columns.get(j));
                }
                int col = scn.nextInt();
                System.out.println("Введите значение");
                String val = scn.next();
                sqlString += " WHERE " + columns.get(col - 1) + "=" + val + ";";
            }
            resSet = statm.executeQuery(sqlString);
            System.out.println();
            for (int j = 0; j < columns.size(); j++) {
                System.out.print(columns.get(j) + "    ");
            }
            System.out.println();
            while (resSet.next()) {
                for (int j = 0; j < columns.size(); j++) {
                    System.out.print(resSet.getString(columns.get(j)) + "    ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteColumn() {
        System.out.println("Выбирите таблицу в которую хотите удалить строку по id");
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<String> columns = new ArrayList<String>();
        String sqlString = "DELETE FROM ";
        try {
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("select * from sqlite_master where type = 'table'");
            int i = 0;
            while (resSet.next()) {
                tables.add(resSet.getString("name"));
                System.out.println((i + 1) + " - " + resSet.getString("name"));
                i++;
            }
            Scanner scn = new Scanner(System.in);
            int numTable = scn.nextInt();
            sqlString += tables.get(numTable - 1) + " WHERE ";
            resSet = statm.executeQuery("pragma table_info(" + tables.get(numTable - 1) + ")");
            sqlString += resSet.getString("name") + "=";
            System.out.println("Введите значение Id");
            sqlString += scn.nextInt();
            statm.execute(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateColumns() {
        System.out.println("Выбирите таблицу в которую хотите вывести");
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<String> columns = new ArrayList<String>();
        String sqlString = "UPDATE ";
        try {
            Statement statm = con.createStatement();
            ResultSet resSet = statm.executeQuery("select * from sqlite_master where type = 'table'");
            int i = 0;
            while (resSet.next()) {
                tables.add(resSet.getString("name"));
                System.out.println((i + 1) + " - " + resSet.getString("name"));
                i++;
            }
            Scanner scn = new Scanner(System.in);
            int numTable = scn.nextInt();
            resSet = statm.executeQuery("pragma table_info(" + tables.get(numTable - 1) + ")");
            System.out.println("Выбирите значение для обновления");
            i = 0;
            while (resSet.next()) {
                columns.add(resSet.getString("name"));
                System.out.println((i + 1) + " - " + resSet.getString("name"));
                i++;
            }
            int numColumn = scn.nextInt();
            System.out.println("Введите значение для " + columns.get(numColumn - 1));
            sqlString += tables.get(numTable - 1) + " SET " + columns.get(numColumn - 1) + "=" + scn.next();
            System.out.println("Введите ключ обновляеого значения");
            sqlString += " WHERE " + columns.get(0) + "=" + scn.next() + ";";
            System.out.println(sqlString);
            statm.execute(sqlString);
            }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
