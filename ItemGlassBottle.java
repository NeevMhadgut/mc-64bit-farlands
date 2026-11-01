public class ItemGlassBottle extends Item {
   public ItemGlassBottle(int par1) {
      super(par1);
   }

   @Override
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

         if (par2World.getBlockMaterial(i, j, k) == acn.g) {
            par1ItemStack.a--;
            if (par1ItemStack.a <= 0) {
               return new ItemStack(Item.bs);
            }

            if (!par3EntityPlayer.ap.a(new ItemStack(Item.bs))) {
               par3EntityPlayer.a(new ItemStack(Item.bs.bQ, 1, 0));
            }
         }
      }

      return par1ItemStack;
   }
}
