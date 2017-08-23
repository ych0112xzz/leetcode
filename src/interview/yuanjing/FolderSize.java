package interview.yuanjing;


/*
Question 1
 */
public class FolderSize {
    public static void main(String[] args) {
        String[] files = {"0 55",  "1 21","2 50","2 43","0 47", "1 22"};
        int count = 3;
        int size = 46;
        int[] res = calculateWaste(files, count, size);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] calculateWaste(String[] files, int folderCount, int clusterSize) {
        int[] result = new int[folderCount];
        if (files == null||clusterSize==0) {
            return result;
        }
        for (int i = 0; i < files.length; i++) {
            String[] data = files[i].split(" ");
            int index = Integer.parseInt(data[0]);
            int value = Integer.parseInt(data[1]);
            int diff = value - value / clusterSize * clusterSize;
            int cur = diff == 0 ? diff : (clusterSize - diff);
            result[index] += cur;
        }
        return result;
    }
}
