package org.edu.stiffy.corejava.memory;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Our custom implementation of the ClassLoader. For any of classes from "org"
 * package it will use its {@link CustomClassLoader#getClass()} method to load
 * it from the specific .class file. For any other class it will use the
 * super.loadClass() method from ClassLoader, which will eventually pass the
 * request to the parent.
 * 
 * @author manishdevraj
 */
public class StaticClassLoader extends ClassLoader {

	/**
	 * Parent ClassLoader passed to this constructor will be used if this
	 * ClassLoader can not resolve a particular class.
	 * 
	 * @param parent
	 *            Parent ClassLoader (may be from getClass().getClassLoader())
	 */
	public StaticClassLoader() {
		super(StaticClassLoader.class.getClassLoader());
	}

	/**
	 * Loads a given class from .class file just like the default ClassLoader.
	 * This method could be changed to load the class over network from some
	 * other server or from the database.
	 * 
	 * @param name
	 *            Full class name
	 */
	private synchronized Class<?> getClass(String name)
			throws ClassNotFoundException {

		// check if class is already loaded?
		Class<?> cls = findLoadedClass(name);
		if (cls != null) {
			System.out.println("Class " + name + "has been loaded.");
			return cls;
		} else {
			System.out.println("Class " + name
					+ " has not been loaded. Loading now.");
		}

		// We are getting a name that looks like
		// org.edu.stiffy.{package}.{ClassToLoad}
		// and we have to convert it into the .class file name
		// like org/edu/stiffy/{package}/{ClassToLoad.class}
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] b = null;
		try {
			// This loads the byte code data from the file
			b = loadClassData(file);
			// defineClass is inherited from the ClassLoader class
			// and converts the byte array into a Class
			cls = defineClass(name, b, 0, b.length);
			resolveClass(cls);
			return cls;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Every request for a class passes through this method. If the requested
	 * class is in "org" package, it will load it using the
	 * {@link CustomClassLoader#getClass()} method. If not, it will use the
	 * super.loadClass() method which in turn will pass the request to the
	 * parent.
	 * 
	 * @param name
	 *            Full class name
	 * @return
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("Loading class '" + name + "'");
		if (name.startsWith("org.")) {
			return getClass(name);
		}
		return super.loadClass(name);
	}

	/**
	 * Loads a given file (presumably .class) into a byte array. The file should
	 * be accessible as a resource, for example it could be located on the
	 * classpath.
	 * 
	 * @param name
	 *            File name to load
	 * @return Byte array read from the file
	 * @throws IOException
	 *             Is thrown when there was some problem reading the file
	 */
	private byte[] loadClassData(String name) throws IOException {
		// Opening the file
		InputStream stream = getClass().getClassLoader().getResourceAsStream(
				name);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream in = new DataInputStream(stream);
		// Reading the binary data
		in.readFully(buff);
		in.close();
		return buff;
	}
}
