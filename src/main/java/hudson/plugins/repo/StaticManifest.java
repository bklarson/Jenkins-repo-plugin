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

/**
 * A POJO containing information about a static manifest.
 */
public class StaticManifest {
    private String file;
    private String branch;
    private String url;
    private String manifest;

    /**
     * Create a new ModifiedFile object with the given path and edit type.
     *
     * @param file
     *            the path to the manifest file for this static manifest
     * @param branch
     *            the manifest repository's branch name for this static manifes
     * @param url
     *            he manifest repository's url for this static manifest
     * @param manifest
     *            the content of this static manifest
     */
    public StaticManifest(final String file, final String branch,
                          final String url, final String manifest) {
        this.file = file;
        this.branch = branch;
        this.url = url;
        this.manifest = manifest;
    }

    /**
     * Returns the path to the manifest file for this static manifest.
     */
    public String getFile() {
        return file;
    }

    /**
     * Returns the manifest repository's branch name for this static manifest.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Returns the manifest repository's url for this static manifest.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns the content of this static manifest.
     */
    public String getManifest() {
        return manifest;
    }
}
