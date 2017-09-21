package com.alfascoring.databaseapplication;

// Created by Regina on 20.09.2017.

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3308/mysql";

    private static Connection CONNECTION;

    public static void main(String[] args) throws ClassNotFoundException {
        connectToDatabase();
        System.out.println("Insert date in format yyyy-mm-dd. Enter start date first, end date second");
        Scanner scanner = new Scanner(System.in);
        String startDate = scanner.nextLine();
        String endDate = scanner.nextLine();
        Map<Client, Appeal> clientAppealMap = Collections.emptyMap();

    }

    public static Map getClientsWithRejectDescription(String startDateString, String endDateString) throws ParseException {
        ArrayList<Appeal> appeals = selectRejectedAppeals();
        ArrayList<Client> clients = selectClients();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date startDate = dateFormat.parse(startDateString);
        Date endDate = dateFormat.parse(endDateString);
        Map<String, Client> map = new HashMap<>();

        for (Appeal appeal : appeals) {
            if (appeal.getAppealDate().after(startDate) && appeal.getAppealDate().before(endDate)) {
                for (Client client : clients) {
                    map.put(appeal.getDescription(), client);
                }
            }
        }
        return map;
    }

    public static void connectToDatabase() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Main.CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Client> selectClients() {
        ArrayList<Client> clientArrayList = clientArrayList = new ArrayList<>();
        try {
            Statement statement = Main.CONNECTION.createStatement();
            String clientQuery = "SELECT * FROM scoring.client_personal_data";
            ResultSet resultSet = statement.executeQuery(clientQuery);
            while (resultSet.next()) {
                Client client = new Client();
                client.setClientInn(resultSet.getInt("client_inn"));
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setMiddleName(resultSet.getString("middle_name"));
                System.out.println(client.toString());
                clientArrayList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientArrayList;
    }

    public static ArrayList<Appeal> selectRejectedAppeals() {
        ArrayList<Appeal> appealsArrayList = appealsArrayList = new ArrayList<>();
        try {
            Statement statement = Main.CONNECTION.createStatement();
            String appealQuery = "SELECT client_INN, appeal_date, description FROM scoring.loan_appeal WHERE status = 'rejected'";
            ResultSet appealResultSet = statement.executeQuery(appealQuery);
            while (appealResultSet.next()) {
                Appeal appeal = new Appeal();
                appeal.setClientInn(appealResultSet.getInt("client_inn"));
                appeal.setAppealDate(appealResultSet.getDate("appeal_date"));
                appeal.setDescription(appealResultSet.getString("description"));
                System.out.println(appeal.toString());
                appealsArrayList.add(appeal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appealsArrayList;
    }

}
