package aslan.can.iteminventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import aslan.can.iteminventory.dao.OracleDBUserDao;

@SpringBootApplication
public class IteminventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(IteminventoryApplication.class, args);
		try {
			OracleDBUserDao.establishConnection();
			System.out.println("SUCCESS: Oracle DB connection established.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Could not connect to Oracle DB.");
		}
	}

}
