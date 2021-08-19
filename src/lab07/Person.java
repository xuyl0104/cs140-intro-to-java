package lab07;

import java.time.LocalDate;
import java.util.Arrays;

public class Person {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    public Person(String lName, String fName, LocalDate bDate) {
        lastName = lName;
        firstName = fName;
        birthDate = bDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean canVoteThisYear() {
        // LocalDate has many method, for example plusYears
        LocalDate temp = birthDate.plusYears(18);

        // how you can make a new LocalDate with the year/month/day
        LocalDate electionDay = LocalDate.of(2020, 11, 3);

        // the zyBook examples compareTo for Strings in "5.12 String comparisons"
        // LocalDate has its own compareTo, where earlier dates are "less than" later dates
        // DECIDE IF THIS IS <, <=, ==, > , >=
        if(electionDay.compareTo(temp) < 0) return false;
            return true;
        }

    public static Person oldest(Person[] people) {
        if (people == null || people.length == 0)
            return null;
        // assume all the objects in `people` are not null
        // Use a loop and compareTo to find the element in `people` that
        // has the earliest birthdate
        if (people.length == 1) {
            return people[0];
        }
        else {
            Person oldest = people[0];
            for (int i = 1; i < people.length; ++i) {
                if (people[i].birthDate.compareTo(oldest.birthDate) < 0) {
                    oldest = people[i];
                }
            }
            return oldest;
        }

    }

    // to simplify printing test cases
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + birthDate;
    }

    public static int howManyCanVote(Person[] people) {
        // return 0 if `people` is null or empty
        // count how many elements of `people` can vote on Nov 3, 2020
        if (people == null || people.length == 0) {
            return 0;
        }
        else {
            LocalDate electionDay = LocalDate.of(2020, 11, 3);
            int count = 0;
            for (int i = 0; i < people.length; ++i) {
                if (people[i].birthDate.plusYears(18).compareTo(electionDay) <= 0) {
                    count++;
                }
            }
            return count;
        }
    }

    public static int countCharsInEachWord(char ch, String word) {
        int count = 0;
        ch = Character.toLowerCase(ch);
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); ++i) {
            if (ch == word.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int[] individualCharTotals(char ch, String[] words) {
        // assume ch is not null; words has at least one word
        int[] res = new int[3];
        if (words == null || words.length == 0) {
            return res;
        }
        else {
            int once = 0;
            int twice = 0;
            int threeOrMoreTimes = 0;
            ch = Character.toLowerCase(ch);
            for (int i = 0; i < words.length; ++i) {
                int times = countCharsInEachWord(ch, words[i]);
                if (times == 1) {
                    once++;
                }
                else if (times == 2) {
                    twice++;
                }
                else {
                    threeOrMoreTimes++;
                }
            }
            res[0] = once;
            res[1] = twice;
            res[2] = threeOrMoreTimes;
            return res;
        }
    }

    public static int[] indexOfFirst(char ch, String[] words) {
        if (words == null || words.length == 0) {
            return new int[] {-1};
        }
        else {
            for (int i = 0; i < words.length; ++i) {
                if (words[i] == null) {
                    continue;
                }
                else {
                    if (words[i].indexOf(ch) == 0) {
                        return new int[] {i};
                    }
                }
            }
            return new int[] {-1};
        }

    }

    public static void main(String[] args) {
        Person p = new Person("A", "B", LocalDate.of(2002, 11, 2));
        Person p2 = new Person("C", "D", LocalDate.of(2002, 11, 3));
        Person p3 = new Person("E", "F", LocalDate.of(2002, 11, 4));
        System.out.println(p.canVoteThisYear());
        System.out.println(p2.canVoteThisYear());
        System.out.println(p3.canVoteThisYear());
        System.out.println(oldest(new Person[] {p, p2, p3}));
        System.out.println(howManyCanVote(new Person[] {p, p2, p3}));
        
        // Tester for `individualCharTotals
        String test = "In mathematics, the sieve of Eratosthenes is an ancient "
                +"algorithm for finding all prime numbers up to any given "
                +"limit. It does so by iteratively marking as composite "
                +"(that is, not prime) the multiples of each prime, starting "
                +"with the first prime number, 2. The multiples of a given "
                +"prime are generated as a sequence of numbers starting from "
                +"that prime, with constant difference between them that is "
                +"equal to that prime. This is the sieve's key distinction "
                +"from using trial division to sequentially test each "
                +"candidate number for divisibility by each prime.";
        String[] array = test.split("[\\s(),.]+");
        System.out.println(array.length);
        System.out.println(Arrays.toString(individualCharTotals('e', array)));

        String[] words = {"string", "words", "integer", "double", "float"};
        System.out.println(indexOfFirst('d', words)[0]);

    }
}