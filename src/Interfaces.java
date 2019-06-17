public class Interfaces {
    public static void main(String args[]) {
        Courses c = new Department();
        String subject = "PHY";
        c.addSubjects();
        c.getSubjects(subject);
        c.modifySubject();
        c.removeSubjects();
    }
}
