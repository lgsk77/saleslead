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
	// ���� �߸��Ǹ�, Ʈ�����ͼ����� ������.
	public static void main(String[] args) throws TwitterException,InterruptedException {
		
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true).setOAuthConsumerKey("")
				.setOAuthConsumerSecret("")
				.setOAuthAccessToken("")
				.setOAuthAccessTokenSecret("");
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();
		
		// twitter4j.properties�� �̿��� Ʈ����API�� �����մϴ�.
		// Twitter twitter = TwitterFactory.getSingleton();

		// �� �˻� ������ ����ϴ�.
		Query query = new Query("�����");
		//100���� ������ ����
		query.count(100);
		// �˻� ����� ���ɴϴ�.
		QueryResult result = twitter.search(query);
		
		twitter.getUserTimeline();
		// ��� ����� �ݺ�ó���մϴ�.
		int i=0;
		//while(true){
			for (Status tweet : result.getTweets()) {
				// Ʈ������ ȭ�鿡 ǥ���մϴ�.
				System.out.println(i +"."+ tweet.getUser().getScreenName() + ":" + tweet.getText());
				i++;
			}
			 //Thread.sleep(60*60*1000);
		
	}
}