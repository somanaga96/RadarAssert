package exception;

public class CSVLoadException extends RuntimeException {
    public CSVLoadException(Exception errorMsg) {
        super(errorMsg);
    }
}
