package practice.neetCode150.part8HeapPriorityQueue.hard;

import java.util.*;

public class Twitter {

    int timeCounter;
    HashMap<Integer, List<int[]>> tweetMap; // userId -> List<timeCounter, tweetID>
    HashMap<Integer, Set<Integer>> followerMap; // userId -> followeeIdSet

    public Twitter() {

        timeCounter = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[] { timeCounter++, tweetId });

    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        Set<Integer> followees = followerMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Ensure self-follow

        for (int followeeId : followees) {

            List<int[]> tweets = tweetMap.get(followeeId);

            if (tweets != null && !tweets.isEmpty()) {

                int len = tweets.size() - 1;
                maxHeap.add(new int[] { tweets.get(len)[0], tweets.get(len)[1], followeeId, len - 1 });

            }

        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {

            int[] tweetInfo = maxHeap.poll();
            feed.add(tweetInfo[1]);

            if (tweetInfo[3] >= 0) {

                int[] tweet = tweetMap.get(tweetInfo[2]).get(tweetInfo[3]);
                maxHeap.add(new int[] { tweet[0], tweet[1], tweetInfo[2], tweetInfo[3] - 1 });

            }

        }

        return feed;

    }

    public void follow(int followerId, int followeeId) {

        followerMap.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> set = followerMap.get(followerId);

        if (set != null)
            set.remove(followeeId);
        // There's no need to do something like followerMap.put(followerId, set); after
        // modifying the set because the map already holds a reference to the modified
        // set.

    }

}

// public class Twitter {

//     public static void main(String[] args) {

//         Twitter obj = new Twitter();

//         obj.postTweet(1, 5);
//         System.out.println(obj.getNewsFeed(1));
//         obj.follow(1, 2);
//         obj.postTweet(2, 6);
//         System.out.println(obj.getNewsFeed(1));
//         obj.unfollow(1, 2);
//         System.out.println(obj.getNewsFeed(1));

//         // obj.postTweet(1, 1);
//         // System.out.println(obj.getNewsFeed(1));
//         // obj.follow(2, 1);
//         // System.out.println(obj.getNewsFeed(2));
//         // obj.unfollow(2, 1);
//         // System.out.println(obj.getNewsFeed(2));

//     }

//     int timeCounter;
//     HashMap<Integer, List<int[]>> tweetMap; // userId List<timeCounter tweetID>
//     HashMap<Integer, HashSet<Integer>> followerMap; // userId followeeIdSet

//     public Twitter() {

//         timeCounter = 0;
//         tweetMap = new HashMap<>();
//         followerMap = new HashMap<>();

//     }

//     public void postTweet(int userId, int tweetId) {

//         tweetMap.computeIfAbsent(userId, k -> {

//             return new ArrayList<>();

//         });

//         tweetMap.computeIfPresent(userId, (k, v) -> {

//             v.add(new int[] { timeCounter, tweetId });
//             return v;

//         });

//         ++timeCounter;

//     }

//     public List<Integer> getNewsFeed(int userId) {

//         List<Integer> feed = new ArrayList<>();
//         PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // descending //
//                                                                                                    // 10.logk recent ||
//                                                                                                    // 10.k insertion

//         followerMap.computeIfAbsent(userId, k -> {
//             return new HashSet<>();
//         });

//         followerMap.get(userId).add(userId); // adding self user in followerMap

//         followerMap.get(userId).forEach((followeeId) -> {

//             if (tweetMap.containsKey(followeeId)) {

//                 int len = tweetMap.get(followeeId).size() - 1; // recent to oldest

//                 // int[] tweet = tweetMap.get(followeeId).get(i);
//                 // maxHeap.offer(new int[] { tweet[0], tweet[1], followeeId, --len });
//                 maxHeap.add(new int[] {

//                         tweetMap.get(followeeId).get(len)[0], tweetMap.get(followeeId).get(len)[1], followeeId, len - 1

//                 });

//             }

//         });

//         while (!maxHeap.isEmpty() && feed.size() <= 10) {

//             int[] maxHeapVar = maxHeap.poll();
//             feed.add(maxHeapVar[1]);

//             if (maxHeapVar[3] >= 0) {

//                 // int[] tweet = tweetMap.get(maxHeapVar[2]).get(maxHeapVar[3]);
//                 // maxHeap.offer(new int[] {
//                 // tweet[0], tweet[1], maxHeapVar[2], --maxHeapVar[3]
//                 // });
//                 maxHeap.add(new int[] {
//                         tweetMap.get(maxHeapVar[2]).get(maxHeapVar[3])[0],
//                         tweetMap.get(maxHeapVar[2]).get(maxHeapVar[3])[1], maxHeapVar[2], maxHeapVar[3] - 1
//                 });

//             }

//         }

//         return feed;
//     }

//     // public HashMap<Integer, List<Integer>> map; // it is goood to add key in O(1)
//     // but not good in removing followeeID O(n). Enter HashSet O(1).
//     public void follow(int followerId, int followeeId) {

//         followerMap.computeIfAbsent(followerId, k -> {

//             return new HashSet<>();

//         });

//         followerMap.computeIfPresent(followerId, (k, v) -> {

//             v.add(followeeId);
//             return v;

//         });

//     }

//     public void unfollow(int followerId, int followeeId) {

//         HashSet<Integer> set = followerMap.computeIfAbsent(followerId, k -> {

//             return new HashSet<>();

//         });

//         if (set.contains(followeeId))
//             set.remove(followeeId);

//     }

// }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
