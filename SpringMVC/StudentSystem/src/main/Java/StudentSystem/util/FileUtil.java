package StudentSystem.util;

import java.io.File;

public class FileUtil {
	public static void createFile(File file) {
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("创建文件夹");
			file.mkdir();
		}
	}

	public static void main(String[] args) {

	}
}
