package contests.week_013.super_hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Superhero {
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner scanner=new Scanner(System.in);
		Integer caseNum = scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			String mNString[]=scanner.nextLine().split(" ");
			int M=Integer.parseInt(mNString[0]);
			int N=Integer.parseInt(mNString[1]);
			int [][] energy=new int[M][N];
			int [][]bullet=new int[M][N];
			for (int j = 0; j < M; j++) {
				String mString[]=scanner.nextLine().split(" ");
				for (int j2 = 0; j2 < N; j2++) {
					energy[j][j2]=Integer.parseInt(mString[j2]);
				}
			}
			for (int j = 0; j < M; j++) {
				String nString[]=scanner.nextLine().split(" ");
				for (int j2 = 0; j2 < N; j2++) {
					bullet[j][j2]=Integer.parseInt(nString[j2]);
				}
			}
			initialBullet(energy,bullet,M,N);
		}
		//int [][] energy={{3,2,5},{8,9,1},{4,7,6}};
		//int [][]bullet={{1,1,1},{1000,1000,1000},{1,1,1}};
		//int N=3;
		
	}
	public static int min(int[]list)
	{
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < list.length; i++) {
			if (list[i]<min) {
				min=list[i];
			}
		}
		return min;
	}
	private static void initialBullet(int[][] energy, int[][] bullet, int m, int n) {
		// TODO Auto-generated method stub
		
		int [][][]c=new int[m][n][n];
		int [][]len=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					c[i][j][j2]=0;
				}
			}
		}
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					c[i][j][j2]=energy[i+1][j2]-bullet[i][j];
					if (c[i][j][j2]<0) {
						c[i][j][j2]=0;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			len[0][i]=energy[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//len[i][j]=
				int min[]=new int[n];
				for (int j2 = 0; j2 < n; j2++) {
					min[j2]=len[i-1][j2]+c[i-1][j2][j];
				}
				len[i][j]=min(min);
			}
		}
		int result=min(len[m-1]);
		System.out.println(result);
		
	}
}
