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

public class CustomerBankIdGenerator implements IdentifierGenerator {

	private Logger logger = LoggerFactory.getLogger(CustomerBankIdGenerator.class);
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("Console:: CustomerBankIdGenerator - generate method");
		logger.info("CustomerBankIdGenerator - generate method");
		long prefix = 100;
		
		logger.info("CustomerBankIdGenerator - generate - prefix :: "+prefix);
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null; 
		 try {
			 	connection = session.connection();
	            statement=connection.createStatement();
	            rs=statement.executeQuery("select count(CUST_BANK_ID) as CUST_BANK_ID from customer_bank_details");

	            logger.debug("CustomerBankIdGenerator - generate - rs :: "+rs.getFetchSize()); 
	            
	            if(rs.next()) {
	                int id=rs.getInt(1)+1;
	                long generatedId = prefix + id;
	                System.out.println("Console:: CustomerBankIdGenerator - generate - Generated Id :: " +generatedId);
	                logger.debug("CustomerBankIdGenerator - generate - Generated Id :: "+generatedId);
	                return generatedId;
	            }
	        } catch (SQLException e) {
	        	System.out.println("Console:: CustomerBankIdGenerator - generate - Error :: " +e.getMessage());
	        	logger.error("CustomerBankIdGenerator - generate - Error ::" +e.getMessage());
	        } finally {
	        	
	        	if(statement != null) {
	        		try {
	        			 System.out.println("Console:: CustomerBankIdGenerator - generate - statement conn closed");
	 	                logger.debug("CustomerBankIdGenerator - generate - statement conn closed"); 
						statement.close();
					} catch (SQLException e) {
						System.out.println("Console:: CustomerBankIdGenerator - generate - statement conn Error :: " +e.getMessage());
			        	logger.error("CustomerBankIdGenerator - generate - statement conn Error ::" +e.getMessage()); 
						//e.printStackTrace();
					}
	        	}//stmt 
	        	
	        	if(rs !=null) {
	        		try {
	        			 System.out.println("Console:: CustomerBankIdGenerator - generate - rs conn closed");
		 	                logger.debug("CustomerBankIdGenerator - generate - rs conn closed"); 
						rs.close();
					} catch (SQLException e) {
						System.out.println("Console:: CustomerBankIdGenerator - generate - rs conn Error :: " +e.getMessage());
			        	logger.error("CustomerBankIdGenerator - generate - rs conn Error ::" +e.getMessage());
						//e.printStackTrace();
					}
	        	}//rs
	        	
			}//finally
		
		return null;
	}

}