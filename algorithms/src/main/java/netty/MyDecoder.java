package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author: Jin Shuai
 * @date: 15/8/23
 */
public class MyDecoder extends ByteToMessageDecoder {
    private int[] key;
    public MyDecoder(int[] dkey) {
        this.key = dkey;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] s = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(s);
        s = decrypt(s, key);
        list.add(new String(s));
    }

    // 解密整段数据
    private static byte[] decrypt(byte[] data, int[] decryptKey) throws Exception {
        if (data.length == 0)
            return data;

        if (decryptKey.length < 8)
            throw new Exception("The decryptKey must be 64bits length!");

        int length = data.length;
        int lastCipherByte;
        int plainText;
        int key;

        // 解密首字节
        lastCipherByte = data[0] & 0xff;
        data[0] ^= decryptKey[0];

        for (int index = 1; index < length; index++) {
            // 解密当前字节
            key = ((decryptKey[index & 0x7] + lastCipherByte) ^ index);
            plainText = (((data[index] & 0xff) - lastCipherByte) ^ key) & 0xff;

            // 更新变量值
            lastCipherByte = data[index] & 0xff;
            data[index] = (byte) plainText;
            decryptKey[index & 0x7] = (byte) (key & 0xff);
        }

        return data;
    }
}
