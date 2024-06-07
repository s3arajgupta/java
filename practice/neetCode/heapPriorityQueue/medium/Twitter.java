// /*
//  * Your Twitter object will be instantiated and called as such:
//  * Twitter obj = new Twitter();
//  * obj.postTweet(userId,tweetId);
//  * List<Integer> param_2 = obj.getNewsFeed(userId);
//  * obj.follow(followerId,followeeId);
//  * obj.unfollow(followerId,followeeId);
//  */

// package practice.neetCode.heapPriorityQueue.medium;

// import modules.Pair;
// import java.util.*;
// import java.util.PriorityQueue;

// public class Twitter {

//     public int userId, followeeId, followerId, tweetId;

//     public Twitter() {

//         // Twitter obj = new Twitter();
//         // obj.postTweet(userId, tweetId);
//         // List<Integer> param_2 = obj.getNewsFeed(userId);
//         // System.out.println(param_2);
//         // obj.follow(followerId, followeeId);
//         // obj.postTweet(userId, tweetId);
//         // param_2 = obj.getNewsFeed(userId);
//         // System.out.println(param_2);
//         // obj.unfollow(followerId, followeeId);
//         // param_2 = obj.getNewsFeed(userId);
//         // System.out.println(param_2);

//         Twitter obj = new Twitter();
//         obj.postTweet(1, 5);
//         List<Integer> param_2 = obj.getNewsFeed(1);
//         System.out.println(param_2);
//         obj.follow(1, 2);
//         obj.postTweet(2, 6);
//         param_2 = obj.getNewsFeed(1);
//         System.out.println(param_2);
//         obj.unfollow(1, 2);
//         param_2 = obj.getNewsFeed(1);
//         System.out.println(param_2);

//     }

//     public PriorityQueue<Pair<Integer, Integer>> tweet = new PriorityQueue<>(
//             (a, b) -> Integer.compare(a.getFirst(), b.getFirst()));

//     public void postTweet(int userId, int tweetId) {
//         tweet.add(new Pair<>(tweetId, userId));

//     }

//     public List<Integer> getNewsFeed(int userId) {
//         List<Integer> res = new ArrayList<>();

//         PriorityQueue<Pair<Integer, Integer>> temp = tweet;

//         while (!temp.isEmpty()) {
//             if (temp.peek().getSecond() == userId)
//                 res.add(temp.poll().getFirst());
//             temp.poll();
//         }
//         return res;
//     }

//     public void follow(int followerId, int followeeId) {


        
//     }

//     public void unfollow(int followerId, int followeeId) {

//     }

// }
