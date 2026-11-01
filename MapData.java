import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData extends zk {
   public long b;
   public long c;
   public byte d;
   public byte e;
   public byte[] f = new byte[16384];
   public int g;
   public List h = new ArrayList();
   private Map j = new HashMap();
   public List i = new ArrayList();

   public MapData(String par1Str) {
      super(par1Str);
   }

   public void a(ady par1NBTTagCompound) {
      this.d = par1NBTTagCompound.d("dimension");

      try {
         this.b = par1NBTTagCompound.g("xCenter");
      } catch (ClassCastException ex) {
         this.b = par1NBTTagCompound.f("xCenter");
      }

      try {
         this.c = par1NBTTagCompound.g("zCenter");
      } catch (ClassCastException ex) {
         this.c = par1NBTTagCompound.f("zCenter");
      }

      this.e = par1NBTTagCompound.d("scale");
      if (this.e < 0) {
         this.e = 0;
      }

      if (this.e > 4) {
         this.e = 4;
      }

      short word0 = par1NBTTagCompound.e("width");
      short word1 = par1NBTTagCompound.e("height");
      if (word0 == 128 && word1 == 128) {
         this.f = par1NBTTagCompound.k("colors");
      } else {
         byte[] abyte0 = par1NBTTagCompound.k("colors");
         this.f = new byte[16384];
         int i = (128 - word0) / 2;
         int j = (128 - word1) / 2;

         for (int k = 0; k < word1; k++) {
            int l = k + j;
            if (l >= 0 || l < 128) {
               for (int i1 = 0; i1 < word0; i1++) {
                  int j1 = i1 + i;
                  if (j1 >= 0 || j1 < 128) {
                     this.f[j1 + l * 128] = abyte0[i1 + k * word0];
                  }
               }
            }
         }
      }
   }

   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("dimension", this.d);
      par1NBTTagCompound.a("xCenter", this.b);
      par1NBTTagCompound.a("zCenter", this.c);
      par1NBTTagCompound.a("scale", this.e);
      par1NBTTagCompound.a("width", (short)128);
      par1NBTTagCompound.a("height", (short)128);
      par1NBTTagCompound.a("colors", this.f);
   }

   public void a(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
      if (!this.j.containsKey(par1EntityPlayer)) {
         nk mapinfo = new nk(this, par1EntityPlayer);
         this.j.put(par1EntityPlayer, mapinfo);
         this.h.add(mapinfo);
      }

      this.i.clear();

      for (int i = 0; i < this.h.size(); i++) {
         nk mapinfo1 = (nk)this.h.get(i);
         if (!mapinfo1.a.G && mapinfo1.a.ap.c(par2ItemStack)) {
            float f = (float)(mapinfo1.a.o - this.b) / (1 << this.e);
            float f1 = (float)(mapinfo1.a.q - this.c) / (1 << this.e);
            int j = 64;
            int k = 64;
            if (!(f < -j) && !(f1 < -k) && !(f > j) && !(f1 > k)) {
               byte byte0 = 0;
               byte byte1 = (byte)(f * 2.0F + 0.5);
               byte byte2 = (byte)(f1 * 2.0F + 0.5);
               byte byte3 = (byte)(par1EntityPlayer.u * 16.0F / 360.0F + 0.5);
               if (this.d < 0) {
                  int l = this.g / 10;
                  byte3 = (byte)(l * l * 34187121 + l * 121 >> 15 & 15);
               }

               if (mapinfo1.a.aB == this.d) {
                  this.i.add(new tv(this, byte0, byte1, byte2, byte3));
               }
            }
         } else {
            this.j.remove(mapinfo1.a);
            this.h.remove(mapinfo1);
         }
      }
   }

   public void a(int par1, int par2, int par3) {
      super.a();

      for (int i = 0; i < this.h.size(); i++) {
         nk mapinfo = (nk)this.h.get(i);
         if (mapinfo.b[par1] < 0 || mapinfo.b[par1] > par2) {
            mapinfo.b[par1] = par2;
         }

         if (mapinfo.c[par1] < 0 || mapinfo.c[par1] < par3) {
            mapinfo.c[par1] = par3;
         }
      }
   }

   public void a(byte[] par1ArrayOfByte) {
      if (par1ArrayOfByte[0] == 0) {
         int i = par1ArrayOfByte[1] & 255;
         int k = par1ArrayOfByte[2] & 255;

         for (int l = 0; l < par1ArrayOfByte.length - 3; l++) {
            this.f[(l + k) * 128 + i] = par1ArrayOfByte[l + 3];
         }

         this.a();
      } else if (par1ArrayOfByte[0] == 1) {
         this.i.clear();

         for (int j = 0; j < (par1ArrayOfByte.length - 1) / 3; j++) {
            byte byte0 = (byte)(par1ArrayOfByte[j * 3 + 1] % 16);
            byte byte1 = par1ArrayOfByte[j * 3 + 2];
            byte byte2 = par1ArrayOfByte[j * 3 + 3];
            byte byte3 = (byte)(par1ArrayOfByte[j * 3 + 1] / 16);
            this.i.add(new tv(this, byte0, byte1, byte2, byte3));
         }
      }
   }
}
