package com.apps.gator.translator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Reads a comma separated file which has two columns of data.
 * 
 * @author sudhir mohanraj
 * 
 */
public class ReadFile {

	public HashMap<String, String> read(String filename) {

		HashMap<String, String> store = new HashMap<String, String>();
		String line = null;

		// Did this to avoid passing around context outside of activities which
		// can lead to unnecessary complications like memory leak
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("assets/" + filename);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				inputStream));
		try {
			while ((line = bReader.readLine()) != null) {
				String values[] = line.split(",");
				store.put(values[0], values[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return store;

	}

}
