import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 词频统计器
 */
public class FrequencyCounter {

    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("1");
            return;
        }

        Path path = Paths.get(args[0]);
        String content = Files.readString(path);

        List<String> words = tokenize(content);
        Map<String, Integer> freq = count(words);

        System.out.println("=== 词频 Top 10 ===");
        topN(freq, 10).forEach((word, count) ->
                System.out.printf("%-15s %d%n", word, count));
    }

    /**
     * 把一段文本切成"单词"列表:
     *   - 全部转小写
     *   - 用非字母数字字符当分隔符
     *   - 过滤掉空字符串
     */
    public static List<String> tokenize(String text) {

        String lower = text.toLowerCase();
        String[] roughWords = lower.split("[^a-z0-9]+");

        Stream<String> stream = Arrays.stream(roughWords);

        Stream<String> filtered = stream.filter(s -> !s.isBlank());

        List<String> result = filtered.toList();

        return result;
    }

    /**
     * 统计词频, 返回 HashMap<String, Integer>
     */
    public static Map<String,Integer>count(List<String> words){
        Map<String,Integer>map = new HashMap<>();
        for (String w : words){
            map.merge(w,1,Integer :: sum);
        }
        return map;
    }


    public static Map<String, Integer> topN(Map<String, Integer> freq, int n) {
        return freq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }























}