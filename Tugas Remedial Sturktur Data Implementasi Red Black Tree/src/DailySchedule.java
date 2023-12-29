import java.util.ArrayList;

public class DailySchedule {
    public static void main(String[] args) {
        RedBlackTree<String> schedule = new RedBlackTree<>();

        schedule.insert("Kuliah");
        schedule.insert("Menonton Film");
        schedule.insert("Makan Siang");
        schedule.insert("Mandi");

        ArrayList<String> dailySchedule = schedule.inOrderTraversal();
        System.out.println("Jadwal Harian:");
        for (String activity : dailySchedule) {
            System.out.println(activity);
        }
    }
}