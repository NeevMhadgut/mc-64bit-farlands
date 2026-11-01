import java.util.Random;

public class BlockLadder extends Block {
   protected BlockLadder(int par1, int par2) {
      super(par1, par2, acn.p);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      float f = 0.125F;
      if (i == 2) {
         this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
      }

      if (i == 3) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
      }

      if (i == 4) {
         this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if (i == 5) {
         this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
      }

      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      float f = 0.125F;
      if (i == 2) {
         this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
      }

      if (i == 3) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
      }

      if (i == 4) {
         this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if (i == 5) {
         this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
      }

      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
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
      return 8;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      if (par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         return true;
      } else if (par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         return true;
      } else {
         return par1World.isBlockNormalCube(par2, par3, par4 - 1L) ? true : par1World.isBlockNormalCube(par2, par3, par4 + 1L);
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if ((i == 0 || par5 == 2) && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
         i = 2;
      }

      if ((i == 0 || par5 == 3) && par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         i = 3;
      }

      if ((i == 0 || par5 == 4) && par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         i = 4;
      }

      if ((i == 0 || par5 == 5) && par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         i = 5;
      }

      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      boolean flag = false;
      if (i == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
         flag = true;
      }

      if (i == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
         flag = true;
      }

      if (i == 4 && par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
         flag = true;
      }

      if (i == 5 && par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
         flag = true;
      }

      if (!flag) {
         this.dropBlockAsItem(par1World, par2, par3, par4, i, 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }

      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
   }

   @Override
   public int a(Random par1Random) {
      return 1;
   }
}
