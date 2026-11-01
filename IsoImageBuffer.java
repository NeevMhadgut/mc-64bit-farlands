import java.awt.image.BufferedImage;

public class IsoImageBuffer {
   public BufferedImage a;
   public World b;
   public long c;
   public long d;
   public boolean e = false;
   public boolean f = false;
   public int g = 0;
   public boolean h = false;

   public IsoImageBuffer(World par1World, long par2, long par3) {
      this.b = par1World;
      this.init(par2, par3);
   }

   public void init(long par1, long par2) {
      this.e = false;
      this.c = par1;
      this.d = par2;
      this.g = 0;
      this.h = false;
   }

   public void init(World par1World, long par2, long par3) {
      this.b = par1World;
      this.init(par2, par3);
   }
}
