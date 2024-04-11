package br.facens.guimagarotti.students.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String mensagem) {
        super(mensagem);
    }

    public StudentNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
