package com.kollu.bank.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class BankIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("i am from BankIdGenerator.generate method");
		long prefix = 1000;
		
		Connection connection = session.connection();
		
		 try {
	            Statement statement=connection.createStatement();
	            ResultSet rs=statement.executeQuery("select count(BANK_ID) as BANK_ID from bank_details");

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
