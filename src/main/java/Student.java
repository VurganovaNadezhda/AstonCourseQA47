import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Класс Student представляет студента с его характеристиками

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    /**
     * Конструктор Student
     *
     * @param name имя студента
     * @param group группа студента
     * @param course курс студента
     * @param grades список оценок
     */
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = new ArrayList<>(grades);
    }

    /**
     * Вычисляет средний балл студента
     *
     * @return средний балл
     */
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    /**
     * Переводит студента на следующий курс, если средний балл >= 3
     *
     * @return true если перевод успешен, false в противном случае
     */
    public boolean promoteToNextCourse() {
        if (getAverageGrade() >= 3.0) {
            this.course++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, grades=%s, average=%.2f}",
                name, group, course, grades, getAverageGrade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}

