import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager(10); // Öğrenci kapasitesi 10
        boolean running = true;

        while (running) {
            System.out.println("\nÖğrenci Yönetim Sistemi");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Öğrenci Sil");
            System.out.println("3. Öğrencileri Listele");
            System.out.println("4. Öğrencinin Ortalama Notunu Gör");
            System.out.println("5. Çıkış");
            System.out.print("Bir seçenek girin: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // buffer temizleme

            switch (choice) {
                case 1:  // Öğrenci Ekle
                    System.out.print("Öğrencinin adını girin: ");
                    String name = scanner.nextLine();
                    System.out.print("Öğrencinin yaşını girin: ");
                    int age = scanner.nextInt();
                    System.out.print("Öğrencinin 3 notunu girin (aralarına boşluk bırakın): ");
                    double[] grades = new double[3];
                    for (int i = 0; i < 3; i++) {
                        grades[i] = scanner.nextDouble();
                    }
                    scanner.nextLine(); // buffer temizleme

                    Student newStudent = new Student();
                    newStudent.setName(name);
                    newStudent.setAge(age);
                    newStudent.setGrades(grades);
                    manager.addStudent(newStudent);
                    System.out.println(name + " başarıyla eklendi!");
                    break;

                case 2:  // Öğrenci Sil
                    System.out.print("Silmek istediğiniz öğrencinin adını girin: ");
                    String removeName = scanner.nextLine();
                    if (manager.removeStudent(removeName)) {
                        System.out.println(removeName + " başarıyla silindi!");
                    } else {
                        System.out.println("Öğrenci bulunamadı.");
                    }
                    break;

                case 3:  // Öğrencileri Listele
                    manager.listStudents();
                    break;

                case 4:  // Öğrencinin Ortalama Notunu Gör
                    System.out.print("Ortalama notunu görmek istediğiniz öğrencinin adını girin: ");
                    String avgName = scanner.nextLine();
                    double avg = manager.getStudentAverage(avgName);
                    if (avg != -1) {
                        System.out.println(avgName + " öğrencisinin ortalaması: " + avg);
                    }
                    break;

                case 5:  // Çıkış
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }
}
