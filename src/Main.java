import java.util.LinkedList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        System.out.println("*****---checkForPalindrome---*****");

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("Don't nod"));

        System.out.println("*****---checkForPalindromeSecond---*****");

        System.out.println(checkForPalindromeSecond("abccba"));
        System.out.println(checkForPalindromeSecond("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeSecond("I did, did I?"));
        System.out.println(checkForPalindromeSecond("hello"));
        System.out.println(checkForPalindromeSecond("Racecar"));
        System.out.println(checkForPalindromeSecond("Don't nod"));
    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();  // stack de açsam bu instance ı fark etmezdi. LinkedList stack gibi çalışır. ekleme yaptıkça son eklediğini çıkarır. LIFO !!!
        StringBuilder noPunctions = new StringBuilder();
        String newLowerCasedText = text.toLowerCase(Locale.ENGLISH).trim().replaceAll("[ '.,?!_-]","");

        for(int i=0; i< newLowerCasedText.length(); i++){
            char x = newLowerCasedText.charAt(i);  // String 'in i. karakteri, array gibi string elemanlarını geziniyor.
            if(x >= 'a' && x <= 'z') {
                noPunctions.append(x);
                stack.push(x);
                System.out.println(stack);
            }
        }
        StringBuilder reverses = new StringBuilder();
        while (!stack.isEmpty()) {
            reverses.append(stack.pop()); // Başından poplar(siler)
            System.out.println(stack);
        }

        return noPunctions.toString().contentEquals(reverses);
        // return noPunctions.toString().equals(reverses.toSting());
    }

    public static boolean checkForPalindromeSecond(String text){
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String textLowerCase = text.toLowerCase(Locale.ENGLISH);

        for(int i = 0; i< textLowerCase.length(); i++){
            char x =textLowerCase.charAt(i);
            if(x >= 'a' && x <= 'z') {
                queue.addLast(x);
                stack.push(x);
                System.out.println(stack);
            }
        }
        while (!stack.isEmpty()) {
            if(!stack.pop().equals((queue.removeFirst()))){
                return false;
            }
        }
        return true;
    }

}

// The java.util.LinkedList.pop() method is used to remove and return the top element from the stack represented by the LinkedList. The method simply pops out an element present at the top of the stack. This method is similar to removeFirst method in LinkedList. Syntax:
//LinkedListObject.pop()