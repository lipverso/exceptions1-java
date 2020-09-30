package model.exceptions;


//Pode ser extensao da RunTimeException (Compilador nao obriga a tratar
//Ou extensa da Exception (Compilador vai obrigar voce a tratar)
//
public class DomainExceptions extends Exception{
    private static final long serialVersionUID = 1L;

    public DomainExceptions(String msg){
        super(msg);
    }
}
