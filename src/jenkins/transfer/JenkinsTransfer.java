package jenkins.transfer;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import jenkins.config.JenkinsConfig;

public class JenkinsTransfer {

	public void saveAsJobs() {
		String jenkinsHome = JenkinsConfig.getJenkinsHome();
		if (jenkinsHome == null || "".equals(jenkinsHome)) {
			System.err.println("jenkins home is null");
			return;
		}
		String jobsPath = jenkinsHome + File.separator + "jobs";
		File jobsDir = new File(jobsPath);
		File[] listFiles = jobsDir.listFiles();
		for (File f : listFiles) {
			if (f.isDirectory()) {
				String[] list = f.list(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.equals("config.xml") || name.equals("nextBuildNumber");
					}
				});
				for(String fileName : list){
					File reqFile = new File(f,fileName);
					saveAs(reqFile);
				}
			}
		}
	}
	
	private void saveAs(File file){
		String separator = File.separator;
		String bakPath = separator+"jobs_bak"+separator;
		File bakFile = new File(file.getPath().replace(separator+"jobs"+separator, bakPath));
		try {
			FileUtils.copyFile(file, bakFile);
		} catch (IOException e) {
			System.err.println("file copy error,"+e.getMessage());
		}
	}

}
