import java.util.ArrayList;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // sensitive data

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory = "";

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println(medicalHistory);
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory = "";

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println(medicalHistory);
    }
}
public class HospitalPatientManagementSystem {

    public static void main(String[] args) {

        ArrayList<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient(1, "Vishal", 30, 5, 2000);
        Patient p2 = new OutPatient(2, "Karan", 25, 500);

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill Amount: " + p.calculateBill());
            System.out.println("----------------------");
        }
    }
}
