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
            System.out.println("���� ����");
            //������� �ο�
            WriteConcern w = new WriteConcern(1,2000);//���� �� ����, ���� �ð� 2000 //������ ���ԵǸ� 2�� ���ÿ� �� ��쵵 ����ϱ�
            mongoClient.setWriteConcern(w);
            //�����ͺ��̽� ����
            DB db = mongoClient.getDB("mymongo");
            //�÷��� ��������
            DBCollection coll = db.getCollection("users");
            
            //user ���̺� �����ͻ���
            DBObject doc = new BasicDBObject();
            doc.put("id","lgsk77@naver.com");
            doc.put("password","741963");
            coll.insert(doc);
            
            //user�� ��� ������ ��������
            /*DBCursor cursor = coll.find();
            while(cursor.hasNext()){
                //Ŀ���� �̸��߿� _id�� �÷� ���� ���
                System.out.println(cursor.next().get("_id"));    
            }*/
            
            //Ư�� ���ǿ� �´� ������ ���
            /*DBObject o = new BasicDBObject();
            o.put("id","root");
            DBCursor cursor = coll.find(o);
            while(cursor.hasNext()){
                System.out.println(cursor.next().toString());
            }*/
            
            //������Ʈ
            /*DBObject origin = new BasicDBObject("id","user01");
            DBObject set = new BasicDBObject("$set",new BasicDBObject("password","22kkkk"));
            coll.update(origin, set);//���� ���� �ڿ��� �ٲ�� ������*/
            
      
            //������ ���� ����
            //coll.remove(new BasicDBObject("id","������")); //������ ����
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
 
    }
 
}
 
 
