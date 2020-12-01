package br.com.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ClaseConexao {
	
	// Created attributes for connection of the BD

	
	private static final String servidor = "jdbc:mysql://localhost:3306/BDApontamento";
	private static final String	usuario = "root";
	private static final String	senha = "";
	private static final String	driver = "com.mysql.jdbc.Driver";

	
	//method response for connection with BD
	
	public Connection getConnection(){
		
	
		
		//Exception try/catch for executed the method for connection the server
		
		try {
			
			Class.forName(driver);
			
			return (Connection) DriverManager.getConnection(servidor, usuario, senha);
			
			
			
		} catch (Exception e) {
			throw new RuntimeException("erro na conexao", e);
		}
	}
		
	
		//method for closed connection references connection 
		
		public static void fecharConexao(Connection con){
			
			if(con != null){
				try {
					con.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		//method for closed connection references connection and PreraredStament 
			
			public static void closeConnection(Connection con,
					java.sql.PreparedStatement stmt) {

				fecharConexao(con);

				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			

			
			//method for closed connection references connection, PreraredStament and ResultSet 
			
			public static void closeConnection(Connection con,
					java.sql.PreparedStatement stmt, ResultSet rs) {

				closeConnection(con, stmt);

				try {

					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
			
			
		
		
	
			}
	
}
