import java.util.Random;

public class BlockSand extends Block {
   public static boolean a = false;

   public BlockSand(int par1, int par2) {
      super(par1, par2, acn.o);
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      this.tryToFall(par1World, par2, par3, par4);
   }

   private void tryToFall(World par1World, long par2, int par3, long par4) {
      long i = par2;
      int j = par3;
      long k = par4;
      if (canFallBelow(par1World, i, j - 1, k) && j >= 0) {
         byte byte0 = 32;
         if (a || !par1World.checkChunksExist(par2 - byte0, par3 - byte0, par4 - byte0, par2 + byte0, par3 + byte0, par4 + byte0)) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);

            while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0) {
               par3--;
            }

            if (par3 > 0) {
               par1World.setBlockWithNotify(par2, par3, par4, this.bO);
            }
         } else if (!par1World.F) {
            EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, par2 + 0.5, par3 + 0.5, par4 + 0.5, this.bO);
            par1World.a(entityfallingsand);
         }
      }
   }

   @Override
   public int e() {
      return 3;
   }

   public static boolean canFallBelow(World par0World, long par1, int par2, long par3) {
      int i = par0World.getBlockId(par1, par2, par3);
      if (i == 0) {
         return true;
      }

      if (i == Block.ar.bO) {
         return true;
      }

      acn material = Block.m[i].cd;
      return material == acn.g ? true : material == acn.h;
   }
}
