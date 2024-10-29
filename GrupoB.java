public class GrupoB {
    // Merge Sort
    public static void mergeSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        mergeSort(vetor, new int[vetor.length], 0, vetor.length - 1);
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    private static void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {
        if (inicio >= fim) return;
        
        int meio = (inicio + fim) / 2;
        mergeSort(vetor, auxiliar, inicio, meio);
        mergeSort(vetor, auxiliar, meio + 1, fim);
        merge(vetor, auxiliar, inicio, fim);
    }

    private static void merge(int[] vetor, int[] auxiliar, int inicio, int fim) {
        for(int i = inicio; i <= fim; i++) {
            auxiliar[i] = vetor[i];
        }

        int meio = (inicio + fim) / 2;
        int esquerda = inicio;
        int direita = meio + 1;
        
      

        for(int i = inicio; i <= fim; i++) {
            Main.iterationCount++;
           if(esquerda > meio){
            vetor[i] = auxiliar[direita];
            direita++;
           }else if(direita > fim){
            vetor[i] = auxiliar[esquerda];
            esquerda++;
           }else if(auxiliar[esquerda] < auxiliar[direita]){
            vetor[i] = auxiliar[esquerda];
            esquerda++;
           }else{
            vetor[i] = auxiliar[direita];
            direita++;
           }
        }
       
    }

    // Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            Main.iterationCount++;
            if (array[j] < pivot) {
                i++;
                Main.swapCount++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Main.swapCount++;
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Shell Sort
    public static void shellSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                    Main.iterationCount++;
                    Main.swapCount++;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }
}