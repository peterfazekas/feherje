package hu.protein.domain.service;

import java.util.List;

public class ScreenDataWriter implements DataWriter {

	@Override
	public List<String> write(List<String> lines) {
		lines.forEach(System.out::println);
		return lines;
	}

}
