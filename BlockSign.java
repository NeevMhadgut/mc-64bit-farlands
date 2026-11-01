import java.util.Random;

public class BlockSign extends BlockContainer {
   private Class a;
   private boolean b;

   protected BlockSign(int par1, Class par2Class, boolean par3) {
      super(par1, acn.d);
      this.b = par3;
      this.bN = 4;
      this.a = par2Class;
      float f = 0.25F;
      float f1 = 1.0F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      if (!this.b) {
         int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
         float f = 0.28125F;
         float f1 = 0.78125F;
         float f2 = 0.0F;
         float f3 = 1.0F;
         float f4 = 0.125F;
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         if (i == 2) {
            this.a(f2, f, 1.0F - f4, f3, f1, 1.0F);
         }

         if (i == 3) {
            this.a(f2, f, 0.0F, f3, f1, f4);
         }

         if (i == 4) {
            this.a(1.0F - f4, f, f2, 1.0F, f1, f3);
         }

         if (i == 5) {
            this.a(0.0F, f, f2, f4, f1, f3);
         }
      }
   }

   @Override
   public int d() {
      return -1;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long i) {
      return true;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public TileEntity u_() {
      try {
         return (TileEntity)this.a.newInstance();
      } catch (Exception exception) {
         throw new RuntimeException(exception);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.au.bQ;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      boolean flag = false;
      if (this.b) {
         if (!par1World.getBlockMaterial(par2, par3 - 1, par4).a()) {
            flag = true;
         }
      } else {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         flag = true;
         if (i == 2 && par1World.getBlockMaterial(par2, par3, par4 + 1L).a()) {
            flag = false;
         }

         if (i == 3 && par1World.getBlockMaterial(par2, par3, par4 - 1L).a()) {
            flag = false;
         }

         if (i == 4 && par1World.getBlockMaterial(par2 + 1L, par3, par4).a()) {
            flag = false;
         }

         if (i == 5 && par1World.getBlockMaterial(par2 - 1L, par3, par4).a()) {
            flag = false;
         }
      }

      if (flag) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }

      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
   }
}
