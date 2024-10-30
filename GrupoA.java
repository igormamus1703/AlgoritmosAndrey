import java.util.Random;

public class GrupoA {
    public static void insertionSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int aux, j;
        for (int i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            j = i - 1;
            while (j >= 0 && vetor[j] > aux) {
                Main.iterationCount++;
                vetor[j + 1] = vetor[j];
                j--;
                Main.swapCount++;
            }
            vetor[j + 1] = aux;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < vetor.length; j++) {
                Main.iterationCount++;
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Main.swapCount++;
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
            }
        }
    }

    
    // Função Bogo Sort
       public static void bogoSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        
        // Continua até o array estar ordenado
        while (!isSorted( vetor)) {
            shuffle(vetor);
            Main.iterationCount++;  // Contagem de iterações a cada embaralhamento
        }
    }

    // Verifica se o array está ordenado
    private static boolean isSorted(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Embaralha o array aleatoriamente
    private static void shuffle(int[] vetor) {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            int randomIndex = random.nextInt(vetor.length);
            int temp = vetor[i];
            vetor[i] = vetor[randomIndex];
            vetor[randomIndex] = temp;
            Main.swapCount++;  // Contagem de trocas
        }
    }
}

