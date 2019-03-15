package hu.protein;

import java.util.ArrayList;
import java.util.List;

import hu.protein.controller.Protein;
import hu.protein.domain.model.AminoAcid;
import hu.protein.domain.service.AminoAcidParser;
import hu.protein.domain.service.BsaParser;
import hu.protein.domain.service.DataParser;
import hu.protein.domain.service.DataReader;
import hu.protein.domain.service.DataWriter;
import hu.protein.domain.service.FileDataReader;
import hu.protein.domain.service.FileDataWriter;
import hu.protein.domain.service.ScreenDataWriter;

public class App {

	private final Protein protein;
	private final DataWriter file;
	private final DataWriter screen;
	
	public App() {
		DataReader inputFile = new FileDataReader();
		DataParser<List<AminoAcid>> aminoAcidParser = new AminoAcidParser(inputFile);
		DataParser<String> bsaParser = new BsaParser(inputFile);
		protein = new Protein(aminoAcidParser.getData("aminosav.txt"), bsaParser.getData("bsa.txt"));
		file = new FileDataWriter("eredmeny.txt");
		screen = new ScreenDataWriter();
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		List<String> lines = new ArrayList<>();
		lines.add("3. feladat:\r\n" + protein.getSortedAminoAcids());
		lines.add("4. feladat: " + protein.getBsaMolecularFormula());
		lines.add("5. feladat: " + protein.getLongestSubSequenceDetail());
		lines.add("6. feladat: " + protein.getCisteinCountInFirstSubSequenceAfterFactorXiSplit());
		screen.write(file.write(lines));
	}
}
