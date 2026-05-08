import com.packages.arrays.*;
import com.packages.linked_list.*;
import com.packages.strings.*;
import java.util.Scanner;
import com.packages.stacks.*;

public class Main 
{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        String resp;
        do {
            System.out.println("Menú de opciones");
            System.out.println("0. Salir");
            System.out.println("1. Cadenas de caracteres");
            System.out.println("2. Vectores");
            System.out.println("3. Matrices");
            System.out.println("4. Registros");
            System.out.println("5. Lista Simplemente Ligada");
            System.out.println("6. Lista Simplemente Ligada Circular");
            System.out.println("7. Lista Doblemente Ligada");
            System.out.println("8. Pilas");
            System.out.println("9. Polinomios con LSL");
            System.out.println("10. Juego Triqui");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    System.out.println("Hasta pronto");
                    break;
                case "1":
                    menuString();
                    break;
                case "2":
                    menuVector();
                    break;
                case "3":
                    menuMatrix();
                    break;
                case "4":
                    menuRecords();
                    break;
                case "5":
                    menuLSL();
                    break;
                case "6":
                    menuLSLC();
                    break;
                case "7":
                    menuLDL();
                    break;
                case "8":
                    menuStacks();
                    break;
                case "9":
                    menuPolynomial();
                    break;
                case "10":
                    menuTriqui();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuString()
    {
        String resp;
        StringChar str = new StringChar();
        do {
            System.out.println("Menú Cadenas de Caracteres");
            System.out.println("0. Regresar");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Mostrar texto");
            System.out.println("3. Longitud texto");
            System.out.println("4. Texto mayúscula");
            System.out.println("5. Texto minúscula");
            System.out.println("6. Palíndromo");
            System.out.println("7. Ejemplos cadenas");
            System.out.println("8. Contar carácter del usuario");
            System.out.println("9. Convertir cadena a ASCII");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese un texto: ");
                    str.setText(input.nextLine());
                    break;
                case "2":
                    System.out.println("Texto ingresado: " + str.getText());
                    break;
                case "3":
                    System.out.println("Longitud texto: " + str.lengthString());
                    break;
                case "4":
                    System.out.println("Texto en mayúscula: " + str.upperString());
                    break;
                case "5":
                    System.out.println("Texto en minúscula: " + str.lowerString());
                    break;
                case "6":
                    str.palindrome();
                    break;
                case "7":
                    ExampleStrings es = new ExampleStrings();
                    break;
                case "8":
                    char charUser;
                    System.out.println("Carácter a contar: ");
                    charUser = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("El carácter " + charUser + " se encuentra " + str.countChar(charUser));
                    break;
                case "9":
                    System.out.println("Cadena ASCII: " + str.stringASCII());
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuVector()
    {
        String resp;
        int datum, pos;
        Vector v = new Vector();
        
        do {
            System.out.println("\n-------Menú Vectores------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar (secuencial)");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar");
            System.out.println("8. Ordenar (burbuja)");
            System.out.println("9. Suma datos");
            System.out.println("10. Promedio datos");
            System.out.println("11. Mayor dato");
            System.out.println("12. Menor dato");
            System.out.println("13. Varianza");
            System.out.println("14. Desviación");
            System.out.println("15. Intercambio");
            System.out.println("16. Producto punto");
            System.out.println("17. Eliminar ocurrencias");
            System.out.println("18. Verificar orden ascendente");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato vector: ");
                    datum = input.nextInt();
                    input.nextLine();
                    if (v.getN() < v.getT()) {
                        v.addVector(datum);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    // v.addVector(input.nextInt());
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + v.getN());
                    break;
                case "3":
                    v.showVector();
                    break;
                case "4":
                    if (v.getN() > 0) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.println(datum + " encontrado en posición " + pos);
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "5":
                    if (v.getN() > 0) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.updateVector(datum, pos);
                            System.out.println("Dato actualizado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "6":
                    if (v.getN() > 0) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            v.deleteVector(pos);
                            System.out.println("Dato eliminado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "7":
                    if (v.getN() < v.getT()) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.insertVector(pos, datum);
                            System.out.println("Dato insertado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "8":
                    if (v.getN() > 0) {
                        v.sortBubble();
                        System.out.println("Vector ordenado correctamente");
                    } else {
                        System.out.println("Vector vacío");
                    }
                case "9":
                    if (v.getN() > 0) {
                        System.out.println("Suma datos vector: " + v.sumVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "10":
                    if (v.getN() > 0) {
                        System.out.println("Promedio datos vector: " + v.avgVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "11":
                    if (v.getN() > 0) {
                        System.out.println("Mayor dato vector: " + v.maxVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "12":
                    if (v.getN() > 0) {
                        System.out.println("Menor dato vector: " + v.minVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "13":
                    if (v.getN() > 1) {
                        System.out.println("Varianza: " + v.variance());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "14":
                    if (v.getN() > 1) {
                        System.out.println("Desviación estándar: " + v.desviation());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "15":
                    if (v.getN() > 0) {
                        v.interchange();
                        System.out.println("Se intercambiaron los datos del vector");
                    } else {
                        System.out.println("No hay datos");
                    }
                    break;
                case "16":
                    int [] v1 = {2, 5 ,-6};
                    int [] v2 = {1, 8 , 4};
                    System.out.println("Producto punto: " + v.productPoint(v1, v2, 3));
                    break;
                case "17":
                    if (v.getN() > 0) {
                        v.deleteOcurrencies();
                        v.showVector();
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "18":
                    if (v.getN() > 0) {
                        if (v.sortAsc()) {
                            System.out.println("Vector ordenado ascendentemente");
                        } else {
                            System.out.println("El vector no está ordenado ascendentemente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuMatrix()
    {
        String resp;
        int rows, cols;
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        rows = 0;
        cols = 0;
        
        do {
            System.out.println("\n-------Menú Matrices------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear matriz");
            System.out.println("2. Tamaño (orden)");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma matrices");
            System.out.println("5. Diagonal principal");
            System.out.println("6. Diagonal secundaria");
            System.out.println("7. Triángulo arriba");
            System.out.println("8. Triángulo izquierdo");
            System.out.println("9. Triángulo derecho");
            System.out.println("10. Triangular inferior");
            System.out.println("11. Triangular inferior secundaria");
            System.out.println("12. Mayor dato por fila");
            System.out.println("13. Promedio por columna");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Número filas: ");
                    rows = input.nextInt();
                    input.nextLine();
                    System.out.print("Número columnas: ");
                    cols = input.nextInt();
                    input.nextLine();
                    if (rows > 0 && rows <= 50 && cols > 0 && cols <= 50) {
                        matrix.setM(rows);
                        matrix.setN(cols);
                        matrix.createMatrix();
                        System.out.println("Matriz creada correctamente");
                    } else {
                        System.out.println("Tamaño no válido para la matriz");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño matriz: " + matrix.getM() + " x " + matrix.getN());
                    break;
                case "3":
                    matrix.showMatrix(matrix.getMat());
                    break;
                case "4":
                    matrix2.setM(rows);
                    matrix2.setN(cols);
                    matrix2.createMatrix();
                    matrix.sumMatrix(matrix.getMat(), matrix2.getMat());
                    matrix.showMatrix(matrix.getMat());
                    System.out.println();
                    matrix2.showMatrix(matrix2.getMat());
                    System.out.println();
                    matrix.showMatrix(matrix.getMatSum());
                    break;
                case "5":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.mainDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "6":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.secondaryDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "7":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.upTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "8":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.leftTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "9":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.rightTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "10":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangular();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "11":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangularSecondary();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "12":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.maxRow();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                case "13":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.averageColumn();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuRecords()
    {
        String name, resp;
        byte age;
        Persons per = new Persons();
        
        do {
            System.out.println("\n-------Menú Registros------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Persona joven");
            System.out.println("5. Porcentaje mayores");
            // System.out.println("5. Promedio datos");
            // System.out.println("6. Mayor dato");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nombre: ");
                    name = input.nextLine();
                    System.out.print("Edad: ");
                    age = input.nextByte();
                    input.nextLine();
                    if (per.getN() < per.getT()) {
                        per.createPerson(name, age);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + per.getN());
                    break;
                case "3":
                    per.showPerson();
                    break;
                case "4":
                    if (per.getN() > 0) {
                        per.youngPerson();
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                case "5":
                    if (per.getN() > 0) {
                        System.out.println("Porcentaje mayores de edad: " + per.percentageMax18());
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                
                // case "9":
                //     if (v.getN() > 0) {
                //         System.out.println("Suma datos vector: " + v.sumVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "10":
                //     if (v.getN() > 0) {
                //         System.out.println("Promedio datos vector: " + v.avgVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "11":
                //     if (v.getN() > 0) {
                //         System.out.println("Mayor dato vector: " + v.maxVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuLSL()
    {
        int datum;
        String resp;
        LSL list = new LSL();
        Node r;
        do {
            System.out.println("\n-------Menú LSL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma");
            System.out.println("5. Promedio");
            System.out.println("6. Buscar");
            System.out.println("7. Modificar");
            System.out.println("8. Eliminar");
            System.out.println("9. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    list.createBeginLSL(datum);
                    System.out.println("Dato agregado en la LSL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                    break;
                case "3":
                    list.showLSL();
                    break;
                case "4":
                    System.out.println("Suma lista: " + list.sumNodesLSL());
                    break;
                case "5":
                    if (list.head != null) {
                        System.out.println(
                            "Promedio lista: " + 
                            list.sumNodesLSL() / list.countNodesLSL()
                        );
                    } else {
                        System.out.println("Lista vacía");
                    }
                    break;
                case "6":
                    if (list.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + r);
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "7":
                    if (list.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.updateNode(r, datum);
                            System.out.println("Se actualizó el dato correctamente");
                            
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "8":
                    if (list.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        list.deleteNodeLSL(datum);
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "9":
                    if (list.head != null) {
                        System.out.print("Dato de referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        Node dirRef = list.findReferenceLSL(datum);
                        if (dirRef != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.insertBeforeLSL(dirRef, datum);
                            System.out.println(datum + " se insertó correctamente");
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLSLC()
    {
        int datum;
        String resp;
        LSLC list = new LSLC();
        Node r;
        do {
            System.out.println("\n-------Menú LSLC------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    
                    list.createEndLSLC(datum);
                    System.out.println("Dato agregado en la LSLC");
                    break;
                // case "2":
                //     System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                //     break;
                case "3":
                    list.showLSLC();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLDL()
    {
        int datum;
        String resp;
        LDL ldl = new LDL();
        NodeLDL dir;
        do {
            System.out.println("\n-------Menú LDL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (después de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    ldl.createBeginLDL(datum);
                    System.out.println("Dato agregado en la LDL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + ldl.getN() + " nodos");
                    break;
                case "3":
                    ldl.showLDL();
                    break;
                case "4":
                    if (ldl.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir == null) {
                            System.out.println(datum + " no se encuentra en la LDL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + dir);
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "5":
                    if (ldl.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.updateNodeLDL(dir, datum);
                            System.out.println("Dato actualizado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "6":
                    if (ldl.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            ldl.deleteNodeLDL(dir);
                            System.out.println("Dato eliminado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "7":
                    if (ldl.head != null) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.insertAfterLDL(dir, datum);
                            System.out.println("Dato insertado correctamente");
                        } else {
                            System.out.println("El dato de referencia " + datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuStacks()
    {
        int datum;
        String resp;
        Stack objStack = new Stack();
        do {
            System.out.println("\n-------Menú Pilas------");
            System.out.println("0. Regresar");
            System.out.println("1. Apilar");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Desapilar");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato a apilar: ");
                    datum = input.nextInt();
                    input.nextLine();
                    objStack.stacking(datum);
                    System.out.println("Dato almacenado en la Pila");
                    break;
                case "2":
                    System.out.println("Tamaño pila: " + objStack.getTop());
                    break;
                case "3":
                    if (objStack.getTop() > 0) {
                        objStack.showStack();
                    } else {
                        System.out.println("No ha creado la Pila");
                    }
                    break;
                case "4":
                    if (objStack.getTop() > 0) {
                        System.out.println(objStack.unStacking() + " se desapiló correctamente");
                    } else {
                        System.out.println("No ha creado la Pila");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
        public static void menuPolynomial()
    {
        String resp, optionPolynomial;
        int coefficient, exponent, quantity, i;
        double a;

        PolynomialLSL f = new PolynomialLSL();
        PolynomialLSL g = new PolynomialLSL();
        PolynomialLSL polynomial = null;
        PolynomialLSL result;
        NodePolynomial dir;

        do {
            System.out.println("\n-------Menú Polinomios con LSL------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear f(x)");
            System.out.println("2. Crear g(x)");
            System.out.println("3. Mostrar f(x) y g(x)");
            System.out.println("4. Ordenar polinomio de mayor a menor exponente");
            System.out.println("5. Modificar coeficiente de un término");
            System.out.println("6. Eliminar término");
            System.out.println("7. Agregar término");
            System.out.println("8. Sumar f(x) + g(x)");
            System.out.println("9. Restar f(x) - g(x)");
            System.out.println("10. Calcular f(a) y g(a)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;

                case "1":
                case "2":
                    if (resp.equals("1")) {
                        polynomial = f;
                        System.out.println("Crear f(x)");
                    } else {
                        polynomial = g;
                        System.out.println("Crear g(x)");
                    }

                    polynomial.clearPolynomial();

                    System.out.print("Cantidad de términos: ");
                    quantity = input.nextInt();
                    input.nextLine();

                    if (quantity > 0) {
                        for (i = 1; i <= quantity; i++) {
                            System.out.println("Término " + i);

                            System.out.print("Coeficiente: ");
                            coefficient = input.nextInt();
                            input.nextLine();

                            System.out.print("Exponente: ");
                            exponent = input.nextInt();
                            input.nextLine();

                            if (coefficient != 0 && exponent >= 0) {
                                if (polynomial.addTerm(coefficient, exponent)) {
                                    System.out.println("Término agregado correctamente");
                                } else {
                                    System.out.println("El exponente ya existe en el polinomio");
                                    i--;
                                }
                            } else {
                                System.out.println("El coeficiente no puede ser 0 y el exponente no puede ser negativo");
                                i--;
                            }
                        }
                    } else {
                        System.out.println("La cantidad de términos debe ser mayor que cero");
                    }

                    break;

                case "3":
                    f.showPolynomial("f");
                    g.showPolynomial("g");
                    break;

                case "4":
                    System.out.print("Polinomio a ordenar (1. f(x), 2. g(x)): ");
                    optionPolynomial = input.nextLine();

                    if (optionPolynomial.equals("1")) {
                        polynomial = f;
                    } else if (optionPolynomial.equals("2")) {
                        polynomial = g;
                    } else {
                        polynomial = null;
                    }

                    if (polynomial != null) {
                        if (polynomial.getHead() != null) {
                            polynomial.sortDesc();
                            System.out.println("Polinomio ordenado correctamente");
                            polynomial.showPolynomial("Resultado");
                        } else {
                            System.out.println("No ha creado el polinomio");
                        }
                    } else {
                        System.out.println("Opción de polinomio no válida");
                    }

                    break;

                case "5":
                    System.out.print("Polinomio a modificar (1. f(x), 2. g(x)): ");
                    optionPolynomial = input.nextLine();

                    if (optionPolynomial.equals("1")) {
                        polynomial = f;
                    } else if (optionPolynomial.equals("2")) {
                        polynomial = g;
                    } else {
                        polynomial = null;
                    }

                    if (polynomial != null) {
                        if (polynomial.getHead() != null) {
                            System.out.print("Exponente del término a modificar: ");
                            exponent = input.nextInt();
                            input.nextLine();

                            dir = polynomial.findTerm(exponent);

                            if (dir != null) {
                                System.out.print("Nuevo coeficiente: ");
                                coefficient = input.nextInt();
                                input.nextLine();

                                if (coefficient != 0) {
                                    polynomial.updateCoefficient(dir, coefficient);
                                    System.out.println("Coeficiente actualizado correctamente");
                                } else {
                                    System.out.println("El coeficiente no puede ser 0");
                                }
                            } else {
                                System.out.println("El exponente no se encuentra en el polinomio");
                            }
                        } else {
                            System.out.println("No ha creado el polinomio");
                        }
                    } else {
                        System.out.println("Opción de polinomio no válida");
                    }

                    break;

                case "6":
                    System.out.print("Polinomio donde desea eliminar (1. f(x), 2. g(x)): ");
                    optionPolynomial = input.nextLine();

                    if (optionPolynomial.equals("1")) {
                        polynomial = f;
                    } else if (optionPolynomial.equals("2")) {
                        polynomial = g;
                    } else {
                        polynomial = null;
                    }

                    if (polynomial != null) {
                        if (polynomial.getHead() != null) {
                            System.out.print("Exponente del término a eliminar: ");
                            exponent = input.nextInt();
                            input.nextLine();

                            if (polynomial.deleteTerm(exponent)) {
                                System.out.println("Término eliminado correctamente");
                            } else {
                                System.out.println("El exponente no se encuentra en el polinomio");
                            }
                        } else {
                            System.out.println("No ha creado el polinomio");
                        }
                    } else {
                        System.out.println("Opción de polinomio no válida");
                    }

                    break;

                case "7":
                    System.out.print("Polinomio donde desea agregar (1. f(x), 2. g(x)): ");
                    optionPolynomial = input.nextLine();

                    if (optionPolynomial.equals("1")) {
                        polynomial = f;
                    } else if (optionPolynomial.equals("2")) {
                        polynomial = g;
                    } else {
                        polynomial = null;
                    }

                    if (polynomial != null) {
                        System.out.print("Coeficiente: ");
                        coefficient = input.nextInt();
                        input.nextLine();

                        System.out.print("Exponente: ");
                        exponent = input.nextInt();
                        input.nextLine();

                        if (coefficient != 0 && exponent >= 0) {
                            if (polynomial.addTerm(coefficient, exponent)) {
                                System.out.println("Término agregado correctamente");
                            } else {
                                System.out.println("El exponente ya existe en el polinomio");
                            }
                        } else {
                            System.out.println("El coeficiente no puede ser 0 y el exponente no puede ser negativo");
                        }
                    } else {
                        System.out.println("Opción de polinomio no válida");
                    }

                    break;

                case "8":
                    if (f.getHead() != null && g.getHead() != null) {
                        result = f.sumPolynomial(g);
                        result.showPolynomial("f + g");
                    } else {
                        System.out.println("Debe crear ambos polinomios");
                    }

                    break;

                case "9":
                    if (f.getHead() != null && g.getHead() != null) {
                        result = f.subtractPolynomial(g);
                        result.showPolynomial("f - g");
                    } else {
                        System.out.println("Debe crear ambos polinomios");
                    }

                    break;

                case "10":
                    if (f.getHead() != null && g.getHead() != null) {
                        System.out.print("Valor de a: ");
                        a = input.nextDouble();
                        input.nextLine();

                        System.out.println("f(" + a + ") = " + f.evaluatePolynomial(a));
                        System.out.println("g(" + a + ") = " + g.evaluatePolynomial(a));
                    } else {
                        System.out.println("Debe crear ambos polinomios");
                    }

                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!resp.equals("0"));
    }

    public static void menuTriqui()
    {
        String resp, nameOne, nameTwo;
        char symbolOne, symbolTwo;
        int row, col, player;

        Triqui triqui = new Triqui();
        TriquiMethods objTriqui = new TriquiMethods(triqui);

        do {
            System.out.println("\n-------Menú Triqui------");
            System.out.println("0. Regresar");
            System.out.println("1. Ingresar usuarios");
            System.out.println("2. Sorteo de inicio");
            System.out.println("3. Realizar jugada");
            System.out.println("4. Modificar nombre de jugador");
            System.out.println("5. Modificar símbolo de jugador");
            System.out.println("6. Mostrar estado del juego");
            System.out.println("7. Pausar partida");
            System.out.println("8. Continuar partida");
            System.out.println("9. Cancelar partida");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;

                case "1":
                    System.out.print("Nombre jugador 1: ");
                    nameOne = input.nextLine();

                    System.out.print("Símbolo jugador 1: ");
                    symbolOne = input.next().charAt(0);
                    input.nextLine();

                    System.out.print("Nombre jugador 2: ");
                    nameTwo = input.nextLine();

                    System.out.print("Símbolo jugador 2: ");
                    symbolTwo = input.next().charAt(0);
                    input.nextLine();

                    if (nameOne.length() > 0 && nameTwo.length() > 0) {
                        if (symbolOne != symbolTwo) {
                            objTriqui.createUsers(nameOne, symbolOne, nameTwo, symbolTwo);
                            System.out.println("Usuarios ingresados correctamente");
                            System.out.println("La partida anterior, si existía, fue anulada");
                        } else {
                            System.out.println("Los jugadores no pueden tener el mismo símbolo");
                        }
                    } else {
                        System.out.println("Los nombres no pueden estar vacíos");
                    }

                    break;

                case "2":
                    if (triqui.getUsersCreated()) {
                        objTriqui.drawStart();

                        System.out.println("Comienza: " + objTriqui.currentPlayerName() + " con el símbolo " + objTriqui.currentPlayerSymbol());

                        objTriqui.showBoard();
                    } else {
                        System.out.println("Debe ingresar los usuarios antes de iniciar");
                    }

                    break;

                case "3":
                    if (triqui.getUsersCreated()) {
                        if (triqui.getGameStarted()) {
                            if (!triqui.getGamePaused()) {
                                objTriqui.showInformation();

                                System.out.print("Fila de la jugada: ");
                                row = input.nextInt();
                                input.nextLine();

                                System.out.print("Columna de la jugada: ");
                                col = input.nextInt();
                                input.nextLine();

                                if (objTriqui.validPosition(row, col)) {
                                    if (objTriqui.emptyPosition(row, col)) {
                                        objTriqui.playTurn(row, col);
                                        objTriqui.showBoard();

                                        if (objTriqui.winner()) {
                                            objTriqui.finishGame();

                                            System.out.println();
                                            objTriqui.showBigTriqui(objTriqui.currentPlayerSymbol());

                                            System.out.println("Felicitaciones " + objTriqui.currentPlayerName() + ", ganaste la partida");
                                        } else {
                                            if (objTriqui.fullBoard()) {
                                                objTriqui.finishGame();
                                                System.out.println("La partida terminó en empate");
                                            } else {
                                                objTriqui.changeTurn();
                                            }
                                        }
                                    } else {
                                        System.out.println("La casilla ya está ocupada");
                                    }
                                } else {
                                    System.out.println("La fila y la columna deben estar entre 1 y 3");
                                }
                            } else {
                                System.out.println("La partida está pausada");
                            }
                        } else {
                            System.out.println("Debe realizar el sorteo de inicio");
                        }
                    } else {
                        System.out.println("Debe ingresar los usuarios");
                    }

                    break;

                case "4":
                    if (triqui.getUsersCreated()) {
                        System.out.print("Jugador a modificar (1 o 2): ");
                        player = input.nextInt();
                        input.nextLine();

                        if (player == 1 || player == 2) {
                            System.out.print("Nuevo nombre: ");
                            nameOne = input.nextLine();

                            if (nameOne.length() > 0) {
                                objTriqui.updateName(player, nameOne);
                                System.out.println("Nombre actualizado correctamente");
                            } else {
                                System.out.println("El nombre no puede estar vacío");
                            }
                        } else {
                            System.out.println("Jugador no válido");
                        }
                    } else {
                        System.out.println("Debe ingresar los usuarios");
                    }

                    break;

                case "5":
                    if (triqui.getUsersCreated()) {
                        System.out.print("Jugador a modificar (1 o 2): ");
                        player = input.nextInt();
                        input.nextLine();

                        if (player == 1 || player == 2) {
                            System.out.print("Nuevo símbolo: ");
                            symbolOne = input.next().charAt(0);
                            input.nextLine();

                            if (objTriqui.updateSymbol(player, symbolOne)) {
                                System.out.println("Símbolo actualizado correctamente");
                            } else {
                                System.out.println("El símbolo ya está siendo usado por el otro jugador");
                            }
                        } else {
                            System.out.println("Jugador no válido");
                        }
                    } else {
                        System.out.println("Debe ingresar los usuarios");
                    }

                    break;

                case "6":
                    if (triqui.getUsersCreated()) {
                        objTriqui.showInformation();
                        objTriqui.showBoard();
                    } else {
                        System.out.println("Debe ingresar los usuarios");
                    }

                    break;

                case "7":
                    if (triqui.getGameStarted() && !triqui.getGamePaused()) {
                        objTriqui.pauseGame();
                        System.out.println("Partida pausada correctamente");
                    } else {
                        System.out.println("No hay una partida activa para pausar");
                    }

                    break;

                case "8":
                    if (triqui.getGameStarted() && triqui.getGamePaused()) {
                        objTriqui.continueGame();
                        System.out.println("Partida continuada correctamente");
                    } else {
                        System.out.println("No hay una partida pausada");
                    }

                    break;

                case "9":
                    if (triqui.getGameStarted()) {
                        objTriqui.cancelGame();
                        System.out.println("Partida cancelada correctamente");
                    } else {
                        System.out.println("No hay una partida activa para cancelar");
                    }

                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!resp.equals("0"));
    }

}

