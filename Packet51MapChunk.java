import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Packet51MapChunk extends abs {
   public long a;
   public long b;
   public int c;
   public int d;
   public byte[] e;
   public boolean f;
   private int g;
   private int h;
   private static byte[] i = new byte[0];

   public Packet51MapChunk() {
      this.q = true;
   }

   public void a(DataInputStream par1DataInputStream) throws IOException {
      try {
         this.a = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.a = par1DataInputStream.readInt();
      }

      try {
         this.b = par1DataInputStream.readLong();
      } catch (ClassCastException ex) {
         this.b = par1DataInputStream.readInt();
      }

      this.f = par1DataInputStream.readBoolean();
      this.c = par1DataInputStream.readShort();
      this.d = par1DataInputStream.readShort();
      this.g = par1DataInputStream.readInt();
      this.h = par1DataInputStream.readInt();
      if (Packet51MapChunk.i.length < this.g) {
         Packet51MapChunk.i = new byte[this.g];
      }

      par1DataInputStream.readFully(Packet51MapChunk.i, 0, this.g);
      int i = 0;

      for (int j = 0; j < 16; j++) {
         i += this.c >> j & 1;
      }

      int k = 12288 * i;
      if (this.f) {
         k += 256;
      }

      this.e = new byte[k];
      Inflater inflater = new Inflater();
      inflater.setInput(Packet51MapChunk.i, 0, this.g);

      try {
         inflater.inflate(this.e);
      } catch (DataFormatException dataformatexception) {
         throw new IOException("Bad compressed data format");
      } finally {
         inflater.end();
      }
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      par1DataOutputStream.writeLong(this.a);
      par1DataOutputStream.writeLong(this.b);
      par1DataOutputStream.writeBoolean(this.f);
      par1DataOutputStream.writeShort((short)(this.c & 65535));
      par1DataOutputStream.writeShort((short)(this.d & 65535));
      par1DataOutputStream.writeInt(this.g);
      par1DataOutputStream.writeInt(this.h);
      par1DataOutputStream.write(this.e, 0, this.g);
   }

   public void a(oe par1NetHandler) {
      par1NetHandler.a(this);
   }

   public int a() {
      return 17 + this.g;
   }
}
