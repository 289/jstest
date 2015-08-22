package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by jinshuai on 15/6/5.
 */
public class Sever {
    public static final int[] DKEY = new int[]{ 0xae, 0xbf, 0x56, 0x79, 0xab, 0xcd, 0xef, 0xf2 };
    public static final int[] EKEY = new int[]{ 0xae, 0xbf, 0x56, 0x79, 0xab, 0xcd, 0xef, 0xf2 };

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            socketChannel.pipeline().addLast("encoder", new MyEncoder(EKEY));
                            socketChannel.pipeline().addLast("decoder", new MyDecoder(DKEY));
                            pipeline.addLast("handler", new ServerHandler());
                        }
                    });

            ChannelFuture cf = bootstrap.bind(8090).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

}
