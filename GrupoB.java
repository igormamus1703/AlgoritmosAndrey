public class GrupoB {
    // Merge Sort
    public static void mergeSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        mergeSort(vetor, new int[vetor.length], 0, vetor.length - 1);
        
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
    public static void quickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p + 1, direita);
        }

     
    }

    private static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = (esquerda - 1);
        int j= (direita + 1);
        while (true) {
            do {
                i++;
                Main.iterationCount++;
            } while (vetor[i] < pivot);
            do {
                j--;
                Main.iterationCount++;
            } while (vetor[j] > pivot);
            if (i >= j) {
                return j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
            Main.swapCount++;
        }
    }

    // Shell Sort
    public static void shellSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int h = 1;
        int n = vetor.length;
        while (h < n ) {
            h = h * 3 +1; 
        }
        h = (int) Math.floor(h/3);

        int elemento,j;
        while(h > 0 ){
            for(int i = h; i < n; i++){
                elemento = vetor[i];
                j = i;
                Main.iterationCount++;
                while(j >= h && vetor[j-h] > elemento){
                    vetor[j] = vetor[j-h];
                    j = j - h;
                    Main.swapCount++;
                }
                vetor[j] = elemento;
            }
            h = h/2;
        }
    }
}