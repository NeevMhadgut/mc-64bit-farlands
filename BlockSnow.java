import java.util.Random;

public class BlockSnow extends Block {
   protected BlockSnow(int par1, int par2) {
      super(par1, par2, acn.v);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(true);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4) & 7;
      return i >= 3 ? AxisAlignedBB.b(par2 + this.bV, par3 + this.bW, par4 + this.bX, par2 + this.bY, par3 + 0.5F, par4 + this.IChunkProvider) : null;
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
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
      float f = 2 * (1 + i) / 16.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3 - 1, par4);
      return i != 0 && (i == Block.K.bO || Block.m[i].a()) ? par1World.getBlockMaterial(par2, par3 - 1, par4).c() : false;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      this.canSnowStay(par1World, par2, par3, par4);
   }

   private boolean canSnowStay(World par1World, long par2, int par3, long par4) {
      if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         return false;
      } else {
         return true;
      }
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      int i = Item.aD.bQ;
      float f = 0.7F;
      double d = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
      double d1 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
      double d2 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
      EntityItem entityitem = new EntityItem(par1World, par3 + d, par4 + d1, par5 + d2, new ItemStack(i, 1, 0));
      entityitem.c = 10;
      par1World.a(entityitem);
      par1World.setBlockWithNotify(par3, par4, par5, 0);
      par2EntityPlayer.a(gv.C[this.bO], 1);
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.aD.bQ;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par1World.getSavedLightValue(wl.b, par2, par3, par4) > 11) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
   }
}
