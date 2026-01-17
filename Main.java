import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStats {
    private static List<String> tokenize(String text) {
        List<String> words = new ArrayList<>();
        Matcher m = Pattern.compile("[A-Za-z0-9]+").matcher(text.toLowerCase());
        while (m.find()) {
            words.add(m.group());
        }
        return words;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("usage: java TextStats <path> [--top N]");
            System.exit(1);
        }
        int top = 10;
        String path = null;
        for (int i = 0; i < args.length; i++) {
            if ("--top".equals(args[i]) && i + 1 < args.length) {
                top = Integer.parseInt(args[++i]);
            } else if (path == null) {
                path = args[i];
            }
        }
        String text = Files.readString(Path.of(path));
        int lines = text.isEmpty() ? 0 : (int) text.chars().filter(c -> c == '\n').count() + 1;
        List<String> words = tokenize(text);
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            counts.put(w, counts.getOrDefault(w, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        System.out.println("lines: " + lines);
        System.out.println("words: " + words.size());
        System.out.println("chars: " + text.length());
        System.out.println("top words:");
        for (int i = 0; i < Math.min(top, list.size()); i++) {
            Map.Entry<String, Integer> e = list.get(i);
            System.out.println("  " + e.getKey() + ": " + e.getValue());
        }
    }
}
