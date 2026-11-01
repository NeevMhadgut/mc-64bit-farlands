public class ItemSeeds extends Item {
   private int a;
   private int b;

   public ItemSeeds(int par1, int par2, int par3) {
      super(par1);
      this.a = par2;
      this.b = par3;
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par7 != 1) {
         return false;
      }

      if (par2EntityPlayer.canPlayerEdit(par4, par5, par6) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6)) {
         int i = par3World.getBlockId(par4, par5, par6);
         if (i == this.b && par3World.isAirBlock(par4, par5 + 1, par6)) {
            par3World.setBlockWithNotify(par4, par5 + 1, par6, this.a);
            par1ItemStack.a--;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
