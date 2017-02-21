package com.test.Twitter;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
 
public class MongoTest {
 
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try{
            mongoClient = new MongoClient("localhost",27017);
            System.out.println("접속 성공");
            //쓰기권한 부여
            WriteConcern w = new WriteConcern(1,2000);//쓰게 락 갯수, 연결 시간 2000 //쓰레드 쓰게되면 2개 동시에 쓸 경우도 생기니까
            mongoClient.setWriteConcern(w);
            //데이터베이스 연결
            DB db = mongoClient.getDB("mymongo");
            //컬렉션 가져오기
            DBCollection coll = db.getCollection("users");
            
            //user 테이블에 데이터삽입
            DBObject doc = new BasicDBObject();
            doc.put("id","lgsk77@naver.com");
            doc.put("password","741963");
            coll.insert(doc);
            
            //user의 모든 데이터 가져오기
            /*DBCursor cursor = coll.find();
            while(cursor.hasNext()){
                //커서의 이름중에 _id인 컬럼 값만 출력
                System.out.println(cursor.next().get("_id"));    
            }*/
            
            //특정 조건에 맞는 데이터 출력
            /*DBObject o = new BasicDBObject();
            o.put("id","root");
            DBCursor cursor = coll.find(o);
            while(cursor.hasNext()){
                System.out.println(cursor.next().toString());
            }*/
            
            //업데이트
            /*DBObject origin = new BasicDBObject("id","user01");
            DBObject set = new BasicDBObject("$set",new BasicDBObject("password","22kkkk"));
            coll.update(origin, set);//앞이 조건 뒤에가 바뀌는 데이터*/
            
      
            //데이터 선택 삭제
            //coll.remove(new BasicDBObject("id","강감찬")); //강감찬 삭제
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
 
    }
 
}
 
 
