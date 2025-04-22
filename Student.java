class Student {
    private String name;
    private int age;
    private double[] grades;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double[] getGrades() {
        return grades;
    }
    public void setGrades(double[] grades) {
        if (grades.length == 3) {
            this.grades = grades;
        } else {
            System.out.println("Hata: Not dizisi 3 elemanlı olmalı!");
        }
    }
    public double getAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }
    @Override
    public String toString() {
        return name + " (Yaş: " + age + ", Ortalama: " + getAverage() + ")";
    }
}
