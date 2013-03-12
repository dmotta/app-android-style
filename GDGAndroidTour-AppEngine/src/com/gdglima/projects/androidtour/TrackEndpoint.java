package com.gdglima.projects.androidtour;

import com.gdglima.projects.androidtour.bo.EMF;
import com.gdglima.projects.androidtour.bo.Track;

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

@Api(name = "trackendpoint")
public class TrackEndpoint {

	@ApiMethod(httpMethod = "GET", name = "track.list", path = "track/list")
	@SuppressWarnings({ "unchecked", "unused" })
	public CollectionResponse<Track> listTrack(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Track> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Track as Track");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Track>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Track obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Track> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	@ApiMethod(httpMethod = "GET", name = "track.get", path = "track/get/{id}")
	public Track getTrack(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Track track = null;
		try {
			track = mgr.find(Track.class, id);
		} finally {
			mgr.close();
		}
		return track;
	}

	@ApiMethod(httpMethod = "POST", name = "track.insert", path = "track/insert")
	public Track insertTrack(Track track) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsTrack(track)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(track);
		} finally {
			mgr.close();
		}
		return track;
	}

	@ApiMethod(httpMethod = "POST", name = "track.update", path = "track/update")
	public Track updateTrack(Track track) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsTrack(track)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(track);
		} finally {
			mgr.close();
		}
		return track;
	}

	@ApiMethod(httpMethod = "POST", name = "track.remove", path = "track/remove")
	public Track removeTrack(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Track track = null;
		try {
			track = mgr.find(Track.class, id);
			mgr.remove(track);
		} finally {
			mgr.close();
		}
		return track;
	}

	private boolean containsTrack(Track track) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Track item = mgr.find(Track.class, track.getId());
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
