package attacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GNO {

	public int[] readArray(int MAX) throws IOException
	{
		int a[]=new int[MAX];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<MAX;i++)
		{
			a[i]=Integer.parseInt(br.readLine());
			
		}
		return a;
		
	}
	
	public int gno(int a[],int MAX)
	{
		int gno=a[0];
		for(int i=0;i<MAX;i++)
		{
			if(gno<a[i])
				gno=a[i];
		}
		return gno;
	}
	
}
