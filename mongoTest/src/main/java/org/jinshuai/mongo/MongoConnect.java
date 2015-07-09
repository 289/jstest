package org.jinshuai.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author Jin Shuai
 */
public class MongoConnect {
    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("192.168.93.129",27017);
        MongoDatabase database = mongo.getDatabase("jinshuai_gamedata");
        MongoCollection<Document> collection = database.getCollection("skill_effect");
        for (Document blog : collection.find()) {
            System.out.println(blog.toJson());
        }
        DBObject dbObject = new BasicDBObject();
    }
}
