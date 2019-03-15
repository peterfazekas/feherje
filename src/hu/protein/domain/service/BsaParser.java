package hu.protein.domain.service;

import java.util.List;
import java.util.stream.Collectors;

public class BsaParser implements DataParser<String> {

	private final DataReader data;

	public BsaParser(DataReader data) {
		this.data = data;
	}
	
	@Override
	public String getData(String fileName) {
		return parse(data.read(fileName));
	}

	private String parse(List<String> lines) {
		return lines.stream().collect(Collectors.joining());
	}

	
}
