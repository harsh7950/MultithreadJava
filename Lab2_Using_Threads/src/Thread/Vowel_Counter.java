package Thread;

import java.util.*;

public class Vowel_Counter {

	 static int vowels;
	 static int vowels1;

	public static void main(String[] argv) throws InterruptedException {

	

			System.out.println("\n          ~~~~~~~~~~~Vowel Counters~~~~~~~~~~~");
			System.out.println("Press 1 for Creating Thread with Duplicates Arguments OR");
			System.out.println("Press 2 for Creating Thread without Duplicate Arguments");
			Scanner sc1 = new Scanner(System.in);
			int temp = sc1.nextInt();
			if (temp == 1) {
				System.out.println(" Enter any Arguments : ");
				Scanner sc = new Scanner(System.in);
				String input_vowel = sc.nextLine();
				String argument = input_vowel.replaceAll("^\\s+", "");
				withoutrepeating(argument);
				System.out.println("Number of Total Vowels : " + vowels1);

			} else if (temp == 2) {
				System.out.println(" Insert any sentence : ");
				Scanner sc = new Scanner(System.in);
				String input_vowel = sc.nextLine();
				String argument = input_vowel.replaceAll("^\\s+", "");
				MostRepeatingWord(argument);
				System.out.println("Total vowel is " + vowels);

			} else {
				System.out.println("Press Only 1 OR 2");
			}

	}

	private static void withoutrepeating(String input_vowel) throws InterruptedException {
		final String[] argument = input_vowel.split("\\s+"); 
		int arg_size = argument.length;
		for (int i = 0; i < arg_size; i++) {
			final String str = argument[i].toString();
			Thread th = new Thread(new Runnable() {
				public void run() {
					countvowel(str, 0);
				}
			});
			;
			th.start();
			th.join();

		}
		int j = 0;
		for (int k = 0; k < arg_size; k++) {
			j = +k;
		}
		System.out.println("Numbers of Thread :" + (j + 1));

	}

	private static void MostRepeatingWord(String input_vowel) throws InterruptedException {
		// TODO Auto-generated method stub

		List<String> paraList = new ArrayList<String>();
		paraList = Arrays.asList(input_vowel.split(" "));
		int size = paraList.size();

		int i = 0;
		Map<String, Integer> duplicatCountMap = new HashMap<String, Integer>();
		for (int j = 0; size > j; j++) {
			int count = 0;
			for (i = 0; size > i; i++) {
				if (paraList.get(j).equals(paraList.get(i))) {
					count++;
					duplicatCountMap.put(paraList.get(j), count);
				}

			}

		}
		Set<String> myValueSet = new HashSet<>();

		for (final Map.Entry<String, Integer> entry : duplicatCountMap.entrySet()) {

			Thread t1 = new Thread(new Runnable() {
				public void run() {
					countvowel(entry.getKey(), entry.getValue());
				}
			});

			t1.start();
			t1.join();

			myValueSet.add(entry.getKey());

		}

		int j = 0;
		for (i = 0; i < myValueSet.size(); i++) {
			j = +i;
		}

		System.out.println("Numbers of Thread :" + (j + 1));
	}

	public static void countvowel(String str, int vcount) {

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'A') {
				count++;
			} else if (ch == 'e' || ch == 'E') {
				count++;
			} else if (ch == 'i' || ch == 'I') {
				count++;
			} else if (ch == 'O' || ch == 'o') {
				count++;
			} else if (ch == 'u' || ch == 'U') {
				count++;
			}
		}

		if (vcount == 0) {
			int k = count;
			System.out.println("The vowel counter for ~~" + str + "~~ is " + k);
			vowels1 +=k;
			
		} else {
			int k = count * vcount;
			System.out.println("The vowel counter for ~~" + str + "~~ is " + k);
			vowels = vowels + k;

		}
	}
}
