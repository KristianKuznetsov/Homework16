import java.util.*;

public class SolutionClass {
    public static Map<String, Boolean> wordMultiple(ArrayList<String> list) {
        Map<String, Boolean> map = new HashMap<>();

        for (String el : list) {
            if (map.containsKey(el)) {
                map.replace(el, true);
            } else {
                map.put(el, false);
            }
        }

        return map;
    }

    public static Map<String, String> pairs(ArrayList<String> list) {
        Map<String, String> result = new HashMap<>();

        for (String s : list) {
            String firstChar = String.valueOf(s.charAt(0));
            String lastChar = String.valueOf(s.charAt(s.length() - 1));
            result.put(firstChar, lastChar);
        }

        return result;
    }

    public static boolean taskStar(String sequence) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (isOpeningBracket(c)) {
                stack.addLast(c);
            } else {
                if (!stack.isEmpty() && isMatching(stack.getLast(), c)) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }

        }

        return (stack.isEmpty()) ? true : false;
    }

    private static boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }

    public static void buildTaskOne() {
        //(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        //wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        //wordMultiple(["c", "c", "c", "c"]) → {"c": true}

        String[] input1 = {"a", "b", "a", "c", "b"};
        String[] input2 = {"c", "b", "a"};
        String[] input3 = {"c", "c", "c", "c"};

        ArrayList<String> list1 = new ArrayList<>(List.of(input1));
        ArrayList<String> list2 = new ArrayList<>(List.of(input2));
        ArrayList<String> list3 = new ArrayList<>(List.of(input3));

        System.out.println(list1 + " -> " + wordMultiple(list1));
        System.out.println(list2 + " -> " + wordMultiple(list2));
        System.out.println(list3 + " -> " + wordMultiple(list3));
        System.out.println("\n");
    }

    public static void buildTaskTwo() {
        //pairs(["code", "bug"]) → {"b": "g", "c": "e"}
        //pairs(["man", "moon", "main"]) → {"m": "n"}
        //pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}

        String[] input1 = {"code", "bug"};
        ArrayList<String> list1 = new ArrayList<>(List.of(input1));
        System.out.println(list1 + " -> " + pairs(list1));

        String[] input2 = {"man", "moon", "main"};
        ArrayList<String> list2 = new ArrayList<>(List.of(input2));
        System.out.println(list2 + " -> " + pairs(list2));

        String[] input3 = {"man", "moon", "good", "night"};
        ArrayList<String> list3 = new ArrayList<>(List.of(input3));
        System.out.println(list3 + " -> " + pairs(list3));

        System.out.println("\n");
    }

    public static void buildTaskStar() {
        //() - сбалансирована
        //[()] - сбалансирована
        //{[()]} - сбалансирована
        //([{{[(())]}}]) - сбалансирована
        //{{[]()}}}} - не сбалансирована
        //{[(])} - не сбалансирована

        String[] array = {"()", "[()]", "{[()]}", "([{{[(())]}}])", "{{[]()}}}}", "{[(])}"};
        for (String el : array) {
            System.out.println(el + " -> " + ((taskStar(el)) ? "сбалансировано" : "не сбалансировано"));
        }
        System.out.println("\n");
    }
}
