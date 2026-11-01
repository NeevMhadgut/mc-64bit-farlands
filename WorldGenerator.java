import java.util.Random;

public abstract class WorldGenerator {
   private final boolean a;

   public WorldGenerator() {
      this.a = false;
   }

   public WorldGenerator(boolean par1) {
      this.a = par1;
   }

   public abstract boolean generate(World var1, Random var2, long var3, int var5, long var6);

   public void a(double d, double d1, double d2) {
   }

   protected void func_50073_a(World par1World, long par2, int par3, long par4, int par5) {
      this.setBlockAndMetadata(par1World, par2, par3, par4, par5, 0);
   }

   protected void setBlockAndMetadata(World par1World, long par2, int par3, long par4, int par5, int par6) {
      if (this.a) {
         par1World.setBlockAndMetadataWithNotify(par2, par3, par4, par5, par6);
      } else if (!par1World.blockExists(par2, par3, par4) || !par1World.getChunkFromBlockCoords(par2, par4).o) {
         par1World.setBlockAndMetadata(par2, par3, par4, par5, par6);
      } else if (par1World.setBlockAndMetadata(par2, par3, par4, par5, par6)) {
         par1World.markBlockNeedsUpdate(par2, par3, par4);
      }
   }
}
