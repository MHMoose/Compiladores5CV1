package mx.ipn.escom.compiladores;

<<<<<<< HEAD
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
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    POTENCIA,
    MODULO,
    MENOR,
    MENORIGUAL,
    MAYOR,
    MAYORIGUAL,
    DISTINTO,
    IGUAL,


=======
public enum TipoToken 
{
    // Crear un tipoToken por palabra reservada

    ADEMAS, FALSO, PARA, FUN, SI, NULO, O, IMPRIMIR,
    RETORNAR, SUPER, ESTE, VERDADERO, VAR, MIENTRAS,
    // Crear un tipoToken: identificador, una cadena y numero
    IDENTIFICAOR, CADENA, NUMERO,
    // Crear un tipoToken por cada "Signo del lenguaje" (ver clase Scanner)

    ABRIR_PARENTESIS, CERRAR_PARENTESIS, ABRIR_LLAVE, CERRAR_LLAVE, COMA, PUNTO, PUNTO_Y_COMA,
    MENOS, MAS, ASTERISCO, DIAGONAL, EXCLAMACION, DIFERENTE_DE, IGUAL, COMPARASION, MENOR_QUE, 
    MENOR_IGUAL_QUE, MAYOR_QUE, MAYOR_IGUAL_QUE,
    

    // Palabras clave:
    Y, CLASE,
>>>>>>> 29dae8b4304c8565a24d92646364a7c0e6ab7d25

    // Final de cadena
    EOF
}
