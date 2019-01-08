package util.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Map;

public class ClientTest {
    private static Logger log=LoggerFactory.getLogger(ClientTest.class);

    public static TransportClient client=null;
    private int port=9300;
    private static String host="192.168.52.40";
//    private static String host=null;//null获取的为本机
//    public static TransportClient getClient(){
//        if(client!=null){
//            return client;
//        }
//        try {
//            System.setProperty("es.set.netty.runtime.available.processors", "false");
//            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
//                    new InetSocketTransportAddress(InetAddress.getByName(host), 9300));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return client;
//    }

//    public void addIndex(){
//        try {
//            IndexResponse indexResponse=client.prepareIndex("test","tweet","1").setSource(
//                    XContentFactory.jsonBuilder().startObject().field("username","test")
//                            .field("age",3).field("sex","female").endObject()).get();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @SuppressWarnings({"resource","unchecked"})
    @Before
    public void getClient(){
        try {
//            System.setProperty("es.set.netty.runtime.available.processors", "false");
//            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
//                    new InetSocketTransportAddress(InetAddress.getByName(host), 9300));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
        try {
            Settings settings=Settings.builder().put("cluster.name","my-application").build();
//            System.setProperty("es.set.netty.runtime.available.processors", "false");
            client = new PreBuiltTransportClient(settings).addTransportAddresses(
                    new TransportAddress(InetAddress.getByName(host), port));
            IndexResponse indexResponse=client.prepareIndex("test","tweet","39").setSource(
                    XContentFactory.jsonBuilder().startObject().field("username","test")
                            .field("age",3).field("sex","female").endObject()).get();

            GetResponse response=client.prepareGet("test","tweet","39").get();
            Map<String,DocumentField> map=response.getFields();
            System.out.println(map);
            Map<String,Object> data=response.getSource();
            System.out.println(response.getId());
            for (Object d:data.entrySet()){
                System.out.println(d);
            }

            DeleteResponse deleteResponse=client.prepareDelete("test","tweet","39").get();
            System.out.println("deleted:"+deleteResponse.getId());

//            client.prepareDelete("test","tweet","39").execute(new ActionListener<DeleteResponse>() {
//                @Override
//                public void onResponse(DeleteResponse deleteResponse) {
//                    String  deleted=deleteResponse.getId();
//                    System.out.println("deleted:"+deleted);
//                }
//
//                @Override
//                public void onFailure(Exception e) {
//
//                }
//            });

            client.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeClient(){
        if(client!=null){
            client.close();
        }
    }

}
