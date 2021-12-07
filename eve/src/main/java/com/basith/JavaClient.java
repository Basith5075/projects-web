package com.basith;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
// This program uses URL and requests the httpservlet servlet and demonstrates some output on the screen
public class JavaClient {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:1011/eveweb/httpservlet");
		URLConnection urlcon = url.openConnection();
	}

}
