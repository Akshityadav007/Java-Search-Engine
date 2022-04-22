package com.example.searchengine.view;

import java.io.*;

public class Console {

	public BufferedReader reader = null;

	public Console() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String readLine() throws IOException {
		return reader.readLine();
	}

	public int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.readLine());
	}

	public double readDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(reader.readLine());
	}

	public char readChar() throws IOException {
		return reader.readLine().charAt(0);
	}

	public long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(reader.readLine());
	}

	public float readFloat() throws NumberFormatException, IOException {
		return Float.parseFloat(reader.readLine());
	}
}
