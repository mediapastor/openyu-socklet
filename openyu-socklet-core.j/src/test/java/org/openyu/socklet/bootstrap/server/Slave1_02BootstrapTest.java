package org.openyu.socklet.bootstrap.server;

import org.junit.Test;


public class Slave1_02BootstrapTest {

	@Test
	public void main() {
		AcceptorBootstrap
				.main(new String[] { "org/openyu/socklet/bootstrap/server/applicationContext-slave1_02.xml" });
	}

}
