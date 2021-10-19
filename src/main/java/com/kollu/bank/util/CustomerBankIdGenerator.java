package com.kollu.bank.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerBankIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("i am from CustomerBankIdGenerator.generate method");
		long prefix = 100;
		
		Connection connection = session.connection();
		
		 try {
	            Statement statement=connection.createStatement();
	            ResultSet rs=statement.executeQuery("select count(CUST_BANK_ID) as CUST_BANK_ID from customer_bank_details");

	            if(rs.next()) {
	                int id=rs.getInt(1)+1;
	                long generatedId = prefix + id;
	                System.out.println("Generated Id: " + generatedId);
	                return generatedId;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return null;
	}

}
