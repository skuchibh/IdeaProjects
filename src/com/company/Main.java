package com.company;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjvdb.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" + COLUMN_NAME + " TEXT, "
                    + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " text" + " )");

            insertContact(statement,"John",1122,"ee@rr.com");
            insertContact(statement,"Smith",2233,"gw@rr.com");
            insertContact(statement,"Goku",1322,"qqwd@rr.com");
            insertContact(statement,"Vegeta",4112,"rasa@rr.com");



            ResultSet results = statement.executeQuery("Select * from contacts");

            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " + results.getInt(COLUMN_PHONE) + " " + results.getString(COLUMN_EMAIL));
            }
            results.close();


            conn.commit();
            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Something Wrong " + e.getMessage());e.printStackTrace();
        }
    }


    private static void  insertContact(Statement statement,String name,int phone,String email) throws SQLException{
        statement.execute("INSERT INTO "+TABLE_CONTACTS+"("+COLUMN_NAME+","+COLUMN_PHONE+","+COLUMN_EMAIL+ ")" +
                "values('"+name+"',"+phone+",'"+email+"')");
    }
}
