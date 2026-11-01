public class ItemSlab extends ItemBlock {
   public ItemSlab(int par1) {
      super(par1);
      this.g(0);
      this.a(true);
   }

   @Override
   public int b(int par1) {
      return Block.ak.a(2, par1);
   }

   @Override
   public int a(int par1) {
      return par1;
   }

   @Override
   public String a(ItemStack par1ItemStack) {
      int i = par1ItemStack.i();
      if (i < 0 || i >= BlockStep.a.length) {
         i = 0;
      }

      return super.e() + "." + BlockStep.a[i];
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par1ItemStack.a == 0) {
         return false;
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      int i = par3World.getBlockId(par4, par5, par6);
      int j = par3World.getBlockMetadata(par4, par5, par6);
      int k = j & 7;
      boolean flag = (j & 8) != 0;
      if ((par7 == 1 && !flag || par7 == 0 && flag) && i == Block.ak.bO && k == par1ItemStack.i()) {
         if (par3World.a(Block.aj.getCollisionBoundingBoxFromPool(par3World, par4, par5, par6))
            && par3World.setBlockAndMetadataWithNotify(par4, par5, par6, Block.aj.bO, k)) {
            par3World.a(par4 + 0.5, par5 + 0.5, par6 + 0.5, Block.aj.cb.d(), (Block.aj.cb.b() + 1.0F) / 2.0F, Block.aj.cb.c() * 0.8F);
            par1ItemStack.a--;
         }

         return true;
      } else {
         return func_50087_b(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7)
            ? true
            : super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7);
      }
   }

   private static boolean func_50087_b(ItemStack par0ItemStack, EntityPlayer par1EntityPlayer, World par2World, long par3, int par4, long par5, int par6) {
      if (par6 == 0) {
         par4--;
      }

      if (par6 == 1) {
         par4++;
      }

      if (par6 == 2) {
         par5--;
      }

      if (par6 == 3) {
         par5++;
      }

      if (par6 == 4) {
         par3--;
      }

      if (par6 == 5) {
         par3++;
      }

      int i = par2World.getBlockId(par3, par4, par5);
      int j = par2World.getBlockMetadata(par3, par4, par5);
      int k = j & 7;
      if (i == Block.ak.bO && k == par0ItemStack.i()) {
         if (par2World.a(Block.aj.getCollisionBoundingBoxFromPool(par2World, par3, par4, par5))
            && par2World.setBlockAndMetadataWithNotify(par3, par4, par5, Block.aj.bO, k)) {
            par2World.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, Block.aj.cb.d(), (Block.aj.cb.b() + 1.0F) / 2.0F, Block.aj.cb.c() * 0.8F);
            par0ItemStack.a--;
         }

         return true;
      } else {
         return false;
      }
   }
}
