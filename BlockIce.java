import java.util.Random;

public class BlockIce extends BlockBreakable {
   public BlockIce(int par1, int par2) {
      super(par1, par2, acn.u, false);
      this.ce = 0.98F;
      this.a(true);
   }

   @Override
   public int c() {
      return 1;
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
      acn material = par1World.getBlockMaterial(par3, par4 - 1, par5);
      if (material.c() || material.d()) {
         par1World.setBlockWithNotify(par3, par4, par5, Block.A.bO);
      }
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par1World.getSavedLightValue(wl.b, par2, par3, par4) > 11 - Block.o[this.bO]) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, Block.B.bO);
      }
   }

   @Override
   public int f() {
      return 0;
   }

   @Override
   protected ItemStack b(int par1) {
      return null;
   }
}
