import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day 02: 学生成绩分析器
 *
 * 练习目标:
 *   1. 自定义类的使用
 *   2. ArrayList 的基本操作
 *   3. for 循环遍历
 *   4. HashMap 按班级分组
 *
 * 运行方式:
 *   javac -encoding UTF-8 -d out src/com/learn/day02/StudentAnalyzer.java
 *   java -cp out com.learn.day02.StudentAnalyzer
 */
public class StudentAnalyzer {

    // 学生类: 用来装一个学生的信息
    static class Student {
        String name;     // 姓名
        int score;       // 分数
        String className; // 班级

        Student(String name, int score, String className) {
            this.name = name;
            this.score = score;
            this.className = className;
        }
    }

    public static void main(String[] args) {
        // 1. 先造一些假数据, 当作"学生名单"
        List<Student> students = new ArrayList<>();
        students.add(new Student("小明", 85, "一班"));
        students.add(new Student("小红", 92, "一班"));
        students.add(new Student("小刚", 78, "一班"));
        students.add(new Student("小李", 95, "二班"));
        students.add(new Student("小王", 88, "二班"));
        students.add(new Student("小赵", 73, "二班"));
        students.add(new Student("小钱", 90, "三班"));

        // 2. 算全班平均分
        double avg = calculateAverage(students);
        System.out.println("全年级平均分: " + avg);

        // 3. 找出分数最高的学生
        Student top = findTopStudent(students);
        System.out.println("最高分学生: " + top.name + " (" + top.score + " 分)");

        // 4. 按班级分组, 看看每个班多少人
        Map<String, Integer> groupCount = groupByClassCount(students);
        System.out.println("各班人数:");
        for (String className : groupCount.keySet()) {
            System.out.println("  " + className + ": " + groupCount.get(className) + " 人");
        }

        // 5. 按班级分组, 看看每个班的平均分
        Map<String, Double> groupAvg = groupByClassAverage(students);
        System.out.println("各班平均分:");
        for (String className : groupAvg.keySet()) {
            System.out.println("  " + className + ": " + groupAvg.get(className) + " 分");
        }
    }

    /**
     * 计算所有学生的平均分
     */
    static double calculateAverage(List<Student> students) {
        // 如果名单是空的, 直接返回 0, 避免后面除法报错
        if (students.size() == 0) {
            return 0;
        }

        // 准备一个变量, 用来累加所有人的分数
        int total = 0;

        // 遍历每个学生, 把分数加到 total 上
        for (Student s : students) {
            total = total + s.score;
        }

        // 平均分 = 总分 / 人数 (用 double 强转, 避免整数除法)
        return (double) total / students.size();
    }

    /**
     * 找出分数最高的学生
     */
    static Student findTopStudent(List<Student> students) {
        // 先假设第 0 个学生是最高的
        Student top = students.get(0);

        // 从第 1 个开始挨个比
        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            // 如果当前学生分数更高, 就把它记为新的"最高分"
            if (current.score > top.score) {
                top = current;
            }
        }

        return top;
    }

    /**
     * 按班级分组, 统计每个班多少人
     * 返回: Map<班级名, 人数>
     */
    static Map<String, Integer> groupByClassCount(List<Student> students) {
        // 准备一个空的 Map, 用来存 "班级 -> 人数"
        Map<String, Integer> result = new HashMap<>();

        // 遍历每个学生
        for (Student s : students) {
            // 看这个学生的班级之前出现过没
            if (result.containsKey(s.className)) {
                // 出现过: 把旧人数拿出来 + 1, 再放回去
                int oldCount = result.get(s.className);
                result.put(s.className, oldCount + 1);
            } else {
                // 没出现过: 这个班第一个人, 记为 1
                result.put(s.className, 1);
            }
        }

        return result;
    }

    /**
     * 按班级分组, 算每个班的平均分
     * 返回: Map<班级名, 平均分>
     */
    static Map<String, Double> groupByClassAverage(List<Student> students) {
        // 先用两个 Map, 一个存总分, 一个存人数
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        // 遍历每个学生, 同时累计总分和人数
        for (Student s : students) {
            // 累加总分
            if (totalMap.containsKey(s.className)) {
                int oldTotal = totalMap.get(s.className);
                totalMap.put(s.className, oldTotal + s.score);
            } else {
                totalMap.put(s.className, s.score);
            }

            // 累加人数 (跟 groupByClassCount 里那段一模一样)
            if (countMap.containsKey(s.className)) {
                int oldCount = countMap.get(s.className);
                countMap.put(s.className, oldCount + 1);
            } else {
                countMap.put(s.className, 1);
            }
        }

        // 最后算每个班的平均分, 放进一个新 Map
        Map<String, Double> result = new HashMap<>();
        for (String className : totalMap.keySet()) {
            int total = totalMap.get(className);
            int count = countMap.get(className);
            double avg = (double) total / count;
            result.put(className, avg);
        }

        return result;
    }

    /* ===========================================================
     * 企业中通常这么写 (你现在不用学, 先看个眼熟):
     *
     * // 用 Stream + Lambda 一行搞定平均分
     * double avg = students.stream()
     *     .mapToInt(s -> s.score)
     *     .average()
     *     .orElse(0);
     *
     * // 用 groupingBy 一行搞定按班级分组统计
     * Map<String, Long> groupCount = students.stream()
     *     .collect(Collectors.groupingBy(s -> s.className, Collectors.counting()));
     * =========================================================== */
}
