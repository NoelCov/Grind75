class TimeMap {
    Map<String, TreeMap<Integer, String>> storage;

    public TimeMap() {
        storage = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (storage.containsKey(key)) {
            storage.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> newMap = new TreeMap<>();
            newMap.put(timestamp, value);
            storage.put(key, newMap);    
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> obj = storage.get(key);
        if (obj == null) {
            return "";
        }
        if (obj.containsKey(timestamp)) {
            return obj.get(timestamp);
        } else {
            int res = getLargestTimestamp(obj, timestamp);
            return res == -1 ? "" : obj.get(res);
        }
    }

    private int getLargestTimestamp(TreeMap<Integer, String> map, int timestamp) {
        try {
            return map.floorKey(timestamp);
        } catch (Exception e) {
            return -1;
        }
    }
}