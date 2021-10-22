package com.kollu.bank.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankIdGenerator implements IdentifierGenerator {

	private Logger logger = LoggerFactory.getLogger(BankIdGenerator.class);
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("Console:: BankIdGenerator - generate method");
		logger.info("BankIdGenerator - generate method");
		
		long prefix = 1000;
		
		logger.info("BankIdGenerator - generate - prefix :: "+prefix);
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		 try {
			 	connection = session.connection();
	            statement=connection.createStatement();
	            rs=statement.executeQuery("select count(BANK_ID) as BANK_ID from bank_details");
	            
	            logger.debug("BankIdGenerator - generate - rs :: "+rs.getFetchSize()); 
	            
	            if(rs.next()) {
	                int id=rs.getInt(1)+1;
	                long generatedId = prefix + id;
	                System.out.println("Console:: BankIdGenerator - generate - Generated Id :: " +generatedId);
	                logger.debug("BankIdGenerator - generate - Generated Id :: "+generatedId); 
	                return generatedId;
	            }
	        } catch (SQLException e) {
	        	 System.out.println("Console:: BankIdGenerator - generate - Error :: " +e.getMessage());
		        	logger.error("BankIdGenerator - generate - Error ::" +e.getMessage()); 
	        } finally {
	        	
	        	if(statement != null) {
	        		try {
	        			 System.out.println("Console:: BankIdGenerator - generate - statement conn closed");
	 	                logger.debug("BankIdGenerator - generate - statement conn closed"); 
						statement.close();
					} catch (SQLException e) {
						System.out.println("Console:: BankIdGenerator - generate - statement conn Error :: " +e.getMessage());
			        	logger.error("BankIdGenerator - generate - statement conn Error ::" +e.getMessage()); 
						//e.printStackTrace();
					}
	        	}//stmt 
	        	
	        	if(rs !=null) {
	        		try {
	        			 System.out.println("Console:: BankIdGenerator - generate - rs conn closed");
		 	                logger.debug("BankIdGenerator - generate - rs conn closed"); 
						rs.close();
					} catch (SQLException e) {
						System.out.println("Console:: BankIdGenerator - generate - rs conn Error :: " +e.getMessage());
			        	logger.error("BankIdGenerator - generate - rs conn Error ::" +e.getMessage());
						//e.printStackTrace();
					}
	        	}//rs
	        	
			}//finally
		
		return null;
	}

}
