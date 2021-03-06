package org.openyu.socklet.session.service.event.supporter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.openyu.commons.lang.event.supporter.BaseListenerSupporter;
import org.openyu.socklet.config.vo.ListenerConfig;
import org.openyu.socklet.session.service.event.SessionListener;
import org.openyu.socklet.socklet.ex.SockletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 會話監聽支援器
 */
public abstract class SessionListenerSupporter extends BaseListenerSupporter
		implements SessionListener {
	private static transient final Logger LOGGER = LoggerFactory
			.getLogger(SessionListenerSupporter.class);

	private ListenerConfig listenerConfig;

	private Map<String, String> initParameters = new LinkedHashMap<String, String>(
			10);

	private Set<String> acceptors = new LinkedHashSet<String>();

	public SessionListenerSupporter() {
	}

	public void init(ListenerConfig listenerConfig) throws SockletException {
		setListenerConfig(listenerConfig);
		init();
	}

	public void init() throws SockletException {
	}

	public ListenerConfig getListenerConfig() {
		return listenerConfig;
	}

	public void setListenerConfig(ListenerConfig listenerConfig) {
		this.listenerConfig = listenerConfig;
		this.initParameters = listenerConfig.getInitParameters();
	}

	public String getInitParameter(String name) {
		return (String) initParameters.get(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return Collections.enumeration(initParameters.keySet());
	}

	public void setInitParameters(Map<String, String> initParameters) {
		this.initParameters = initParameters;
	}

	public Map<String, String> getInitParameters() {
		return initParameters;
	}

	public Set<String> getAcceptors() {
		return acceptors;
	}

	public void setAcceptors(Set<String> acceptors) {
		this.acceptors = acceptors;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("listenerConfig", listenerConfig);
		builder.append("initParameters", initParameters);
		builder.append("acceptors", acceptors);
		return builder.toString();
	}
}
