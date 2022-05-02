package mycom.my.student.model;

public class StudentsDTO {
    private int nn;
    private String name;
    private String teachername;
    private String stroke;
    private int No;

    public StudentsDTO() {
        super();
    }

    public StudentsDTO(int nn, String name, String teachername, String stroke, int No) {
        this.nn = nn;
        this.name = name;
        this.teachername = teachername;
        this.stroke = stroke;
        this.No = No;
    }

    public int getNn() {
        return nn;
    }

    public void setNn(int nn) {
        this.nn = nn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    @Override
    public String toString() {
        return "StudentsDTO{" + "nn=" + nn + ", name=" + name + ", teachername=" + teachername + ", stroke=" + stroke + ", No=" + No + '}';
    }

}