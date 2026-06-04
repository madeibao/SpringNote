package exception;

/**
 * @ClassName MyUserException
 * @Author：Mayuan
 * @Date 2023/8/14/0014 15:15
 * @Description TODO
 * @Version 1.0
 **/


public class MyUserException extends Exception{
    public MyUserException() {
        super();
    }

    public MyUserException(String message) {
        super(message);
    }
}