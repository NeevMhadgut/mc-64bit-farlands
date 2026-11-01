import java.util.Random;

public class BlockCake extends Block {
   protected BlockCake(int par1, int par2) {
      super(par1, par2, acn.C);
      this.a(true);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      float f = 0.0625F;
      float f1 = (1 + i * 2) / 16.0F;
      float f2 = 0.5F;
      this.a(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
   }

   @Override
   public void h() {
      float f = 0.0625F;
      float f1 = 0.5F;
      this.a(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      double f = 0.0625;
      double f1 = (1 + i * 2) / 16.0;
      double f2 = 0.5;
      return AxisAlignedBB.b(par2 + f1, par3, par4 + f, par2 + 1L - f, par3 + f2 - f, par4 + 1L - f);
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      double f = 0.0625;
      double f1 = (1 + i * 2) / 16.0;
      double f2 = 0.5;
      return AxisAlignedBB.b(par2 + f1, par3, par4 + f, par2 + 1L - f, par3 + f2, par4 + 1L - f);
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1) {
         return this.bN;
      } else if (par1 == 0) {
         return this.bN + 3;
      } else {
         return par2 > 0 && par1 == 4 ? this.bN + 2 : this.bN + 1;
      }
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN;
      } else {
         return par1 == 0 ? this.bN + 3 : this.bN + 1;
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
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
      return true;
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
   }

   private void eatCakeSlice(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par5EntityPlayer.a(false)) {
         par5EntityPlayer.aF().a(2, 0.1F);
         int i = par1World.getBlockMetadata(par2, par3, par4) + 1;
         if (i >= 6) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         } else {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
            par1World.markBlockAsNeedsUpdate(par2, par3, par4);
         }
      }
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
      return par1World.getBlockMaterial(par2, par3 - 1, par4).a();
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }
}
