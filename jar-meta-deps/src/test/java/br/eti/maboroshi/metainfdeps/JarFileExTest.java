package br.eti.maboroshi.metainfdeps;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class JarFileExTest {

	@Test
	public void testGetClasspath() throws Exception {
		JarFileEx jarFile;
		
		jarFile = new JarFileEx(new File("sample", "test.jar"));
		
		for (String s: jarFile.getClasspath()){
			System.out.printf("\"%1$s\" -> \"%2$s\"\n", jarFile.getName(), s);
		}
		
	}

}
