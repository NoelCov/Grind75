class Solution {
    // Time Complexity O(n * m) where n is the numCourses and m the size of the list
    // of n *if it exists*.
    // Space Complexity O(n) where n is the number of unique courses in
    // prerequisites.
    public Map<Integer, List<Integer>> map = new HashMap<>();
    public Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // We add all courses and their prerequisites to a map.
        for (int[] prereq : prerequisites) {
            if (!map.containsKey(prereq[0])) {
                map.put(prereq[0], new ArrayList<>());
            }
            map.get(prereq[0]).add(prereq[1]);
        }

        // Traverse through the courses to find out if they can be taken
        for (int i = 0; i < numCourses; i++) {
            if (map.containsKey(i)) {
                if (!dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS that goes through all the prerequisites of a couse and finds out if the
    // course can be taken
    // if so we remove it from the map so that we don't have to do repeated work in
    // the future.
    public boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);

        if (map.containsKey(course)) {
            for (int prereq : map.get(course)) {
                if (!dfs(prereq)) {
                    return false;
                }
            }
            map.remove(course);
        }
        visited.remove(course);
        return true;
    }
}