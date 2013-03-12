package com.gdglima.projects.androidtour;

import com.gdglima.projects.androidtour.bo.EMF;
import com.gdglima.projects.androidtour.bo.Sesion;

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

@Api(name = "sesionendpoint")
public class SesionEndpoint {

	@ApiMethod(httpMethod = "GET", name = "sesion.list", path = "sesion/list")
	@SuppressWarnings({ "unchecked", "unused" })
	public CollectionResponse<Sesion> listSesion(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Sesion> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Sesion as Sesion");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Sesion>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Sesion obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Sesion> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	@ApiMethod(httpMethod = "GET", name = "sesion.get", path = "sesion/get/{id}")
	public Sesion getSesion(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Sesion sesion = null;
		try {
			sesion = mgr.find(Sesion.class, id);
		} finally {
			mgr.close();
		}
		return sesion;
	}

	@ApiMethod(httpMethod = "POST", name = "sesion.insert", path = "sesion/insert")
	public Sesion insertSesion(Sesion sesion) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsSesion(sesion)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(sesion);
		} finally {
			mgr.close();
		}
		return sesion;
	}

	@ApiMethod(httpMethod = "POST", name = "sesion.update", path = "sesion/update")
	public Sesion updateSesion(Sesion sesion) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsSesion(sesion)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(sesion);
		} finally {
			mgr.close();
		}
		return sesion;
	}

	@ApiMethod(httpMethod = "POST", name = "sesion.remove", path = "sesion/remove")
	public Sesion removeSesion(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Sesion sesion = null;
		try {
			sesion = mgr.find(Sesion.class, id);
			mgr.remove(sesion);
		} finally {
			mgr.close();
		}
		return sesion;
	}

	private boolean containsSesion(Sesion sesion) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Sesion item = mgr.find(Sesion.class, sesion.getId());
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
