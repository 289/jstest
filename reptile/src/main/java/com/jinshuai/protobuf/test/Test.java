//package com.jinshuai.protobuf.test;
//
///**
// * Autor: jinshuai
// * Date: 2014/8/23
// * Time: 0:25
// */
//public class Test {
//	public static void main(String[] args){
//		ProtobufTest.msgInfo.Builder builder=ProtobufTest.msgInfo.newBuilder();
//		builder.setGoodID(100);
//		builder.setGuid("11111-23222-3333-444");
//		builder.setOrder(0);
//		builder.setType("ITEM");
////		builder.setID(10);
//		builder.setUrl("http://xxx.jpg");
//		ProtobufTest.msgInfo info=builder.build();
//		byte[] result=info.toByteArray() ;
//
//		try{
//			ProtobufTest.msgInfo msg = ProtobufTest.msgInfo.parseFrom(result);
//			System.out.println(msg);
//		}
//		catch(Exception ex){
//			System.out.println(ex.getMessage());
//		}
//	}
//}
