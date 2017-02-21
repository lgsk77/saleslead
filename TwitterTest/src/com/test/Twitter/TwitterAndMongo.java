package com.test.Twitter;

import java.util.StringTokenizer;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAndMongo {
//ss
	public static void main(String[] args) throws TwitterException, InterruptedException {
		MongoClient mongoClient = null;//MongoClient ����
		try {
			mongoClient = new MongoClient("localhost", 27017);
			System.out.println("���� ����");
			// ������� �ο�
			WriteConcern w = new WriteConcern(1, 2000);// ���� �� ����, ���� �ð� 2000
														// //������ ���ԵǸ� 2�� ���ÿ� ��
														// ��쵵 ����ϱ�
			mongoClient.setWriteConcern(w);
			// �����ͺ��̽� ����
			DB db = mongoClient.getDB("mymongo");
			// �÷��� ��������
			DBCollection coll = db.getCollection("notebook1");
				
			ConfigurationBuilder cf = new ConfigurationBuilder();
			cf.setDebugEnabled(true).setOAuthConsumerKey("2J8zHAjtZFDUx3RwAZ0iElt85")
					.setOAuthConsumerSecret("1xTqo0P5F7JeEFrCumwGdnOjB4MEHgOTmxN24SrDXuPF0vlo0f")
					.setOAuthAccessToken("218118624-gx61UVXIC11L55HjTbrmrSLIkcgbxBMe3xiXuDhy")
					.setOAuthAccessTokenSecret("zm3Qwb8wS3GyH7PQ070nMScCkH6Za4qOsQMXs6xTZzTzb");
	
			TwitterFactory tf = new TwitterFactory(cf.build());
			Twitter twitter = tf.getInstance();
	
			// twitter4j.properties�� �̿��� Ʈ����API�� �����մϴ�.
			// Twitter twitter = TwitterFactory.getSingleton();
	
			// �� �˻� ������ ����ϴ�.
			// ��� ����� �ݺ�ó���մϴ�.
			int i = 0;
			while(true){
			 Query query = new Query("��Ʈ��");
				// 100���� ������ ����
				query.count(100);
				// �˻� ����� ���ɴϴ�.
				QueryResult result = twitter.search(query);
		
				twitter.getUserTimeline();
				for (Status tweet : result.getTweets()) {
					
					// Ʈ������ ȭ�鿡 ǥ���մϴ�.
					System.out.println(i + "." + tweet.getUser().getScreenName() + ":" + tweet.getText());
					
					//retweet ��������
					String tweetText=tweet.getText();
					int RtStart = tweetText.indexOf("@");
					//System.out.println(RtStart);
					int RtEnd = tweetText.indexOf(":");
					//System.out.println(RtEnd);
					String retweet = null;
					if(RtStart > 0 && RtEnd > 0 && tweetText.indexOf("[��ó]")<0){
						//System.out.println(RtStart+" : " + RtEnd);
						retweet = tweetText.substring(RtStart+1,RtEnd);
					}
					
					System.out.println(retweet);
					
					DBObject doc = new BasicDBObject();
					doc.put("id", tweet.getUser().getScreenName());
					doc.put("reTweet", retweet);
					doc.put("tweet", tweet.getText());
					coll.insert(doc);
					i++;
				}
				Thread.sleep(60*1000);
		 }

	
			// user ���̺� �����ͻ���
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
