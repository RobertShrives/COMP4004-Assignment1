package AcceptanceTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestAddItem {

private static LibServer server = new LibServer(Config.DEFAULT_PORT);
@BeforeClass
public static void beforeClass() {
server.start();
}
@AfterClass
public static void tearDownAfterClass() throws Exception {
}
@Test
public void testAddItemTitleExists() {
LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
server.handle(client1.getID(), "Hello");
server.handle(client1.getID(), "Clerk");
server.handle(client1.getID(), "admin");
server.handle(client1.getID(), "Create Item");
server.handle(client1.getID(), "9781442668584");
//server.remove(client1.getID());
}
@Test
public void testAddItemTitleDoesNotExist() {
LibClient client2 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
server.handle(client2.getID(), "Hello");
server.handle(client2.getID(), "Clerk");
server.handle(client2.getID(), "admin");
server.handle(client2.getID(), "Create Item");
server.handle(client2.getID(), "3731442668584");
server.handle(client2.getID(), "Create Title");
server.handle(client2.getID(), "3731442668584,book");
server.handle(client2.getID(), "Create Item");
server.handle(client2.getID(), "3731442668584");

}
}