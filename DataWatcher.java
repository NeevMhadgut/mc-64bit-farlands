import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataWatcher {
   private static final HashMap a = new HashMap();
   private final Map b = new HashMap();
   private boolean c;

   public void a(int par1, Object par2Obj) {
      Integer integer = (Integer)a.get(par2Obj.getClass());
      if (integer == null) {
         throw new IllegalArgumentException("Unknown data type: " + par2Obj.getClass());
      }

      if (par1 > 31) {
         throw new IllegalArgumentException("Data value id EntityAIDoorInteract too big with " + par1 + "! (Max EntityAIDoorInteract " + 31 + ")");
      }

      if (this.b.containsKey(par1)) {
         throw new IllegalArgumentException("Duplicate id value for " + par1 + "!");
      }

      acx watchableobject = new acx(integer, par1, par2Obj);
      this.b.put(par1, watchableobject);
   }

   public byte a(int par1) {
      return (Byte)((acx)this.b.get(par1)).b();
   }

   public short b(int par1) {
      return (Short)((acx)this.b.get(par1)).b();
   }

   public int c(int par1) {
      return (Integer)((acx)this.b.get(par1)).b();
   }

   public String d(int par1) {
      return (String)((acx)this.b.get(par1)).b();
   }

   public void b(int par1, Object par2Obj) {
      acx watchableobject = (acx)this.b.get(par1);
      if (!par2Obj.equals(watchableobject.b())) {
         watchableobject.a(par2Obj);
         watchableobject.a(true);
         this.c = true;
      }
   }

   public static void a(List par0List, DataOutputStream par1DataOutputStream) throws IOException {
      if (par0List != null) {
         for (acx watchableobject : par0List) {
            a(par1DataOutputStream, watchableobject);
         }
      }

      par1DataOutputStream.writeByte(127);
   }

   public void a(DataOutputStream par1DataOutputStream) throws IOException {
      for (acx watchableobject : this.b.values()) {
         a(par1DataOutputStream, watchableobject);
      }

      par1DataOutputStream.writeByte(127);
   }

   private static void a(DataOutputStream par0DataOutputStream, acx par1WatchableObject) throws IOException {
      int i = (par1WatchableObject.c() << 5 | par1WatchableObject.a() & 31) & 0xFF;
      par0DataOutputStream.writeByte(i);
      switch (par1WatchableObject.c()) {
         case 0:
            par0DataOutputStream.writeByte((Byte)par1WatchableObject.b());
            break;
         case 1:
            par0DataOutputStream.writeShort((Short)par1WatchableObject.b());
            break;
         case 2:
            par0DataOutputStream.writeInt((Integer)par1WatchableObject.b());
            break;
         case 3:
            par0DataOutputStream.writeFloat((Float)par1WatchableObject.b());
            break;
         case 4:
            abs.a((String)par1WatchableObject.b(), par0DataOutputStream);
            break;
         case 5:
            ItemStack itemstack = (ItemStack)par1WatchableObject.b();
            par0DataOutputStream.writeShort(itemstack.a().bQ);
            par0DataOutputStream.writeByte(itemstack.a);
            par0DataOutputStream.writeShort(itemstack.i());
            break;
         case 6:
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)par1WatchableObject.b();
            par0DataOutputStream.writeLong(chunkcoordinates.a);
            par0DataOutputStream.writeInt(chunkcoordinates.b);
            par0DataOutputStream.writeLong(chunkcoordinates.c);
      }
   }

   public static List a(DataInputStream par0DataInputStream) throws IOException {
      ArrayList arraylist = null;

      for (byte byte0 = par0DataInputStream.readByte(); byte0 != 127; byte0 = par0DataInputStream.readByte()) {
         if (arraylist == null) {
            arraylist = new ArrayList();
         }

         int i = (byte0 & 224) >> 5;
         int j = byte0 & 31;
         acx watchableobject = null;
         switch (i) {
            case 0:
               watchableobject = new acx(i, j, par0DataInputStream.readByte());
               break;
            case 1:
               watchableobject = new acx(i, j, par0DataInputStream.readShort());
               break;
            case 2:
               watchableobject = new acx(i, j, par0DataInputStream.readInt());
               break;
            case 3:
               watchableobject = new acx(i, j, par0DataInputStream.readFloat());
               break;
            case 4:
               watchableobject = new acx(i, j, abs.a(par0DataInputStream, 64));
               break;
            case 5:
               short word0 = par0DataInputStream.readShort();
               byte byte1 = par0DataInputStream.readByte();
               short word1 = par0DataInputStream.readShort();
               watchableobject = new acx(i, j, new ItemStack(word0, byte1, word1));
               break;
            case 6:
               long k = par0DataInputStream.readLong();
               int l = par0DataInputStream.readInt();
               long i1 = par0DataInputStream.readLong();
               watchableobject = new acx(i, j, new ChunkCoordinates(k, l, i1));
         }

         arraylist.add(watchableobject);
      }

      return arraylist;
   }

   public void a(List par1List) {
      for (acx watchableobject : par1List) {
         acx watchableobject1 = (acx)this.b.get(watchableobject.a());
         if (watchableobject1 != null) {
            watchableobject1.a(watchableobject.b());
         }
      }
   }

   static {
      a.put(Byte.class, 0);
      a.put(Short.class, 1);
      a.put(Integer.class, 2);
      a.put(Float.class, 3);
      a.put(String.class, 4);
      a.put(ItemStack.class, 5);
      a.put(ChunkCoordinates.class, 6);
   }
}
