package org.openyu.socklet.bootstrap.client;

import org.junit.Test;
import org.openyu.commons.thread.ThreadHelper;
import org.openyu.socklet.bootstrap.client.ClientBootstrap;

public class ClientSlave1BootstrapTest {

	@Test
	public void main() {
		ClientBootstrap
				.main(new String[] { "org/openyu/socklet/bootstrap/client/applicationContext-client-slave1.xml" });
		//
		if (ClientBootstrap.isStarted()) {
			ThreadHelper.loop(50);
		}
	}

}
