package exception;

/**
 * @ClassName NameException
 * @Author：Mayuan
 * @Date 2023/8/14/0014 15:15
 * @Description TODO
 * @Version 1.0
 **/
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
