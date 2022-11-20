package exception;

/**
 * 余额不足异常
 */
public class BalanceNotEnoughException extends Exception{
    public BalanceNotEnoughException() {
    }

    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
