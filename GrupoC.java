public class GrupoC {
    // Radix Sort
    public static void radixSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int max = getMax(vetor);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(vetor, exp);
        }
    }

   

    private static void countingSort(int[] vetor, int exp) {
        int[] output = new int[vetor.length];
        int[] count = new int[10];
        for (int i = 0; i < vetor.length; i++) {
            count[(vetor[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[(vetor[i] / exp) % 10] - 1] = vetor[i];
            count[(vetor[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, vetor, 0, vetor.length);
    }

    // Gnome Sort
    public static void gnomeSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int index = 0;
        while (index < vetor.length) {
            if (index == 0 || vetor[index] >= vetor[index - 1]) {
                index++;
            } else {
                Main.swapCount++;
                int temp = vetor[index];
                vetor[index] = vetor[index - 1];
                vetor[index - 1] = temp;
                index--;
            }
            Main.iterationCount++;
        }
    }

    // Counting Sort
    public static void countingSort(int[] vetor) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int max = getMax(vetor);
        int[] count = new int[max + 1];
        for (int num : vetor) {
            count[num]++;
            Main.iterationCount++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                vetor[index++] = i;
                count[i]--;
                Main.swapCount++;
            }
        }
    }

    private static int getMax(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        return max;
    }
}
