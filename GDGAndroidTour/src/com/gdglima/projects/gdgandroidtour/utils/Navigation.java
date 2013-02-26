/**
 * 
 */
package com.gdglima.projects.gdgandroidtour.utils;

import com.gdglima.projects.core.view.IScreen;

import android.content.Context;

/**
 * @author notebookqd
 *
 */

public class Navigation {

	private Context _context;
	private IScreen _current=null;
	
	public Navigation(Context $context)
	{
		set_context($context);
	}

	/**
	 * @return the _context
	 */
	public Context get_context() {
		return _context;
	}

	/**
	 * @return the _current
	 */
	public IScreen get_current() {
		return _current;
	}

	/**
	 * @param _current the _current to set
	 */
	public void set_current(IScreen _current) {
		this._current = _current;
	}

	/**
	 * @param _context the _context to set
	 */
	public void set_context(Context _context) {
		this._context = _context;
	}
}
