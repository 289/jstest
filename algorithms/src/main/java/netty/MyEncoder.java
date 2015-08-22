package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: Jin Shuai
 * @date: 15/8/23
 */
public class MyEncoder extends MessageToByteEncoder<String> {

    private int[] key;
    public MyEncoder(int[] dkey) {
        this.key = dkey;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, String msg, ByteBuf byteBuf) throws Exception {
        if(msg.length() != 0) {
            byteBuf.writeBytes(encode0(msg));
        }
    }

    private byte[] encode0(String msg){
        int lastCipherByte = 0;

        int[] encryptKey = key;
        byte[] plainText = msg.getBytes();
        byte[] outText = new byte[plainText.length];

        int length = plainText.length;
        lastCipherByte = (byte) ((plainText[0] ^ encryptKey[0]) & 0xff);
        outText[0] = (byte)lastCipherByte;

        // 循环加密
        int keyIndex = 0;
        for (int i = 1; i < length; i++) {
            keyIndex = i & 0x7;
            encryptKey[keyIndex] = ((encryptKey[keyIndex] + lastCipherByte) ^ i) & 0xff;
            lastCipherByte = (((plainText[i] ^ encryptKey[keyIndex]) & 0xff) + lastCipherByte) & 0xff;
            outText[i] = (byte) lastCipherByte;
        }
        return outText;
    }
}
