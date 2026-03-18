import java.util.*;

class Student {
    String name;
    String dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }

    int getQuizMark(String quiz) {
        switch (quiz) {
            case "Q1": return q1;
            case "Q2": return q2;
            case "Q3": return q3;
            default: return -1;
        }
    }
}

public class QuizRankingSystem {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String[] parts = sc.nextLine().split(" ");

            switch (parts[0]) {
                case "Record":
                    record(parts);
                    break;
                case "Top":
                    top(parts[1]);
                    break;
            }
        }
    }

    static void record(String[] p) {

        list.add(new Student(
                p[1],
                p[2],
                Integer.parseInt(p[3]),
                Integer.parseInt(p[4]),
                Integer.parseInt(p[5])
        ));

        System.out.println("Record Added: " + p[1]);
    }

    static void top(String key) {

        if (list.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        if (key.startsWith("Q"))
            topQuiz(key);
        else
            topDepartment(key);
    }

    static void topDepartment(String dept) {

        int max = -1;
        List<Student> winners = new ArrayList<>();

        for (Student s : list) {

            if (!s.dept.equals(dept)) continue;

            int total = s.total();

            if (total > max) {
                max = total;
                winners.clear();
                winners.add(s);
            } else if (total == max) {
                winners.add(s);
            }
        }

        if (winners.isEmpty()) {
            System.out.println("Department Not Found");
            return;
        }

        for (Student s : winners)
            System.out.println(s.name + " " + max);
    }

    static void topQuiz(String quiz) {

        int max = -1;
        List<Student> winners = new ArrayList<>();

        for (Student s : list) {

            int mark = s.getQuizMark(quiz);

            if (mark > max) {
                max = mark;
                winners.clear();
                winners.add(s);
            } else if (mark == max) {
                winners.add(s);
            }
        }

        for (Student s : winners)
            System.out.println(s.name + " " + max);
    }
}