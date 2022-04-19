package web.ide.devEnviroment.exeption;

public class SupervisorNotFoundException extends RuntimeException{
    public SupervisorNotFoundException(String message){
        super(message);
    }
}
