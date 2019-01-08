import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testOracle {
    public static String driverName="oracle.jdbc.driver.OracleDriver";
    public static String dbUrl="jdbc:oracle:thin:@10.20.1.238:11521:XE";
    public static String password="onlineqc";
    public static String username="onlineqc";

    public static void main(String[] args) {
        try {
            Class.forName(driverName);
            System.out.println("数据库驱动连接成功!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库驱动连接失败!");
        }

        try {
            Connection connection=DriverManager.getConnection(dbUrl,username,password);
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select * from qc_popupinfo");

            while (set.next()){
                System.out.println(set.getString("popupid"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库连接成功!");
        }
    }
}
