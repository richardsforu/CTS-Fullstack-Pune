package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Person;

public class TestDB {
	
	public static void main(String[] args) {
		
		// Load hibernate.cfg.xml
		Configuration cfg1=new Configuration().configure("mysql.xml");
		Configuration cfg2=new Configuration().configure("oracle.xml");
		// Start reading data from XML
		
		// Build session Factory obj
		
		SessionFactory sf1= cfg1.buildSessionFactory();
		SessionFactory sf2= cfg2.buildSessionFactory();
		
		// get one session from session Factory
		Session s1= sf1.openSession();
		Session s2= sf2.openSession();
		// --> s1- save
		// --> s1 - update
		// --> s1 - delete
		// --> s1 - fetch
		
		Person p1=new Person();
		
		p1.setPersonId("P001");
		p1.setPersonName("James");
		p1.setAge(23);
		p1.setAddr("Hyderabad");
		p1.setDob(new Date());

		//s1.save(p1);
		s2.save(p1);
		
		//s1.beginTransaction().commit();
		
		s2.evict(p1); // removes from Persistent state
		
	/*	p1.setPersonId("P001");
		p1.setPersonName("James Goedic");
		p1.setAge(23);
		p1.setAddr("Hyderabad");
		p1.setDob(new Date());*/

		//s2.delete(p1);
		
		//s1.beginTransaction().commit();
		s2.beginTransaction().commit();
		
		System.out.println("--- Done ---");
		
		
		
		
		
		
		
		
		
		
	}

}
