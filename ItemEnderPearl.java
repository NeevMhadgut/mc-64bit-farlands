public class ItemEnderPearl extends Item {
   public ItemEnderPearl(int par1) {
      super(par1);
      this.bR = 64;
   }

   @Override
   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (par3EntityPlayer.j != null) {
         return par1ItemStack;
      }

      if (!par3EntityPlayer.aT.d) {
         par1ItemStack.a--;
      }

      par2World.a(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (d.nextFloat() * 0.4F + 0.8F));
      if (!par2World.F) {
         par2World.a(new adw(par2World, par3EntityPlayer));
      }

      return par1ItemStack;
   }
}
