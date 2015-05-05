package file_editor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileEditor {

	private static final Logger logger = Logger.getLogger(FileEditor.class.getName());

	public static void main(String[] args) throws IOException {

		FileEditor fileEditor = new FileEditor();
		fileEditor.createFile("src\\file_editor\\data.txt");
		fileEditor.renameFile("src\\file_editor\\data.txt",	"src\\file_editor\\peace_data.txt");
		fileEditor.deleteFile("src\\file_editor\\peace_data.txt");
		fileEditor.viewFiles("src\\file_editor\\");
	}

	private void createFile(String fileName) {
		File file = new File(fileName);
		FileOutputStream fos = null;
		try {
			logger.log(Level.INFO, "trying to create file - " + file.getAbsolutePath());
			if (!file.exists()) {
				fos = new FileOutputStream(file);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "error while creating file " + file, e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.log(Level.SEVERE,
							"error while closing file " + file, e);
				}
			}
		}
		System.out.println("Is file created: " + file.exists()
				+ ", file name is: " + file.getName());
	}

	private void renameFile(String oldFileName, String newFileName) {
		File oldFile = new File(oldFileName);
		File newFile = new File(newFileName);
		logger.log(Level.INFO,
				"trying to rename file - " + oldFile.getAbsolutePath() + " to: "
						+ newFile.getAbsolutePath());
		if (!oldFile.exists() || !oldFile.renameTo(newFile)) {
			logger.log(Level.SEVERE, "Rename failed");
		} else {
			logger.log(Level.SEVERE, "File was renamed");
			// System.out.println("File was renamed");
		}
	}

	private void deleteFile(String fileName) {
		File file = new File(fileName);
		logger.log(Level.INFO,
				"trying to delete file - " + file.getAbsolutePath());
		if (!file.exists() || !file.delete()) {
			logger.log(Level.SEVERE, "Delete failed");
		} else {
			logger.log(Level.SEVERE, "File was deleted");
		}
	}

	private void viewFiles(String fileDirectory){
		File directory = new File(fileDirectory);
		logger.log(Level.INFO, "trying to show files - " + directory.getAbsolutePath());
		String[] sDirList;
		if(directory.isDirectory()){
			sDirList = directory.list();
			for(String file: sDirList){
				System.out.println(file);
			}
		}else{
			logger.log(Level.SEVERE, "There are no files in this directory!");
		}
	}
}
