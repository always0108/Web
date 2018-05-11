package StudentSystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;


@SuppressWarnings("serial")
public class UploadFileAction {
	//private Logger log = Logger.getLogger(UploadFileAction.class);
	private File file; // 上传文件内容保存到此临时文件中
	private String fileFileContenttype;
	private String fileFileName;

	public String execute() throws Exception {
		return "";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileContenttype() {
		return fileFileContenttype;
	}

	public void setFileFileContenttype(String fileFileContenttype) {
		this.fileFileContenttype = fileFileContenttype;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}
