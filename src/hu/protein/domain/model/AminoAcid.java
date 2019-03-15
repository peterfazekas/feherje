package hu.protein.domain.model;

import hu.protein.domain.service.AminoAcidHelper;

public class AminoAcid {

	private final String id;
	private final String shortName;
	private final int c;
	private final int h;
	private final int o;
	private final int n;
	private final int s;
	
	public AminoAcid(String id, String shortName, int c, int h, int o, int n, int s) {
		this.id = id;
		this.shortName = shortName;
		this.c = c;
		this.h = h;
		this.o = o;
		this.n = n;
		this.s = s;
	}

	public String getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public int getC() {
		return c;
	}

	public int getH() {
		return h;
	}

	public int getO() {
		return o;
	}

	public int getN() {
		return n;
	}

	public int getS() {
		return s;
	}
	
	public Integer getWeight() {
		return AminoAcidHelper.calculateWeight(this);
	}

	@Override
	public String toString() {
		return shortName + " " + getWeight();
	}
	
	
}
