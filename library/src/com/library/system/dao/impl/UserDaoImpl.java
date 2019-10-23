package com.library.system.dao.impl;

import com.library.system.dao.IUserDao;
import com.library.system.pojo.User;
import com.library.system.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao{


    public String login(User u){
        try {
            Connection conn = DBUtil.getConnetion();
            String sql = "SELECT password,name FROM User WHERE user=?";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                if (u.getPassword().equals(rs.getString("password"))){
                    u.setUsername(rs.getString("name"));
                    return "true";
                }
                else{
                    return "false";
                }
            }
            else{
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
    
    

}
