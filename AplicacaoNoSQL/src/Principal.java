import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		try {

			MongoClient mongoClient = new MongoClient("localhost");
			DB db = mongoClient.getDB("MeuBancoDeDados");

			// não sei pra que serve :)
			mongoClient.setWriteConcern(WriteConcern.JOURNALED);

			DBCollection coll = db.getCollection("testCollection");

			BasicDBObject doc = new BasicDBObject("name", "MongoDB222").append(
					"type", "database222").append("count", "2");

			coll.insert(doc, WriteConcern.JOURNALED);

			System.out.println("Sucesso");

			DBCursor cursor = coll.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next());
				}
			} finally {
				cursor.close();
			}

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
	}
}
