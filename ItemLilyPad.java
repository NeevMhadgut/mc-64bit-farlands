public class ItemLilyPad extends aky {
   public ItemLilyPad(int par1) {
      super(par1, false);
   }

   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      MovingObjectPosition movingobjectposition = this.a(par2World, par3EntityPlayer, true);
      if (movingobjectposition == null) {
         return par1ItemStack;
      }

      if (movingobjectposition.a == aat.a) {
         long i = movingobjectposition.b;
         int j = movingobjectposition.c;
         long k = movingobjectposition.d;
         if (!par2World.canMineBlock(par3EntityPlayer, i, j, k)) {
            return par1ItemStack;
         }

         if (!par3EntityPlayer.canPlayerEdit(i, j, k)) {
            return par1ItemStack;
         }

         if (par2World.getBlockMaterial(i, j, k) == acn.g && par2World.getBlockMetadata(i, j, k) == 0 && par2World.isAirBlock(i, j + 1, k)) {
            par2World.setBlockWithNotify(i, j + 1, k, Block.EntityXPOrb.bO);
            if (!par3EntityPlayer.aT.d) {
               par1ItemStack.a--;
            }
         }
      }

      return par1ItemStack;
   }

   public int b(int par1, int par2) {
      return Block.EntityXPOrb.d(par1);
   }
}
