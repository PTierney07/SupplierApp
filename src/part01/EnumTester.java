package part01;

import java.util.EnumSet;
import java.util.Scanner;

public class EnumTester {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int numOfEnums = EnumSet.allOf(SupRegion.class).size();
		
		printEnumList( numOfEnums);
		
		int regionChoice = input.nextInt();
		
		SupRegion supRegion = SupRegion.values()[regionChoice-1];
		
		System.out.println(supRegion);
		
		
	}
	public static void printEnumList(int numOfEnums) {
			for(int index = 1; index <= numOfEnums; index++) {
				System.out.println(index + ": " + SupRegion.values()[index-1].getSupRegionAsString() );
			}
		}
}
