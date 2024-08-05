package Stdent2;


    public class Student {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String code;
    private int gender; // 0 - Female, 1 - Male
    private float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age= age;
    }

    public String name(){
        return name;
    }
    public void getName(String name){
        this.name = name;
    }


    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade){
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }
    public void setCode( String code){
        this.code = code;
    }

    public int getAge() {
        return age;
    }
    public void setName(int age){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }

    public void getAge(String age){
        this.email= email;
    }

    public String setPhone(){
        return phone;
    }
    public void getPhone(String phone ){
        this.phone = phone;
    }

    public int setGender(){
        return gender;
    }
    public void getGender(int gender){
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Student{"+
                "name='" + name + '\'' +
                ",age="+ age +
                ",email='" + email + '\'' +
                ",phone='" + phone + '\''+
                ",gender=" + (gender == 0 ? "Female" : "Male" ) +
                ",grader=" + grade +
                '}';


    }
        public String getName() {
        return name;
        }
    }
