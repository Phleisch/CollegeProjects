public class Project {
    public static void checkNull(Object obj, String varName) {
        if (obj == null)
            throw new IllegalArgumentException(varName + " cannot be null.");
    }
}