package algorithms;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * @author Jin Shuai
 */
public class XORTest {
    private static int[] key1 = new int[]{ 0xae, 0xbf, 0x56, 0x78, 0xab, 0xcd, 0xef, 0xf1 };
    private static int[] key2 = new int[]{ 0xae, 0xbf, 0x56, 0x78, 0xab, 0xcd, 0xef, 0xf1 };

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

    public static byte[] encypt(byte[] plainText,int encryptKey[]){
        IoBuffer cipherBuffer = IoBuffer.allocate(plainText.length);
        int lastCipherByte = 0;
        // 加密首字节
        lastCipherByte = (byte) ((plainText[0] ^ encryptKey[0]) & 0xff);
        cipherBuffer.put((byte) lastCipherByte);

        // 循环加密
        int keyIndex = 0;
        for (int i = 1; i < plainText.length; i++) {
            keyIndex = i & 0x7;
            encryptKey[keyIndex] = ((encryptKey[keyIndex] + lastCipherByte) ^ i) & 0xff;
            lastCipherByte = (((plainText[i] ^ encryptKey[keyIndex]) & 0xff) + lastCipherByte) & 0xff;
            cipherBuffer.put((byte) lastCipherByte);
        }
        return cipherBuffer.array();
    }


    public static void main(String[] args) throws Exception {
        byte[] ss = "Hello World!".getBytes();
//        System.out.println(encypt(ss, key));
        byte[] ss2 = encypt(ss, key1);
        System.out.println(new String(decrypt(ss2,key2)));
    }


}
