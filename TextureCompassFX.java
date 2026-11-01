import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;

public class TextureCompassFX extends tt {
   private Minecraft a;
   private int[] b = new int[256];
   private double c;
   private double d;

   public TextureCompassFX(Minecraft par1Minecraft) {
      super(Item.aQ.b(0));
      this.a = par1Minecraft;
      this.k = 1;

      try {
         BufferedImage bufferedimage = ImageIO.read(Minecraft.class.getResource("/gui/items.png"));
         int i = this.g % 16 * 16;
         int j = this.g / 16 * 16;
         bufferedimage.getRGB(i, j, 16, 16, this.b, 0, 16);
      } catch (IOException ioexception) {
         ioexception.printStackTrace();
      }
   }

   public void a() {
      for (int i = 0; i < 256; i++) {
         int j = this.b[i] >> 24 & 0xFF;
         int k = this.b[i] >> 16 & 0xFF;
         int l = this.b[i] >> 8 & 0xFF;
         int i1 = this.b[i] >> 0 & 0xFF;
         if (this.h) {
            int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
            int k1 = (k * 30 + l * 70) / 100;
            int l1 = (k * 30 + i1 * 70) / 100;
            k = j1;
            l = k1;
            i1 = l1;
         }

         this.f[i * 4 + 0] = (byte)k;
         this.f[i * 4 + 1] = (byte)l;
         this.f[i * 4 + 2] = (byte)i1;
         this.f[i * 4 + 3] = (byte)j;
      }

      double d = 0.0;
      if (this.a.f != null && this.a.h != null) {
         ChunkCoordinates chunkcoordinates = this.a.f.x();
         double d2 = chunkcoordinates.a - this.a.h.o;
         double d4 = chunkcoordinates.c - this.a.h.q;
         d = (this.a.h.u - 90.0F) * Math.PI / 180.0 - Math.atan2(d4, d2);
         if (!this.a.f.t.e()) {
            d = Math.random() * Math.PI * 2.0;
         }
      }

      double d1 = d - this.c;

      while (d1 < -Math.PI) {
         d1 += Math.PI * 2;
      }

      while (d1 >= Math.PI) {
         d1 -= Math.PI * 2;
      }

      if (d1 < -1.0) {
         d1 = -1.0;
      }

      if (d1 > 1.0) {
         d1 = 1.0;
      }

      this.d += d1 * 0.1;
      this.d *= 0.8;
      this.c = this.c + this.d;
      double d3 = Math.sin(this.c);
      double d5 = Math.cos(this.c);

      for (int i2 = -4; i2 <= 4; i2++) {
         int k2 = (int)(8.5 + d5 * i2 * 0.3);
         int i3 = (int)(7.5 - d3 * i2 * 0.3 * 0.5);
         int k3 = i3 * 16 + k2;
         int i4 = 100;
         int k4 = 100;
         int i5 = 100;
         char c = 255;
         if (this.h) {
            int k5 = (i4 * 30 + k4 * 59 + i5 * 11) / 100;
            int i6 = (i4 * 30 + k4 * 70) / 100;
            int k6 = (i4 * 30 + i5 * 70) / 100;
            i4 = k5;
            k4 = i6;
            i5 = k6;
         }

         this.f[k3 * 4 + 0] = (byte)i4;
         this.f[k3 * 4 + 1] = (byte)k4;
         this.f[k3 * 4 + 2] = (byte)i5;
         this.f[k3 * 4 + 3] = (byte)c;
      }

      for (int j2 = -8; j2 <= 16; j2++) {
         int l2 = (int)(8.5 + d3 * j2 * 0.3);
         int j3 = (int)(7.5 + d5 * j2 * 0.3 * 0.5);
         int l3 = j3 * 16 + l2;
         int j4 = j2 < 0 ? 100 : 255;
         int l4 = j2 < 0 ? 100 : 20;
         int j5 = j2 < 0 ? 100 : 20;
         char c1 = 255;
         if (this.h) {
            int l5 = (j4 * 30 + l4 * 59 + j5 * 11) / 100;
            int j6 = (j4 * 30 + l4 * 70) / 100;
            int l6 = (j4 * 30 + j5 * 70) / 100;
            j4 = l5;
            l4 = j6;
            j5 = l6;
         }

         this.f[l3 * 4 + 0] = (byte)j4;
         this.f[l3 * 4 + 1] = (byte)l4;
         this.f[l3 * 4 + 2] = (byte)j5;
         this.f[l3 * 4 + 3] = (byte)c1;
      }
   }
}
