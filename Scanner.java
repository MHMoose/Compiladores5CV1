package mx.ipn.escom.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;
import javax.xml.transform.Source;

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
    }


    Scanner(String source)
    {
        this.source = source;
    }

    List<Token> scanTokens()
    {
        int Estado, Posicion;
        char Caracter;

        Estado = 0;
        

        for (Posicion=0; Posicion<source.length(); Posicion++)
        {
            Caracter = source.charAt(Posicion);
            
            switch(Estado)
            {
                case 0:

                    if (Caracter=='(')
                    {
                        tokens.add(new Token(TipoToken.ABRIR_PARENTESIS, "(", null, linea));
                    }
                    else if(Caracter==')')
                    {
                        tokens.add(new Token(TipoToken.CERRAR_PARENTESIS, ")", null, linea));
                    }
                    else if(Caracter=='{')
                    {
                        tokens.add(new Token(TipoToken.ABRIR_LLAVE, "{", null, linea));
                    }
                    else if(Caracter=='}')
                    {
                        tokens.add(new Token(TipoToken.CERRAR_LLAVE, "}", null, linea));
                    }
                    else if(Caracter==',')
                    {
                        tokens.add(new Token(TipoToken.COMA, ",", null, linea));
                    }
                    else if(Caracter=='.')
                    {
                        tokens.add(new Token(TipoToken.PUNTO, ".", null, linea));
                    }
                    else if(Caracter==';')
                    {
                        tokens.add(new Token(TipoToken.PUNTO_Y_COMA, ";", null, linea));
                    }
                    else if(Caracter=='-')
                    {
                        tokens.add(new Token(TipoToken.RESTA, "-", null, linea));
                    }
                    else if(Caracter=='+')
                    {
                        tokens.add(new Token(TipoToken.SUMA, "+", null, linea));
                    }
                    else if(Caracter=='*')
                    {
                        tokens.add(new Token(TipoToken.ASTERISCO, "*", null, linea));
                    }
                    else if(Caracter=='/')
                    {
                        Estado = 1;
                    }
                    else if(Caracter=='!')
                    {
                        Estado = 2;
                    }
                    else if(Caracter=='=')
                    {
                        Estado = 3;
                    }
                    else if(Caracter=='<')
                    {
                        Estado = 4;
                    }
                    else if(Caracter=='>')
                    {
                        Estado = 5;
                    }
                    else if(Caracter=='"')
                    {
                       Estado = 9;
                    }
                    else if(Character.isDigit(Caracter))
                    {
                        Estado = 10;
                    }
                    else if(Character.isLetter(Caracter))
                    {
                        Estado = 16;
                    }
               break;
                
               case 1:

                    if(Caracter=='/')
                    {
                        Estado = 6;
                    }
                    else if(Caracter=='*')
                    {
                        Estado = 7;
                    }
                    else
                    {
                        Posicion--;
                        tokens.add(new Token(TipoToken.ENTRE, "/", null, linea));
                        Estado = 0;
                    }
                    
               break;
                case 2:

                    if (Caracter=='=')
                    {
                        tokens.add(new Token(TipoToken.DIFERENTE_DE, "!=", null, linea));
                    }
                    else
                    {
                        Posicion--;
                        tokens.add(new Token(TipoToken.DIFERENTE, "!", null, linea));
                    }

                    Estado = 0;

                break;

                case 3:

                    if(Caracter=='=')
                    {
                        tokens.add(new Token(TipoToken.IGUAL, "==", null, linea));
                    }   
                    else
                    {
                        Posicion--;
                        tokens.add(new Token(TipoToken.ASIGNACION, "=", null, linea));
                    } 

                    Estado = 0;

                break;

                case 4:

                    if (Caracter=='=')
                    {
                        tokens.add(new Token(TipoToken.MENOR_IGUAL_QUE, "<=", null, linea));
                    }
                    else
                    {
                        Posicion--;
                        tokens.add(new Token(TipoToken.MENOR_QUE, "<", null, linea));
                    }

                    Estado = 0;

                break;

                case 5:

                    if (Caracter=='=')
                    {
                        tokens.add(new Token(TipoToken.MAYOR_IGUAL_QUE,">=", null, linea));
                    }
                    else
                    {
                        Posicion--;
                        tokens.add(new Token(TipoToken.MAYOR_QUE, ">", null, linea));
                    }

                    Estado = 0;

                break;

                case 6:

                    if(Caracter=='\n')
                    {
                        Estado = 0;
                    }
                    else
                    {
                        Estado = 6;
                    }

                break;

                case 7:

                    if(Caracter=='*')
                    {
                        Estado = 8;
                    }
                    else
                    {
                        Estado = 7;
                    }

                break;

                case 8:

                    if(Caracter=='/')
                    {
                        Estado = 0;
                    }
                    else
                    {
                        Estado = 8;
                    }

                break;

                case 9:

                if(Caracter == '"')
                {
                    tokens.add(new Token(TipoToken.CADENA,"CADENA", null, linea));

                    Estado = 0;
                }
                else
                {
                    Estado = 9;
                }


            break;

            case 10:

                if(Character.isDigit(Caracter))
                {
                    Estado = 10;
                }                
                else if(Caracter == '.')
                {
                    Estado = 11;
                }
                else if(Caracter == 'E')
                {
                    Estado = 13;
                }
                else
                {
                    Posicion--;
                    tokens.add(new Token(TipoToken.NUMERO,"NUMERO", null, linea));

                    Estado = 0;
                }

            break;
            
            case 11:
                if(Character.isDigit(Caracter))
                {
                    Estado = 12;
                }
            break;

            case 12:
                if(Character.isDigit(Caracter))
                {
                    Estado = 12;
                }
                else if(Caracter == 'E')
                {
                    Estado = 13;
                }
                else
                {
                    Posicion--;
                    tokens.add(new Token(TipoToken.NUMERO,"NUMERO", null, linea));

                    Estado = 0;
                }
            break;

            case 13:
                if(Caracter == '+' || Caracter == '-')
                {
                    Estado = 14;
                }
                else if(Character.isDigit(Caracter))
                {
                    Estado = 15;
                }
            break;

            case 14:
                if(Character.isDigit(Caracter))
                {
                    Estado = 15;
                }
            break;

            case 15:
                if(Character.isDigit(Caracter))
                {
                    Estado = 15;
                }
                else
                {
                    Posicion--;
                    tokens.add(new Token(TipoToken.NUMERO,"NUMERO", null, linea));

                    Estado = 0;
                }
            break;

            case 16:

            tokens.add(new Token(palabrasReservadas.getOrDefault(String, TipoToken.IDENTIFICADOR),palabrasReservadas.get(String),literal,linea));

            break;

            }
        }
        //Aquí va el corazón del scanner.
        
            
        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF,"", null, linea));
    
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