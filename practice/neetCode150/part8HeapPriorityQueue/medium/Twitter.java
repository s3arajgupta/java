// class Twitter {
//     int count;
//     HashMap<Integer, List<int[]>> tweetMap;
//     HashMap<Integer, HashSet<Integer>> followerMap;
      
//     public Twitter() {
//       count = 0;
//       tweetMap = new HashMap<>();
//       followerMap = new HashMap<>();
//     }
      
//     public void postTweet(int userId, int tweetId) {
//       tweetMap.computeIfAbsent(userId,
//         k -> new ArrayList<>()
//       );
  
//       tweetMap.computeIfPresent(userId, (k, v) -> {
//         v.add(new int[]{count, tweetId});
//         return v;
//       });
  
//       ++count;
//     }
      
//     public List<Integer> getNewsFeed(int userId) {
//       List<Integer> res = new ArrayList<>();
  
//       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
//         Integer.compare(b[0], a[0])
//       );
  
//       followerMap.computeIfAbsent(userId,
//         k -> new HashSet<>()
//       );
  
//       followerMap.get(userId).add(userId);
  
//       followerMap.get(userId).forEach((followeeId) -> {
//         if (tweetMap.containsKey(followeeId)) {
//           int i = tweetMap.get(followeeId).size() - 1;
//           int[] tweet = tweetMap.get(followeeId).get(i);
//           pq.offer(new int[]{tweet[0], tweet[1], 
//             followeeId, --i});  
//         }
//       });
  
//       while (!pq.isEmpty() && res.size() < 10) {
//         int[] data = pq.poll();
//         res.add(data[1]);
  
//         if (data[3] >= 0) {
//           int[] tweet = tweetMap.get(data[2]).get(data[3]);
//           pq.offer(new int[]{tweet[0], tweet[1], 
//             data[2], --data[3]});
//         }
//       }
  
//       return res;
//     }
      
//     public void follow(int followerId, int followeeId) {
//       followerMap.computeIfAbsent(followerId, 
//         k -> new HashSet<>());
  
//       followerMap.computeIfPresent(followerId, (k, v) -> {
//         v.add(followeeId);
//         return v;
//       }); 
//     }
      
//     public void unfollow(int followerId, int followeeId) {
//       HashSet<Integer> set = followerMap.computeIfAbsent(followerId, 
//         k -> new HashSet<>());
  
//       if (set.contains(followeeId)) {
//         set.remove(followeeId);
//       }
//     }
//   }
  
//   /**
//    * Your Twitter object will be instantiated and called as such:
//    * Twitter obj = new Twitter();
//    * obj.postTweet(userId,tweetId);
//    * List<Integer> param_2 = obj.getNewsFeed(userId);
//    * obj.follow(followerId,followeeId);
//    * obj.unfollow(followerId,followeeId);
//    */
  

// Focus on which data structures to use and the trade between them.

package practice.neetCode150.part8HeapPriorityQueue.medium;

import modules.Pair;
import java.util.*;

public class Twitter {

    public static void main(String[] args) {

        Twitter obj = new Twitter();
        // obj.postTweet(1, 5);
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // System.out.println(obj.getNewsFeed(1));
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // obj.follow(1, 2);
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // obj.postTweet(2, 6);
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // System.out.println(obj.getNewsFeed(1));
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // obj.unfollow(1, 2);
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);
        // System.out.println(obj.getNewsFeed(1));
        // System.out.println("userMap " + userMap);
        // System.out.println("tweetMap " + tweetMap);

        obj.postTweet(1, 1);
        System.out.println("userMap " + userMap);
        System.out.println("tweetMap " + tweetMap);
        System.out.println(obj.getNewsFeed(1));
        System.out.println("userMap " + userMap);
        System.out.println("tweetMap " + tweetMap);
        obj.follow(2, 1);
        System.out.println("userMap " + userMap);
        System.out.println("tweetMap " + tweetMap);
        System.out.println(obj.getNewsFeed(2));
        System.out.println("userMap " + userMap);
        System.out.println("tweetMap " + tweetMap);
        obj.unfollow(2, 1);
        System.out.println("userMap " + userMap);
        System.out.println("tweetMap " + tweetMap);
        System.out.println(obj.getNewsFeed(2));

    }

    public int userId, followeeId, followerId, tweetId;
    public int count; // most recent tweets
    public static HashMap<Integer, HashSet<Integer>> userMap; // followerId followeeId
    public static HashMap<Integer, List<Pair<Integer, Integer>>> tweetMap; // count, tweetID
    public PriorityQueue<Pair<Integer, Integer>> tweet; //

    public Twitter() {

        count = 0;
        userMap = new HashMap<>();
        tweetMap = new HashMap<>();
        tweet = new PriorityQueue<>((a, b) -> b.getFirst() - a.getFirst()); // ninja
        // tweet = new PriorityQueue<>(
        // (a, b) -> Integer.compare(a.getFirst(), b.getFirst())); // ninja

    }

    public void postTweet(int userId, int tweetId) {

        if (tweetMap.containsKey(userId)) {
            tweetMap.get(userId).add(new Pair<Integer, Integer>(count++, tweetId));
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(userId);
            userMap.put(userId, set);
            tweetMap.put(userId, new ArrayList<>());
            tweetMap.get(userId).add(new Pair<Integer, Integer>(count++, tweetId));
        }

    }

    public List<Integer> getNewsFeed(int userId) {

        tweet.clear();

        HashSet<Integer> set = new HashSet<>();
        if (userMap.containsKey(userId)) {
            set = userMap.get(userId);
        } else {
            set = new HashSet<>();
        }

        List<List<Pair<Integer, Integer>>> allTweets = new ArrayList<>();
        for (Integer i : set) {
            if (tweetMap.get(i) != null)
                allTweets.add(tweetMap.get(i));
            else
                allTweets.add(new ArrayList<>());

        }
        // System.out.println("allTweets " + allTweets);

        for (int i = 0; i < allTweets.size(); i++) {
            for (int j = 0; j < allTweets.get(i).size(); j++) {
                tweet.add(new Pair<Integer, Integer>(allTweets.get(i).get(j).getFirst(),
                        allTweets.get(i).get(j).getSecond()));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!tweet.isEmpty() && result.size() > 10) {
            result.add(tweet.poll().getSecond());
        }

        return result;

    }

    // public static HashMap<Integer, List<Integer>> map; // it is goood to access
    // key in O(1) but not good in removing followeeID O(n). Enter HashSet O(n).
    // public static HashSet<Integer> set = new HashSet<>(); // not necessessary

    public void follow(int followerId, int followeeId) {

        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followerId);
            userMap.put(followerId, set);
            userMap.get(followerId).add(followeeId);
        }

    }

    public void unfollow(int followerId, int followeeId) {

        if (userMap.containsKey(followerId))
            userMap.get(followerId).remove(followeeId);

    }

}
