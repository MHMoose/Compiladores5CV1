package mx.ipn.escom.compiladores;

public enum TipoToken {
    /*Se crea un tipoToken por cada palabra reservada, así como un 
    identificador, para una cadena y numero, también se hace por cada
    "Signo del lenguaje"*/

    ADEMAS, FALSO, PARA, FUN, SI, NULO, O, IMPRIMIR,
    RETORNAR, SUPER, ESTE, VERDADERO, VAR, MIENTRAS,

    // Palabras clave:
    Y, 
    CLASE, 
    
    ABRIR_PARENTESIS, CERRAR_PARENTESIS, ABRIR_LLAVE, CERRAR_LLAVE,
    COMA, PUNTO, PUNTO_Y_COMA, SUMA, RESTA, ASTERISCO,
    


    // Final de cadena
    EOF
}
