package web.ide.devEnviroment.exeption;

public class StudentNotFoundExeption extends RuntimeException {
    public StudentNotFoundExeption(String message){
        super(message);
    }

}
