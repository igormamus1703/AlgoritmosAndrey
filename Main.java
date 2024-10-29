import java.util.Random;

public class Main {

    // Variáveis globais para contagem de trocas e iterações
    public static long swapCount = 0;
    public static long iterationCount = 0;

    // Função para gerar vetores de inteiros aleatórios com uma seed
    public static int[] generateRandomArray(int size, long seed) {
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Função para medir o tempo de execução de um algoritmo de ordenação
    public static long measureTime(Runnable sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = {10};
        int runs = 5;
        long seed = 12345;

        for (int size : sizes) {
            System.out.println("\nTamanho do vetor: " + size);

            for (int i = 0; i < runs; i++) {
                System.out.println("\nRodada: " + (i + 1));
                int[] baseArray = generateRandomArray(size, seed);

                // Resetando contadores para cada execução de algoritmo
                swapCount = 0;
                iterationCount = 0;

                // Testes para os algoritmos do Grupo A
                long timeInsertionSort = measureTime(() -> GrupoA.insertionSort(baseArray.clone()));
                System.out.println("Insertion Sort - Tempo: " + timeInsertionSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeSelectionSort = measureTime(() -> GrupoA.selectionSort(baseArray.clone()));
                System.out.println("Selection Sort - Tempo: " + timeSelectionSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeCombSort = measureTime(() -> GrupoA.bogoSort(baseArray.clone()));
                System.out.println("Comb Sort - Tempo: " + timeCombSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                // Testes para os algoritmos do Grupo B
                
                long timeMergeSort = measureTime(() -> GrupoB.mergeSort(baseArray.clone()));
                System.out.println("Merge Sort - Tempo: " + timeMergeSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeQuickSort = measureTime(() -> GrupoB.quickSort(baseArray.clone(), 0, baseArray.clone().length - 1));
                System.out.println("Quick Sort - Tempo: " + timeQuickSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeShellSort = measureTime(() -> GrupoB.shellSort(baseArray.clone()));
                System.out.println("Shell Sort - Tempo: " + timeShellSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                // Testes para os algoritmos do Grupo C
                
                long timeRadixSort = measureTime(() -> GrupoC.radixSort(baseArray.clone()));
                System.out.println("Radix Sort - Tempo: " + timeRadixSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeGnomeSort = measureTime(() -> GrupoC.gnomeSort(baseArray.clone()));
                System.out.println("Gnome Sort - Tempo: " + timeGnomeSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeCountingSort = measureTime(() -> GrupoC.countingSort(baseArray.clone()));
                System.out.println("Counting Sort - Tempo: " + timeCountingSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);
            }
        }
    }
}
