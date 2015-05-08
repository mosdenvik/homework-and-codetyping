package copy_files_with_threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopyFiles extends Thread{

	private static final Logger logger = Logger.getLogger(CopyFiles.class.getName());

	public static void copyFiles(File source, File destination){
		logger.log(Level.INFO, "Checking directories---> "
				+ ". Source exist: " + source.exists() + " .... "
				+ " Destination exis: " + destination.exists());
		if (source.isDirectory()) {
			if (!destination.exists()) {
				destination.mkdir();
			}
			String[] files = source.list();
			for (int i = 0; i < files.length; i++) {
				copyFiles(new File(source, files[i]), new File(destination,	files[i]));
			}
			logger.log(Level.INFO, "Copying files completed:" + Arrays.toString(files));

		} else {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new FileInputStream(source);
				out = new FileOutputStream(destination);
				byte[] buffer = new byte[1024];
				int byterRead;
				while ((byterRead = in.read(buffer)) > 0) {
					out.write(buffer, 0, byterRead);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}