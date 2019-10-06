/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kaushal420
 */
public class DBQuery 
{
    public Connection con=null;
    public Statement st=null;
    public ResultSet rs=null,rs1=null;
    public static int count=0;
//     public int consumer_shared(String share_to,String share_from,String fname) throws ClassNotFoundException, SQLException
//    {
//        
//    }
    public int key_modifiedcontent(String fnm,String key_value,String consunm) throws ClassNotFoundException, SQLException
    {
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into modifiedcontentkeydetail values('"+fnm+"','"+key_value+"','"+consunm+"')";
        int i=st.executeUpdate(sql);
        return i;
    }
    public int key_content(String f_file_name,String key_value) throws ClassNotFoundException, SQLException
    {
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into contentkeydetail values('"+f_file_name+"','"+key_value+"')";
        int i=st.executeUpdate(sql);
        return i;
    }
    public String verifyUser(String ownername,String ownerfile,String consumername) throws ClassNotFoundException, SQLException
    {
        String status_verify="";
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="select * from filerequestdetail where requester_name='"+consumername+"' and owner_name='"+ownername+"' and owner_file='"+ownerfile+"'";
        rs=st.executeQuery(sql);
        while(rs.next())
        {
            status_verify=rs.getString("status");
        }
        return status_verify;
    }
    public String getmodifiedcontentkeydetail() throws ClassNotFoundException, SQLException
    {
        String hashvalue="",consumername="",fname="";
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="select * from modifiedcontentkeydetail";
        rs=st.executeQuery(sql);
        String value_list="";
        while(rs.next())
        {
            hashvalue=rs.getString("keyvalue");
            fname=rs.getString("fname");
            consumername=rs.getString("consumername");

            value_list+=hashvalue+"-"+fname+"-"+consumername+"==";
        }
       String data= value_list.substring(0, value_list.length()-2);
       JOptionPane.showMessageDialog(null,data);
        return data;
    }
    public String getcontentkeydetail()throws ClassNotFoundException, SQLException
    {
        String hashvalue="";
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="select * from contentkeydetail";
        rs=st.executeQuery(sql);
        String value_list="";
        while(rs.next())
        {
            hashvalue=rs.getString("hash_key_value");
            value_list+=hashvalue+"==";
        }
       String data= value_list.substring(0, value_list.length()-2);
        return data;
    }
    public int updateStatus(String requester_name,String owner_file,String update_status) throws ClassNotFoundException, SQLException
    {
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="update filerequestdetail set status='"+update_status+"' where requester_name='"+requester_name+"' and owner_file='"+owner_file+"' ";
        int i=st.executeUpdate(sql);
        return i;
    }
    public int filerequestdetail(String requestername,String requesteremail,String time,String formattedDate,String ownername,String owneremail,String ownerfile) throws ClassNotFoundException, SQLException
    {
        String status="Reject";
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into filerequestdetail values('"+requestername+"','"+requesteremail+"','"+time+"','"+formattedDate+"','"+ownername+"','"+owneremail+"','"+ownerfile+"','"+status+"')";
        int i=st.executeUpdate(sql);
        return i;
    }
    public int uploaddetail(String name,String email,String f_file_name,String ph_file_name,String watrimg) throws ClassNotFoundException, SQLException, SQLException, ClassNotFoundException, ClassNotFoundException
    {
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into fdetail values('"+name+"','"+email+"','"+f_file_name+"','"+ph_file_name+"','"+watrimg+"')";
        int i=st.executeUpdate(sql);
        return i;
    }
    public void storepersondetail(String name,String email,String fname,String secretkey,String role) throws ClassNotFoundException, SQLException
    {
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into persondetail values('"+name+"','"+email+"','"+fname+"','"+secretkey+"','"+role+"')";
        int i=st.executeUpdate(sql);
       
    }
    public String getDetail(String name,String email,String skey) throws ClassNotFoundException, SQLException
    {
         int i;
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="select * from persondetail where name='"+name+"' and email='"+email+"'and skey='"+skey+"' ";
        rs=st.executeQuery(sql);
        String utype="";
        while(rs.next())
        {
            utype=rs.getString("role");
        }
        
         String sql1="select * from registration where name='"+name+"' and email='"+email+"' ";
        rs1=st.executeQuery(sql1);
        String dob="";
        while(rs1.next())
        {
            dob=rs1.getString("dob");
        }
        return utype+"=="+dob;
    }
    public String verifyadmin(String nm,String pwd) throws ClassNotFoundException, SQLException
    {
         int i;
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="select * from adminlogin where name='"+nm+"' and password='"+pwd+"' ";
        rs=st.executeQuery(sql);
        String utype="";
        while(rs.next())
        {
            utype=rs.getString("type");
        }
        return utype;
    }
    public int storeData(String name,String password,String email,String gender,String dob,String role,String filename) throws ClassNotFoundException, SQLException
    {
        String qry="select count(*) from registration";
         con=databaseConnectivity.getconnection();
        st=con.createStatement();
        rs=st.executeQuery(qry);
        while(rs.next())
        {
            count++;
        }
        
        int i;
        con=databaseConnectivity.getconnection();
        st=con.createStatement();
        String sql="insert into registration values('"+count+"','"+name+"','"+password+"','"+email+"','"+gender+"','"+dob+"','"+role+"','"+filename+"')";
        i=st.executeUpdate(sql);
        System.out.println("i:"+i);
        return i;
        
    }
    
}
