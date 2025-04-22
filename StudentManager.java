public class StudentManager {
    private Student[] students;
    private int studentCount;

    public StudentManager(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }

    public void addStudent(Student s){
        if (studentCount < students.length) {
            students[studentCount] = s;
            studentCount++;
        }
        else {
            System.out.println("Öğrenci kapasitesi dolu!!!");
        }
    }
    public boolean removeStudent(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                // Öğrenciyi bulduk, diziyi kaydırıyoruz
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null; // son elemanı temizle
                studentCount--; // sayaç azalt
                return true;
            }
        }
        return false; // hiç eşleşme bulunmadıysa
    }
    public void listStudents() {
        if (studentCount== 0){
            System.out.println("Hiç öğrenci yok");
        }
        for(int i=0; i<studentCount;i++){
            System.out.println((i+1)+"."+ students[i]);
        }
    }
    public  double getStudentAverage(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
              return students[i].getAverage();
            }
        }
        System.out.println("Öğrenci bulunmadi!!!");
        return -1;
    }

}
