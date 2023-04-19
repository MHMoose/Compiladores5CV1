package mx.ipn.escom.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner 
{

    private final String source;
    private int Estado = 0;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private static final Map<String, TipoToken> palabrasReservadas;
    static 
    {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("ademas", TipoToken.ADEMAS);
        palabrasReservadas.put("falso", TipoToken.FALSO);
        palabrasReservadas.put("para", TipoToken.PARA);
        palabrasReservadas.put("fun", TipoToken.FUN); //definir funciones
        palabrasReservadas.put("si", TipoToken.SI);
        palabrasReservadas.put("nulo", TipoToken.NULO);
        palabrasReservadas.put("o", TipoToken.O);
        palabrasReservadas.put("imprimir", TipoToken.IMPRIMIR);
        palabrasReservadas.put("retornar", TipoToken.RETORNAR);
        palabrasReservadas.put("super", TipoToken.SUPER);
        palabrasReservadas.put("este", TipoToken.ESTE);
        palabrasReservadas.put("verdadero", TipoToken.VERDADERO);
        palabrasReservadas.put("var", TipoToken.VAR); //definir variables
        palabrasReservadas.put("mientras", TipoToken.MIENTRAS);

        palabrasReservadas.put("abrir_parentesis", TipoToken.ABRIR_PARENTESIS);
        palabrasReservadas.put(")", TipoToken.CERRAR_PARENTESIS);
        palabrasReservadas.put("{", TipoToken.ABRIR_LLAVE);
        palabrasReservadas.put("}", TipoToken.CERRAR_LLAVE);
        palabrasReservadas.put(",", TipoToken.COMA);
        palabrasReservadas.put(".", TipoToken.PUNTO);
        palabrasReservadas.put(";", TipoToken.PUNTO_Y_COMA);
        palabrasReservadas.put("-", TipoToken.MENOS);
        palabrasReservadas.put("+", TipoToken.MAS);
        palabrasReservadas.put("*", TipoToken.ASTERISCO);
        palabrasReservadas.put("/", TipoToken.DIAGONAL);
        palabrasReservadas.put("!", TipoToken.EXCLAMACION);
        palabrasReservadas.put("!=", TipoToken.DIFERENTE_DE);
        palabrasReservadas.put("=", TipoToken.IGUAL);
        palabrasReservadas.put("==", TipoToken.COMPARASION);
        palabrasReservadas.put("<", TipoToken.MENOR_QUE);
        palabrasReservadas.put("<=", TipoToken.MENOR_IGUAL_QUE);
        palabrasReservadas.put(">", TipoToken.MAYOR_QUE);
        palabrasReservadas.put(">=", TipoToken.MAYOR_IGUAL_QUE);
    }


    Scanner(String source){
        this.source = source;
    }

    List<Token> scanTokens(){
        //Aquí va el corazón del scanner.
        while(source!="")
        {
            switch(Estado)
            {
                case 0:
                    
                    if (source=="(")
                    {
                        tokens.add(new Token(TipoToken.ABRIR_PARENTESIS, "(" ,null, linea));
                    }
                    else if (source==")")
                    {

                    }
                    else if (source=="{")
                    {

                    }
                    else if (source=="}")
                    {

                    }
                    else if (source==",")
                    {

                    }
                    else if (source==".")
                    {

                    }
                    else if (source==";")
                    {

                    }
                    else if (source=="-")
                    {

                    }
                    else if (source=="+")
                    {

                    }
                    else if (source=="*")
                    {

                    }
                    else if (source=="/")
                    {

                    }
                    else if (source=="!")
                    {

                    }
                    else if (source=="=")
                    {
                        
                    }
                    else if (source=="<")
                    {
                        Estado = 1;
                        System.out.println("WARD");
                    }
                    else if (source==">")
                    {

                    }

                    //break;
                case 1:
                    
                    if (source=="=")
                    {
                        //Sytem.out.println("WARD");
                        tokens.add(new Token(TipoToken.MENOR_IGUAL_QUE, "<=" , "<=" , linea));
                    }

                    //break;
            }
            
        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF,"", null, linea));
        }
        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */