import java.util.Scanner;

// Custom Exception Class
class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}

class RobotHazardAuditor {
    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {
        // Validation for armPrecision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
        
        // Validation for workerDensity
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        // Determine machineRiskFactor based on machineryState
        double machineRiskFactor;
        switch (machineryState) {
            case "Worn":
                machineRiskFactor = 1.3;
                break;
            case "Faulty":
                machineRiskFactor = 2.0;
                break;
            case "Critical":
                machineRiskFactor = 3.0;
                break;
            default:
                throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        // Formula: ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor)
        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }
}

public class RobotHazardAnalyzer{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            // Reading Inputs
            double armPrecision = Double.parseDouble(scanner.nextLine());
            int workerDensity = Integer.parseInt(scanner.nextLine());
            String machineryState = scanner.nextLine();

            // Calculation
            double riskScore = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.printf("Robot Hazard Risk Score: %.1f\n", riskScore);

        } catch (RobotSafetyException e) {
            // Displaying the specific error message from the exception
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input format");
        } 
    }
}