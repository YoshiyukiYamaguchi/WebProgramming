package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBeans;
public class UserDao {


	public UserBeans LoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionDao.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, loginId);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();

			if (!rs.next()) {
				return null;
			}
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new UserBeans(loginIdData,nameData);

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {


		if(conn !=null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
	}
}


public List <UserBeans> findAll(){
	Connection conn = null;
	List<UserBeans>userList= new ArrayList<UserBeans>();
	try {
		conn = ConnectionDao.getConnection();
		String sql = "SELECT * FROM user";
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			  String loginId = rs.getString("login_id");
              String name = rs.getString("name");
              String birthDate = rs.getString("birth_date");
              String password = rs.getString("password");
              String createDate = rs.getString("create_date");
              String updateDate = rs.getString("update_date");
              UserBeans user = new UserBeans(id, loginId, name, birthDate, password, createDate, updateDate);

              userList.add(user);
		}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		         }finally {
		        	 if (conn != null) {
		                 try {
		                     conn.close();
		              } catch (SQLException e) {
		                     e.printStackTrace();
		                     return null;
		                 }
		        	 }
		         }
	return userList;

	}

public void UsersUpdate(String name,String password, String birthDate, String id) {
    Connection conn = null;
    List<UserBeans>userInfo= new ArrayList<UserBeans>();
    try {
        conn = ConnectionDao.getConnection();
        String sql = "UPDATE user SET name = ?, password = ? , birth_date = ? WHERE id = ?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, name);
        pStmt.setString(2, password);
        pStmt.setString(3, birthDate);
        pStmt.setString(4, id);


        pStmt.executeUpdate();


    } catch (SQLException e) {
        e.printStackTrace();

    } finally {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
public UserBeans UserInfo(String id) {
    Connection conn = null;
    List<UserBeans>userInfo= new ArrayList<UserBeans>();
    try {
        conn = ConnectionDao.getConnection();
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, id);
        ResultSet rs = pStmt.executeQuery();

        if (!rs.next()) {
            return null;
        }
        int iddata = rs.getInt("id");
		String loginId = rs.getString("login_id");
        String name = rs.getString("name");
        String birthDate = rs.getString("birth_date");
        String password = rs.getString("password");
        String createDate = rs.getString("create_date");
        String updateDate = rs.getString("update_date");
        UserBeans user = new UserBeans(iddata, loginId, name, birthDate, password, createDate, updateDate);

        return user;

    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

public String NewUser(String loginId, String name, String birthDate, String password ) throws SQLException {
	Connection conn = null;
	String ERR = "入力された内容は正しくありません。";
	List<UserBeans> userInfo = new ArrayList<UserBeans>();
	try {
		conn = ConnectionDao.getConnection();

		String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(),now())";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1,loginId );
		pStmt.setString(2, name);
		pStmt.setString(3, birthDate);
		pStmt.setString(4, password);
		pStmt.executeUpdate();


	}catch (SQLException e) {
		e.printStackTrace();
		throw e;
    } finally {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
	return ERR;

}




public UserBeans UsersDelete(String id) {
    Connection conn = null;
    List<UserBeans>userDeleteDao = new ArrayList<UserBeans>();
    try {
        conn = ConnectionDao.getConnection();
        String sql = ("DELETE FROM user WHERE id = ?");
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, id);
        pStmt.executeUpdate();

    }catch (SQLException e) {
    	e.printStackTrace();
    }finally {
    	if(conn != null) {
    		try {
    			conn.close();
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}
    	 }
    	}
	return null;
    }


public List<UserBeans> UserSeach(String loginId, String name, String birthDate, String date) {
	Connection conn = null;
	List<UserBeans>userSearchList = new ArrayList<UserBeans>();
	try {
		conn = ConnectionDao.getConnection();
		String sql = "SELECT * FROM user WHERE 1=1 ";
		if(!loginId.equals("")) {
			sql = sql + "AND login_id='" + loginId + "' ";
		}
		if(!name.equals("")) {
			sql = sql + "AND name LIKE '%" + name + "%' ";
		}
		if(!birthDate.equals("")) {
			sql = sql +  "AND birth_date >='" + birthDate  + "' ";
		}
		if(!date.equals("")) {
			sql = sql + "AND birth_date =< '" + date + "' ";
		}






		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			  String loginIddata = rs.getString("login_id");
              String namedata = rs.getString("name");
              String birthDatedata = rs.getString("birth_date");
              String password = rs.getString("password");
              String createDate = rs.getString("create_date");
              String updateDate = rs.getString("update_date");
              UserBeans user = new UserBeans(id, loginIddata, namedata, birthDatedata, password, createDate, updateDate);

              userSearchList.add(user);
		}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		         }finally {
		        	 if (conn != null) {
		                 try {
		                     conn.close();
		              } catch (SQLException e) {
		                     e.printStackTrace();
		                     return null;
		                 }
		        	 }
		         }
	return userSearchList;

	}
}







