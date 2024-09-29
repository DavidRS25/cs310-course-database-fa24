package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                
                ResultSetMetaData rsmd = rs.getMetaData(); //using from jbdc online 
                int numberOfColumns = rsmd.getColumnCount();
                
                
                
                while (rs.next()) {
                    
                    JsonObject object = new JsonObject();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        String colName = rsmd.getColumnName(i);
                        
                        Object jsobject = rs.getObject(i);
                        String value = jsobject.toString();
                        //System.out.println("here");
                        object.put(colName, value);
                        //System.out.println(object);
                    }
                    records.add(object);
                }
            }
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
