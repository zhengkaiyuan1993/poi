/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.util;

import static org.apache.poi.util.TempFile.JAVA_IO_TMPDIR;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Default implementation of the {@link TempFileCreationStrategy} used by {@link TempFile}:
 * Files are collected into one directory.
 * Files may be manually deleted by user prior to JVM exit.
 * You can define the system property {@link #DELETE_FILES_ON_EXIT} and set to true if you want to
 * delete any stray files on clean JVM exit.
 *
 * The POI code should tidy up temp files when it no longer needs them.
 * The temporary directory is not deleted after the JVM exits.
 * Files that are created in the poifiles directory outside
 * the control of DefaultTempFileCreationStrategy are not deleted.
 * See {@link TempFileCreationStrategy} for better strategies for long-running
 * processes or limited temporary storage.
 */
public class DefaultTempFileCreationStrategy implements TempFileCreationStrategy {
    /** Name of POI files directory in temporary directory. */
    public static final String POIFILES = "poifiles";

    /** To use files.deleteOnExit after clean JVM exit, set the <code>-Dpoi.delete.tmp.files.on.exit</code> JVM property */
    public static final String DELETE_FILES_ON_EXIT = "poi.delete.tmp.files.on.exit";

    /** The directory where the temporary files will be created (<code>null</code> to use the default directory). */
    private volatile File dir;

    /** The lock to make dir initialized only once. */
    private final Lock dirLock = new ReentrantLock();

    /**
     * Creates the strategy so that it creates the temporary files in the default directory.
     *
     * @see File#createTempFile(String, String)
     */
    public DefaultTempFileCreationStrategy() {
        this(null);
    }

    /**
     * Creates the strategy allowing to set the
     *
     * @param dir The directory where the temporary files will be created (<code>null</code> to use the default directory).
     *
     * @see Files#createTempFile(Path, String, String, FileAttribute[]) 
     */
    public DefaultTempFileCreationStrategy(File dir) {
        this.dir = dir;
    }

    @Override
    public File createTempFile(String prefix, String suffix) throws IOException {
        // Identify and create our temp dir, if needed
        createPOIFilesDirectoryIfNecessary();

        // Generate a unique new filename
        File newFile = Files.createTempFile(dir.toPath(), prefix, suffix).toFile();

        // Set the delete on exit flag, but only when explicitly disabled
        if (System.getProperty(DELETE_FILES_ON_EXIT) != null) {
            newFile.deleteOnExit();
        }

        // All done
        return newFile;
    }

    /* (non-JavaDoc) Created directory path is <JAVA_IO_TMPDIR>/poifiles/prefix0123456789 */
    @Override
    public File createTempDirectory(String prefix) throws IOException {
        // Identify and create our temp dir, if needed
        createPOIFilesDirectoryIfNecessary();

        // Generate a unique new filename
        File newDirectory = Files.createTempDirectory(dir.toPath(), prefix).toFile();

        //this method appears to be only used in tests, so it is probably ok to use deleteOnExit
        newDirectory.deleteOnExit();

        // All done
        return newDirectory;
    }

    protected String getJavaIoTmpDir() throws IOException {
        final String tmpDir = System.getProperty(JAVA_IO_TMPDIR);
        if (tmpDir == null) {
            throw new IOException("System's temporary directory not defined - set the -D" + JAVA_IO_TMPDIR + " jvm property!");
        }
       return tmpDir;
    }

    protected Path getPOIFilesDirectoryPath() throws IOException {
        return Paths.get(getJavaIoTmpDir(), POIFILES);
    }

    // Create our temp dir only once by double-checked locking
    // The directory is not deleted, even if it was created by this TempFileCreationStrategy
    private void createPOIFilesDirectoryIfNecessary() throws IOException {
        // First make sure we recreate the directory if it was not somehow removed by a third party
        if (dir != null && !dir.exists()) {
            dir = null;
        }
        if (dir == null) {
            dirLock.lock();
            try {
                if (dir == null) {
                    final Path dirPath = getPOIFilesDirectoryPath();
                    File fileDir = dirPath.toFile();
                    if (fileDir.exists()) {
                        if (!fileDir.isDirectory()) {
                            throw new IOException("Could not create temporary directory. '" + fileDir + "' exists but is not a directory.");
                        }
                        dir = fileDir;
                    } else {
                        dir = Files.createDirectories(dirPath).toFile();
                    }
                }
            } finally {
                dirLock.unlock();
            }
        }
    }

}
