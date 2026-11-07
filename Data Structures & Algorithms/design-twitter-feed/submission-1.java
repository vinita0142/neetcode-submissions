class Twitter {

    class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId, int time){
            this.tweetId=tweetId;
            this.time=time;
        }
    }

    class Entry{
        int userId;
        int index;
        Tweet tweet;

        Entry(int userId,int index, Tweet tweet){
            this.userId=userId;
            this.index=index;
            this.tweet=tweet;
        }
    }


    HashMap<Integer,List<Tweet>> tweets;

    HashMap<Integer,Set<Integer>> following;
    int time;
    public Twitter() {
        tweets=new HashMap<>();
        following=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId,new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //max heap newest tweet comes first 

        PriorityQueue<Entry> maxHeap=new PriorityQueue<>(
            (a,b) -> Integer.compare(b.tweet.time, a.tweet.time)
        );

        addLatestTweet(userId,maxHeap);

        if(following.containsKey(userId)){
            for(int followeeId:following.get(userId)){
                addLatestTweet(followeeId,maxHeap);
            }
        }

        List<Integer> feed=new ArrayList<>();

        while(!maxHeap.isEmpty() && feed.size()<10){
            Entry current=maxHeap.poll();

            feed.add(current.tweet.tweetId);

            if(current.index>0){
                int prev=current.index-1;

                Tweet prevTweet=tweets.get(current.userId).get(prev);
                maxHeap.offer(new Entry(current.userId,prev,prevTweet));
            }
        }
        return feed;

    }


    private void addLatestTweet(int userId, PriorityQueue<Entry> maxHeap){

        if(!tweets.containsKey(userId)) return;

        List<Tweet> list=tweets.get(userId);
        int lastIndex=list.size()-1;

        maxHeap.offer(new Entry(userId,lastIndex,list.get(lastIndex)));
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}
