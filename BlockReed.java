import java.util.Random;

public class BlockReed extends Block {
   protected BlockReed(int par1, int par2) {
      super(par1, acn.j);
      this.bN = par2;
      float f = 0.375F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
      this.a(true);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par1World.isAirBlock(par2, par3 + 1, par4)) {
         int i = 1;

         while (par1World.getBlockId(par2, par3 - i, par4) == this.bO) {
            i++;
         }

         if (i < 3) {
            int j = par1World.getBlockMetadata(par2, par3, par4);
            if (j == 15) {
               par1World.setBlockWithNotify(par2, par3 + 1, par4, this.bO);
               par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
            } else {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, j + 1);
            }
         }
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3 - 1, par4);
      if (i == this.bO) {
         return true;
      } else if (i != Block.u.bO && i != Block.v.bO && i != Block.E.bO) {
         return false;
      } else if (par1World.getBlockMaterial(par2 - 1L, par3 - 1, par4) == acn.g) {
         return true;
      } else if (par1World.getBlockMaterial(par2 + 1L, par3 - 1, par4) == acn.g) {
         return true;
      } else {
         return par1World.getBlockMaterial(par2, par3 - 1, par4 - 1L) == acn.g ? true : par1World.getBlockMaterial(par2, par3 - 1, par4 + 1L) == acn.g;
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      this.checkBlockCoordValid(par1World, par2, par3, par4);
   }

   protected final void checkBlockCoordValid(World par1World, long par2, int par3, long par4) {
      if (!this.canBlockStay(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      return this.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.aJ.bQ;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 1;
   }
}
