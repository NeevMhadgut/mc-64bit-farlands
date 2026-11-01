public class ItemShears extends Item {
   public ItemShears(int par1) {
      super(par1);
      this.f(1);
      this.g(238);
   }

   @Override
   public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, long par3, int par4, long par5, EntityLiving par6EntityLiving) {
      if (par2 != Block.K.bO && par2 != Block.W.bO && par2 != Block.X.bO && par2 != Block.bu.bO) {
         return super.onBlockDestroyed(par1ItemStack, par2, par3, par4, par5, par6EntityLiving);
      }

      par1ItemStack.a(1, par6EntityLiving);
      return true;
   }

   @Override
   public boolean a(Block par1Block) {
      return par1Block.bO == Block.W.bO;
   }

   @Override
   public float a(ItemStack par1ItemStack, Block par2Block) {
      if (par2Block.bO == Block.W.bO || par2Block.bO == Block.K.bO) {
         return 15.0F;
      } else {
         return par2Block.bO == Block.ab.bO ? 5.0F : super.a(par1ItemStack, par2Block);
      }
   }
}
