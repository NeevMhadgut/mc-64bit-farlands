public class BlockWorkbench extends Block {
   protected BlockWorkbench(int par1) {
      super(par1, acn.d);
      this.bN = 59;
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN - 16;
      } else if (par1 == 0) {
         return Block.x.a_(0);
      } else {
         return par1 != 2 && par1 != 4 ? this.bN : this.bN + 1;
      }
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      par5EntityPlayer.displayWorkbenchGUI(par2, par3, par4);
      return true;
   }
}
