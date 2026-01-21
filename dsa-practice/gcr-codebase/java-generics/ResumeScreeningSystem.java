import java.util.ArrayList;
import java.util.List;

// 1. Abstract Base Class for Job Roles
abstract class JobRole {
    String roleName;
    JobRole(String roleName) { this.roleName = roleName; }
    public abstract void showRequirements();
}

// 2. Specific Job Role Implementations
class SoftwareEngineer extends JobRole {
    SoftwareEngineer() { super("Software Engineer"); }
    public void showRequirements() { System.out.println("Skills: Java, Spring Boot, Microservices."); }
}

class DataScientist extends JobRole {
    DataScientist() { super("Data Scientist"); }
    public void showRequirements() { System.out.println("Skills: Python, Machine Learning, Statistics."); }
}

class ProductManager extends JobRole {
    ProductManager() { super("Product Manager"); }
    public void showRequirements() { System.out.println("Skills: Roadmap, Agile, User Research."); }
}

// 3. Generic Class to process Resumes with Bounded Type Parameter
class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public T getRole() { return role; }
    public String getCandidateName() { return candidateName; }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + " | Applied for: " + role.roleName;
    }
}

// 4. Main AI Screening System
public class ResumeScreeningSystem {

    // 5. Wildcard Method: Processes any list of resumes that extend JobRole
    // List<? extends Resume<? extends JobRole>> helps handle any role type
    public static void processScreeningPipeline(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("--- Starting AI Resume Screening Pipeline ---");
        for (Resume<? extends JobRole> r : resumes) {
            System.out.println("Processing " + r);
            System.out.print("   ");
            r.getRole().showRequirements(); // Accessing methods of Bounded Type
        }
        System.out.println("--- Screening Complete ---\n");
    }

    public static void main(String[] args) {
        // Resume List for Software Engineers
        List<Resume<SoftwareEngineer>> sweResumes = new ArrayList<>();
        sweResumes.add(new Resume<>("Amit Sharma", new SoftwareEngineer()));
        sweResumes.add(new Resume<>("Priya Verma", new SoftwareEngineer()));

        // Resume List for Data Scientists
        List<Resume<DataScientist>> dsResumes = new ArrayList<>();
        dsResumes.add(new Resume<>("Rohan Das", new DataScientist()));

        // Resume List for Product Managers
        List<Resume<ProductManager>> pmResumes = new ArrayList<>();
        pmResumes.add(new Resume<>("Sanya Malhotra", new ProductManager()));

        // Running the Screening Pipeline using Wildcards
        processScreeningPipeline(sweResumes);
        processScreeningPipeline(dsResumes);
        processScreeningPipeline(pmResumes);
    }
}
