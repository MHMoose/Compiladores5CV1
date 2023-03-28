package mx.ipn.escom.compiladores;

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

    // Final de cadena
    EOF
}
