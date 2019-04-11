package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Databaseconnection {

	public static void main(String[] args) throws SQLException, InstantiationException, Exception, ClassNotFoundException {
		// TODO Auto-generated method stub
	/*Class.forName("com.mysql.jdbc.Driver").newInstance();

		System.out.println("Driver JDBC loaded!");*/
		
		Connection con = DriverManager.getConnection("Jdbc:mysql://"+"localhost"+":"+"3306"+"/seleniumdb","root","Digital");
		if (con != null) {
                System.out.println("Connected to the database test2");
                System.out.println("Connected to the database test3");
                System.out.println("Connected to the database test4");
            }

		System.out.println("database created");
		Statement st =con.createStatement();
		ResultSet rs= st.executeQuery("select * from credentials where scenario = 'Zerobalance'");
		rs.next();
		rs.getString("username");
		/*while(rs.next())
		{
			System.setProperty("webdriver.gecko.driver","D:\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			driver.get("https://login.salesforce.com/");
			//rs.next();
			driver.findElement(By.name("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			driver.close();
		}*/
		

	}

}
