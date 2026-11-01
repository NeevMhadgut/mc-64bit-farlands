import java.util.Random;

public class BlockTallGrass extends BlockFlower {
   protected BlockTallGrass(int par1, int par2) {
      super(par1, par2, acn.k);
      float f = 0.4F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
   }

   @Override
   public int a(int par1, int par2) {
      if (par2 == 1) {
         return this.bN;
      } else if (par2 == 2) {
         return this.bN + 16 + 1;
      } else {
         return par2 == 0 ? this.bN + 16 : this.bN;
      }
   }

   @Override
   public int i() {
      double d = 0.5;
      double d1 = 1.0;
      return zv.a(d, d1);
   }

   @Override
   public int d(int par1) {
      return par1 == 0 ? 16777215 : ColorizerFoliage.c();
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      return i == 0 ? 16777215 : par1IBlockAccess.getBiomeGenForCoords(par2, par4).k();
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return par2Random.nextInt(8) == 0 ? Item.S.bQ : -1;
   }

   @Override
   public int a(int par1, Random par2Random) {
      return 1 + par2Random.nextInt(par1 * 2 + 1);
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      if (!par1World.F && par2EntityPlayer.EntityThrowable() != null && par2EntityPlayer.EntityThrowable().c == Item.be.bQ) {
         par2EntityPlayer.a(gv.C[this.bO], 1);
         this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.X, 1, par6));
      } else {
         super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
      }
   }
}
