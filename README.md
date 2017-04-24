# jenkins-transfer

## 执行命令获取jobs

	- 命令如下：java -Djava.ext.dirs=lib  -Djenkins.JENKINS_HOME=$JENKINS_HOME jenkins.JenkinsMain
	- 程序会将所有的jenkins job内容拷贝到$JENKINS_HOME/jobs_bak目录下
	- 将jobs_bak打包，复制到迁移的jenkins服务器的$JENKINS_HOME

## jobs 迁移

	- 将jobs_bak的内容拷贝到$JENKINS_HOME/jobs中。
	- 登录jenkins，进入系统管理，点击“读取位置”。
	- jenkins重启后，jobs读取成功。


