import java.util.Random;

public class BlockLockedChest extends Block {
   protected BlockLockedChest(int par1) {
      super(par1, acn.d);
      this.bN = 26;
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 1) {
         return this.bN - 1;
      }

      if (par5 == 0) {
         return this.bN - 1;
      }

      int i = par1IBlockAccess.getBlockId(par2, par3, par4 - 1L);
      int j = par1IBlockAccess.getBlockId(par2, par3, par4 + 1L);
      int k = par1IBlockAccess.getBlockId(par2 - 1L, par3, par4);
      int l = par1IBlockAccess.getBlockId(par2 + 1L, par3, par4);
      byte byte0 = 3;
      if (Block.n[i] && !Block.n[j]) {
         byte0 = 3;
      }

      if (Block.n[j] && !Block.n[i]) {
         byte0 = 2;
      }

      if (Block.n[k] && !Block.n[l]) {
         byte0 = 5;
      }

      if (Block.n[l] && !Block.n[k]) {
         byte0 = 4;
      }

      return par5 != byte0 ? this.bN : this.bN + 1;
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN - 1;
      } else if (par1 == 0) {
         return this.bN - 1;
      } else {
         return par1 == 3 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long i) {
      return true;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
   }
}
