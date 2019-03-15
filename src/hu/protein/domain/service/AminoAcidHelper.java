package hu.protein.domain.service;

import hu.protein.domain.model.AminoAcid;

public class AminoAcidHelper {

	private final static int C = 12;
	private final static int H = 1;
	private final static int O = 16;
	private final static int N = 14;
	private final static int S = 32;
	
	public static Integer calculateWeight(AminoAcid aminoAcid) {
		return C * aminoAcid.getC() + 
			   H * aminoAcid.getH() + 
			   O * aminoAcid.getO() +
			   N * aminoAcid.getN() + 
			   S * aminoAcid.getS();
	}
	
	public static AminoAcid add(AminoAcid amino1, AminoAcid amino2) {
		int c = amino1.getC() + amino2.getC();
		int h = amino1.getH() + amino2.getH() - 2;
		int o = amino1.getO() + amino2.getO() - 1;
		int n = amino1.getN() + amino2.getN();
		int s = amino1.getS() + amino2.getS();
		return new AminoAcid(null, null, c, h, o, n, s);
	}
	
	public static AminoAcid init() {
		return new AminoAcid(null, null, 0, 0, 0, 0, 0);
	}
	
	public static String getResult(AminoAcid aminoAcid) {
		return String.format("C %d H %d O %d N %d S %d", aminoAcid.getC(), aminoAcid.getH(), 
				aminoAcid.getO(), aminoAcid.getN(), aminoAcid.getS());
	}
}
