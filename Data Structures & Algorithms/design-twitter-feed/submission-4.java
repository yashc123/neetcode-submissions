class Twitter {

    Map<Integer, List<Tweet>> userTweets;
    Map<Integer, Set<Integer>> followers;
    int timestamp = 1;

    class Tweet {
        int time;
        int id;

        Tweet(int t, int i) {
            time = t;
            id = i;
        }
    }

    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>(List.of(new Tweet(timestamp, tweetId))));
        } else {
            userTweets.get(userId).add(new Tweet(timestamp, tweetId));
        }
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (followers.containsKey(userId)) {
            for (int daId : followers.get(userId)) {
                if (userTweets.containsKey(daId)) {
                    for (Tweet t : userTweets.get(daId)) {
                        feed.add(t);
                    }
                }
            }
        }
        if (userTweets.containsKey(userId)) {
            for (Tweet t : userTweets.get(userId)) {
                feed.add(t);
            }
        }

        List<Integer> finalResult = new ArrayList<>();
        while (!feed.isEmpty() && finalResult.size() < 10) {
            finalResult.add(feed.poll().id);
        }

        return finalResult;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>(Set.of(followeeId)));
        } else {
            followers.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}