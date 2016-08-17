package com.sgpvalid.admin.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class Repository {
	  
	  @Inject
	    private  EntityManager entityManager;
	    
	    @SuppressWarnings("unchecked")
		protected <T> T addEntity(Class<T> classToCast, Object entity) {
	        entityManager.persist(entity);
	        return (T) entity;
	    }

	    protected <T> T getEntity(Class<T> classToClast, Serializable pk) {
	        return entityManager.find(classToClast, pk);
	    }

	    @SuppressWarnings("unchecked")
		protected <T> T setEntity(Class<T> classToCast, Object entity) {
	        Object updateObj = entityManager.merge(entity);
	        return (T) updateObj;
	    }

	    protected void removeEntity(Object entity) {
	        Object updateObj = entityManager.merge(entity);
	        entityManager.remove(updateObj);
	    }

	    @SuppressWarnings("unchecked")
		protected <T> List<T> getPureList(Class<T> classToCast, String query, Object... values) {
	        Query qr = createQuery(query, values);
	        return qr.getResultList();
	    }

	    @SuppressWarnings("unchecked")
		protected <T> T getPurePojo(Class<T> classToCast, String query, Object... values) {
	        Query qr = createQuery(query, values);
	        return (T) qr.getSingleResult();
	    }

	    protected int executeCommand(String query, Object... values) {
	        Query qr = createQuery(query, values);
	        return qr.executeUpdate();
	    }

	    private Query createQuery(String query, Object... values) {
	        Query qr = entityManager.createQuery(query);
	        for (int i = 0; i < values.length; i++) {
	            qr.setParameter((i+1), values[i]);
	        }
	        return qr;
	    }
}
