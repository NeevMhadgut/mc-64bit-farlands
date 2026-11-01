public class ItemHoe extends Item {
   public ItemHoe(int par1, uk par2EnumToolMaterial) {
      super(par1);
      this.bR = 1;
      this.g(par2EnumToolMaterial.a());
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      int i = par3World.getBlockId(par4, par5, par6);
      int j = par3World.getBlockId(par4, par5 + 1, par6);
      if ((par7 == 0 || j != 0 || i != Block.u.bO) && i != Block.v.bO) {
         return false;
      }

      Block block = Block.aA;
      par3World.a((float)par4 + 0.5F, par5 + 0.5F, (float)par6 + 0.5F, block.cb.d(), (block.cb.b() + 1.0F) / 2.0F, block.cb.c() * 0.8F);
      if (par3World.F) {
         return true;
      }

      par3World.setBlockWithNotify(par4, par5, par6, block.bO);
      par1ItemStack.a(1, par2EntityPlayer);
      return true;
   }

   @Override
   public boolean a() {
      return true;
   }
}
