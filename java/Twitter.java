/**

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.
    
    --- Need to improve ---

**/

import java.util.*;
import java.sql.Timestamp;
class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer,List<Tweet>> userFeeds;
    /** Initialize your data structure here. */
    public Twitter() {
        followerMap=new HashMap<Integer,Set<Integer>>();
        userFeeds = new HashMap<Integer,List<Tweet>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if(!userFeeds.containsKey(userId)){
            userFeeds.put(userId, new ArrayList<Tweet>());
        }
        userFeeds.get(userId).add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<Integer>();
        List<Tweet> lst=new ArrayList<Tweet>();
        if(!userFeeds.containsKey(userId)){
            return ans;
        }
        lst.addAll(userFeeds.get(userId));
        Set<Integer> followers = followerMap.get(userId);
        if(followers != null && followers.size()>0){
        for(int followee:followers){
            List<Tweet> fuserFeed= userFeeds.get(followee);
            if(fuserFeed !=null){
                lst.addAll(fuserFeed);
            }
        }
        }
        Collections.sort(lst, new Comparator<Tweet>(){
            @Override
            public int compare(Tweet t1, Tweet t2){
                return t1.ts.compareTo(t2.ts);
            }
        });
        int count =0;
        for(int i=lst.size()-1;i>=0 && count<10;i--){
            ans.add(lst.get(i).id);
            count++;
        }
        
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId,new HashSet<Integer>());
        }
        if(!userFeeds.containsKey(followerId)){
            userFeeds.put(followerId,new ArrayList<Tweet>());
        }
            
        followerMap.get(followerId).add(followeeId);
       
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
           return;
        }
        if(followerMap.containsKey(followerId)){
            Set<Integer> followees=followerMap.get(followerId);
            followees.remove(followeeId);
            
        }
        
    }
}
class Tweet{
    int id;
    Timestamp ts;
    Tweet(int id){
        this.id=id;
        Date date = new Date();
        long time =date.getTime();
        this.ts= new Timestamp(time);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
