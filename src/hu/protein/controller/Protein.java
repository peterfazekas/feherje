package hu.protein.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hu.protein.domain.model.AminoAcid;
import hu.protein.domain.service.AminoAcidHelper;

public class Protein {

	private final List<AminoAcid> aminoAcids;
	private final String bsaSequence;

	public Protein(List<AminoAcid> aminoAcids, String bsaSequence) {
		this.aminoAcids = aminoAcids;
		this.bsaSequence = bsaSequence;
	}
	
	public String getSortedAminoAcids() {
		return aminoAcids.stream()
				.sorted(Comparator.comparing(AminoAcid::getWeight))
				.map(AminoAcid::toString)
				.collect(Collectors.joining("\r\n"));
	}
	
	public String getBsaMolecularFormula() {
		AminoAcid molecularFormula = AminoAcidHelper.init();
		for (int i = 0; i < bsaSequence.length(); i++) {
			molecularFormula = AminoAcidHelper.add(molecularFormula, getById(String.valueOf(bsaSequence.charAt(i))));
		}
		return AminoAcidHelper.getResult(molecularFormula);
	}
	
	private AminoAcid getById(String id) {
		return aminoAcids.stream().filter(i -> i.getId().equals(id)).findAny().get();
	}
	
	public String getLongestSubSequenceDetail() {
		String longestSubSequence = getLongestSubSequence();
		int begin = bsaSequence.indexOf(longestSubSequence);
		int length = longestSubSequence.length() + 1;
		return String.format("Kimotripszin enzimmel széthasított BSA lánc leghosszabb darabjának adatai:\r\n" +
				             "   hossza: %d, kezdete: %d, vége %d", length, begin, begin + length);
	}
	
	private String getLongestSubSequence() {
		String[] items = bsaSequence.split("[YWF]");
		return Arrays.stream(items)
				.sorted((j, i) -> ((Integer)i.length()).compareTo(j.length()))
				.findFirst()
				.get();
	}
	
	public String getCisteinCountInFirstSubSequenceAfterFactorXiSplit() {
		return String.format("A Factor XI hasítás utáni első fehérjelánc részletben %d Cisztein található.", 
				countCisteinInSubSequence(getFirstSubSequenceAfterFactorXiSplit()));
	}
	
	private long countCisteinInSubSequence(String subSequence) {
		return subSequence.chars().filter(i -> (char) i == 'C').count();
	}
	
	private String getFirstSubSequenceAfterFactorXiSplit() {
		String[] items = bsaSequence.split("R[AV]");
		return items[0];
	}
	
	
}
