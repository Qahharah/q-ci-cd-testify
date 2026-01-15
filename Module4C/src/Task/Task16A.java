package Task;

public class Task16A {

    // Method 1: No parameter
    public void workout() {
        System.out.println("Doing a general workout at the gym");
    }

    // Method 2: One parameter
    public void workout(String exercise) {
        System.out.println("Doing " + exercise + " at the gym");
    }

    // Method 3: Two parameters
    public void workout(String exercise, int reps) {
        System.out.println("Doing " + reps + " reps of " + exercise);
    }

    public static void main(String[] args) {

        Task16A gymSession = new Task16A();

        gymSession.workout();
        gymSession.workout("Push ups");
        gymSession.workout("Squats", 20);
    }
}
