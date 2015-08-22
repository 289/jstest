package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by jinshuai on 15/6/5.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private volatile int i = 0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.toString());
        if(i < 2){
            ctx.writeAndFlush(msg);
            i++;
        }
        super.channelRead(ctx, msg);
    }
}
