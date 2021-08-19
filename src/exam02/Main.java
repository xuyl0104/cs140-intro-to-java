package exam02;
import exam02.BinaryTree;
import exam02.NamesResource;
import exam02.Person;
import exam02.Question2;
import exam02.Question3;
import exam02.Question4;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BinaryTree tree = new BinaryTree();
		System.out.println("Testing tree, expected 0, actual: " + tree.sumData());
		System.out.println("Testing tree, expected 0.0, actual: " + tree.averageData());
		BinaryTree tree1 = new BinaryTree(null);
		System.out.println("-------------");
		tree1.prettyPrint();
		System.out.println("-------------");
		System.out.println("Testing tree1, expected 0, actual: " + tree1.sumData());
		System.out.println("Testing tree1, expected 0, actual: " + tree1.averageData());
		BinaryTree tree2 = new BinaryTree(7);
		System.out.println("-------------");
		tree2.prettyPrint();
		System.out.println("-------------");
		System.out.println("Testing tree2, expected 7, actual: " + tree2.sumData());
		System.out.println("Testing tree2, expected 7.0, actual: " + tree2.averageData());
		tree1.add(5);
		tree1.add(7);
		tree1.add(-1);
		tree1.add(10);
		System.out.println("-------------");
		tree1.prettyPrint();
		System.out.println("-------------");
		System.out.println("Testing tree1, expected 21, actual: " + tree1.sumData());
		System.out.println("Testing tree1, expected 5.25, actual: " + tree1.averageData());
		tree2.add(5);
		tree2.add(null);
		tree2.add(6);
		tree2.add(-1);
		tree2.add(10);
		System.out.println("-------------");
		tree2.prettyPrint();
		System.out.println("-------------");
		System.out.println("Testing tree2, expected 27, actual: " + tree2.sumData());
		System.out.println("Testing tree2, expected 5.4, actual: " + tree2.averageData());		
		System.out.println("-------------");
		System.out.println("Testing Question2(null).longestString, expected \"\", actual: \"" + new Question2(null).longestString() + "\"");
		System.out.println("Testing Question2(List.of()).longestString, expected \"\", actual: \"" + new Question2(List.of()).longestString() + "\"");
		List<String> lst = new ArrayList<>(Arrays.asList(null, null, null, null));
		System.out.println("Testing Question2(lst).longestString, expected \"\", actual: \"" + new Question2(lst).longestString() + "\"");
		lst = new ArrayList<>(Arrays.asList(null, "", "", null, null, "", null));
		System.out.println("Testing Question2(lst).longestString, expected \"\", actual: \"" + new Question2(lst).longestString() + "\"");
		lst = new ArrayList<>(Arrays.asList(null, "123", "1234", null, null, "12", null));
		System.out.println("Testing Question2(lst).longestString, expected \"1234\", actual: \"" + new Question2(lst).longestString() + "\"");
		System.out.println("-------------");	
		System.out.println("Testing Question3(null).leastSSN, expected null, actual: " + new Question3(null).leastSSN());
		System.out.println("Testing Question3(List.of()).leastSSN, expected null, actual: " + new Question3(List.of()).leastSSN());
		List<Person> pLst = new ArrayList<>(Arrays.asList(null, null, null, null));
		System.out.println("Testing Question3(pLst).leastSSN, expected null, actual: " + new Question3(pLst).leastSSN());
		pLst = new ArrayList<>();
		for(int i = 0; i < 20; ++i) {
			LocalDate d = NamesResource.getRandomBirthDate(1970, 2014);
			pLst.add(new Person(NamesResource.getRandomLastName(), 
					NamesResource.getRandomFirstName(), NamesResource.getRandomID(), d));
		}
		System.out.println("Testing Question3(pLst).leastSSN, expected: Erna, Blackwell, id: 118299978, actual: " + new Question3(pLst).leastSSN());
		pLst.add(0, null);
		pLst.add(1, null);
		pLst.add(5, null);
		pLst.add(15, null);
		System.out.println("Testing Question3(pLst).leastSSN, expected: Erna, Blackwell, id: 118299978, actual: " + new Question3(pLst).leastSSN());
		System.out.println("-------------");	
		for(var str : new Question4().largeAndOddPopulation())
			System.out.println(str);
	}

}
