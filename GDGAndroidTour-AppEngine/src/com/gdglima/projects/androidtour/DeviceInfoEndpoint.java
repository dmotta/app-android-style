package com.gdglima.projects.androidtour;

import com.gdglima.projects.androidtour.bo.DeviceInfo;
import com.gdglima.projects.androidtour.bo.EMF;

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

@Api(name = "deviceinfoendpoint")
public class DeviceInfoEndpoint {

	@ApiMethod(httpMethod = "GET", name = "device.list", path = "device/list")
	@SuppressWarnings({ "unchecked", "unused" })
	public CollectionResponse<DeviceInfo> listDeviceInfo(@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<DeviceInfo> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from DeviceInfo as DeviceInfo");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<DeviceInfo>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (DeviceInfo obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<DeviceInfo> builder().setItems(execute).setNextPageToken(cursorString).build();
	}

	@ApiMethod(httpMethod = "GET", name = "device.get", path = "device/get/{id}")
	public DeviceInfo getDeviceInfo(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		DeviceInfo deviceinfo = null;
		try {
			deviceinfo = mgr.find(DeviceInfo.class, id);
		} finally {
			mgr.close();
		}
		return deviceinfo;
	}

	@ApiMethod(httpMethod = "POST", name = "device.insert", path = "device/insert")
	public DeviceInfo insertDeviceInfo(DeviceInfo deviceinfo) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsDeviceInfo(deviceinfo)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(deviceinfo);
		} finally {
			mgr.close();
		}
		return deviceinfo;
	}

	@ApiMethod(httpMethod = "POST", name = "device.update", path = "device/update")
	public DeviceInfo updateDeviceInfo(DeviceInfo deviceinfo) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsDeviceInfo(deviceinfo)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(deviceinfo);
		} finally {
			mgr.close();
		}
		return deviceinfo;
	}

	@ApiMethod(httpMethod = "POST", name = "device.remove", path = "device/remove")
	public DeviceInfo removeDeviceInfo(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		DeviceInfo deviceinfo = null;
		try {
			deviceinfo = mgr.find(DeviceInfo.class, id);
			mgr.remove(deviceinfo);
		} finally {
			mgr.close();
		}
		return deviceinfo;
	}

	private boolean containsDeviceInfo(DeviceInfo deviceinfo) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			DeviceInfo item = mgr.find(DeviceInfo.class, deviceinfo.getDeviceRegistrationID());
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
