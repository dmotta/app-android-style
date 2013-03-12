package com.gdglima.projects.androidtour;

import com.gdglima.projects.androidtour.bo.EMF;
import com.gdglima.projects.androidtour.bo.Ponente;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "ponenteendpoint")
public class PonenteEndpoint {

	@ApiMethod(httpMethod = "GET", name = "ponente.list", path = "ponente/list")	
	@SuppressWarnings({ "unchecked", "unused" })
	public CollectionResponse<Ponente> listPonente(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Ponente> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Ponente as Ponente");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Ponente>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Ponente obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Ponente> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	@ApiMethod(httpMethod = "GET", name = "ponente.get", path = "ponente/get/{id}")
	public Ponente getPonente(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Ponente ponente = null;
		try {
			ponente = mgr.find(Ponente.class, id);
		} finally {
			mgr.close();
		}
		return ponente;
	}

	@ApiMethod(httpMethod = "POST", name = "ponente.insert", path = "ponente/insert")
	public Ponente insertPonente(Ponente ponente) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsPonente(ponente)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(ponente);
		} finally {
			mgr.close();
		}
		return ponente;
	}

	@ApiMethod(httpMethod = "POST", name = "ponente.update", path = "ponente/update")
	public Ponente updatePonente(Ponente ponente) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsPonente(ponente)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(ponente);
		} finally {
			mgr.close();
		}
		return ponente;
	}

	@ApiMethod(httpMethod = "POST", name = "ponente.remove", path = "ponente/remove")
	public Ponente removePonente(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Ponente ponente = null;
		try {
			ponente = mgr.find(Ponente.class, id);
			mgr.remove(ponente);
		} finally {
			mgr.close();
		}
		return ponente;
	}

	private boolean containsPonente(Ponente ponente) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Ponente item = mgr.find(Ponente.class, ponente.getGplus_id());
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
