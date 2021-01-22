import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        System.out.println(transliteration("Привет"));
        System.out.println(countingChar("Banana"));
        System.out.println(countingCharIndex("Banana"));
    }

    private static Map<Character, String> createMap() {
        char[] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        String[] eng = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};
        Map<Character, String> translit = new HashMap<>();
        for (int i = 0; i < rus.length; i++) {
            translit.put(rus[i], eng[i]);
        }
        return translit;
    }

    private static String transliteration(String s) {
        Map<Character, String> translit = createMap();
        String String = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char symb = String.charAt(i);
            String symbResult = translit.get(symb);
            if (Character.isLowerCase(s.charAt(i))) {
                result.append(symbResult);
            }
            else {
                result.append(Character.toUpperCase(symbResult.charAt(i))).append(symbResult.substring(i+1));
            }
        }
        return result.toString();
    }

    private static Map<Character, Integer> countingChar(String s) {
        Map<Character, Integer> countSymbol = new HashMap<>();
        String Str= s.toLowerCase();
        for (int i=0; i<Str.length(); i++) {
            Character symb = Str.charAt(i);
            if (countSymbol.containsKey(symb)) {
                countSymbol.put(symb, countSymbol.get(symb) + 1);
            }
            else {
                countSymbol.put(symb, 1);
            }
        }
        return countSymbol;
    }

    private static  Map<Character, List<Integer>> countingCharIndex(String s) {
        Map<Character, List<Integer>> countIndex = new HashMap<>();
        String Str= s.toLowerCase();
        char[] symb = Str.toCharArray();
        for (int i=0; i<Str.length(); i++) {
            if (countIndex.containsKey(symb[i])) {
                countIndex.get(symb[i]).add(i);
            }
            else {
                countIndex.put(symb[i], new ArrayList<>(List.of(i)));
            }
        }
        return countIndex;
    }
}