import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Data1 {
	

		String dbUrl="jdbc:mysql://localhost:3306/pradee";
	    String dbUname="root";
	    String dbPassword="";
	    String dbDriver="com.mysql.cj.jdbc.Driver";
		String name,password,phone_no,email,landmark,street,city,district,pincode;
		Data1(String name,String password,String phone_no,String email,String landmark,String street,String city,String district,String pincode){
			this.name=name;
			this.password=password;
			this.phone_no=phone_no;
			this.email=email;
			this.landmark=landmark;
			this.street=street;
			this.city=city;
			this.district=district;
			this.pincode=pincode;
		}
		 
		void store() {
		   
			 Connection con = null;
		   		try {
					Class.forName(dbDriver);  //class not found exception
					con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
					
					String sql = "insert into signup (name,password,phone_no,email,landmark,street,city,district,pincode)"
							+ "values('"+name+"','"+password+"','"+phone_no+"','"+email+"','"+landmark+"','"+street+"','"+city+"','"+district+"','"+pincode+"')";
		 		   
					Statement s = con.createStatement();
				
				   	s.execute(sql);
				   
				   	con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}


