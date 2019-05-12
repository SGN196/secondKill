package com.caiqian;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private String url = "jdbc:mysql://localhost:3306/test";

    private String user = "root";
    private String password = "wqre";
    private String alphabat = "abcdefghijklmnopqrstuvwxyz";
    private final char[] word = alphabat.toCharArray();

    @Test
    public void test01(){
        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet rt = null;
        long start = System.currentTimeMillis();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into may_one(name, phone) values(?,?)";
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i <=100000; i++)
            {
                Integer length = (int)(Math.random() * 10) + 4;
                StringBuilder name = new StringBuilder();
                for (int j = 0; j < length; j++)
                {
                    name.append(alphabat.charAt((int)(Math.random() * 26)));
                }
                pstm.setString(1, name.toString());

                pstm.setString(2, Long.toString(System.currentTimeMillis()));
                pstm.execute();

            }

     /*       for (int i = 0; i <=2000; i++){
                StringBuilder sql = new StringBuilder("insert into may_one(name, phone) values");
                for (int j = 0; j < 50; j++)
                {
                    StringBuilder name = new StringBuilder();
                    name.append("(\"");
                    Integer length = (int)(Math.random() * 10) + 4;
                    for (int k = 0; k < length; k++)
                    {
                        name.append(alphabat.charAt((int)(Math.random() * 26)));
                    }
                    name.append("(\",\"");
                    name.append(Long.toString(System.currentTimeMillis()));
                    name.append("\"");
                }


            }*/
            pstm = conn.prepareStatement(sql);


            System.out.println("总共花费" + (System.currentTimeMillis() - start) + "ms");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(pstm != null){
                try
                {
                    pstm.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try
                {
                    conn.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
