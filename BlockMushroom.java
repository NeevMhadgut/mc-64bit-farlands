import java.util.Random;

public class BlockMushroom extends BlockFlower {
   protected BlockMushroom(int par1, int par2) {
      super(par1, par2);
      float f = 0.2F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
      this.a(true);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par5Random.nextInt(25) == 0) {
         byte byte0 = 4;
         int i = 5;

         for (long j = par2 - byte0; j <= par2 + byte0; j++) {
            for (long l = par4 - byte0; l <= par4 + byte0; l++) {
               for (int j1 = par3 - 1; j1 <= par3 + 1; j1++) {
                  if (par1World.getBlockId(j, j1, l) == this.bO) {
                     if (--i <= 0) {
                        return;
                     }
                  }
               }
            }
         }

         long k = par2 + par5Random.nextInt(3) - 1L;
         int i1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
         long k1 = par4 + par5Random.nextInt(3) - 1L;

         for (int l1 = 0; l1 < 4; l1++) {
            if (par1World.isAirBlock(k, i1, k1) && this.canBlockStay(par1World, k, i1, k1)) {
               par2 = k;
               par3 = i1;
               par4 = k1;
            }

            k = par2 + par5Random.nextInt(3) - 1L;
            i1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
            k1 = par4 + par5Random.nextInt(3) - 1L;
         }

         if (par1World.isAirBlock(k, i1, k1) && this.canBlockStay(par1World, k, i1, k1)) {
            par1World.setBlockWithNotify(k, i1, k1, this.bO);
         }
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
   }

   @Override
   protected boolean f_(int par1) {
      return Block.n[par1];
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      if (par3 >= 0 && par3 < 256) {
         int i = par1World.getBlockId(par2, par3 - 1, par4);
         return i == Block.by.bO || par1World.getFullBlockLightValue(par2, par3, par4) < 13 && this.f_(i);
      } else {
         return false;
      }
   }

   public boolean fertilizeMushroom(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      par1World.setBlock(par2, par3, par4, 0);
      WorldGenBigMushroom worldgenbigmushroom = null;
      if (this.bO == Block.TileEntityMobSpawnerRenderer.bO) {
         worldgenbigmushroom = new WorldGenBigMushroom(0);
      } else if (this.bO == Block.ag.bO) {
         worldgenbigmushroom = new WorldGenBigMushroom(1);
      }

      if (worldgenbigmushroom != null && worldgenbigmushroom.generate(par1World, par5Random, par2, par3, par4)) {
         return true;
      }

      par1World.setBlockAndMetadata(par2, par3, par4, this.bO, i);
      return false;
   }
}
