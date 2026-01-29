import java.util.*;

// Custom Exception
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

// BackupTask Class
class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority;   // lower number = higher priority
    String time;

    public BackupTask(String folderPath, int priority, String time)
            throws InvalidBackupPathException {

        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path.");
        }

        this.folderPath = folderPath;
        this.priority = priority;
        this.time = time;
    }

    @Override
    public int compareTo(BackupTask other) {
        return this.priority - other.priority;
    }
}

// Main Scheduler Class
public class FileBackupScheduler {

    PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();

    // Add backup task
    public void scheduleBackup(BackupTask task) {
        backupQueue.add(task);
        System.out.println("Backup scheduled: " + task.folderPath);
    }

    // Execute backups
    public void executeBackups() {
        System.out.println("\nExecuting backups in priority order:");

        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            System.out.println(
                "Backing up: " + task.folderPath +
                " | Time: " + task.time +
                " | Priority: " + task.priority
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();

        try {
            scheduler.scheduleBackup(
                new BackupTask("C:/System", 1, "01:00 AM")); // critical

            scheduler.scheduleBackup(
                new BackupTask("D:/Projects", 2, "02:00 AM"));

            scheduler.scheduleBackup(
                new BackupTask("E:/Movies", 3, "03:00 AM"));

            // Invalid path → Exception
            scheduler.scheduleBackup(
                new BackupTask("", 4, "04:00 AM"));

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}

