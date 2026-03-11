package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo 
{
 public static void main(String[] args) 
 {
  Configuration cfg = new Configuration();
  cfg.configure();

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();

  Transaction tx = session.beginTransaction();

  // Insert record
  Delivery d = new Delivery();
  d.setId(1);
  d.setName("Food Delivery");
  d.setDate("2026-03-11");
  d.setStatus("Delivered");

  session.save(d);

  System.out.println("Record Inserted");

  // HQL Delete using positional parameter
  Query q = session.createQuery("delete from Delivery where id=?1");
  q.setParameter(1,1);

  int n = q.executeUpdate();

  System.out.println("Record Deleted = "+n);

  tx.commit();

  session.close();
  sf.close();
 }
}