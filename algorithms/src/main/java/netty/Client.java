package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by jinshuai on 15/6/5.
 */
public class Client {
    public static final int[] DKEY = new int[]{ 0xae, 0xbf, 0x56, 0x79, 0xab, 0xcd, 0xef, 0xf2 };
    public static final int[] EKEY = new int[]{ 0xae, 0xbf, 0x56, 0x79, 0xab, 0xcd, 0xef, 0xf2 };

    public static void main(String[] args) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        try {
            client.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("encoder", new MyEncoder(EKEY));
                            socketChannel.pipeline().addLast("decoder", new MyDecoder(DKEY));
                            socketChannel.pipeline().addLast(new ClientHandler());
                        }
                    });
            ChannelFuture cf = client.connect("127.0.0.1", 8090).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }

}
