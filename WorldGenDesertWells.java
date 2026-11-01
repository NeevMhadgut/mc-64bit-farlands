import java.util.Random;

public class WorldGenDesertWells extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      while (par1World.isAirBlock(par3, par4, par5) && par4 > 2) {
         par4--;
      }

      int i = par1World.getBlockId(par3, par4, par5);
      if (i != Block.E.bO) {
         return false;
      }

      for (int j = -2; j <= 2; j++) {
         for (int k1 = -2; k1 <= 2; k1++) {
            if (par1World.isAirBlock(par3 + j, par4 - 1, par5 + k1) && par1World.isAirBlock(par3 + j, par4 - 2, par5 + k1)) {
               return false;
            }
         }
      }

      for (int k = -1; k <= 0; k++) {
         for (int l1 = -2; l1 <= 2; l1++) {
            for (int k2 = -2; k2 <= 2; k2++) {
               par1World.setBlock(par3 + l1, par4 + k, par5 + k2, Block.Q.bO);
            }
         }
      }

      par1World.setBlock(par3, par4, par5, Block.A.bO);
      par1World.setBlock(par3 - 1L, par4, par5, Block.A.bO);
      par1World.setBlock(par3 + 1L, par4, par5, Block.A.bO);
      par1World.setBlock(par3, par4, par5 - 1L, Block.A.bO);
      par1World.setBlock(par3, par4, par5 + 1L, Block.A.bO);

      for (int l = -2; l <= 2; l++) {
         for (int i2 = -2; i2 <= 2; i2++) {
            if (l == -2 || l == 2 || i2 == -2 || i2 == 2) {
               par1World.setBlock(par3 + l, par4 + 1, par5 + i2, Block.Q.bO);
            }
         }
      }

      par1World.setBlockAndMetadata(par3 + 2L, par4 + 1, par5, Block.ak.bO, 1);
      par1World.setBlockAndMetadata(par3 - 2L, par4 + 1, par5, Block.ak.bO, 1);
      par1World.setBlockAndMetadata(par3, par4 + 1, par5 + 2L, Block.ak.bO, 1);
      par1World.setBlockAndMetadata(par3, par4 + 1, par5 - 2L, Block.ak.bO, 1);

      for (int i1 = -1; i1 <= 1; i1++) {
         for (int j2 = -1; j2 <= 1; j2++) {
            if (i1 == 0 && j2 == 0) {
               par1World.setBlock(par3 + i1, par4 + 4, par5 + j2, Block.Q.bO);
            } else {
               par1World.setBlockAndMetadata(par3 + i1, par4 + 4, par5 + j2, Block.ak.bO, 1);
            }
         }
      }

      for (int j1 = 1; j1 <= 3; j1++) {
         par1World.setBlock(par3 - 1L, par4 + j1, par5 - 1L, Block.Q.bO);
         par1World.setBlock(par3 - 1L, par4 + j1, par5 + 1L, Block.Q.bO);
         par1World.setBlock(par3 + 1L, par4 + j1, par5 - 1L, Block.Q.bO);
         par1World.setBlock(par3 + 1L, par4 + j1, par5 + 1L, Block.Q.bO);
      }

      return true;
   }
}
