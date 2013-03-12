package com.gdglima.projects.androidtour.bo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {

	
	private static EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		if(emfInstance == null) {
			emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
        }
		return emfInstance;
	}
}