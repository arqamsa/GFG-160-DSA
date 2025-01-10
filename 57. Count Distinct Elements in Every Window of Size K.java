import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        // First window of size k
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            int outgoingElement = arr[i - k];
            int incomingElement = arr[i];

            // Remove the outgoing element
            freqMap.put(outgoingElement, freqMap.get(outgoingElement) - 1);
            if (freqMap.get(outgoingElement) == 0) {
                freqMap.remove(outgoingElement);
            }

            // Add the incoming element
            freqMap.put(incomingElement, freqMap.getOrDefault(incomingElement, 0) + 1);
            
            // Add the count of distinct elements in the current window
            result.add(freqMap.size());
        }

        return result;
    }
}
