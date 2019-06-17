abstract class ModifySubject implements Courses {
    public void addSubjects() {
        // add your subjects
        System.out.println("Added Subject");
    }

    public String getSubjects(String subject) {
        // get all the subjects
        System.out.println("Subject " + subject);
        return subject;
    }

    public void removeSubjects() {
        // remove all the subjects
        System.out.println("Removed Subject");
    }
}


public class Department extends ModifySubject implements Courses {
    @Override
    public void modifySubject() {
        // modify some parts of Subject
        System.out.println("Modify Subject");
    }


}
