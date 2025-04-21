package recurssion.com;

public class PrintTable {

	public static void printTable(int n) {
		if(n == 0) {
			return;
		}
		printTable(n - 1);
		if(n % 10 == 0) {
			System.out.print(n+" ");
			System.out.println();
		}
		System.out.print(n+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintTable.printTable(564);
	}

}
