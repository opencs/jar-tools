package br.eti.maboroshi.metainfdeps;

import java.io.File;

public class MetaInfDeps {

	public MetaInfDeps() {
	}
	
	
	private static boolean accept(File f) {
		
		
		return (f.getName().endsWith(".jar") || f.getName().endsWith(".war")) && (f.isFile());
	}

	public static void main(String[] args) {

		try {
			File root = new File(args[0]);

			for (File f : root.listFiles()) {
				if (accept(f)) {
					try {
						JarFileEx jarFile = new JarFileEx(f);
						
						for (String s: jarFile.getClasspath()){
							System.out.printf("\"%1$s\" -> \"%2$s\"\n", f.getName(), s);
						}
						
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
