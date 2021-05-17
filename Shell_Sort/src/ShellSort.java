import java.util.Scanner;

class ShellSort {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        int opc,len = 0;
        int [] arr = new int[20];
        ShellSort ob = new ShellSort();
        do{
            opc = menu();
            switch (opc){
                case 1:
                    len = valores(arr);
                    printArray(arr,len);
                    break;
                case 2:
                    ob.sort(arr,len);
                    printArray(arr,len);
                    break;
                case 3:
                    System.out.println("Saliendo del programa... ");
                    break;
                default:
                    System.out.println("Error, Opcion no encontrada");
                    break;
            }
        }while (opc != 3);
    }

    public static int valores(int[] arr) {
        int len = 0;
        System.out.print("\nCantidad de valores a ingresar (<20): ");//Se ingresa la cantidad de valores a capturar
        len = sc.nextInt();

        for(int j = 0; j<len; j++){
            System.out.print("\nIngresa un valor: ");
            arr[j] = sc.nextInt();
        }
        return len;
    }


    public static int menu(){
        System.out.println("\tMenu");
        System.out.println("1) Ingresa valores");
        System.out.println("2) Ordena los valores");
        System.out.println("3) Salir");
        System.out.print("Ingresa una opcion: ");
        return sc.nextInt();
    }

    static void printArray(int[] arr, int n){
        System.out.println();
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("\n");
    }

    // Funcion ShellSort
    void sort(int[] arr,int n) {
        // Se crea un intervalo para comparar partes del array
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){//se guarda en una var temp el valor del a[i]
                int temp = arr[i];           //y se realiza la busqueda de su lugar

                // Se intercambias las locaciones hasta que a[i]
                // este en el lugar correcto
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp; //Se pone al elemento a[i] en su lugar correcto
            }
        }
    }


}