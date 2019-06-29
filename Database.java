package pack;

import com.google.appengine.api.datastore.*;

import java.util.HashMap;
import java.util.UUID;

public class Database {
    HashMap<Object, Object> hm = new HashMap<>();
    HashMap<Object, Object> ht = new HashMap<>();

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    String name;
    static String password;
    static String uid;
Database(){}
public Database(String name){
    this.name=name;}
    Database(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public String[] check() {
        Query q = new Query("person");
        String[] userNamePassword = new String[2];
        PreparedQuery pq = datastore.prepare(q);
        for (Entity en : pq.asIterable()) {
            hm.put(en.getProperty("name"), en.getProperty("password"));
               }

        if (hm.containsKey(name)) {
            if (hm.get(name).equals(password)) {
                userNamePassword[0] = name;
                userNamePassword[1] = password;
            }
        }
        return userNamePassword;
    }

    public String checkUid() {
        Query q = new Query("person");
        String userNamePassword = new String();
        PreparedQuery pq = datastore.prepare(q);
        for (Entity en : pq.asIterable()) {
            ht.put(en.getProperty("name"), en.getProperty("uid"));
        }

        if (ht.containsKey(name)) {


                userNamePassword = ht.get(name).toString();

        }
        return userNamePassword;}
    public void addUser(){
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Entity p = new Entity("person",name);
        p.setProperty("name",name );
        p.setProperty("password",password);
    String s= UUID.randomUUID().toString();
        p.setProperty("uid",s);
datastore.put(p);}
public void storeComment(String method,String req_head,String content,String res_head,String body ){
           String a= checkUid();
    Entity p = new Entity("Description",name);
    p.setProperty("uid",a);
    p.setProperty("method",method);
    p.setProperty("request_header",req_head);
    p.setProperty("content-type",content);
    p.setProperty("response_header",res_head);
    p.setProperty("body",body);
    datastore.put(p);
            }
    public String[] fetchDetails(String id) {
        Query q = new Query("Description").setFilter(new Query.FilterPredicate("uid", Query.FilterOperator.EQUAL, id));

        PreparedQuery pq = datastore.prepare(q);
        String details[] = {
                pq.asSingleEntity().getProperty("uid").toString(),
                pq.asSingleEntity().getProperty("method").toString(),
                pq.asSingleEntity().getProperty("request_header").toString(),
                pq.asSingleEntity().getProperty("content-type").toString(),
                pq.asSingleEntity().getProperty("response_header").toString(),
               pq.asSingleEntity().getProperty("body").toString(),
        };
    return details;} }

