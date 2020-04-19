package DaoTest;

public class test {

    public static void main(String[] args) {
        student stu = new student();
        stu.setId(4);
        stu.setAge(35);
        stu.setName("momo");
//      System.out.println(stu);
        dao.save(stu);
    }


}
