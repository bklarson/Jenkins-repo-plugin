/*
 * The MIT License
 *
 * Copyright (c) 2010, Brad Larson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.repo;

import hudson.model.Run;
import hudson.scm.ChangeLogSet;
import hudson.scm.RepositoryBrowser;

import java.util.Iterator;
import java.util.List;

/**
 * A ChangeLogSet, which is used when generating the list of changes from one
 * build to the next.
 */
public class RepoChangeLogSet extends ChangeLogSet<ChangeLogEntry> {
	private final List<ChangeLogEntry> logs;

	/**
	 * Object Constructor. Call the super class, initialize our variable, and
	 * set us as the parent for all of our children.
	 *
	 * @param build
	 *            The build which caused this change log.
	 * @param browser
	 *            Repository browser.
	 * @param logs
	 *            a list of RepoChangeLogEntry, containing every change (commit)
	 *            which has occurred since the last build.
	 */
	protected RepoChangeLogSet(final Run build,
			final RepositoryBrowser<?> browser, final List<ChangeLogEntry> logs) {
		super(build, browser);
		this.logs = logs;
		for (final ChangeLogEntry log : logs) {
			log.setParent(this);
		}
	}

	/**
	 * Returns an iterator for our RepoChangeLogEntry list. This is used when
	 * generating the Web UI.
	 */
	public Iterator<ChangeLogEntry> iterator() {
		return logs.iterator();
	}

	@Override
	public boolean isEmptySet() {
		return logs.isEmpty();
	}

	@Override
	public String getKind() {
		return "repo";
	}
}
