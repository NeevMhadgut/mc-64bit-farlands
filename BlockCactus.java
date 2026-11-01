import java.util.Random;

public class BlockCactus extends Block {
   protected BlockCactus(int par1, int par2) {
      super(par1, par2, acn.x);
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
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      double f = 0.0625;
      return AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 1 - f, par4 + 1L - f);
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      double f = 0.0625;
      return AxisAlignedBB.b(par2 + f, par3, par4 + f, par2 + 1L - f, par3 + 1, par4 + 1L - f);
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN - 1;
      } else {
         return par1 == 0 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public int d() {
      return 13;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : this.canBlockStay(par1World, par2, par3, par4);
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!this.canBlockStay(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockMaterial(par2 - 1L, par3, par4).a()) {
         return false;
      }

      if (par1World.getBlockMaterial(par2 + 1L, par3, par4).a()) {
         return false;
      }

      if (par1World.getBlockMaterial(par2, par3, par4 - 1L).a()) {
         return false;
      }

      if (par1World.getBlockMaterial(par2, par3, par4 + 1L).a()) {
         return false;
      }

      int i = par1World.getBlockId(par2, par3 - 1, par4);
      return i == Block.aV.bO || i == Block.E.bO;
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      par5Entity.a(md.h, 1);
   }
}
