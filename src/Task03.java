import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        System.out.println("Задание 3");
        String[] strings = {"  Hello vsem", "Java or Python ", "Scoree by noviy god"};

        System.out.println("Исходный массив: " + arrayToString(strings));

        Arrays.sort(strings, (s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println("Массив после сортировки в обратном порядке: " + arrayToString(strings));

        Arrays.sort(strings, (s1, s2) -> countWords(s1) - countWords(s2));
        System.out.println("Массив после сортировки по количеству слов: " + arrayToString(strings));
    }

    private static String arrayToString(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }
    private static int countWords(String s) {
        return s.split("\\s+").length;
    }
}




