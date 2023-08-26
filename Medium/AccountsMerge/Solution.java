class Solution {

    // Disjoin Sets class. To find and unify accounts
    class DS {
        private int[] vertices;
        private int[] weights;

        public DS(int size) {
            vertices = new int[size];
            weights = new int[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = i;
                weights[i] = 1;
            }
        }

        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            if (weights[parentA] >= weights[parentB]) {
                vertices[parentB] = parentA;
                weights[parentA] += weights[parentB];
            } else {
                vertices[parentA] = parentB;
                weights[parentB] += weights[parentA];
            }
        }

        public int find(int a) {
            if (vertices[a] == a) {
                return a;
            }
            return find(vertices[a]);
        }
    }

    // Time Complexity O(n * m) where m is the size of the longest account in
    // accounts.
    // Space Complexity O(n)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        DS ds = new DS(size);

        // Use a hashmap to save email to account id but most importantly to unify
        // or merge when an email is in 2 different accounts
        Map<String, Integer> emailsToId = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailsToId.containsKey(email)) {
                    emailsToId.put(email, i);
                } else {
                    ds.union(emailsToId.get(email), i);
                }
            }
        }

        // Connect account id to list of emails using the parent from disjoint sets
        // if we had any emails that appeared in two accounts they were merged previouly
        // so here we find the parent of that emailId (already merged), and use that one
        // to unify all emails into lists
        Map<Integer, List<String>> accountToEmails = new HashMap<>();
        for (String email : emailsToId.keySet()) {
            int accountId = ds.find(emailsToId.get(email));

            if (!accountToEmails.containsKey(accountId)) {
                accountToEmails.put(accountId, new ArrayList<>());
            }
            accountToEmails.get(accountId).add(email);
        }

        // Simply sort list of emails, add account name, and add to result.
        List<List<String>> res = new ArrayList<>();
        for (Integer key : accountToEmails.keySet()) {
            List<String> arr = accountToEmails.get(key);
            Collections.sort(arr);
            arr.add(0, accounts.get(key).get(0));
            res.add(arr);
        }
        return res;
    }
}