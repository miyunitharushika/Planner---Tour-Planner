/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.*;
import classes.DBConnecter;

/**
 *
 * @author dilha
 */
public class trip {

    private String trip_id;
    private String User_id;
    private String itrm_id;
    private String planName;
    private String planDate;
    private String location;
    private String accomadation;
    private String price;
    private String time;
    private String note;
    private int cost;
    private int budget;

    public trip() {
    }

    public trip(String itrm_id,String User_id, String trip_id, String planName, String planDate, String location, String accomadation, String price, String time, String note, int cost, int budget) {

        this.itrm_id = itrm_id;
        this.trip_id = trip_id;
        this.User_id = User_id;
        this.planName = planName;
        this.planDate = planDate;
        this.location = location;
        this.accomadation = accomadation;
        this.price = price;
        this.time = time;
        this.note = note;
        this.cost = cost;
        this.budget = budget;
    }

    public void savePlan() throws Exception {

        String query = "INSERT INTO itineryitem(itrm_id, trip_id, location, cost, time,date, type) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = DBConnecter.getConnection().prepareStatement(query);
        pstmt.setString(1, itrm_id);
        pstmt.setString(2, trip_id);
        pstmt.setString(3, location);
        pstmt.setString(4, String.valueOf(cost));
        pstmt.setString(5, time);
        pstmt.setString(6, planDate);
        pstmt.setString(7, "One Day");
        pstmt.executeUpdate();

    }

    public int getItemID() throws Exception {

        String query = "SELECT * FROM itineryitem ORDER BY itrm_id DESC LIMIT 1";
        PreparedStatement pstmt = DBConnecter.getConnection().prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        int num = 0;
        while (rs.next()) {
            String id = rs.getString("itrm_id").substring(rs.getString("itrm_id").length() - 4);
            num = Integer.parseInt(id);
        }

        return num + 1;
    }
    
    public int getUserID() throws Exception {

        String query = "SELECT * FROM user ORDER BY user_id DESC LIMIT 1";
        PreparedStatement pstmt = DBConnecter.getConnection().prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        int num = 0;
        while (rs.next()) {
            String id = rs.getString("user_id").substring(rs.getString("user_id").length() - 4);
            num = Integer.parseInt(id);
        }

        return num + 1;
    }
    public int getTripID() throws Exception {

        String query = "SELECT * FROM trip ORDER BY trip_id DESC LIMIT 1";
        PreparedStatement pstmt = DBConnecter.getConnection().prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        int num = 0;
        while (rs.next()) {
            String id = rs.getString("trip_id").substring(rs.getString("trip_id").length() - 4);
            num = Integer.parseInt(id);
        }

        return num + 1;
    }

    public int saveTrip() throws Exception {
        
        String query = "INSERT INTO trip(trip_id, user_id,plan_name, travel_date, budget, status, rating) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = DBConnecter.getConnection().prepareStatement(query);
        pstmt.setString(1, trip_id);
        pstmt.setString(2, User_id);
        pstmt.setString(3, planName);
        pstmt.setString(4, planDate);
        pstmt.setString(5, String.valueOf(budget));
        pstmt.setString(6, note);
        pstmt.setString(7, "5");


        int a = pstmt.executeUpdate();
        return a;

    }

    public int getBudget() {
        return this.budget;
    }

}
