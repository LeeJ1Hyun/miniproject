package mycom.my.student.model;

public class StudentsService {

    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StudentsService.name = name;
    }
 
}
