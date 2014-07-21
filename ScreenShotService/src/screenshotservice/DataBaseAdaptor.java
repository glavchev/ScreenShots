/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenshotservice;

import java.sql.*;
import java.awt.*;


/**
 *
 * @author RAIDMAX
 */
public class DataBaseAdaptor {
    
    Connection DBConnection;
    Statement  DBStatement;
    ResultSet  DBResult;
    Boolean   IsOpen;
    String Name = "";
    
    public DataBaseAdaptor(String DataBaseName)
    {
        IsOpen = false;
        Name = DataBaseName;
    }
    
    public void Connection()
    {
       try{
           DBConnection = DriverManager.getConnection(Name);
           IsOpen = true;
       }
       catch(Exception X){
       // TODO make something
       }
             
    }
    
    public void CloseConnection()
    {
        try{
        DBConnection.close();
        IsOpen = false;
        }
        catch(Exception X)
        {
            // TODO make something
        }
    };
    
    public void ExecuteQuery(String Query)
    {   
        try{
            if(IsOpen = true)
            {
            DBStatement = DBConnection.createStatement();
            DBResult = DBStatement.executeQuery(Query);
            }
        }  
        catch(Exception X)
        {
           //TODO make something
        }
    }
    
}
