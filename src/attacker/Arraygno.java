package attacker;

import java.io.IOException;

public class Arraygno {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		GNO g=new GNO();
		int[] a=g.readArray(10);
		System.out.println("Greatest no"+g.gno(a, 10));

	}

}
