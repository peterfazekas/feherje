package hu.protein.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import hu.protein.domain.model.AminoAcid;

public class AminoAcidParser implements DataParser<List<AminoAcid>> {

	private final DataReader data;
	
	public AminoAcidParser(DataReader data) {
		this.data = data;
	}

	@Override
	public List<AminoAcid> getData(String fileName) {
		return parse(data.read(fileName));
	}
	
	private List<AminoAcid> parse(List<String> lines) {
		return IntStream.range(0,  lines.size())
			.filter(i -> i % 7 == 0)
			.mapToObj(i -> createAminoAcid(lines, i))
			.collect(Collectors.toList());
	}
	
	private AminoAcid createAminoAcid(List<String> lines, int i) {
		String shortName = lines.get(i);
		String id = lines.get(i + 1);
		int c = getAsInt(lines.get(i + 2));
		int h = getAsInt(lines.get(i + 3));
		int o = getAsInt(lines.get(i + 4));
		int n = getAsInt(lines.get(i + 5));
		int s = getAsInt(lines.get(i + 6));
		return new AminoAcid(id, shortName, c, h, o, n, s);
	}
	
	private int getAsInt(String item) {
		return Integer.parseInt(item);
	}

}
