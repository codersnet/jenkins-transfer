package jenkins;

import jenkins.transfer.JenkinsTransfer;

public class JenkinsMain {

	public static void main(String[] args) {
		JenkinsTransfer tr = new JenkinsTransfer();
		tr.saveAsJobs();
	}
	
}
