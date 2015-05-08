package copy_files_with_threads;

import java.io.File;

public class CopyFilesApp {

	public static void main(String[] args) {
		File source = new File("C:\\Users\\фуск\\Desktop\\sourse");
		File destination = new File("C:\\Users\\фуск\\Desktop\\destination");
		System.out.println("Hello from thread: " + Thread.currentThread().getName());
		Thread copyThread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Hello from thread: " + Thread.currentThread().getName());
				CopyFiles.copyFiles(source, destination);
			}
		},"copyThread");
		copyThread.start();
	}
}
