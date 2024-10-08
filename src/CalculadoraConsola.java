


/*Autor Del Codigo Pablo Andres Ovalle Cardozo - Codigo 70040245*/



import java.util.Scanner;

public class CalculadoraConsola {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Seno");
            System.out.println("6. Coseno");
            System.out.println("7. Tangente");
            System.out.println("8. Raíz enésima");
            System.out.println("9. Potencia enésima");
            System.out.println("10. Calcular IVA");
            System.out.println("11. Salir");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese dos números:");
                    double num1 = scanner.nextDouble();
                    double num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                    
                case 2:
                    System.out.println("Ingrese dos números:");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                    
                case 3:
                    System.out.println("Ingrese dos números:");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                    
                case 4:
                    System.out.println("Ingrese dos números:");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: División por cero.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese un ángulo en radianes:");
                    double angulo = scanner.nextDouble();
                    System.out.println("Resultado: " + Math.sin(angulo));
                    break;
                    
                case 6:
                    System.out.println("Ingrese un ángulo en radianes:");
                    angulo = scanner.nextDouble();
                    System.out.println("Resultado: " + Math.cos(angulo));
                    break;
                    
                case 7:
                    System.out.println("Ingrese un ángulo en radianes:");
                    angulo = scanner.nextDouble();
                    System.out.println("Resultado: " + Math.tan(angulo));
                    break;

                    case 8:
                    System.out.println("Ingrese un número y el valor de la raíz:");
                    num1 = scanner.nextDouble();
                    int raiz = scanner.nextInt();
                    System.out.println("Resultado: " + Math.pow(num1, 1.0 / raiz));
                    break;
                    
                case 9:
                    System.out.println("Ingrese un número y el valor de la potencia:");
                    num1 = scanner.nextDouble();
                    int potencia = scanner.nextInt();
                    System.out.println("Resultado: " + Math.pow(num1, potencia));
                    break;

                    case 10:
                    System.out.println("Ingrese el monto y el porcentaje de IVA:");
                    num1 = scanner.nextDouble();
                    double iva = scanner.nextDouble();
                    System.out.println("Resultado: " + (num1 + (num1 * iva / 100)));
                    break;
                    
                case 11:
                    System.out.println("Saliendo de la calculadora...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
            
            System.out.println();
            
        } while (opcion != 11);
        
        scanner.close();
    }
}
