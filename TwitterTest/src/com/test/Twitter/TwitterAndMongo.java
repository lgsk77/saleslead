package com.test.Twitter;

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
		MongoClient mongoClient = null;//MongoClient 생성
		try {
			mongoClient = new MongoClient("localhost", 27017);
			System.out.println("접속 성공");
			// 쓰기권한 부여
			WriteConcern w = new WriteConcern(1, 2000);// 쓰게 락 갯수, 연결 시간 2000
														// //쓰레드 쓰게되면 2개 동시에 쓸
														// 경우도 생기니까
			mongoClient.setWriteConcern(w);
			// 데이터베이스 연결
			DB db = mongoClient.getDB("mymongo");
			// 컬렉션 가져오기
			DBCollection coll = db.getCollection("users");
				
			ConfigurationBuilder cf = new ConfigurationBuilder();
			cf.setDebugEnabled(true).setOAuthConsumerKey("2J8zHAjtZFDUx3RwAZ0iElt85")
					.setOAuthConsumerSecret("1xTqo0P5F7JeEFrCumwGdnOjB4MEHgOTmxN24SrDXuPF0vlo0f")
					.setOAuthAccessToken("218118624-gx61UVXIC11L55HjTbrmrSLIkcgbxBMe3xiXuDhy")
					.setOAuthAccessTokenSecret("zm3Qwb8wS3GyH7PQ070nMScCkH6Za4qOsQMXs6xTZzTzb");
	
			TwitterFactory tf = new TwitterFactory(cf.build());
			Twitter twitter = tf.getInstance();
	
			// twitter4j.properties를 이용해 트위터API에 접근합니다.
			// Twitter twitter = TwitterFactory.getSingleton();
	
			// 새 검색 조건을 만듭니다.
			Query query = new Query("이재용");
			// 100개의 쿼리문 만듬
			query.count(100);
			// 검색 결과를 얻어옵니다.
			QueryResult result = twitter.search(query);
	
			twitter.getUserTimeline();
			// 모든 결과를 반복처리합니다.
			int i = 0;
			// while(true){
			for (Status tweet : result.getTweets()) {
				// 트윗들을 화면에 표시합니다.
				System.out.println(i + "." + tweet.getUser().getScreenName() + ":" + tweet.getText());
				DBObject doc = new BasicDBObject();
				doc.put("id", tweet.getUser().getScreenName());
				doc.put("tweet", tweet.getText());
				coll.insert(doc);
				i++;
			}
			// Thread.sleep(60*60*1000);
	
	
			// user 테이블에 데이터삽입
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
