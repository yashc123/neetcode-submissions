class TimeMap {

    Map<String, List<String>> timeMap;
    Map<String, List<Integer>> numberMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        numberMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>(List.of(value)));
            numberMap.put(key, new ArrayList<>(List.of(timestamp)));
        } else {
            timeMap.get(key).add(value);
            numberMap.get(key).add(timestamp);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        int length = numberMap.get(key).size();

        if (numberMap.get(key).get(0) > timestamp) {
            return "";
        }

        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (numberMap.get(key).get(mid) == timestamp) {
                return timeMap.get(key).get(mid);
            } else if (numberMap.get(key).get(mid) < timestamp) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return timeMap.get(key).get(end);
    }
}