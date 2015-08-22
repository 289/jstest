package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: Jin Shuai
 * @date:   15/6/5
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {


//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush("hello");
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
private final ByteBuf firstMessage;
    public ClientHandler(){
        firstMessage = Unpooled.buffer("hello world".getBytes().length);
        firstMessage.writeBytes("hello world".getBytes());
//        for (int i = 0; i < firstMessage.capacity(); i++) {
//            firstMessage.writeByte(i);
//        }

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(firstMessage);
        ctx.writeAndFlush("hello world");
//        ctx.writeAndFlush("123");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client received:"+msg);
        ctx.write(msg);
    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
