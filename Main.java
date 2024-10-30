import java.util.Random;

public class Main {

    // Variáveis globais para contagem de trocas e iterações
    public static long swapCount = 0;
    public static long iterationCount = 0;

    // Função para gerar vetores de inteiros aleatórios com uma seed
    public static int[] geradorAleatorio(int tamanho, long seed) {
        Random random = new Random(seed);
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
           vetor[i] = random.nextInt(tamanho);
        }
        return vetor;
    }

    // Função para medir o tempo de execução de um algoritmo de ordenação
    public static long measureTime(Runnable metodoSort) {
        long startTime = System.nanoTime();
        metodoSort.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] tamanhos = {10};
        int runs = 5;
        long seed = 12345;

        for (int tamanho : tamanhos) {
            System.out.println("\nTamanho do vetor: " + tamanho);

            for (int i = 0; i < runs; i++) {
                System.out.println("\nRodada: " + (i + 1));
                int[] vetor = geradorAleatorio(tamanho, seed);

                // Resetando contadores para cada execução de algoritmo
                swapCount = 0;
                iterationCount = 0;

                // Testes para os algoritmos do Grupo A
                long timeInsertionSort = measureTime(() -> GrupoA.insertionSort(vetor.clone()));
                System.out.println("Insertion Sort - Tempo: " + timeInsertionSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeSelectionSort = measureTime(() -> GrupoA.selectionSort(vetor.clone()));
                System.out.println("Selection Sort - Tempo: " + timeSelectionSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeCombSort = measureTime(() -> GrupoA.bogoSort(vetor.clone()));
                System.out.println("Comb Sort - Tempo: " + timeCombSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                // Testes para os algoritmos do Grupo B
                
                long timeMergeSort = measureTime(() -> GrupoB.mergeSort(vetor.clone()));
                System.out.println("Merge Sort - Tempo: " + timeMergeSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeQuickSort = measureTime(() -> GrupoB.quickSort(vetor.clone(), 0, vetor.clone().length - 1));
                System.out.println("Quick Sort - Tempo: " + timeQuickSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeShellSort = measureTime(() -> GrupoB.shellSort(vetor.clone()));
                System.out.println("Shell Sort - Tempo: " + timeShellSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                // Testes para os algoritmos do Grupo C
                
                long timeRadixSort = measureTime(() -> GrupoC.radixSort(vetor.clone()));
                System.out.println("Radix Sort - Tempo: " + timeRadixSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeGnomeSort = measureTime(() -> GrupoC.gnomeSort(vetor.clone()));
                System.out.println("Gnome Sort - Tempo: " + timeGnomeSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);

                
                long timeCountingSort = measureTime(() -> GrupoC.countingSort(vetor.clone()));
                System.out.println("Counting Sort - Tempo: " + timeCountingSort + " ns, Trocas: " + swapCount + ", Iterações: " + iterationCount);
            }
        }
    }
}
