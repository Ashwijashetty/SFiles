package com.cg.soap;

import javax.xml.ws.Endpoint;

public class CalculatorPublish {
public static void main(String[] args) {
	Endpoint.publish("http://127.0.0.1:9876/csi", new CalculatorImpl());
}
}
