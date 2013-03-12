package com.gdglima.projects.androidtour;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import com.gdglima.projects.androidtour.bo.Aula;
import com.gdglima.projects.androidtour.bo.EMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

@Api(name = "aulaendpoint")
public class AulaEndpoint {

	
	@ApiMethod(httpMethod = "GET", name = "aula.list", path = "aula/list")
	@SuppressWarnings({ "unchecked", "unused" })
	public CollectionResponse<Aula> listAula(@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Aula> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Aula as Aula");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Aula>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Aula obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Aula> builder().setItems(execute).setNextPageToken(cursorString).build();
	}

	@ApiMethod(httpMethod = "GET", name = "aula.get", path = "aula/get/{id}")
	public Aula getAula(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Aula aula = null;
		try {
			aula = mgr.find(Aula.class, id);
		} finally {
			mgr.close();
		}
		return aula;
	}

	@ApiMethod(httpMethod = "POST", name = "aula.insert", path = "aula/insert")
	public Aula insertAula(Aula aula) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsAula(aula)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(aula);
		} finally {
			mgr.close();
		}
		return aula;
	}

	@ApiMethod(httpMethod = "POST", name = "aula.update", path = "aula/update")
	public Aula updateAula(Aula aula) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsAula(aula)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(aula);
		} finally {
			mgr.close();
		}
		return aula;
	}

	@ApiMethod(httpMethod = "POST", name = "aula.update", path = "aula/update")
	public Aula removeAula(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Aula aula = null;
		try {
			aula = mgr.find(Aula.class, id);
			mgr.remove(aula);
		} finally {
			mgr.close();
		}
		return aula;
	}

	private boolean containsAula(Aula aula) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Aula item = mgr.find(Aula.class, aula.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
