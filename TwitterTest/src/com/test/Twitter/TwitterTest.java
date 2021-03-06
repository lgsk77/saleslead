package com.test.Twitter;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {
	// 무언가 잘못되면, 트위터익셉션을 보세요.
	public static void main(String[] args) throws TwitterException,InterruptedException {
		
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true).setOAuthConsumerKey("")
				.setOAuthConsumerSecret("")
				.setOAuthAccessToken("")
				.setOAuthAccessTokenSecret("");
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();
		
		// twitter4j.properties를 이용해 트위터API에 접근합니다.
		// Twitter twitter = TwitterFactory.getSingleton();

		// 새 검색 조건을 만듭니다.
		Query query = new Query("이재용");
		//100개의 쿼리문 만듬
		query.count(100);
		// 검색 결과를 얻어옵니다.
		QueryResult result = twitter.search(query);
		
		twitter.getUserTimeline();
		// 모든 결과를 반복처리합니다.
		int i=0;
		//while(true){
			for (Status tweet : result.getTweets()) {
				// 트윗들을 화면에 표시합니다.
				System.out.println(i +"."+ tweet.getUser().getScreenName() + ":" + tweet.getText());
				i++;
			}
			 //Thread.sleep(60*60*1000);
		
	}
}