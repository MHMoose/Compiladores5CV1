package mx.ipn.escom.compiladores;

public class Token {

    final TipoToken tipo; //Identificador
    final String lexema; //Valor
    final Object literal;
    final int linea;

    public Token(TipoToken tipo, String lexema, Object literal, int linea) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.literal = literal;
        this.linea = linea;
    }

    public String toString(){
        return tipo + " " + lexema + " " + literal;
    }
}
