package com.vipul;

public class ResponseText {

	private String requestBean;
	private String websocketBean;
	private String sessionBean;
	private String singletonBean;
	private String prototypeBean;
	private String applicationBean;

	public String getRequestBean() {
		return requestBean;
	}

	public void setRequestBean(String requestBean) {
		this.requestBean = requestBean;
	}

	public String getWebsocketBean() {
		return websocketBean;
	}

	public void setWebsocketBean(String websocketBean) {
		this.websocketBean = websocketBean;
	}

	public String getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(String sessionBean) {
		this.sessionBean = sessionBean;
	}

	public String getSingletonBean() {
		return singletonBean;
	}

	public void setSingletonBean(String singletonBean) {
		this.singletonBean = singletonBean;
	}

	public String getPrototypeBean() {
		return prototypeBean;
	}

	public void setPrototypeBean(String prototypeBean) {
		this.prototypeBean = prototypeBean;
	}

	public String getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(String applicationBean) {
		this.applicationBean = applicationBean;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("\\n").append("\"requestBean\": ").append("\"").append(getRequestBean())
				.append("\",").append("\\n").append("\"websocketBean\": ").append("\"").append(getWebsocketBean())
				.append("\",").append("\\n").append("\"sessionBean\": ").append("\"").append(getSessionBean())
				.append("\",").append("\\n").append("\"singletonBean\": ").append("\"").append(getSingletonBean())
				.append("\",").append("\\n").append("\"prototypeBean\": ").append("\"").append(getPrototypeBean())
				.append("\",").append("\\n").append("\"applicationBean\": ").append("\"").append(getApplicationBean())
				.append("\"").append("\\n }");
		return super.toString();
	}

}
