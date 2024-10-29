import java.util.Random;

public class GrupoA {
    public static void insertionSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                Main.iterationCount++;
                array[j + 1] = array[j];
                Main.swapCount++;
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                Main.iterationCount++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Main.swapCount++;
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    
    // Função Bogo Sort
       public static void bogoSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        
        // Continua até o array estar ordenado
        while (!isSorted(array)) {
            shuffle(array);
            Main.iterationCount++;  // Contagem de iterações a cada embaralhamento
        }
    }

    // Verifica se o array está ordenado
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Embaralha o array aleatoriamente
    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
            Main.swapCount++;  // Contagem de trocas
        }
    }
}

