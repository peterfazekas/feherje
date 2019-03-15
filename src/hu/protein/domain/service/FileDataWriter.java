package hu.protein.domain.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter implements DataWriter {

	private final String fileName;
	
	public FileDataWriter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<String> write(List<String> lines) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			lines.forEach(pw::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
