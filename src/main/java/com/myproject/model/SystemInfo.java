package com.myproject.model;

public class SystemInfo {
	/**
	 * java版本
	 */
	private String javaVersion;
	/**
	 * 操作系统信息
	 */
	private String os;

	/**
	 * 服务器名称
	 */
	private String serverName;
	/**
	 * 监听端口
	 */
	private Integer serverPort;
	/**
	 * 当前目录
	 */
	private String currentDir;

	public String getJavaVersion() {
		if (javaVersion == null) {
			javaVersion = System.getProperty("java.version");
		}
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getOs() {
		if (os == null) {
			os = System.getProperty("os.name") + " "
					+ System.getProperty("os.arch") + " "
					+ System.getProperty("os.version");
		}
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getCurrentDir() {
		return currentDir;
	}

	public void setCurrentDir(String currentDir) {
		this.currentDir = currentDir;
	}

}
