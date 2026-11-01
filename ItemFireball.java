public class ItemFireball extends Item {
   public ItemFireball(int par1) {
      super(par1);
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par3World.F) {
         return true;
      }

      if (par7 == 0) {
         par5--;
      }

      if (par7 == 1) {
         par5++;
      }

      if (par7 == 2) {
         par6--;
      }

      if (par7 == 3) {
         par6++;
      }

      if (par7 == 4) {
         par4--;
      }

      if (par7 == 5) {
         par4++;
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      int i = par3World.getBlockId(par4, par5, par6);
      if (i == 0) {
         par3World.a(par4 + 0.5, par5 + 0.5, par6 + 0.5, "fire.ignite", 1.0F, d.nextFloat() * 0.4F + 0.8F);
         par3World.setBlockWithNotify(par4, par5, par6, Block.ar.bO);
      }

      if (!par2EntityPlayer.aT.d) {
         par1ItemStack.a--;
      }

      return true;
   }
}
