package br.eti.maboroshi.metainfdeps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarFileEx extends JarFile {

	public JarFileEx(String name) throws IOException {
		super(name);
	}

	public JarFileEx(File file) throws IOException {
		super(file);
	}

	public JarFileEx(String name, boolean verify) throws IOException {
		super(name, verify);
	}

	public JarFileEx(File file, boolean verify) throws IOException {
		super(file, verify);
	}

	public JarFileEx(File file, boolean verify, int mode) throws IOException {
		super(file, verify, mode);
	}

	
	public List<String> getClasspath() throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		
		Manifest manifest = this.getManifest();
		if (manifest != null) {
			String jars = manifest.getMainAttributes().getValue("Class-Path");
			if (jars != null) {
				for (String s: jars.split(" ")) {
					result.add(s);
				}
			}
		}
		return result;
	}
}
