package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import db.Manager;

import java.sql.Date;

import model.DLEvent;
import model.Edge;
import xml.Message;
import junit.framework.TestCase;

/**
 * 
 * @author Timothy Kolek
 *
 */

public class TestTurnResponseController extends TestCase {
	TurnResponseController cont;

	public void setUp(){
		cont = new TurnResponseController();
	}
	public void testTurnProcess(){
		Message.configure("decisionlines.xsd");
		DLEvent temp = new DLEvent("test", "tester", "Hello?", 1, 1);
		Date tempDate = new Date(0);
		temp.setDateCreated(tempDate);
		cont.model.addTestDLEvent(temp);
		
		Message response = cont.process("test");
		
		Node first = response.contents.getFirstChild();
		NamedNodeMap map = first.getAttributes();
		String completed = "";
		if (map.getNamedItem("completed") != null){
			completed = map.getNamedItem("completed").getNodeValue();
		}
		
		assertEquals("", completed);
		
		temp.addEdge(new Edge(1,2,23));
		
		response = cont.process("test");
		
		first = response.contents.getFirstChild();
		map = first.getAttributes();
		completed = "";
		if (map.getNamedItem("completed") != null){
			completed = map.getNamedItem("completed").getNodeValue();
		}
		
		assertEquals("true", completed);
		
		Manager.deleteEvent("test");
		
		
	}
}
