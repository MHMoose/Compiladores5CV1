package mx.ipn.escom.compiladores;

public enum TipoToken {
    /*Se crea un tipoToken por cada palabra reservada, así como un 
    identificador, para una cadena y numero, también se hace por cada
    "Signo del lenguaje"*/
    // Palabras clave:
    Y, 
    CLASE, 
    ADEMAS, 
    FALSO, 
    PARA, 
    FUN, 
    SI, 
    NULO, 
    O, 
    IMPRIMIR,
    RETORNAR, 
    SUPER, 
    ESTE, 
    VERDADERO, 
    VAR, 
    MIENTRAS,
    COMA,
    PUNTO,
    PUNTOCOMA,
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    MODULO,
    MENOR,
    MENORIGUAL,
    MAYOR,
    MAYORIGUAL,
    DISTINTO,
    IGUAL,
    


    // Final de cadena
    EOF
}
