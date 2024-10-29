public class GrupoC {
    // Radix Sort
    public static void radixSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];
        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

    // Gnome Sort
    public static void gnomeSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int index = 0;
        while (index < array.length) {
            if (index == 0 || array[index] >= array[index - 1]) {
                index++;
            } else {
                Main.swapCount++;
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
            Main.iterationCount++;
        }
    }

    // Counting Sort
    public static void countingSort(int[] array) {
        Main.swapCount = 0;
        Main.iterationCount = 0;
        int max = getMax(array);
        int[] count = new int[max + 1];
        for (int num : array) {
            count[num]++;
            Main.iterationCount++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
                Main.swapCount++;
            }
        }
    }
}
