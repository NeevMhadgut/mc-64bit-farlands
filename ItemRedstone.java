public class ItemRedstone extends Item {
   public ItemRedstone(int par1) {
      super(par1);
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par3World.getBlockId(par4, par5, par6) != Block.aS.bO) {
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

         if (!par3World.isAirBlock(par4, par5, par6)) {
            return false;
         }
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      if (Block.EntityThrowable.canPlaceBlockAt(par3World, par4, par5, par6)) {
         par1ItemStack.a--;
         par3World.setBlockWithNotify(par4, par5, par6, Block.EntityThrowable.bO);
      }

      return true;
   }
}
