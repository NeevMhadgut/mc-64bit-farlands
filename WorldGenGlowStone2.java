import java.util.Random;

public class WorldGenGlowStone2 extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      if (!par1World.isAirBlock(par3, par4, par5)) {
         return false;
      }

      if (par1World.getBlockId(par3, par4 + 1, par5) != Block.ItemBucket.bO) {
         return false;
      }

      par1World.setBlockWithNotify(par3, par4, par5, Block.bd.bO);

      for (int i = 0; i < 1500; i++) {
         long j = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int k = par4 - par2Random.nextInt(12);
         long l = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.getBlockId(j, k, l) == 0) {
            int i1 = 0;

            for (int j1 = 0; j1 < 6; j1++) {
               int k1 = 0;
               if (j1 == 0) {
                  k1 = par1World.getBlockId(j - 1L, k, l);
               }

               if (j1 == 1) {
                  k1 = par1World.getBlockId(j + 1L, k, l);
               }

               if (j1 == 2) {
                  k1 = par1World.getBlockId(j, k - 1, l);
               }

               if (j1 == 3) {
                  k1 = par1World.getBlockId(j, k + 1, l);
               }

               if (j1 == 4) {
                  k1 = par1World.getBlockId(j, k, l - 1L);
               }

               if (j1 == 5) {
                  k1 = par1World.getBlockId(j, k, l + 1L);
               }

               if (k1 == Block.bd.bO) {
                  i1++;
               }
            }

            if (i1 == 1) {
               par1World.setBlockWithNotify(j, k, l, Block.bd.bO);
            }
         }
      }

      return true;
   }
}
