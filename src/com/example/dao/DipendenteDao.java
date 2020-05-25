package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Dipendente;
import com.example.util.HibernateUtil;

public class DipendenteDao {

	public void saveDipendente(Dipendente dipendente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dipendente);
		transaction.commit();
		session.close();
	}

	public void updateDipendente(Dipendente dipendente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(dipendente);
		transaction.commit();
		session.close();
	}


	public Dipendente getDipendente(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		Dipendente dipendente = session.get(Dipendente.class, id);
		session.close();
		return dipendente;
	}

	public List<Dipendente> getAllDipendente() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Dipendente> listDipendente = session.createQuery(" from dipendente", Dipendente.class).getResultList();
		session.close();
		
		return listDipendente;
	}
}
