package exception;

/**
 * @ClassName AgeException
 * @Author：Mayuan
 * @Date 2023/8/14/0014 15:14
 * @Description TODO
 * @Version 1.0
 **/


public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
