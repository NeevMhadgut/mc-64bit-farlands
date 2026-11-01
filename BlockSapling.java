import java.util.Random;

public class BlockSapling extends BlockFlower {
   protected BlockSapling(int par1, int par2) {
      super(par1, par2);
      float f = 0.4F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         super.updateTick(par1World, par2, par3, par4, par5Random);
         if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
            int i = par1World.getBlockMetadata(par2, par3, par4);
            if ((i & 8) == 0) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 8);
            } else {
               this.growTree(par1World, par2, par3, par4, par5Random);
            }
         }
      }
   }

   @Override
   public int a(int par1, int par2) {
      par2 &= 3;
      if (par2 == 1) {
         return 63;
      } else if (par2 == 2) {
         return 79;
      } else {
         return par2 == 3 ? 30 : super.a(par1, par2);
      }
   }

   public void growTree(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4) & 3;
      Object obj = null;
      int j = 0;
      int k = 0;
      boolean flag = false;
      if (i == 1) {
         obj = new WorldGenTaiga2(true);
      } else if (i == 2) {
         obj = new i(true);
      } else if (i == 3) {
         for (j = 0; j >= -1; j--) {
            for (k = 0; k >= -1; k--) {
               if (this.func_50076_f(par1World, par2 + j, par3, par4 + k, 3)
                  && this.func_50076_f(par1World, par2 + j + 1L, par3, par4 + k, 3)
                  && this.func_50076_f(par1World, par2 + j, par3, par4 + k + 1L, 3)
                  && this.func_50076_f(par1World, par2 + j + 1L, par3, par4 + k + 1L, 3)) {
                  obj = new WorldGenHugeTrees(true, 10 + par5Random.nextInt(20), 3, 3);
                  flag = true;
                  break;
               }
            }

            if (obj != null) {
               break;
            }
         }

         if (obj == null) {
            k = 0;
            j = 0;
            obj = new WorldGenTrees(true, 4 + par5Random.nextInt(7), 3, 3, false);
         }
      } else {
         obj = new WorldGenTrees(true);
         if (par5Random.nextInt(10) == 0) {
            obj = new WorldGenBigTree(true);
         }
      }

      if (flag) {
         par1World.setBlock(par2 + j, par3, par4 + k, 0);
         par1World.setBlock(par2 + j + 1L, par3, par4 + k, 0);
         par1World.setBlock(par2 + j, par3, par4 + k + 1L, 0);
         par1World.setBlock(par2 + j + 1L, par3, par4 + k + 1L, 0);
      } else {
         par1World.setBlock(par2, par3, par4, 0);
      }

      if (!((WorldGenerator)obj).generate(par1World, par5Random, par2 + j, par3, par4 + k)) {
         if (flag) {
            par1World.setBlockAndMetadata(par2 + j, par3, par4 + k, this.bO, i);
            par1World.setBlockAndMetadata(par2 + j + 1L, par3, par4 + k, this.bO, i);
            par1World.setBlockAndMetadata(par2 + j, par3, par4 + k + 1L, this.bO, i);
            par1World.setBlockAndMetadata(par2 + j + 1L, par3, par4 + k + 1L, this.bO, i);
         } else {
            par1World.setBlockAndMetadata(par2, par3, par4, this.bO, i);
         }
      }
   }

   public boolean func_50076_f(World par1World, long par2, int par3, long par4, int par5) {
      return par1World.getBlockId(par2, par3, par4) == this.bO && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
   }

   @Override
   protected int c(int par1) {
      return par1 & 3;
   }
}
