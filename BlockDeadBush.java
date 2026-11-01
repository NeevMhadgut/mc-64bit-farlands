import java.util.Random;

public class BlockDeadBush extends BlockFlower {
   protected BlockDeadBush(int par1, int par2) {
      super(par1, par2, acn.k);
      float f = 0.4F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
   }

   @Override
   protected boolean f_(int par1) {
      return par1 == Block.E.bO;
   }

   @Override
   public int a(int par1, int par2) {
      return this.bN;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return -1;
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      if (!par1World.F && par2EntityPlayer.EntityThrowable() != null && par2EntityPlayer.EntityThrowable().c == Item.be.bQ) {
         par2EntityPlayer.a(gv.C[this.bO], 1);
         this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.Y, 1, par6));
      } else {
         super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
      }
   }
}
