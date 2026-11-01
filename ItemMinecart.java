public class ItemMinecart extends Item {
   public int a;

   public ItemMinecart(int par1, int par2) {
      super(par1);
      this.bR = 1;
      this.a = par2;
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      int i = par3World.getBlockId(par4, par5, par6);
      if (BlockRail.e(i)) {
         if (!par3World.F) {
            par3World.a(new EntityMinecart(par3World, par4 + 0.5, par5 + 0.5, par6 + 0.5, this.a));
         }

         par1ItemStack.a--;
         return true;
      } else {
         return false;
      }
   }
}
