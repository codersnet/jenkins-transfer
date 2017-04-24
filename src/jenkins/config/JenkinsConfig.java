package jenkins.config;

public class JenkinsConfig {

	private static final String JENKINS_HOME = "jenkins.JENKINS_HOME";

	public static String getJenkinsHome() {

		return System.getProperty(JENKINS_HOME);
	}

	public static void getJenkinsHome(String jenkinsHome) {
		System.setProperty(JENKINS_HOME, jenkinsHome);
	}
}
