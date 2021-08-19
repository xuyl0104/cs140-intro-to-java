package lab01;

public class MyInitials {

	public static void main(String[] args) {
		String myName = "Yunlong Xu";
		String[] names = myName.split(" ");
		char[] initials = new char[names.length];

		for (int i = 0; i < names.length; ++i) {
			initials[i] = names[i].charAt(0);
		}
		// print the index of intials
		for (int i = 0; i < initials.length; ++i) {
			System.out.print(initials[i] - 64);
			System.out.print(" ");
		}
		System.out.println();

		// hard-coded System.out.print
		System.out.print("...............");
		System.out.println("...............");
		System.out.print("...##....##....");
		System.out.println("...##.....##...");
		System.out.print("....##..##.....");
		System.out.println("....##...##....");
		System.out.print(".....####......");
		System.out.println(".....##.##.....");
		System.out.print("......##.......");
		System.out.println("......###......");
		System.out.print("......##.......");
		System.out.println(".....##.##.....");
		System.out.print("......##.......");
		System.out.println("....##...##....");
		System.out.print("......##.......");
		System.out.println("...##.....##...");
		System.out.print("...............");
		System.out.println("...............");

	}
}
